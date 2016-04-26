package com.wy.c3p0.bean;

public class MonitorResultModel {
    private int id;// 布控结果信息主键

    private int monitorInfoId;// 对应布控信息主键

    private String vhcUrl;// 图片地址

    private String carNumber;// 车牌号码

    private String carBrand;// 车辆品牌

    private String carModel;// 车辆型号

    private String carYear;// 车辆年款

    private String carSeries;// 车辆系列

    private String carSpeed;// 车速

    private String currentDate1;// 拍摄日期

    private String currentAddress;// 拍摄地点

    private String carBrandColor;// 车牌底色

    private String carColor;// 车身颜色

    private String carCharacteristic;// 车辆特征

    private String carType;// 车辆类别

    private String rate;// 匹配度

    private String plateType;// 车牌类别

    private String uuid;// UUID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonitorInfoId() {
        return monitorInfoId;
    }

    public void setMonitorInfoId(int monitorInfoId) {
        this.monitorInfoId = monitorInfoId;
    }

    public String getVhcUrl() {
        return vhcUrl;
    }

    public void setVhcUrl(String vhcUrl) {
        this.vhcUrl = vhcUrl;
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

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(String carSpeed) {
        this.carSpeed = carSpeed;
    }

    public String getCurrentDate1() {
        return currentDate1;
    }

    public void setCurrentDate1(String currentDate1) {
        this.currentDate1 = currentDate1;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getCarBrandColor() {
        return carBrandColor;
    }

    public void setCarBrandColor(String carBrandColor) {
        this.carBrandColor = carBrandColor;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarCharacteristic() {
        return carCharacteristic;
    }

    public void setCarCharacteristic(String carCharacteristic) {
        this.carCharacteristic = carCharacteristic;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPlateType() {
        return plateType;
    }

    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 用数组给监控结果对象赋值.
     * 
     * @param str
     *            字符串数组
     * @return 是否成功
     * @author wuyong
     */
    public boolean setFieldsByString(String[] str) {
        try {
            // 吴永提供的测试数据分析
            // 唯一编号+车牌号码+车牌底色+品牌+型号+年款+系列+类别+车身颜色+时间+地点+车速+图片url+特征
            /*
             * this.vhcKey = str[0]; this.vhcURL = str[12]; this.carNumber =
             * str[1]; this.carBrand = str[3]; this.carType = str[7];
             * this.carYear = str[5]; this.carSeries = str[6]; this.carSpeed =
             * str[11]; this.currentDate = str[9]; this.currentAddress =
             * str[10]; this.carBrandColor = str[2]; this.carColor = str[8];
             * this.carCharacteristic = str[13]; this.carModel = str[4];
             */
            /**
             * <p>
             * 占强提供的测试数据分析 <br/>
             * 车身颜色，品牌，类型，年款，系列，车牌号，卡口编号，车速，过车时间，车辆类别，车牌颜色，图片路径，特征值，车牌类别,UUID
             * </p>
             * <p>
             * 三所提供的文本格式 
             * 1） 车辆消息的文本格式 <br/>
             * "event_id", "time", "camera_id", "plate", "model", "type", "color", "seatbelt", "visor", "url" <br/>
             * 2） 非标车辆消息的文本格式<br/>
             * event_id,time,camera_id,semi_vehicle_type,url <br/>
             * 1.车辆消息中”seatbelt”、”visor”是指安全带和遮阳板,取值是系上，未系和放下，收起。<br/>
             * 2.非标车中的”semi_vehicle_type”的取值有电动车、三轮车、自行车等，没有颜色子段。
             * </p>
             **/
            this.vhcUrl = str[11];
            this.carNumber = str[5];
            this.carBrand = str[1];
            this.carType = str[9];
            this.carYear = str[3];
            this.carSeries = str[4];
            this.carSpeed = str[7];
            this.currentDate1 = str[8];
            this.currentAddress = str[6];
            this.carBrandColor = str[10];
            this.carColor = str[0];
            this.carCharacteristic = str[12];
            this.carModel = str[2];
            this.plateType = str[13];
            this.uuid = str[14];
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonitorResultModel [id=" + id + ", monitorInfoId=" + monitorInfoId + ", vhcUrl=" + vhcUrl
                + ", carNumber=" + carNumber + ", carBrand=" + carBrand + ", carModel=" + carModel + ", carYear="
                + carYear + ", carSeries=" + carSeries + ", carSpeed=" + carSpeed + ", currentDate1=" + currentDate1
                + ", currentAddress=" + currentAddress + ", carBrandColor=" + carBrandColor + ", carColor=" + carColor
                + ", carCharacteristic=" + carCharacteristic + ", carType=" + carType + ", rate=" + rate
                + ", plateType=" + plateType + ", uuid=" + uuid + "]";
    }
}
