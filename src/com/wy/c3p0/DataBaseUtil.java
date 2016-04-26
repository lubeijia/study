package com.wy.c3p0;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

import com.wy.c3p0.bean.MonitorModel;
import com.wy.c3p0.bean.MonitorResultModel;
import com.wy.constants.Constants;
import com.wy.file.bean.MyFile;
import com.wy.utils.FileUtils;

public class DataBaseUtil {
    private static final ConnectionPool POOL = ConnectionPool.getInstance();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日，  HH:mm:ss");
    private static String currentPath = "F:" + File.separator + "fs" + File.separator;
    private static String logPath = currentPath + "log.log";

    public static void main(String[] args) {
        DataBaseUtil.selectAllFile();
    }
    
    
    /**
     * 插入文件信息.
     * 
     * @param myFile
     * @return
     * @author wuyong
     */
    public static boolean insertFile(MyFile myFile) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO `file` ( ");
        sb.append("`id`, ");
        sb.append("`name`, ");
        sb.append("`md5`, ");
        sb.append("`uuid`, ");
        sb.append("`tail`, ");
        sb.append("`size`, ");
        sb.append("`path`, ");
        sb.append("`insertDate`, ");
        sb.append("`lastModifiedDate`, ");
        sb.append("`isOnly`, ");
        sb.append("`sha1`, ");
        sb.append("`crc32`, ");
        sb.append("`isRename`, ");
        sb.append("`exist`, ");
        sb.append("`updateDate` ");
        sb.append(")");
        sb.append("VALUE ");
        sb.append("( ");
        sb.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
        sb.append(" ); ");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, myFile.getId());
            ps.setString(2, myFile.getName());
            ps.setString(3, myFile.getMd5());
            ps.setString(4, myFile.getUuid());
            ps.setString(5, myFile.getTail());
            ps.setString(6, String.valueOf(myFile.getSize()));
            ps.setString(7, myFile.getPath());
            ps.setString(8, myFile.getInsertDate());
            ps.setString(9, myFile.getLastModifiedDate());
            ps.setInt(10, myFile.getIsOnly());
            ps.setString(11, myFile.getSha1());
            ps.setString(12, myFile.getCrc32());
            ps.setInt(13, myFile.getIsRename());
            ps.setInt(14, myFile.getExist());
            ps.setString(15, myFile.getUpdateDate());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("文件信息插入数据库失败！" + myFile.toString());
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "文件信息插入数据库失败！" + myFile.toString() + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 更新文件信息.
     * 
     * @param myFile
     * @return
     * @author wuyong
     */
    public static boolean updateFile(MyFile myFile) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE `file` ");
        sb.append(" SET ");
        sb.append(" `name` = ?, ");
        sb.append(" `md5` = ?, ");
        sb.append(" `uuid` = ?, ");
        sb.append(" `tail` = ?, ");
        sb.append(" `size` = ?, ");
        sb.append(" `path` = ?, ");
        sb.append(" `insertDate` = ?, ");
        sb.append(" `lastModifiedDate` = ?, ");
        sb.append(" `isOnly` = ?, ");
        sb.append(" `sha1` = ?, ");
        sb.append(" `crc32` = ?, ");
        sb.append(" `isRename` = ?, ");
        sb.append(" `exist` = ?, ");
        sb.append(" `updateDate` = ? ");
        sb.append("WHERE");
        sb.append(" `id` = ? ");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, myFile.getName());
            ps.setString(2, myFile.getMd5());
            ps.setString(3, myFile.getUuid());
            ps.setString(4, myFile.getTail());
            ps.setString(5, String.valueOf(myFile.getSize()));
            ps.setString(6, myFile.getPath());
            ps.setString(7, myFile.getInsertDate());
            ps.setString(8, myFile.getLastModifiedDate());
            ps.setInt(9, myFile.getIsOnly());
            ps.setString(10, myFile.getSha1());
            ps.setString(11, myFile.getCrc32());
            ps.setInt(12, myFile.getIsRename());
            ps.setInt(13, myFile.getExist());
            ps.setString(14, myFile.getUpdateDate());
            ps.setInt(15, myFile.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("文件信息在数据库更新失败！" + myFile.toString());
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "文件信息在数据库更新失败！" + myFile.toString() + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 删除文件信息.
     * 
     * @param id
     * @return
     * @author wuyong
     */
    public static boolean deleteFileById(int id) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" `id` = ?");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("数据库删除文件信息失败！id= " + id);
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "数据库删除文件信息失败！id= " + id + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 根据md5判断文件是否重复.
     * 
     * @param md5
     * @return
     * @author wuyong
     */
    public static boolean isReapet(String md5) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT count(`id`) ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" `md5` = ?");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, md5);
            rs = ps.executeQuery();
            if (rs.next() && (rs.getInt(1) > 0)) {
                result = true;
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("判断数据库中文件是否重复失败！md5= " + md5);
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "判断数据库中文件是否重复失败！md5= " + md5 + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 根据md5获取文件信息.
     * 
     * @param md5
     * @return
     * @author wuyong
     */
    public static List<MyFile> selectFileByMD5(String md5) {
        List<MyFile> result = new LinkedList<MyFile>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" `md5` = ?");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, md5);
            rs = ps.executeQuery();
            while (rs.next()) {
                MyFile myFile = new MyFile();
                myFile.setId(rs.getInt(1));
                myFile.setName(rs.getString(2));
                myFile.setMd5(rs.getString(3));
                myFile.setUuid(rs.getString(4));
                myFile.setTail(rs.getString(5));
                myFile.setSize(Long.valueOf(rs.getString(6)));
                myFile.setPath(rs.getString(7));
                myFile.setInsertDate(rs.getString(8));
                myFile.setLastModifiedDate(rs.getString(9));
                myFile.setIsOnly(rs.getInt(10));
                myFile.setSha1(rs.getString(11));
                myFile.setCrc32(rs.getString(12));
                myFile.setIsRename(rs.getInt(13));
                myFile.setExist(rs.getInt(14));
                myFile.setUpdateDate(rs.getString(15));
                result.add(myFile);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("在数据库中查询文件失败！md5= " + md5);
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "在数据库中查询文件失败！md5= " + md5 + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 获取所有文件信息.
     * 
     * @return
     * @author wuyong
     */
    public static List<MyFile> selectAllFile() {
        List<MyFile> result = new LinkedList<MyFile>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * ");
        sb.append("FROM  `file` where 1=1 ");
        sb.append(" and `exist` != 2");
        // sb.append(" and id>3693 ");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                MyFile myFile = new MyFile();
                myFile.setId(rs.getInt(1));
                myFile.setName(rs.getString(2));
                myFile.setMd5(rs.getString(3));
                myFile.setUuid(rs.getString(4));
                myFile.setTail(rs.getString(5));
                myFile.setSize(Long.valueOf(rs.getString(6)));
                myFile.setPath(rs.getString(7));
                myFile.setInsertDate(rs.getString(8));
                myFile.setLastModifiedDate(rs.getString(9));
                myFile.setIsOnly(rs.getInt(10));
                myFile.setSha1(rs.getString(11));
                myFile.setCrc32(rs.getString(12));
                myFile.setIsRename(rs.getInt(13));
                myFile.setExist(rs.getInt(14));
                myFile.setUpdateDate(rs.getString(15));
                result.add(myFile);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("在数据库中查询所有文件失败！ ");
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "在数据库中查询所有文件失败！ " + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 获取所有重复文件信息
     * 
     * @return
     * @author wuyong
     */
    public static List<MyFile> selectAllRepeatFile() {
        List<MyFile> result = new LinkedList<MyFile>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" `isOnly` = ?");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, 0);
            rs = ps.executeQuery();
            while (rs.next()) {
                MyFile myFile = new MyFile();
                myFile.setId(rs.getInt(1));
                myFile.setName(rs.getString(2));
                myFile.setMd5(rs.getString(3));
                myFile.setUuid(rs.getString(4));
                myFile.setTail(rs.getString(5));
                myFile.setSize(Long.valueOf(rs.getString(6)));
                myFile.setPath(rs.getString(7));
                myFile.setInsertDate(rs.getString(8));
                myFile.setLastModifiedDate(rs.getString(9));
                myFile.setIsOnly(rs.getInt(10));
                myFile.setSha1(rs.getString(11));
                myFile.setCrc32(rs.getString(12));
                myFile.setIsRename(rs.getInt(13));
                myFile.setExist(rs.getInt(14));
                myFile.setUpdateDate(rs.getString(15));
                result.add(myFile);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("在数据库中查询搜友重复文件失败！");
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "在数据库中查询搜友重复文件失败！" + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 获取所有未重命名文件
     * 
     * @return
     * @author wuyong
     */
    public static List<MyFile> selectAllUnrenameFile() {
        List<MyFile> result = new LinkedList<MyFile>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" `isRename` = ?");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, 0);
            rs = ps.executeQuery();
            while (rs.next()) {
                MyFile myFile = new MyFile();
                myFile.setId(rs.getInt(1));
                myFile.setName(rs.getString(2));
                myFile.setMd5(rs.getString(3));
                myFile.setUuid(rs.getString(4));
                myFile.setTail(rs.getString(5));
                myFile.setSize(Long.valueOf(rs.getString(6)));
                myFile.setPath(rs.getString(7));
                myFile.setInsertDate(rs.getString(8));
                myFile.setLastModifiedDate(rs.getString(9));
                myFile.setIsOnly(rs.getInt(10));
                myFile.setSha1(rs.getString(11));
                myFile.setCrc32(rs.getString(12));
                myFile.setIsRename(rs.getInt(13));
                myFile.setExist(rs.getInt(14));
                myFile.setUpdateDate(rs.getString(15));
                result.add(myFile);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("在数据库中查询所有未重命名文件失败！");
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "在数据库中查询所有未重命名文件失败！" + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 获取文件个数
     * 
     * @return
     * @author wuyong
     */
    public static int getFileCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT count(*) as count ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" 1=1 ");
        int count = 0;
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "在数据库中查询文件个数失败！" + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return count;
    }

    /**
     * 分页获取文件
     * 
     * @return
     * @author wuyong
     */
    public static List<MyFile> selectFilesByPage(int begin, int count) {
        List<MyFile> result = new LinkedList<MyFile>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" 1=1 ");
        sb.append(" and `exist` != 2 ");
        sb.append(" limit ?,? ");

        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, begin);
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                MyFile myFile = new MyFile();
                myFile.setId(rs.getInt(1));
                myFile.setName(rs.getString(2));
                myFile.setMd5(rs.getString(3));
                myFile.setUuid(rs.getString(4));
                myFile.setTail(rs.getString(5));
                myFile.setSize(Long.valueOf(rs.getString(6)));
                myFile.setPath(rs.getString(7));
                myFile.setInsertDate(rs.getString(8));
                myFile.setLastModifiedDate(rs.getString(9));
                myFile.setIsOnly(rs.getInt(10));
                myFile.setSha1(rs.getString(11));
                myFile.setCrc32(rs.getString(12));
                myFile.setIsRename(rs.getInt(13));
                myFile.setExist(rs.getInt(14));
                myFile.setUpdateDate(rs.getString(15));
                result.add(myFile);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "在数据库中分页获取文件信息失败！" + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }

    /**
     * 获取所有不存在的文件信息。
     * 
     * @return
     * @author wuyong
     */
    public static List<MyFile> selectNotExistFiles() {
        List<MyFile> result = new LinkedList<MyFile>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * ");
        sb.append("FROM  `file` ");
        sb.append(" WHERE ");
        sb.append(" 1=1 ");
        sb.append(" and `exist` = 0 ");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                MyFile myFile = new MyFile();
                myFile.setId(rs.getInt(1));
                myFile.setName(rs.getString(2));
                myFile.setMd5(rs.getString(3));
                myFile.setUuid(rs.getString(4));
                myFile.setTail(rs.getString(5));
                myFile.setSize(Long.valueOf(rs.getString(6)));
                myFile.setPath(rs.getString(7));
                myFile.setInsertDate(rs.getString(8));
                myFile.setLastModifiedDate(rs.getString(9));
                myFile.setIsOnly(rs.getInt(10));
                myFile.setSha1(rs.getString(11));
                myFile.setCrc32(rs.getString(12));
                myFile.setIsRename(rs.getInt(13));
                myFile.setExist(rs.getInt(14));
                myFile.setUpdateDate(rs.getString(15));
                result.add(myFile);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            String tempLogInfo = sdf.format(new Date()) + "在数据库中获取不存在的文件信息失败！" + "\r\n";
            FileUtils.writeFile(logPath, tempLogInfo);
            System.err.println(tempLogInfo);
        }
        return result;
    }
    /**
     * 更新布控信息状态.
     * 
     * @author wuyong
     * @date 2015年11月17日
     * @param monitor
     *            布控信息
     */
    public void updateMonitorStateById(MonitorModel monitor) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE `MONITOR_INFO`");
        sb.append("SET `STATE` = ?");
        sb.append("WHERE");
        sb.append("`ID` =?");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, monitor.getState());
            ps.setInt(2, monitor.getId());
            ps.executeUpdate();
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询布控信息.
     * 
     * @author wuyong
     * @date 2015年11月17日
     * @return 布控信息列表
     */
    public List<MonitorModel> selectMonitor() {
        LinkedList<MonitorModel> monitors = new LinkedList<MonitorModel>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT");
        sb.append("*");
        sb.append("FROM");
        sb.append("`MONITOR_INFO`");
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                MonitorModel monitor = new MonitorModel();
                monitor.setId(rs.getInt(1));
                monitor.setTitle(rs.getString(2));
                monitor.setBeginDate(rs.getString(3));
                monitor.setEndDate(rs.getString(4));
                monitor.setArea(rs.getString(5));
                monitor.setCarNumber(rs.getString(6));
                monitor.setCarBrand(rs.getString(7));
                monitor.setCarType(rs.getString(8));
                monitor.setCarYear(rs.getString(9));
                monitor.setCarColor(rs.getString(10));
                monitor.setRecipient(rs.getString(11));
                monitor.setComment(rs.getString(12));
                monitor.setState(rs.getString(13));
                monitor.setCarModel(rs.getString(14));
                monitor.setTaskName(rs.getString(15));
                monitor.setTaskState(rs.getString(16));
                monitor.setTaskUpdateTime(rs.getString(17));
                monitor.setBeginTime(DateUtils
                        .parseDate(monitor.getBeginDate(), new String[] { Constants.EASYUI_DATE_TIME }).getTime());
                // monitor.setBeginTime(sdf.parse(monitor.getBeginDate()).getTime());
                monitor.setEndTime(DateUtils
                        .parseDate(monitor.getEndDate(), new String[] { Constants.EASYUI_DATE_TIME }).getTime());
                // monitor.setEndTime(sdf.parse(monitor.getEndDate()).getTime());
                monitors.add(monitor);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            System.err.println("查询数据库，获取布控信息失败！");
        } catch (ParseException e) {
            System.err.println("布控时间格式转换异常！");
        }
        return monitors;
    }

    /**
     * 插入布控结果信息.
     * 
     * @author wuyong
     * @date 2015年11月17日
     * @param monitorResult
     *            布控结果信息
     */
    public void insertMonitorResult(MonitorResultModel monitorResult) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO `MONITOR_RESULT` (");
        sb.append("`MONITOR_INFO_ID`,");
        sb.append("`VHC_URL`,");
        sb.append("`CAR_NUMBER`,");
        sb.append("`CAR_BRAND`,");
        sb.append("`CAR_TYPE`,");
        sb.append("`CAR_YEAR`,");
        sb.append("`CAR_SERIES`,");
        sb.append("`CAR_SPEED`,");
        sb.append("`CURRENT_DATE1`,");
        sb.append("`CURRENT_ADDRESS`,");
        sb.append("`CAR_BRAND_COLOR`,");
        sb.append("`CAR_COLOR`,");
        sb.append("`CAR_CHARACTERISTIC`,");
        sb.append("`CAR_MODEL`,");
        sb.append("`RATE`,");
        sb.append("`PLATE_TYPE`,");
        sb.append("`UUID`");
        sb.append(")");
        sb.append("VALUE");
        sb.append("(");
        sb.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
        sb.append(" );");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, monitorResult.getMonitorInfoId());
            ps.setString(2, monitorResult.getVhcUrl());
            ps.setString(3, monitorResult.getCarNumber());
            ps.setString(4, monitorResult.getCarBrand());
            ps.setString(5, monitorResult.getCarType());
            ps.setString(6, monitorResult.getCarYear());
            ps.setString(7, monitorResult.getCarSeries());
            ps.setString(8, monitorResult.getCarSpeed());
            ps.setString(9, monitorResult.getCurrentDate1());
            ps.setString(10, monitorResult.getCurrentAddress());
            ps.setString(11, monitorResult.getCarBrandColor());
            ps.setString(12, monitorResult.getCarColor());
            ps.setString(13, monitorResult.getCarCharacteristic());
            ps.setString(14, monitorResult.getCarModel());
            ps.setString(15, monitorResult.getRate());
            ps.setString(16, monitorResult.getPlateType());
            ps.setString(16, monitorResult.getUuid());
            ps.executeUpdate();
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新布控查缉监控者当前运行数量.
     * 
     * @author wuyong
     * @date 2015年11月17日
     * @param count
     *            个数
     */
    public void updateMonitorManagerCount(int count) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE `SYS_DICTIONARY`");
        sb.append("SET `VALUE_1` = ? ");
        sb.append("WHERE");
        sb.append(" `CATEGORYCODE` = 'monitor' and `ITEMCODE`  = 'managerCount'");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, String.valueOf(count));
            ps.executeUpdate();
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取结构化视频数据近七日总量.
     * 
     * @return 视频总量封装数据
     * @author wuyong
     */
    public List<Map<String, String>> selectSvdCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        List<Map<String, String>> result = new LinkedList<Map<String, String>>();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        sb.append("VALUE_2,VALUE_1 ");
        sb.append("FROM ");
        sb.append("SYS_DICTIONARY ");
        sb.append("WHERE ");
        sb.append("CATEGORYCODE = 'svd_count' ");
        sb.append("ORDER BY VALUE_2  DESC ");
        sb.append("LIMIT 0,7 ");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, String> data = new HashMap<String, String>();
                data.put(rs.getString(1), rs.getString(2));
                result.add(data);
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新结构化视频数据量.
     * 
     * @param svdCountList
     *            结构化数据量参数
     * @author wuyong
     */
    public void updateSvdCount(List<Map<String, String>> svdCountList) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ");
        sb.append("`SYS_DICTIONARY` ");
        sb.append("SET ");
        sb.append("VALUE_1 = ?, ");
        sb.append("VALUE_2 = ? ");
        sb.append("WHERE");
        sb.append(" CATEGORYCODE = 'svd_count' and ITEMCODE  = ?");
        try {
            for (int i = 0; i < 7 && i < svdCountList.size(); i++) {
                ps = conn.prepareStatement(sb.toString());
                String value_2 = svdCountList.get(i).keySet().toArray()[0].toString();
                String value_1 = svdCountList.get(i).get(value_2);
                String itemCode = "day" + (i + 1);
                ps.setString(1, value_1);
                ps.setString(2, value_2);
                ps.setString(3, itemCode);
                ps.executeUpdate();
            }
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新过车指数监控者当前运行数量.
     * 
     * @param count
     *            个数
     * @author wuyong
     */
    public void updateGczsCount(int count) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = POOL.getConnection();
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ");
        sb.append("`SYS_DICTIONARY` ");
        sb.append("SET ");
        sb.append("`VALUE_1` = ? ");
        sb.append("WHERE");
        sb.append(" `CATEGORYCODE` = 'gczs' and `ITEMCODE`  = 'runningCount'");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setString(1, String.valueOf(count));
            ps.executeUpdate();
            ConnectionPool.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
