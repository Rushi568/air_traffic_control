/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kali
 */
public class Flight {
    private String hexNumber;       //0
    private double latitude;        //1    
    private double longitude;       //2
    private int direction;          //3
    private int altitude;           //4
    private int speed;              //5
    private String unknown1;        //6
    private String radarTech;       //7
    private String aircraftType;    //8
    private String airframeInfo;    //9
    private long timestamp;         //10
    private String sourceApt;       //11
    private String destApt;         //12
    private String flightnumber;    //13
    private String unknown2;        //14
    private String unknown3;        //15
    private String tailnumber;      //16 
    private String unknown4;        //17

    @Override
    public String toString() {
        return "Flight{" + "hexNumber=" + hexNumber + ", latitude=" + latitude + ", longitude=" + longitude + ", direction=" + direction + ", altitude=" + altitude + ", speed=" + speed + ", unknown1=" + unknown1 + ", radarTech=" + radarTech + ", aircraftType=" + aircraftType + ", airframeInfo=" + airframeInfo + ", timestamp=" + timestamp + ", sourceApt=" + sourceApt + ", destApt=" + destApt + ", flightnumber=" + flightnumber + ", unknown2=" + unknown2 + ", unknown3=" + unknown3 + ", tailnumber=" + tailnumber + ", unknown4=" + unknown4 + '}';
    }

    public String getHexNumber() {
        return hexNumber;
    }

    public void setHexNumber(String hexNumber) {
        this.hexNumber = hexNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(String unknown1) {
        this.unknown1 = unknown1;
    }

    public String getRadarTech() {
        return radarTech;
    }

    public void setRadarTech(String radarTech) {
        this.radarTech = radarTech;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAirframeInfo() {
        return airframeInfo;
    }

    public void setAirframeInfo(String airframeInfo) {
        this.airframeInfo = airframeInfo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSourceApt() {
        return sourceApt;
    }

    public void setSourceApt(String sourceApt) {
        this.sourceApt = sourceApt;
    }

    public String getDestApt() {
        return destApt;
    }

    public void setDestApt(String destApt) {
        this.destApt = destApt;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(String unknown2) {
        this.unknown2 = unknown2;
    }

    public String getUnknown3() {
        return unknown3;
    }

    public void setUnknown3(String unknown3) {
        this.unknown3 = unknown3;
    }

    public String getTailnumber() {
        return tailnumber;
    }

    public void setTailnumber(String tailnumber) {
        this.tailnumber = tailnumber;
    }

    public String getUnknown4() {
        return unknown4;
    }

    public void setUnknown4(String unknown4) {
        this.unknown4 = unknown4;
    }
    
    
}
