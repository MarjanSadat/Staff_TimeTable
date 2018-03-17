package ir.marjan.controller;

import ir.marjan.model.entity.TimeTable;
import ir.marjan.model.entity.User;
import ir.marjan.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TimeTableController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/user/timeTables.do", method = RequestMethod.GET)
    public ModelAndView doGetTimes() {

        ModelAndView modelAndView = new ModelAndView("user/timetables");
        String username =request.getRemoteUser();
        System.out.println(username);
        User user = userService.findByUserName(username);
        List<TimeTable> timeTables = user.getTimeTableTOS();
        modelAndView.addObject("userTimetables", timeTables);

        return modelAndView;


    }
}
