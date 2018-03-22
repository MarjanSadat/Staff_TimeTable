package ir.marjan.controller;

import ir.marjan.model.entity.Role;
import ir.marjan.model.entity.TimeTable;
import ir.marjan.model.entity.User;
import ir.marjan.model.service.RolesService;
import ir.marjan.model.service.TimeTableService;
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
    private TimeTableService timeTableService;


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RolesService rolesService;

    @RequestMapping(value = "/user/timeTables.do", method = RequestMethod.GET)
    public ModelAndView doGetTimes() {

        String username =request.getRemoteUser();
        Role role = rolesService.findByUsername(username);
        System.out.println(username);
        User user = userService.findByUserName(username);
        List<TimeTable> timeTables = user.getTimeTableTOS();
        List<User> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView(role.getPermission()+"/timetables");
        modelAndView.addObject("userTimetables", timeTables);
        modelAndView.addObject("userList",userList);

        return modelAndView;
    }

    @RequestMapping(value = "/user/{id}/userTime.do", method = RequestMethod.GET)
    public ModelAndView getUserTime(@PathVariable ("id") long id){
        List<TimeTable> timeTables = userService.find(id).getTimeTableTOS();
        ModelAndView modelAndView = new ModelAndView("user/timetables");
        modelAndView.addObject("userTimetables",timeTables);



        return modelAndView;
    }
}
