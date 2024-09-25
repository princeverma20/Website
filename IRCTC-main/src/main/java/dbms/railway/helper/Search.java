package dbms.railway.helper;

public class Search {
    private String Date;

    public Search(String date, String sourceStation, String destinationStation) {
        Date = date;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
    }

    private String sourceStation;
    private String destinationStation;


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }
}
