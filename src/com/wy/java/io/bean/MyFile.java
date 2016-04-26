package com.wy.java.io.bean;

/**
 * @author wuyong
 * @date 2016年1月20日 下午3:52:41
 */
public class MyFile {
    private String name;
    private String md5;
    private String uuid;
    private String tail;
    private long size;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    @Override
    public String toString() {
        return "MyFile [name=" + name + ", md5=" + md5 + ", uuid=" + uuid + ", tail=" + tail + ", size=" + size
                + ", path=" + path + "]";
    }
}
