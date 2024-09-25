package dbms.railway.controllers;

import dbms.railway.dao.AvailabilityJdbcDao;
import dbms.railway.dao.ReserveJdbcDao;
import dbms.railway.dao.UserJdbcDao;
import dbms.railway.models.Availability;
import dbms.railway.models.Ticket;

import dbms.railway.models.User;
import dbms.railway.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class BookController {
    @Autowired
    private ReserveJdbcDao reserveJdbcDao;
    @Autowired
    public BookController(ReserveJdbcDao reserveJdbcDao) {
        this.reserveJdbcDao = reserveJdbcDao;
    }

    @GetMapping("/bookTicket/{id}/{time}/{st1}/{st2}/{ac1}/{ac2}/{ac3}/{slp}/{gen}")
    public String bookTicket(@PathVariable("id")Long id, @PathVariable("time")String time,@PathVariable("st1")String st1,@PathVariable("st2")String st2,@PathVariable("ac1")Boolean ac1,@PathVariable("ac2")String ac2,@PathVariable("ac3")String ac3,@PathVariable("slp")String slp,@PathVariable("gen")String gen, Model model){
        System.out.println("manas");
        model.addAttribute("id",id);
        model.addAttribute("time",time);
        model.addAttribute("st1",st1);
        model.addAttribute("st2",st2);
        model.addAttribute("ac1",ac1);
        model.addAttribute("ac2",ac2);
        model.addAttribute("ac3",ac3);
        model.addAttribute("slp",slp);
        model.addAttribute("gen",gen);
        System.out.println(time);
        Ticket ticket = new Ticket();
        ticket.setTrainId(id);
        ticket.setTime(time);
        ticket.setSt1(st1);
        ticket.setSt2(st2);
        model.addAttribute("ticket",ticket);
        return "ticket";
    }

    @CrossOrigin
    @PostMapping("/book")
    public String addTicket(Ticket ticket, Model model, @AuthenticationPrincipal UserDetails userDetails) throws SQLException, ClassNotFoundException {
        System.out.println(ticket);
        this.reserveJdbcDao.reserve(ticket.getTrainId(),ticket.getTime(),ticket.getCla(),ticket.getSt1(),ticket.getSt2(),userDetails.getUsername(),ticket.getFirstName(),ticket.getLastName(),ticket.getAge());
        System.out.println("jayaswal");
        return "index";
    }
}
