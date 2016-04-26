package com.wy.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.wy.c3p0.DataBaseUtil;
import com.wy.file.bean.MyFile;
import com.wy.utils.FileUtils;

/**
 * 读取F:\fs\fileInfo.data文件，并将文件内容写入数据库
 * @author wuyong
 * @date 2016年2月4日 上午9:02:29
 */
public class Main {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日，  HH:mm:ss");
    private static String currentPath = "F:" + File.separator + "fs" + File.separator;
    private static String logPath = currentPath + "log" + new Date().getTime() + ".log";
    private static String fileInfoPath = currentPath + "fileInfo.data";

    public static void main(String[] args) {
        // manageFile();// 找到文件，并读取内容，根据md5值修改文件名，并将文件信息存入数据库。
         //deleteFileOfRepeat();//删除重复的文件
        // deleteFileOfUnexist();//删除不存在的文件信息
        readFile();// 找到文件，并读取内容，根据md5值修改文件名，并打印文件信息
        printFileOfRepeat();// 打印重复文件
        printFileOfUnexist();// 打印不存在的文件
        // printFileOfUnrename(fileRootPath);// 打印未重命名的文件.
    }

//    /**
//     * 找到存有文件信息的文件.
//     * 
//     * @author wuyong
//     */
//    private static void manageFile() {
//        File file = new File(fileInfoPath);
//        if (file.isFile() && file.exists()) {// 文件存在；
//            readFileByLines(file);
//        } else {
//            String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取" + fileInfoPath + "文件失败！\r\n";
//            FileUtils.writeFile(logPath, tempLogInfo);
//            System.err.println(tempLogInfo);
//        }
//    }

