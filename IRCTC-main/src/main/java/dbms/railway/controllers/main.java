package dbms.railway.controllers;

import dbms.railway.dao.AvailabilityJdbcDao;
import dbms.railway.dao.StationJdbcDao;
import dbms.railway.dao.UserJdbcDao;
import dbms.railway.helper.Search;
import dbms.railway.models.Availability;
import dbms.railway.models.User;
import dbms.railway.models.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class main {
    @Autowired
    private StationJdbcDao stationJdbcDao;

    @Autowired
    private AvailabilityJdbcDao availabilityJdbcDao;

    private final UserJdbcDao userJdbcDao;

    @Autowired
    public main(UserJdbcDao userJdbcDao) {
        this.userJdbcDao = userJdbcDao;
    }

@GetMapping("/")
    public String index(Model model) {

        model.addAttribute("welcomeMessage", "Welcome, User!");

        List<station> stations = stationJdbcDao.getAllStations();
        model.addAttribute("stations", stations);
        return "index";
    }
@GetMapping("/signup")
public String showSignupForm(Model model) {
    model.addAttribute("user", new User());
    return "signup";
}
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        try {
            userJdbcDao.createUser(user);
            return "redirect:/signin";
        } catch (DuplicateKeyException e) {
            model.addAttribute("errorMessage", "Username already exists. Please choose a different username.");
            return "signup";
        }
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/search")
    public String searchTrains(@ModelAttribute("search") Search search, Model model) throws ClassNotFoundException, SQLException {


        String date=search.getDate()+" 00:00:00";
        String s=search.getSourceStation();
        String sourceStation=s.substring(s.indexOf('(')+1,s.indexOf(')'));
        s=search.getDestinationStation();
        String destinationStation=s.substring(s.indexOf('(')+1,s.indexOf(')'));



        List<Availability> l=this.availabilityJdbcDao.getTrainsbysearch(date,sourceStation,destinationStation);

        model.addAttribute("l",l);
        return "FindingTrain";
}
    @GetMapping("/find")
    public String find(){
        return "FindingTrain";
    }

}