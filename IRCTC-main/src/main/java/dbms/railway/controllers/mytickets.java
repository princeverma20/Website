package dbms.railway.controllers;
import dbms.railway.dao.AvailabilityJdbcDao;
import dbms.railway.dao.ReserveJdbcDao;
import dbms.railway.dao.TicketJdbcDao;
import dbms.railway.dao.StationJdbcDao;
import dbms.railway.models.Ticket;
import dbms.railway.models.Ticket2;
import dbms.railway.models.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@Controller
public class mytickets {
    @Autowired
    private final StationJdbcDao stationJdbcDao;
    private final TicketJdbcDao ticketJdbcDao;

    @Autowired
    private AvailabilityJdbcDao availabilityJdbcDao;


    public mytickets(TicketJdbcDao ticketJdbcDao, StationJdbcDao stationJdbcDao){
        this.stationJdbcDao=stationJdbcDao;
        this.ticketJdbcDao=ticketJdbcDao;
    }
    @GetMapping("/mytickets")
    public String myticket(@AuthenticationPrincipal UserDetails userDetails, Model model){

        List<Ticket2> tickets  = ticketJdbcDao.getTicketByUsername(userDetails.getUsername());
        model.addAttribute("tickets", tickets);
        return "booked_ticket";
    }
    @GetMapping("/mytickets/{pnr}")
    public String myticket(Model model, @PathVariable("pnr") String pnr){

        Ticket2 ticket  = ticketJdbcDao.getTicketByPNR(pnr);

        String station1=stationJdbcDao.getStationByStationCode(ticket.getSt1()).getStationName();
        String station2=stationJdbcDao.getStationByStationCode(ticket.getSt2()).getStationName();
        model.addAttribute("ticket", ticket);
        model.addAttribute("sour", station1);
        model.addAttribute("dest", station2);
        return "ticket_details";
    }

    @RequestMapping("/mytickets/{pnr}/cancel")
    public String cancelTicket(Model model,@PathVariable("pnr") String pnr){
       try{
           availabilityJdbcDao.CancelTicketByPnr(pnr);
       }
       catch(ClassNotFoundException | SQLException e){

           e.printStackTrace();
       }
        List<station> stations = stationJdbcDao.getAllStations();
        model.addAttribute("stations", stations);
        return "index";
    }
}
