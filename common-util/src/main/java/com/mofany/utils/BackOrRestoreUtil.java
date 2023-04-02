package com.mofany.utils;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author MoFany-J
 * @date 2023/4/2
 * @description BackOrRestoreUtil
 */
public class BackOrRestoreUtil {
    /**
     * 当前系统名
     */
    private static final String CURRENT_OS_NAME = "os.name";
    /**
     * windows系统
     */
    private static final String WINDOWS = "windows";
    /**
     * linux
     */
    private static final String LINUX = "linux";
    /**
     * linux的默认shell
     */
    private static final String LINUX_SHELL = "/bin/bash";
    /**
     * windows的默认shell
     */
    private static final String WINDOWS_SHELL = "cmd";
    /**
     * 获取全局日志对象
     */
    private static final Logger logger = Logger.getGlobal();

    /**
     * 备份数据库到指定到文件中
     *
     * @param host           host地址
     * @param username       用户名
     * @param password       密码
     * @param backupFilePath 备份的文件路径
     * @param database       备份的数据库名称
     * @return
     * @throws Exception
     * @@description mysqldump  -h localhost # 主机
     * -u root      # 用户
     * -p password  # 密码
     * --result-file=/databaseBackup/database_file.sql   # 备份后生成的sql文件
     * --default-character-set=utf8 target_database_name # 要备份的目标数据库
     */
    public static boolean backup(String host, String username, String password, String backupFilePath, String database) throws IOException, InterruptedException {
        // 通过StringBuilder拼接Mysql备份命令
        StringBuilder stringBuilder = new StringBuilder();
        // 拼接备份命令
        stringBuilder.append("mysqldump ");
        // 拼接：主机+用户名+密码
        stringBuilder.append(" -h").append(host)
                .append(" -u").append(username)
                .append(" -p").append(password);
        // 拼接备份后的结果集存放文件与要备份的数据库
        stringBuilder.append(" --result-file=").append(backupFilePath)
                .append(" --default-character-set=utf8 ").append(database);
        // 返回命令行参数
        String[] cmdArray = getCommand(stringBuilder.toString());
        // 调用外部执行exe文件的java api
        Process process = Runtime.getRuntime().exec(cmdArray);
        // 值 0 表示线程正常终止，此进程对象表示的子进程的退出值
        if (process.waitFor() == 0) {
            logger.info("数据已经备份到：" + backupFilePath + " 文件中");
            // 进程正常执行则返回true
            return true;
        }
        // 进程异常执行则返回false
        return false;
    }

    /**
     * 恢复数据库备份文件
     *
     * @param restoreFilePath 备份文件所在路径地址
     * @param host            host地址
     * @param username        用户名
     * @param password        密码
     * @param database        还原的数据库名称
     * @return
     * @throws Exception
     * @@description mysql -h localhost   # 主机地址
     * -u root        # 用户名
     * -p 123456      # 密码
     * target_database_name < database_file.sql # 将SQL脚本文件还原为指定的数据库
     */
    public static boolean restore(String restoreFilePath, String host, String username, String password, String database) throws IOException, InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        // 拼接恢复命令
        stringBuilder.append("mysql")
                .append(" -h").append(host)
                .append(" -u").append(username)
                .append(" -p").append(password);
        // 拼接要恢复的目标数据库与执行恢复的文件
        stringBuilder.append(" ").append(database)
                .append(" < ").append(restoreFilePath);

        // 返回命令行参数
        String[] cmdArray = getCommand(stringBuilder.toString());
        // TODO 调用exec命令执行恢复,前提是要恢复的数据库必须存在且与创建的数据库同名
        Process process = Runtime.getRuntime().exec(cmdArray);
        // 值 0 表示线程正常终止，此进程对象表示的子进程的退出值
        if (process.waitFor() == 0) {
            // 数据已经恢复到指定路径
            logger.info("数据已从：" + restoreFilePath + " 导入到数据库中");
            return true;
        }
        return false;
    }

    /**
     * @param command 命令行参数
     * @return 宿主机的判断，Linux还是Windows
     */
    private static String[] getCommand(String command) {
        // 获取当前系统名
        String currentOS = System.getProperty(CURRENT_OS_NAME);
        // Linux的shell
        String shell = LINUX_SHELL;
        // Linux的c
        String c = "-c";
        // 判断当前系统名是否为Windows系统，是则设置
        if (currentOS.toLowerCase().startsWith(WINDOWS)) {
            shell = WINDOWS_SHELL;
            c = "/c";
        }
        // 参数：shell c command
        String[] cmd = {shell, c, command};
        return cmd;
    }

    /**
     * 测试类
     */
    public static void main(String[] args) {
        // 获取系统名
        String currentOS = System.getProperty(CURRENT_OS_NAME);
        // 输出当前系统
        System.out.println(currentOS);
        // 当前系统是否为指定系统
        System.out.println(currentOS.toLowerCase().startsWith(WINDOWS));
    }
}
