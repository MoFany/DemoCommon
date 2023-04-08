package com.mofan.test;

import com.mofany.utils.FileAllCopyUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author MoFany-J
 * @date 2022/10/17
 * @description Test
 */
public class Test {
    /**
     * 源文件
     * */
    private File sourceFiles=new File("D:/Cisco works");

    /**
     * 目标文件
     * */
    private File targetFiles=new File("./生成的文件/");

    /**
     * @description 无参构造器则会在当前项目路径下生成复制的文件
     * */
    public Test(){

    }

    /**
     * @param targetFile 指定目标文件路径
     * @description 利用有参构造器用于指定生成文件的存放位置
     * */
    public Test(String targetFile){
        this.targetFiles=new File(targetFile);
    }

    /**
     * 主调方法
     * */
    @org.junit.Test
    public void test() throws IOException {

        //不指定参数则在当前路径下复制文件
        Test test=new Test();
        //读取的文件
        new FileAllCopyUtil().allFiles(test.sourceFiles,test.targetFiles);
    }
}
