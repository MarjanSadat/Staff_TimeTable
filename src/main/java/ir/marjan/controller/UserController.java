package ir.marjan.controller;

import ir.marjan.model.entity.Role;
import ir.marjan.model.entity.User;
import ir.marjan.model.service.RolesService;
import ir.marjan.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/admin/users.do", method = RequestMethod.GET)
    public ModelAndView doGetUsers() {
        ModelAndView modelAndView = new ModelAndView("admin/main");
        modelAndView.addObject("usersTos", userService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/user/profile.do", method = RequestMethod.GET)
    public ModelAndView getUserProfile() {
        ModelAndView modelAndView = new ModelAndView("user/profile");
        modelAndView.addObject("userProfile", userService.findByUserName(request.getRemoteUser()));
        return modelAndView;
    }


    @RequestMapping(value = "/user/profile.do", method = RequestMethod.POST)
    public String saveUserProfile(@RequestParam("firstname") String firstname,
                                  @RequestParam("lastname") String lastname,
                                  @RequestParam("username") String username,
                                  @RequestParam("password") String password) throws ServletException {
        String currentUser = request.getRemoteUser();
        User user = userService.findByUserName(currentUser);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPassword(password);
        String target;
        if (currentUser.equals(username)) {
            userService.edit(user);
            target = "redirect:/user/timeTables.do";
        } else {
            user.setUsername(username);
            Role role = rolesService.findByUsername(currentUser);
            role.setUsername(username);
            rolesService.edit(role);
            userService.edit(user);
            request.logout();
            target = "redirect:/actions/login.jsp";
        }
        return target;
    }

}
