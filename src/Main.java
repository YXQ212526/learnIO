import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import java.io.FileReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    //1. 输出到一个文件, FileOutputStream以字符串形式
    try {
      OutputStream outputStream = new FileOutputStream("/Users/yuanxueqi/myIOFile");
      byte[] bytes = "this is from java".getBytes();
      outputStream.write(bytes);
      outputStream.close();
    } catch (Exception e) {
      System.out.println("exception");
    }
    // 1.1 输出到一个文件, FileOutputStream以file对象形式
    try {
      File f = new File("/Users/yuanxueqi/myIOFile1.1");
      OutputStream outputStream = new FileOutputStream(f);
      byte[] bytes = "hello".getBytes();
      //1.1.1全部写入
      //outputStream.write(bytes);
      //1.1.2 从bytes里偏移2，只写入2长度
      outputStream.write(bytes, 2, 2);

      outputStream.close();
    } catch (Exception e) {
      System.out.println("exception");
    }

    try {
      File f = new File("/Users/yuanxueqi/myIOFile1.1");
      FileWriter fileWriter = new FileWriter(f);
      BufferedWriter writer = new BufferedWriter(fileWriter);

      writer.write("how");
      writer.close();
      fileWriter.close();
    } catch (Exception e) {
      System.out.println("exception");
    }
    // 追加模式，默认是不追加，把文件清空开始写
    try {
      File f = new File("/Users/yuanxueqi/myIOFile1.1");
      FileWriter fileWriter = new FileWriter(f, true);

      fileWriter.write("ok");

      fileWriter.close();
    } catch (Exception e) {
      System.out.println("exception");
    }

    OutputStream outputStream = new FileOutputStream("/Users/yuanxueqi/myIOFile", true);
    byte[] bytes = "this is from java".getBytes();
    outputStream.write(bytes);
    outputStream.close();

    // 2. 输入到字节流中
    try {
      InputStream inputStream = new FileInputStream("/Users/yuanxueqi/myIOFile");

      int size = inputStream.available();
      byte[] bytes = new byte[100];

      inputStream.read(bytes, 0, size);
      inputStream.close();

      System.out.println(bytes);
    } catch (Exception e) {
      System.out.println("exception");
    }

    // 3. 输入到字符串中
    try {
      InputStream inputStream = new FileInputStream("/Users/yuanxueqi/myIOFile");

      int size = inputStream.available();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < size; i++) {
        sb.append((char) inputStream.read());
      }

      inputStream.close();

      System.out.println(sb);
    } catch (Exception e) {
      System.out.println("exception");
    }
    //  3.1 输入到字节串中
    try {
      File f = new File("/Users/yuanxueqi/myIOFile1.1");
      InputStream inputStream = new FileInputStream(f);

      int size = inputStream.available();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < size; i++) {
        sb.append((char) inputStream.read());
      }

      inputStream.close();

      System.out.println(sb);
    } catch (Exception e) {
      System.out.println("exception");
    }

    FileInputStream f = new FileInputStream("/Users/yuanxueqi/myIOFile1.1");
    InputStreamReader reader = new InputStreamReader(f);
    StringBuffer sb = new StringBuffer();
    while (reader.ready()) {
      sb.append((char) reader.read());
    }
    System.out.println(sb);
    reader.close();
    f.close();

    FileReader fileReader = new FileReader("/Users/yuanxueqi/myIOFile1.1");
    StringBuffer sb = new StringBuffer();
    while (fileReader.ready()) {
      sb.append((char) fileReader.read());
    }
    System.out.println(sb);
    fileReader.close();
  }
}
