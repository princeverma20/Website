package dbms.railway.models;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class Availability {
    private Long trainId;
    private String trainTime;
    private String trainName;
    private String St1;
    private String St2;
    private String arrivalTime;

    private String departureTime;
    private int distance;
    private int ac1;

    private float fac1;
    private int wac1;
    private boolean iac1;
    private int ac2;
    private float fac2;
    private int wac2;
    private boolean iac2;
    private int ac3;
    private float fac3;
    private int wac3;
    private boolean iac3;
    private int slp;
    private float fslp;
    private int wslp;
    private boolean islp;
    private int gen;
    private float fgen;
    private int wgen;
    private boolean igen;

    public Availability(Long trainId, String trainTime, String trainName, String st1, String st2, String arrivalTime, String departureTime, int distance, int ac1, float fac1, int wac1, boolean iac1, int ac2, float fac2, int wac2, boolean iac2, int ac3, float fac3, int wac3, boolean iac3, int slp, float fslp, int wslp, boolean islp, int gen, float fgen, int wgen, boolean igen) {
        this.trainId = trainId;
        this.trainTime = trainTime;
        this.trainName = trainName;
        St1 = st1;
        St2 = st2;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.distance = distance;
        this.ac1 = ac1;
        this.fac1 = fac1;
        this.wac1 = wac1;
        this.iac1 = iac1;
        this.ac2 = ac2;
        this.fac2 = fac2;
        this.wac2 = wac2;
        this.iac2 = iac2;
        this.ac3 = ac3;
        this.fac3 = fac3;
        this.wac3 = wac3;
        this.iac3 = iac3;
        this.slp = slp;
        this.fslp = fslp;
        this.wslp = wslp;
        this.islp = islp;
        this.gen = gen;
        this.fgen = fgen;
        this.wgen = wgen;
        this.igen = igen;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(String trainTime) {
        this.trainTime = trainTime;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSt1() {
        return St1;
    }

    public void setSt1(String st1) {
        St1 = st1;
    }

    public String getSt2() {
        return St2;
    }

    public void setSt2(String st2) {
        St2 = st2;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getAc1() {
        return ac1;
    }

    public void setAc1(int ac1) {
        this.ac1 = ac1;
    }

    public float getFac1() {
        return fac1;
    }

    public void setFac1(float fac1) {
        this.fac1 = fac1;
    }

    public int getWac1() {
        return wac1;
    }

    public void setWac1(int wac1) {
        this.wac1 = wac1;
    }

    public boolean isIac1() {
        return iac1;
    }

    public void setIac1(boolean iac1) {
        this.iac1 = iac1;
    }

    public int getAc2() {
        return ac2;
    }

    public void setAc2(int ac2) {
        this.ac2 = ac2;
    }

    public float getFac2() {
        return fac2;
    }

    public void setFac2(float fac2) {
        this.fac2 = fac2;
    }

    public int getWac2() {
        return wac2;
    }

    public void setWac2(int wac2) {
        this.wac2 = wac2;
    }

    public boolean isIac2() {
        return iac2;
    }

    public void setIac2(boolean iac2) {
        this.iac2 = iac2;
    }

    public int getAc3() {
        return ac3;
    }

    public void setAc3(int ac3) {
        this.ac3 = ac3;
    }

    public float getFac3() {
        return fac3;
    }

    public void setFac3(float fac3) {
        this.fac3 = fac3;
    }

    public int getWac3() {
        return wac3;
    }

    public void setWac3(int wac3) {
        this.wac3 = wac3;
    }

    public boolean isIac3() {
        return iac3;
    }

    public void setIac3(boolean iac3) {
        this.iac3 = iac3;
    }

    public int getSlp() {
        return slp;
    }

    public void setSlp(int slp) {
        this.slp = slp;
    }

    public float getFslp() {
        return fslp;
    }

    public void setFslp(float fslp) {
        this.fslp = fslp;
    }

    public int getWslp() {
        return wslp;
    }

    public void setWslp(int wslp) {
        this.wslp = wslp;
    }

    public boolean isIslp() {
        return islp;
    }

    public void setIslp(boolean islp) {
        this.islp = islp;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public float getFgen() {
        return fgen;
    }

    public void setFgen(float fgen) {
        this.fgen = fgen;
    }

    public int getWgen() {
        return wgen;
    }

    public void setWgen(int wgen) {
        this.wgen = wgen;
    }

    public boolean isIgen() {
        return igen;
    }

    public void setIgen(boolean igen) {
        this.igen = igen;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "trainId=" + trainId +
                ", trainTime='" + trainTime + '\'' +
                ", trainName='" + trainName + '\'' +
                ", St1='" + St1 + '\'' +
                ", St2='" + St2 + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", distance=" + distance +
                ", ac1=" + ac1 +
                ", fac1=" + fac1 +
                ", wac1=" + wac1 +
                ", iac1=" + iac1 +
                ", ac2=" + ac2 +
                ", fac2=" + fac2 +
                ", wac2=" + wac2 +
                ", iac2=" + iac2 +
                ", ac3=" + ac3 +
                ", fac3=" + fac3 +
                ", wac3=" + wac3 +
                ", iac3=" + iac3 +
                ", slp=" + slp +
                ", fslp=" + fslp +
                ", wslp=" + wslp +
                ", islp=" + islp +
                ", gen=" + gen +
                ", fgen=" + fgen +
                ", wgen=" + wgen +
                ", igen=" + igen +
                '}';
    }
}
