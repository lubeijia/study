package com.wy.c3p0.bean;

public class MonitorModel implements Comparable<MonitorModel> {

    private int id;// 布控信息主键
    private String title;// 标题
    private String beginDate;// 布控开始日期
    private String endDate;// 布控结束日期
    private long beginTime;// 布控开始时间
    private long endTime;// 布控结束时间
    private String area;// 布控区域
    private String carNumber;// 车辆号码
    private String carBrand;// 车辆品牌
    private String carType;// 车辆类型
    private String carYear;// 车辆年款
    private String carColor;// 车身颜色
    private String recipient;// 布控结果接收人ID
    private String comment;// 备注（案情摘要等）
    private String state;// 布控状态。0：正在布控；1：布控结束；2：撤销布控；3：删除布控
    private String carModel;// 车辆型号
    private String taskName;// 任务对应线程名称
    private String taskState;// 任务对应线程状态
    private String taskUpdateTime;// 任务对应线程最后刷新时间

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getTaskUpdateTime() {
        return taskUpdateTime;
    }

    public void setTaskUpdateTime(String taskUpdateTime) {
        this.taskUpdateTime = taskUpdateTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "MonitorModel [id=" + id + ", title=" + title + ", beginDate=" + beginDate + ", endDate=" + endDate
                + ", area=" + area + ", carNumber=" + carNumber + ", carBrand=" + carBrand + ", carType=" + carType
                + ", carYear=" + carYear + ", carColor=" + carColor + ", recipient=" + recipient + ", comment="
                + comment + ", state=" + state + ", carModel=" + carModel + ", taskName=" + taskName + ", taskState="
                + taskState + ", taskUpdateTime=" + taskUpdateTime + "]";
    }

    /**
     * 日志记录信息.
     * 
     * @return 记录信息
     * @author wuyong
     */
    public String getInfo() {
        return "ID为：" + id + "，车牌号码为：" + carNumber + "，标题为：" + title + "。";
    }

    @Override
    public int compareTo(MonitorModel monitor) {
        if (this.id < monitor.id) {
            return -1;
        }
        if (this.id > monitor.id) {
            return 1;
        }
        return 0;

    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { // 先检查是否其自反性，后比较other是否为空。这样效率高
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof MonitorModel)) {
            return false;
        }
        final MonitorModel monitor = (MonitorModel) other;
        if (monitor.getId() != this.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
