package com.mofan.test;

import com.mofany.utils.BackOrRestoreUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/4/2
 * @description CommonTest 通用测试类
 */
public class CommonTest {
    /**
     * 备份方法测试
     * */
    @Test
    public void test1() throws Exception {
        String host="localhost";
        String userName="root";
        String pwd="Jiangmh220";
        String database="test";
        String path="src/main/resources/backup/";
        // 执行备份
        boolean result=BackOrRestoreUtil.backup(host,userName,pwd,path+"test1.sql",database);
        if (result){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }

    /**
     * 还原方法测试
     * */
    @Test
    public void test2() throws Exception {
        String host="localhost";
        String userName="root";
        String pwd="Jiangmh220";
        String database="test";
        String path="src/main/resources/backup/";
        // 执行还原,还原数据库前必须提前保证该数据库已经创建成功
        boolean result=BackOrRestoreUtil.restore(path+"test1.sql",host,userName,pwd,database);
        if (result){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }

    /**
     * 一次性备份多个数据库
     * */
    @Test
    public void test3() throws Exception {
        String host="localhost";
        String userName="root";
        String pwd="Jiangmh220";
        String database="--databases test java67";
        String path="src/main/resources/backup/";
        // 执行备份
        boolean result=BackOrRestoreUtil.backup(host,userName,pwd,path+"all-database.sql",database);
        if (result){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }

    /**
     * 一次性还原多个数据库方法测试
     * */
    @Test
    public void test4() throws Exception {
        String host="localhost";
        String userName="root";
        String pwd="Jiangmh220";
        String path="src/main/resources/backup/";
        // 执行还原,还原数据库前必须提前保证该数据库已经创建成功
        boolean result=BackOrRestoreUtil.restore(path+"all-database.sql",host,userName,pwd);
        if (result){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }


    /**
     * 一次性备份全部数据库
     * */
    @Test
    public void test5() throws Exception {
        String host="localhost";
        String userName="root";
        String pwd="Jiangmh220";
        List<String> databases=new ArrayList<>();
        databases.add("test");
        databases.add("java67");
        databases.add("activiti6");
        String path="src/main/resources/backup/";


        // 执行备份
        boolean result=BackOrRestoreUtil.backup(host,userName,pwd,path+"all-database.sql",BackOrRestoreUtil.filterDatabases(databases));
        if (result){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }

}
