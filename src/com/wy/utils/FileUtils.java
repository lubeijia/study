package com.wy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.wy.c3p0.DataBaseUtil;
import com.wy.file.bean.MyFile;

/**
 * @author wuyong
 * @date 2016年2月3日 下午3:54:38
 */
public class FileUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日，  HH:mm:ss");
    private static String currentPath = "F:" + File.separator + "fs" + File.separator;
    private static String logPath = currentPath + "log.log";

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void writeFile(String fileName, String content) {

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(fileName, true);// true表明会追加内容
            PrintWriter pw = new PrintWriter(fos);
            pw.write(content);
            pw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取某个文件夹下的所有文件,并将已经重命名的文件信息存入到数据库
     */
    public static void scanFile(String filePath) {
        String md5 = null;
        String name = null;
        File file = new File(filePath);
        if (file.isFile()) {
            name = file.getName();
            md5 = name.split("_")[0];
            if (md5.length() > 30 && md5.length() < 33 && file.getName().split("_").length > 1) {
                MyFile myFile = new MyFile();
                myFile.setExist(1);
                myFile.setInsertDate(sdf.format(new Date()));
                myFile.setIsRename(1);
                myFile.setIsOnly(1);
                myFile.setLastModifiedDate(sdf.format(file.lastModified()));
                myFile.setMd5(md5);
                myFile.setName(file.getName());
                myFile.setPath(file.getAbsolutePath());
                myFile.setSize(file.length());
                myFile.setTail(name.substring(name.lastIndexOf(".") + 1));
                myFile.setUpdateDate(sdf.format(new Date()));
                myFile.setUuid(UUID.randomUUID().toString());
                DataBaseUtil.insertFile(myFile);
            } else {
                String content = "分析文件失败！" + filePath + "\r\n";
                System.out.println(content);
                FileUtils.writeFile(logPath, content);
            }
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                scanFile(filePath + File.separator + filelist[i]);
            }
        }
    }

    /**
     * 遍历数据库，将其中文件名包含2个及以上的md5的文件修改文件名，并更新数据库中的信息。
     * 
     * @author wuyong
     */
    public static void upDataFileInfoAndUpdateDB() {
        List<MyFile> files = DataBaseUtil.selectAllFile();
        for (MyFile myFile : files) {
            File currentFile = new File(myFile.getPath());
            if (currentFile.exists()) {// 文件存在
                String[] names = myFile.getName().split("_");
                if (names.length > 2 && names[0].equals(names[1])) {
                    // 构建标准文件名
                    String newName = myFile.getName().substring(names[0].length() + 1);
                    String oldFilePath = myFile.getPath();
                    oldFilePath = oldFilePath.substring(0, oldFilePath.lastIndexOf(File.separator));
                    File newFile = new File(oldFilePath + File.separator + newName);
                    boolean success = currentFile.renameTo(newFile);
                    if (success) {
                        myFile.setName(newName);
                        myFile.setPath(newFile.getAbsolutePath());
                        myFile.setIsRename(1);
                        DataBaseUtil.updateFile(myFile);
                        System.out.println(myFile.toString());
                    } else {
                        String content = "修改文件名，删除冗余信息失败！" + myFile.toString() + "\r\n";
                        System.out.println(content);
                    }
                }

                // if (md5s.contains(myFile.getMd5())) {// md5重复
                // List<MyFile> files2 = db.selectFileByMD5(myFile.getMd5());
                // for (MyFile myFile2 : files2) {
                // myFile2.setIsRepeat(1);
                // db.updateFile(myFile2);
                // }
                // } else {// md5不重复
                // md5s.add(myFile.getMd5());
                // myFile.setIsRepeat(0);
                // db.updateFile(myFile);
                // }
            } else {// 文件不存在
                myFile.setExist(2);
                DataBaseUtil.updateFile(myFile);
                System.err.println("文件不存在" + myFile.toString());
                // db.deleteFileById(myFile.getId());
            }
        }
    }

    /**
     * 遍历数据库，并将不存在的文件标记为2，重复的文件只保留一个，删除其他文件。
     * 
     * @author wuyong
     */
    public static void updateDBandDeleteRepeatFile() {

        List<MyFile> files = DataBaseUtil.selectAllFile();
        for (MyFile myFile : files) {
            File currentFile = new File(myFile.getPath());
            if (currentFile.exists()) {// 文件存在
                if (myFile.getIsOnly() == 0) {
                    List<MyFile> files2 = DataBaseUtil.selectFileByMD5(myFile.getMd5());
                    for (MyFile file : files2) {
                        if (myFile.getId() != file.getId()) {
                            File deleteFile = new File(file.getPath());
                            if (deleteFile.exists()) {
                                if (deleteFile.delete()) {
                                    file.setExist(2);
                                    DataBaseUtil.updateFile(file);
                                } else {
                                    System.out.println("删除文件失败" + file);
                                }
                            } else {
                                if (file.getExist() != 2) {
                                    file.setExist(2);
                                    DataBaseUtil.updateFile(file);
                                    System.err.println("文件不存在" + file.toString());
                                }
                                System.out.println("文件不存在" + myFile);
                            }
                        }
                    }
                    myFile.setIsOnly(1);
                    myFile.setExist(1);
                    DataBaseUtil.updateFile(myFile);
                }
            } else {// 文件不存在
                if (myFile.getExist() != 2) {
                    myFile.setExist(2);
                    DataBaseUtil.updateFile(myFile);
                    System.err.println("文件不存在" + myFile.toString());
                }
            }
        }
    }

    /**
     * 删除不存在的文件信息记录
     * 
     * @author wuyong
     */
    public static void updateDBdeleteInfoByNotExistFile() {
        List<MyFile> myFiles = DataBaseUtil.selectNotExistFiles();
        for (MyFile myFile : myFiles) {
            DataBaseUtil.deleteFileById(myFile.getId());
        }

    }
}
