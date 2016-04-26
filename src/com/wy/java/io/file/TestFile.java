package com.wy.java.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.wy.java.io.bean.MyFile;

/**
 * @author wuyong
 * @date 2016年1月18日 下午3:09:26
 */
public class TestFile {

    public static void main(String[] args) throws InterruptedException, IOException {
//        String filepath = "F:\\video\\不可思异.HD.720p.国语中字.rmvb";
//        File file = new File(filepath);
        String fileName = "F:\\BaiduYunDownload\\蛐蛐和谐整理】[HD]香港底迪打灰机 微信公众：蛐蛐汁源\\hash.txt";
        readFileByLines(fileName);
    }

    public static void runTask(String filePath) throws FileNotFoundException, IOException {
        // Set<String> set = new HashSet<String>();
        // Map<String, MyFile> map = new HashMap<String, MyFile>();
        readfile(filePath);
    }

    /**
     * 测试md5
     * 
     * @param file
     * @throws InterruptedException
     * @throws FileNotFoundException
     * @author wuyong
     */
    public static void testMD5(File file) throws InterruptedException, FileNotFoundException {
        long t1 = 0;
        long t2 = 0;
        String value = null;
        Thread.sleep(1000);
        int count = 4;
        while (--count > 0) {

            t1 = System.currentTimeMillis();
            value = getMd5ByFile(file);
            t2 = System.currentTimeMillis();
            System.err.println("方法名：" + "getMd5ByFile");
            System.err.println("结果：" + value);
            System.err.println("计算时间：" + (t2 - t1));
            System.err.println("=================");

            t1 = System.currentTimeMillis();
            value = getFileMD5(file);
            t2 = System.currentTimeMillis();
            System.out.println("方法名：" + "getFileMD5");
            System.out.println("结果：" + value);
            System.out.println("计算时间：" + (t2 - t1));
            System.out.println("=================");
        }
    }

    /**
     * 打印文件信息
     * 
     * @param file
     * @author wuyong
     */
    public static void printFileInfo(File file) {
        System.out.println("文件名称：" + file.getName());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件的相对路径：" + file.getPath());
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("文件可以读取：" + file.canRead());
        System.out.println("文件可以写入：" + file.canWrite());
        System.out.println("文件上级路径：" + file.getParent());
        System.out.println("文件大小：" + file.length() + "B");
        System.out.println("文件最后修改时间：" + new Date(file.lastModified()));
        System.out.println("是否是文件类型：" + file.isFile());
        System.out.println("是否是文件夹类型：" + file.isDirectory());

    }

    /**
     * 打印文件信息
     * 
     * @param path
     * @throws IOException
     * @author wuyong
     */
    public static void printFileInfo2(Path path) throws IOException {
        BasicFileAttributeView basicview = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicfile = basicview.readAttributes();
        System.out.println("创建时间==" + new Date(basicfile.creationTime().toMillis()));
        System.out.println("文件大小==" + basicfile.size());
        System.out.println("fileKey==" + basicfile.fileKey());
        System.out.println("hashCode==" + basicfile.hashCode());
        System.out.println("isOther==" + basicfile.isOther());
        System.out.println("isDirectory==" + basicfile.isDirectory());
        System.out.println("isRegularFile==" + basicfile.isRegularFile());
        System.out.println("isSymbolicLink==" + basicfile.isSymbolicLink());
        System.out.println("toString==" + basicfile.toString());
        System.out.println("lastAccessTime==" + basicfile.lastAccessTime());
        System.out.println("lastModifiedTime==" + basicfile.lastModifiedTime());
    }

    /**
     * 修改文件名
     * 
     * @param file
     * @author wuyong
     * @throws FileNotFoundException
     */
    public static MyFile renameFile(File file) throws FileNotFoundException {
        MyFile myFile = new MyFile();
        String originalName = file.getName();
        String newName = originalName;
        String md5 = null;
        md5 = getMd5ByFile(file);
        if (md5 == null) {
            md5 = getFileMD5(file);
        }
        if (md5 != null) {
            newName = md5 + "_" + originalName;
        }
        String fileName = file.getAbsolutePath();
        if (fileName.indexOf(File.separator) >= 0) {
            fileName = fileName.substring(0, fileName.lastIndexOf(File.separator));
        }
        File f2 = new File(fileName + File.separator + newName);

        myFile.setName(newName);
        myFile.setMd5(md5);
        myFile.setSize(file.length());
        myFile.setTail(newName.substring(newName.lastIndexOf("."), newName.length()));
        myFile.setUuid(UUID.randomUUID().toString());
        myFile.setPath(file.getAbsolutePath());
        if (!file.renameTo(f2)) { // 改名
            System.out.println("文件改名失败！");
            System.out.println("原文件名为:" + originalName);
            System.out.println("应改为文件名:" + newName);
            System.out.println();
            return null;
        }
        return myFile;
    }

    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }

    /**
     * 删除某个文件夹下的所有文件夹和文件
     */

    /*
     * public static boolean deletefile(String delpath) throws
     * FileNotFoundException, IOException { try {
     * 
     * File file = new File(delpath); if (!file.isDirectory()) {
     * System.out.println("1"); file.delete(); } else if (file.isDirectory()) {
     * System.out.println("2"); String[] filelist = file.list(); for (int i = 0;
     * i < filelist.length; i++) { File delfile = new File(delpath + "\\" +
     * filelist[i]); if (!delfile.isDirectory()) { System.out.println("path=" +
     * delfile.getPath()); System.out.println("absolutepath=" +
     * delfile.getAbsolutePath()); System.out.println("name=" +
     * delfile.getName()); delfile.delete(); System.out.println("删除文件成功"); }
     * else if (delfile.isDirectory()) { deletefile(delpath + "\\" +
     * filelist[i]); } } file.delete();
     * 
     * }
     * 
     * } catch (FileNotFoundException e) { System.out.println(
     * "deletefile()   Exception:" + e.getMessage()); } return true; }
     */

    public static String getMd5ByFile(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * 获取单个文件的MD5值！
     * 
     * @param file
     * @return
     */
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
            showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    /** 
     * A方法追加文件：使用RandomAccessFile 
     */  
    public static void appendMethodA(String fileName, String content) {  
        try {  
            // 打开一个随机访问文件流，按读写方式  
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            //将写文件指针移到文件尾。  
            randomFile.seek(fileLength);  
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * B方法追加文件：使用FileWriter 
     */  
    public static void appendMethodB(String fileName, String content) {  
        try {  
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
            FileWriter writer = new FileWriter(fileName, true);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
