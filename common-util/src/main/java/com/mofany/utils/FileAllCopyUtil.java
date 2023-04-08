package com.mofany.utils;

import java.io.*;

/**
 * @author MoFany-J
 * @date 2022/10/17
 * @description FileAllCopyUtil 复制指定文件夹下的所有文件，通过字节流去复制
 *
 * 方法2：直接获取文件的完整路径通过直接修改字符串第一个字符的方式结合mkdirs()创建目录再创建文件
 */
public class FileAllCopyUtil {
    /**
     * @param parentFile 要创建文件的父文件
     * @description 创建目录结构
     * */
    public boolean createNewDirs(File parentFile) throws IOException {
        //该文件路径不存时，先创建子孙文件夹与文件夹中的文件
        if(!parentFile.exists()){
            //创建具有父子关系的文件夹
            if (parentFile.mkdirs()){
                System.out.println("Create New Directory:"+parentFile);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        File file=new File("./tempFile/test/a.txt");
        // 获取当前文件的完整版绝对路径
        String absoluteSelfPath=file.getCanonicalFile().toString();
        // 获取当前文件父亲的绝对路径
        String absoluteParentPath=file.getParentFile().getCanonicalPath();
        System.out.println("Self:"+file.getAbsolutePath());
        System.out.println("自己的绝对路径："+absoluteSelfPath);
        System.out.println("父级文件绝对路径："+absoluteParentPath);
        // 创建目标文件前先创建其父文件
        boolean newDirs = new FileAllCopyUtil().createNewDirs(file.getParentFile());
        System.out.println(newDirs?"父目录已创建":"父目录已存在");
    }

    /**
     * @param dirs 前缀目录
     * @param filename 要创建的文件名
     * @description 指定目录下创建文件,然后返回包含新路径的文件对象
     * */
    public File createNewFiles(File dirs,String filename) throws IOException {
        File file=new File(dirs+"\\"+filename);
        System.out.println("Create New File:"+file);
        //当前目录存在时就创建文件
        if(dirs.exists()){
           file.createNewFile();
        }
        return file;
    }

    /**
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     * @description 同名文件已经存在时，进行跨盘符的文件读写
     * */
    public void fileReadAndWrite(File sourceFile,File targetFile) throws IOException {
        //创建输入流：读源文件
        InputStream inputStream = null;
        //创建输出流：写目标文件
        OutputStream outputStream=null;
        //判断文件名是否相等
        if (sourceFile.getName().equals(targetFile.getName())){
            try{
                inputStream=new FileInputStream(sourceFile);
                outputStream=new FileOutputStream(targetFile);
                int len=0;
                //返回此输入流在不阻塞的情况下读取(或跳过)的字节数的估算值，即文件的预估大小
                byte[] buffer=new byte[inputStream.available()];
                //读取源文件
                while ((len=inputStream.read(buffer))!=-1){
                    //写目标文件：读多少写多少
                    outputStream.write(buffer,0,len);
                }

            }finally {
                //关闭资源
                inputStream.close();
                outputStream.close();
            }
        }
    }

    /**
     * @param sourceFilePath 源路径：D:/Cisco works
     * @param targetFilePath 目标路径：./生成的文件/
     * @description 递归遍历源路径下的每一个文件夹、文件,然后复刻这些文件以及文件结构
     * */
    public void allFiles(File sourceFilePath,File targetFilePath) throws IOException {
        //生成新的完整的目标目录
        File directory=new File(targetFilePath+"\\"+sourceFilePath.getName());
        //创建目录结构
        createNewDirs(directory);
        //返回当前抽象路径名表示的目录下的所有文件
        for (File file:sourceFilePath.listFiles()) {
            //判断该文件或文件夹是否存在
            if(file.exists()){
                //判断是否是文件夹
                if(file.isDirectory()){
                    //当前file是目录时递归遍历
                    allFiles(file,directory);
                }else {
                    //当前file是普通文件时则创建该文件
                    File targetfile=createNewFiles(directory,file.getName());
                    //然后通过该路径进行写文件，file(读)---->newfile(写)
                    fileReadAndWrite(file,targetfile);
                }
            }else {
                //该路径下没有指定内容的文件或文件夹
                System.out.println("File not Found!");
            }
        }
        return;
    }
}
