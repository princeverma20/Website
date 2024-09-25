package dbms.railway.dao;


import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbms.railway.models.Ticket2;
import dbms.railway.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TicketJdbcDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<Ticket2> ticketRowMapper = (rs, rowNum) -> {
        Ticket2 ticket= new Ticket2();
        ticket.setTrainId(rs.getLong("train_id"));
        ticket.setTrainName(rs.getString("tName"));
        ticket.setSt1(rs.getString("source"));
        ticket.setSt2(rs.getString("destination"));
        ticket.setCla(rs.getString("class"));
        ticket.setFirstName(rs.getString("passenger_fname"));
        ticket.setLastName(rs.getString("passenger_lname"));
        ticket.setAge(rs.getInt("passenger_age"));
        ticket.setPnr(rs.getString("pnr"));
        ticket.setPath(rs.getString("path"));
        ticket.setStTime(rs.getString("start_time"));
        ticket.setEndTime(rs.getString("end_time"));
        ticket.setCoachNum(rs.getInt("C_N"));
        ticket.setSeatNum(rs.getInt("S_N"));
        ticket.setFair(rs.getFloat("fair"));
        ticket.setUser(rs.getString("booked_by"));
        ticket.setBookedAt(rs.getString("booked_at"));
        ticket.setCnf(rs.getBoolean("cnf"));
        ticket.setWL(rs.getInt("WL"));
        return ticket;
    };

    private HashMap<String, Object> getticketMap(Ticket2 ticket) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("train_id", ticket.getTrainId());
        map.put("tName", ticket.getTrainName());
        map.put("source", ticket.getSt1());
        map.put("destination", ticket.getSt2());
        map.put("class", ticket.getCla());
        map.put("passenger_fname", ticket.getFirstName());
        map.put("passenger_lname", ticket.getLastName());
        map.put("passenger_age", ticket.getAge());
        map.put("pnr", ticket.getPnr());
        map.put("path", ticket.getPath());
        map.put("start_time", ticket.getStTime());
        map.put("end_time", ticket.getEndTime());
        map.put("C_N", ticket.getCoachNum());
        map.put("S_N", ticket.getSeatNum());
        map.put("fair", ticket.getFair());
        map.put("booked_by", ticket.getUser());
        map.put("booked_at", ticket.getBookedAt());
        map.put("cnf", ticket.getCnf());
        map.put("WL", ticket.getWL());
        return map;
    }


//    SELECT * , WL(t.pnr, t.booked_at,t.class) as WL FROM ticket as t;
    public List<Ticket2> getTicketByUsername(String booked_by) {
        String sql = "SELECT * , WL(t.pnr, t.booked_at,t.class) as WL, u.name as tName  FROM Ticket as t, trains as u WHERE u.id = t.train_id and  booked_by = ";
        sql = sql +"'" +booked_by +"'";
        sql = sql + " ORDER BY t.start_time";
        System.out.println(sql);
        System.out.println("reached");
        System.out.println(booked_by);
        HashMap<String, Object> params = new HashMap<>();
        params.put("booked_by", booked_by);
        return namedParameterJdbcTemplate.query(sql, ticketRowMapper);
    }

    public Ticket2 getTicketByPNR(String pnr){
        String sql = "SELECT * , WL(t.pnr, t.booked_at,t.class) as WL, u.name as tName FROM Ticket as t, trains as u WHERE u.id = t.train_id and  pnr = :pnr";
        HashMap<String, Object> params = new HashMap<>();
        params.put("pnr", pnr);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, ticketRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }



}
