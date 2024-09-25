package dbms.railway.models;

public class Ticket2 {
    private long trainId;
    private String trainName;
    private String st1;
    private String st2;
    private String cla;
    private String firstName;
    private String lastName;
    private Integer age;
    private String pnr;
    private String path;
    private String stTime;
    private String endTime;
    private Integer coachNum;
    private Integer seatNum;
    private float Fair;
    private String User;
    private String bookedAt;
    private Boolean cnf;
    private Integer WL;

    public Ticket2() {
    }

    public Ticket2(long trainId, String trainName, String st1, String st2, String cla, String firstName, String lastName, Integer age, String pnr, String path, String stTime, String endTime, Integer coachNum, Integer seatNum, float fair, String user, String bookedAt, Boolean cnf, Integer WL) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.st1 = st1;
        this.st2 = st2;
        this.cla = cla;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pnr = pnr;
        this.path = path;
        this.stTime = stTime;
        this.endTime = endTime;
        this.coachNum = coachNum;
        this.seatNum = seatNum;
        Fair = fair;
        User = user;
        this.bookedAt = bookedAt;
        this.cnf = cnf;
        this.WL = WL;
    }

    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSt1() {
        return st1;
    }

    public void setSt1(String st1) {
        this.st1 = st1;
    }

    public String getSt2() {
        return st2;
    }

    public void setSt2(String st2) {
        this.st2 = st2;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStTime() {
        return stTime;
    }

    public void setStTime(String stTime) {
        this.stTime = stTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCoachNum() {
        return coachNum;
    }

    public void setCoachNum(Integer coachNum) {
        this.coachNum = coachNum;
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    public float getFair() {
        return Fair;
    }

    public void setFair(float fair) {
        Fair = fair;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(String bookedAt) {
        this.bookedAt = bookedAt;
    }

    public Boolean getCnf() {
        return cnf;
    }

    public void setCnf(Boolean cnf) {
        this.cnf = cnf;
    }

    public Integer getWL() {
        return WL;
    }

    public void setWL(Integer WL) {
        this.WL = WL;
    }

    @Override
    public String toString() {
        return "Ticket2{" +
                "trainId=" + trainId +
                ", trainName='" + trainName + '\'' +
                ", st1='" + st1 + '\'' +
                ", st2='" + st2 + '\'' +
                ", cla='" + cla + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", pnr='" + pnr + '\'' +
                ", path='" + path + '\'' +
                ", stTime='" + stTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", coachNum=" + coachNum +
                ", seatNum=" + seatNum +
                ", Fair=" + Fair +
                ", User='" + User + '\'' +
                ", bookedAt='" + bookedAt + '\'' +
                ", cnf=" + cnf +
                ", WL=" + WL +
                '}';
    }
}
