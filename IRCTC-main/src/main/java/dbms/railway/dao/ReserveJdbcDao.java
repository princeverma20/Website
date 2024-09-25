package dbms.railway.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class ReserveJdbcDao {
    String sqldriver="com.mysql.cj.jdbc.Driver";
    String urlname="jdbc:mysql://localhost:3306/railway";
    String userid="root";
    String pass="xxxxxxxx";
    public void reserve(Long trainId,String time,String cla,String st1,String st2,String userName,String firstName,String lastName,Integer age) throws ClassNotFoundException, SQLException {
        Class.forName(sqldriver);
        String url=urlname;
        String username=userid;
        String password=pass;
        String sql="call BOOK(?,?,?,?,?,?,?,?,?)";

        Connection con= DriverManager.getConnection(url,username, password);

        PreparedStatement pstmt=con.prepareStatement(sql);

        pstmt.setLong(1,trainId);
        pstmt.setString(2,time);
        pstmt.setString(3,st1);
        pstmt.setString(4,st2);
        pstmt.setString(5,cla);
        pstmt.setString(6,userName);
        pstmt.setString(7,firstName);
        pstmt.setString(8,lastName);
        pstmt.setInt(9,age);


        pstmt.executeQuery();

    }

}
