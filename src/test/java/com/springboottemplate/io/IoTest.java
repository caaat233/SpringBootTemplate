package com.springboottemplate.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class IoTest {


    public static void main(String[] args) {
        IoTest  a = new IoTest();
        //设置读取路径
        String filePath = "D:\\javaTest\\abc.txt";
        //调用读取方法
        String input = a.readeFile(filePath);
        //打印abc.txt文件的内容
        System.out.println(input);

        //写入到文件里的内容
        String content = "今天2018/03/20，星期二";
        //调用写入方法
        a.writeFile(filePath,content);

        //在修改文件内容后，再调用读取方法
        String b = a.readeFile(filePath);
        ////打印修改后的abc.txt文件的内容
        System.out.println(b);

    }
    /**
     * FileInputStream类的使用：读取文件内容
     * @param filePath
     * @return
     */
    private String readeFile(String filePath) {
        FileInputStream input = null;
        String result = "";
        try {
            //1.根据path实例化一个输入流的对象
            input = new FileInputStream(filePath);
            //2.返回这个输入流中可以被读的剩下的bytes字节的估计值；
            int size = input.available();
            //3.根据输入流的字节创建一个byte数组
            byte[] array = new byte[size];
            //4.把数据读取到byte数组中
            input.read(array);
            //5.根据获取的byte数组新建一个字符串，然后输出
            result = new String(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(input != null){
                try {
                    //关闭
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    /**
     * FileOutputStream类的使用：内容写入到文件中
     * @param filePath
     * @return
     */
    private void writeFile(String filePath,String content) {
        FileOutputStream out = null;
        try {
            //1.根据路径创建输出流对象
            out = new FileOutputStream(filePath) ;
            //2.把String字符串转换成byte数组；
            byte[] b = content.getBytes();
            //3.把byte数组输出
            out.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