    /**
     * 找到存有文件信息的文件.
     * 
     * @author wuyong
     */
    private static void readFile() {
        File file = new File(fileInfoPath);
        if (file.isFile() && file.exists()) {// 文件存在；
            readFileByLines2print(file);
        } else {
            String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取" + fileInfoPath + "文件失败！\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
    }

//    /**
//     * 读入文件内的信息，并校验，如果文件不存在、重复，做好标记，存入数据库并打印到日志文件1
//     */
//    public static void readFileByLines(File file) {
//        BufferedReader reader = null;
//        String tempStr = null;
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            while ((tempStr = reader.readLine()) != null) {// 未到文件尾，读入内容
//                boolean isFull = true;
//                MyFile myFile = new MyFile();
//                String name = tempStr.substring(tempStr.lastIndexOf(File.separator) + 1);
//                myFile.setName(name);
//                String md5 = null;
//                String uuid = UUID.randomUUID().toString();
//                myFile.setUuid(uuid);
//                String tail = name.substring(name.lastIndexOf(".") + 1, name.length());
//                myFile.setTail(tail);
//                String size = null;
//                String path = tempStr.substring(6);
//                myFile.setPath(path);
//                String lastModifiedDate = null;
//                String sha1 = null;
//                String crc32 = null;
//                File currentFile = new File(myFile.getPath());
//                if (!currentFile.exists() && tempStr.indexOf("Failed") == 0) {// 解析视频文件失败信息
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取信息对应为视频文件解析失败内容！" + tempStr + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                    tempStr = reader.readLine();
//                    tempStr = reader.readLine();
//                    tempStr = reader.readLine();
//                    continue;
//                }
//                if ((tempStr = reader.readLine()) != null) {
//                    size = tempStr.split(" ")[1];
//                    myFile.setSize(Long.parseLong(size));
//                } else {
//                    isFull = false;
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件大小失败！" + tempStr + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                }
//                if ((tempStr = reader.readLine()) != null) {
//                    lastModifiedDate = tempStr.substring(10);
//                    myFile.setLastModifiedDate(lastModifiedDate);
//                } else {
//                    isFull = false;
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件最后修改时间失败！" + tempStr + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                }
//                if ((tempStr = reader.readLine()) != null) {
//                    md5 = tempStr.split(" ")[1];
//                    myFile.setMd5(md5);
//                } else {
//                    isFull = false;
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件md5失败！" + tempStr + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                }
//                if ((tempStr = reader.readLine()) != null) {
//                    sha1 = tempStr.split(" ")[1];
//                    myFile.setSha1(sha1);
//                } else {
//                    isFull = false;
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件sha1失败！" + tempStr + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                }
//                if ((tempStr = reader.readLine()) != null) {
//                    crc32 = tempStr.split(" ")[1];
//                    myFile.setCrc32(crc32);
//                } else {
//                    isFull = false;
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件crc32失败！" + tempStr + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                }
//                if ((tempStr = reader.readLine()) != null) {// 不同文件信息以空行分隔
//
//                } else {
//                    isFull = false;
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件结尾失败！" + tempStr + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                }
//                if (isFull) {// 读取内容为完整的视频信息
//                    myFile.setInsertDate(sdf.format(new Date()));
//                    myFile.setUpdateDate(sdf.format(new Date()));
//                    List<MyFile> filesByMd5 = DataBaseUtil.selectFileByMD5(md5);
//                    if (filesByMd5.size() > 0) {// 文件是否重复
//                        myFile.setIsOnly(0);
//                    } else {
//                        myFile.setIsOnly(1);
//                    }
//                    if (!currentFile.exists()) {// 文件不存在
//                        myFile.setExist(0);
//                        myFile.setIsRename(0);
//                    } else {// 文件存在
//                        myFile.setExist(1);
//                        // 构建标准文件名
//                        String newName = myFile.getMd5() + "_" + myFile.getName();
//                        String oldFilePath = currentFile.getAbsolutePath();
//                        oldFilePath = oldFilePath.substring(0, oldFilePath.lastIndexOf(File.separator));
//                        File newFile = new File(oldFilePath + File.separator + newName);
//                        boolean success = currentFile.renameTo(newFile);
//                        if (success) {// 改名成功
//                            myFile.setName(newName);
//                            myFile.setPath(newFile.getAbsolutePath());
//                            myFile.setIsRename(1);
//                        } else {// 改名失败
//                            myFile.setIsRename(0);
//                        }
//                    }
//                    DataBaseUtil.insertFile(myFile);// 将文件信息插入数据库
//                    String tempLogInfo = "success:" + sdf.format(new Date()) + "\t文件信息存入数据库！" + myFile.toString()
//                            + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    // System.out.println(tempLogInfo);
//                } else {// 读取信息出错
//                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t文件未存入数据库！" + myFile.toString() + "\r\n";
//                    FileUtils.writeFile(logPath, tempLogInfo);
//                    System.err.println(tempLogInfo);
//                    break;
//                }
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            String logInfo = "error:" + sdf.format(new Date()) + "\t文件未存入数据库！" + tempStr + "\r\n";
//            FileUtils.writeFile(logPath, logInfo);
//            System.err.println(logInfo);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
//    }

    /**
     * 读入文件内的信息，并校验，如果文件不存在、重复，做好标记，打印文件信息
     */
    public static void readFileByLines2print(File file) {
        BufferedReader reader = null;
        String tempStr = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((tempStr = reader.readLine()) != null) {// 未到文件尾，读入内容
                boolean isFull = true;
                MyFile myFile = new MyFile();
                String name = tempStr.substring(tempStr.lastIndexOf(File.separator) + 1);
                myFile.setName(name);
                String md5 = null;
                String uuid = UUID.randomUUID().toString();
                myFile.setUuid(uuid);
                String tail = name.substring(name.lastIndexOf(".") + 1, name.length());
                myFile.setTail(tail);
                String size = null;
                String path = tempStr.substring(6);
                myFile.setPath(path);
                String lastModifiedDate = null;
                String sha1 = null;
                String crc32 = null;
                File currentFile = new File(myFile.getPath());
                if (!currentFile.exists() && tempStr.indexOf("Failed") == 0) {// 解析视频文件失败信息
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取信息对应为视频文件解析失败内容！" + tempStr + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                    tempStr = reader.readLine();
                    tempStr = reader.readLine();
                    tempStr = reader.readLine();
                    continue;
                }
                if ((tempStr = reader.readLine()) != null) {
                    size = tempStr.split(" ")[1];
                    myFile.setSize(Long.parseLong(size));
                } else {
                    isFull = false;
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件大小失败！" + tempStr + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                }
                if ((tempStr = reader.readLine()) != null) {
                    lastModifiedDate = tempStr.substring(10);
                    myFile.setLastModifiedDate(lastModifiedDate);
                } else {
                    isFull = false;
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件最后修改时间失败！" + tempStr + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                }
                if ((tempStr = reader.readLine()) != null) {
                    md5 = tempStr.split(" ")[1];
                    myFile.setMd5(md5);
                } else {
                    isFull = false;
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件md5失败！" + tempStr + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                }
                if ((tempStr = reader.readLine()) != null) {
                    sha1 = tempStr.split(" ")[1];
                    myFile.setSha1(sha1);
                } else {
                    isFull = false;
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件sha1失败！" + tempStr + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                }
                if ((tempStr = reader.readLine()) != null) {
                    crc32 = tempStr.split(" ")[1];
                    myFile.setCrc32(crc32);
                } else {
                    isFull = false;
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件crc32失败！" + tempStr + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                }
                if ((tempStr = reader.readLine()) != null) {// 不同文件信息以空行分隔

                } else {
                    isFull = false;
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t读取文件结尾失败！" + tempStr + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                }
                if (isFull) {// 读取内容为完整的视频信息
                    myFile.setInsertDate(sdf.format(new Date()));
                    myFile.setUpdateDate(sdf.format(new Date()));
                    List<MyFile> filesByMd5 = DataBaseUtil.selectFileByMD5(md5);
                    if (filesByMd5.size() > 0) {// 文件是否重复
                        myFile.setIsOnly(0);
                    } else {
                        myFile.setIsOnly(1);
                    }
                    if (!currentFile.exists()) {// 文件不存在
                        myFile.setExist(0);
                        myFile.setIsRename(0);
                    } else {// 文件存在
                        myFile.setExist(1);
                        // 构建标准文件名
                        String newName = myFile.getMd5() + "_" + myFile.getName();
                        String oldFilePath = currentFile.getAbsolutePath();
                        oldFilePath = oldFilePath.substring(0, oldFilePath.lastIndexOf(File.separator));
                        File newFile = new File(oldFilePath + File.separator + newName);
                        myFile.setIsRename(0);
                         boolean success = currentFile.renameTo(newFile);
                         if (success) {// 改名成功
                         myFile.setName(newName);
                         myFile.setPath(newFile.getAbsolutePath());
                         myFile.setIsRename(1);
                         } else {// 改名失败
                         myFile.setIsRename(0);
                         }
                    }
                     DataBaseUtil.insertFile(myFile);// 将文件信息插入数据库
                    String tempLogInfo = "success:" + sdf.format(new Date()) + "\t文件信息读取成功！" + myFile.toString()
                            + "\r\n";
                    if(myFile.getIsOnly()==0){
                        System.err.println(tempLogInfo);
                    }
                    FileUtils.writeFile(logPath, tempLogInfo);
//                     System.out.println(tempLogInfo);
                } else {// 读取信息出错
                    String tempLogInfo = "error:" + sdf.format(new Date()) + "\t文件信息读取不全！" + myFile.toString() + "\r\n";
                    FileUtils.writeFile(logPath, tempLogInfo);
                    System.err.println(tempLogInfo);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            String logInfo = "error:" + sdf.format(new Date()) + "\t文件未存入数据库！" + tempStr + "\r\n";
            FileUtils.writeFile(logPath, logInfo);
            System.err.println(logInfo);
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
     * 删除重复的文件信息，并删除对应文件。如果文件不重复，更正数据库数据。
     * 
     * @author wuyong
     */
    public static void deleteFileOfRepeat() {
        List<MyFile> myFiles = DataBaseUtil.selectAllRepeatFile();
        for (MyFile myFile : myFiles) {
            if (DataBaseUtil.selectFileByMD5(myFile.getMd5()).size() > 1) {// 再次检测，数据库中是否是有多个相同文件
                DataBaseUtil.deleteFileById(myFile.getId());// 数据库中删除文件信息
                File currentFile = new File(myFile.getPath());
                currentFile.deleteOnExit();// 删除磁盘上的对应文件
                String logInfo = "success:重复文件删除成功！" + myFile.toString() + "\r\n";
                System.out.println(logInfo);
                FileUtils.writeFile(logPath, logInfo);
            } else {
                myFile.setIsOnly(1);
                DataBaseUtil.updateFile(myFile);
                String logInfo = "error:文件不重复，更新数据库信息！" + myFile.toString() + "\r\n";
                System.err.println(logInfo);
                FileUtils.writeFile(logPath, logInfo);
            }
        }
    }

    /**
     * 打印重复文件信息
     * 
     * @author wuyong
     */
    public static void printFileOfRepeat() {
        List<MyFile> myFiles = DataBaseUtil.selectAllRepeatFile();
        System.out.println("重复文件");
        for (MyFile myFile : myFiles) {
            if (DataBaseUtil.selectFileByMD5(myFile.getMd5()).size() > 1) {// 再次检测，数据库中是否是有多个相同文件
                String logInfo = "print-success:打印重复文件成功！" + myFile.toString() + "\r\n";
                System.out.println(myFile.getMd5()+"  "+logInfo);
                FileUtils.writeFile(logPath, logInfo);
            } else {
                myFile.setIsOnly(1);
                DataBaseUtil.updateFile(myFile);
                String logInfo = "error:文件不重复，更新数据库信息！" + myFile.toString() + "\r\n";
                System.err.println(logInfo);
                FileUtils.writeFile(logPath, logInfo);
            }
        }
    }

    /**
     * 删除不存在的文件信息，如果文件存在，更正数据库数据。
     * 
     * @author wuyong
     */
    public static void deleteFileOfUnexist() {
        List<MyFile> myFiles = DataBaseUtil.selectNotExistFiles();
        for (MyFile myFile : myFiles) {
            File currentFile = new File(myFile.getPath());
            if (currentFile.exists()) {// 文件存在
                myFile.setExist(1);
                DataBaseUtil.updateFile(myFile);
                String logInfo = "error:文件存在，更新数据库信息！" + myFile.toString() + "\r\n";
                System.err.println(logInfo);
                FileUtils.writeFile(logPath, logInfo);
            } else {// 文件不存在
                DataBaseUtil.deleteFileById(myFile.getId());// 在数据库中删除文件信息
                String logInfo = "success:删除不存在文件信息成功！" + myFile.toString() + "\r\n";
                System.out.println(logInfo);
                FileUtils.writeFile(logPath, logInfo);
            }
        }
    }

    public static void printFileOfUnexist() {
        System.out.println("不存在文件");
        List<MyFile> myFiles = DataBaseUtil.selectNotExistFiles();
        for (MyFile myFile : myFiles) {
            File currentFile = new File(myFile.getPath());
            if (currentFile.exists()) {// 文件存在
                myFile.setExist(1);
                DataBaseUtil.updateFile(myFile);
                String logInfo = "error:文件存在，更新数据库信息！" + myFile.toString() + "\r\n";
                System.err.println(logInfo);
                FileUtils.writeFile(logPath, logInfo);
            } else {// 文件不存在
                String logInfo = "print-success:打印不存在文件成功！" + myFile.toString() + "\r\n";
                System.out.println(logInfo);
                FileUtils.writeFile(logPath, logInfo);
            }
        }
    }

    /**
     * 打印未重命名的文件.
     * 
     * @param filePath
     *            根目录
     * @author wuyong
     */
    public static void printFileOfUnrename(String filePath) {
        String md5 = null;
        String name = null;
        File file = new File(filePath);
        if (file.isFile()) {
            name = file.getName();
            md5 = name.split("_")[0];
            if (md5 == null || md5.isEmpty() || md5.length() < 30 || md5.length() > 33
                    || file.getName().split("_").length < 2) {
                String content = "print-success:该文件未重命名" + file.getAbsolutePath() + "\r\n";
                System.out.println(content);
                FileUtils.writeFile(logPath, content);
            }
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                printFileOfUnrename(filePath + File.separator + filelist[i]);
            }
        }
    }
}
