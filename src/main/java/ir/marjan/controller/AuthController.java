package ir.marjan.controller;

import ir.marjan.model.entity.TimeTable;
import ir.marjan.model.entity.User;
import ir.marjan.model.service.TimeTableService;
import ir.marjan.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class AuthController {

    private long timeId;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private TimeTableService timeTableService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        try {
            request.login(username, password);
            User user = userService.findByUserName(username);
            TimeTable timeTable = new TimeTable();
            timeTable.setEntry(new Date());
            timeTable.setUser(user);
            timeTableService.save(timeTable);
            setTimeId(timeTable.getId());
            return "redirect:/user/timeTables.do";
        } catch (Exception e) {
            return "redirect:/actions/login.jsp";
        }
    }


    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public String logout() throws Exception {
        request.logout();
        TimeTable timeTable = timeTableService.find(getTimeId());
        timeTable.setExit(new Date());
        timeTableService.edit(timeTable);
        return "redirect:/actions/login.jsp";
    }

    private long getTimeId() {
        return timeId;
    }

    private void setTimeId(long timeId) {
        this.timeId = timeId;
    }
}
