package com.wy.file.bean;

/**
 * @author wuyong
 * @date 2016年1月20日 下午3:52:41
 */
public class MyFile {
    private int id;// id
    private String name;// 文件名
    private String md5;
    private String uuid;
    private String tail;// 扩展名
    private long size;// 大小
    private String path;// 文件路径
    private String insertDate;// 插入时间
    private String lastModifiedDate;// 最后一次修改时间
    private int isOnly;// 是否唯一文件：0非；1是
    private String sha1;//
    private String crc32;//
    private int isRename;// 是否重命名：0非，1是
    private int exist;// 文件是否存在：0非；1是
    private String updateDate;// 系统更新文件时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getIsOnly() {
        return isOnly;
    }

    public void setIsOnly(int isOnly) {
        this.isOnly = isOnly;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getCrc32() {
        return crc32;
    }

    public void setCrc32(String crc32) {
        this.crc32 = crc32;
    }

    public int getIsRename() {
        return isRename;
    }

    public void setIsRename(int isRename) {
        this.isRename = isRename;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "MyFile [id=" + id + ", name=" + name + ", md5=" + md5 + ", uuid=" + uuid + ", tail=" + tail + ", size="
                + size + ", path=" + path + ", insertDate=" + insertDate + ", lastModifiedDate=" + lastModifiedDate
                + ", isOnly=" + isOnly + ", sha1=" + sha1 + ", crc32=" + crc32 + ", isRename=" + isRename + ", exist="
                + exist + ", updateDate=" + updateDate + "]";
    }

}
