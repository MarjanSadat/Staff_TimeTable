package ir.marjan.controller;

import ir.marjan.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/users.do", method = RequestMethod.GET)
    public ModelAndView doGetUsers() {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("admin/main");
        modelAndView.addObject("usersTos", userService.findAll());
        return modelAndView;
    }
}