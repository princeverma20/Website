package dbms.railway.dao;

import java.sql.*;
import dbms.railway.models.Availability;
import dbms.railway.models.User;
import dbms.railway.models.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class AvailabilityJdbcDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    String sqldriver="com.mysql.cj.jdbc.Driver";
    String urlname="jdbc:mysql://localhost:3306/railway";
    String userid="root";
    String pass="xxxxxxxx";

    public List<Availability> getTrainsbysearch(String date, String St1, String St2) throws ClassNotFoundException, SQLException{

        Class.forName(sqldriver);
        String url=urlname;
        String username=userid;
        String password=pass;

        String sql="call AvailablityCheck(?,?,?)";

        Connection con=DriverManager.getConnection(url,username, password);

        PreparedStatement pstmt=con.prepareStatement(sql);

        pstmt.setString(1,date);
        pstmt.setString(2,St1);
        pstmt.setString(3,St2);

        ResultSet resultSet=pstmt.executeQuery();
        List<Availability> avl=new ArrayList<>();
        System.out.println("kola");
        while(resultSet.next()){
            Availability a=new Availability((long)0, "","","","","","",0, 0,0,0,false,0,0,0,false,0,0,0,false,0,0,0,false,0,0,0,false);
            a.setTrainId(resultSet.getLong("train_id"));
            a.setTrainTime(resultSet.getString("train_time"));
            a.setTrainName(resultSet.getString("train_name"));
            a.setSt1(resultSet.getString("st1"));
            a.setSt2(resultSet.getString("st2"));
            a.setArrivalTime(resultSet.getString("arrival_time"));
            a.setDepartureTime(resultSet.getString("departure_time"));
            a.setDistance(resultSet.getInt("distance"));
            a.setAc1(resultSet.getInt("AC1"));
            a.setFac1(resultSet.getFloat("FFAC1"));
            a.setWac1(resultSet.getInt("WAC1"));
            a.setIac1(resultSet.getBoolean("IAC1"));
            a.setAc2(resultSet.getInt("AC2"));
            a.setFac2(resultSet.getFloat("FFAC2"));
            a.setWac2(resultSet.getInt("WAC2"));
            a.setIac2(resultSet.getBoolean("IAC2"));
            a.setAc3(resultSet.getInt("AC3"));
            a.setFac3(resultSet.getFloat("FFAC3"));
            a.setWac3(resultSet.getInt("WAC3"));
            a.setIac3(resultSet.getBoolean("IAC3"));
            a.setSlp(resultSet.getInt("SLP"));
            a.setFslp(resultSet.getFloat("FFSLP"));
            a.setWslp(resultSet.getInt("WSLP"));
            a.setIslp(resultSet.getBoolean("ISLP"));
            a.setGen(resultSet.getInt("GEN"));
            a.setFgen(resultSet.getFloat("FFGEN"));
            a.setWgen(resultSet.getInt("WGEN"));
            a.setIgen(resultSet.getBoolean("IGEN"));
            avl.add(a);
//            System.out.println(a.getTrainId());
        }
        return avl;
    }
    public void CancelTicketByPnr(String pnr) throws ClassNotFoundException, SQLException{

        Class.forName(sqldriver);
        String url=urlname;
        String username=userid;
        String password=pass;
        String sql = "CALL iscancel(?, ?)";

        Connection con=DriverManager.getConnection(url,username, password);

        PreparedStatement pstmt=con.prepareStatement(sql);

        pstmt.setString(1,pnr);
        pstmt.setBoolean(2,true);

        ResultSet resultSet=pstmt.executeQuery();

        con.close();
    }
}
