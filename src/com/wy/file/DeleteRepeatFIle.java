package com.wy.file;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.wy.c3p0.DataBaseUtil;
import com.wy.file.bean.MyFile;
import com.wy.utils.FileUtils;

/**
 * 删除重复文件，并更新数据库。
 * @author wuyong
 * @date 2016年2月4日 上午9:02:29
 */
public class DeleteRepeatFIle {
    private static String currentPath = "F:" + File.separator + "fs" + File.separator;
    private static String logPath = currentPath + "log" + new Date().getTime() + ".log";

    public static void main(String[] args) {
         deleteFileOfRepeat();//删除重复的文件
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
}

