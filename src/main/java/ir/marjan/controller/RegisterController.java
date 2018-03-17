package ir.marjan.controller;

import ir.marjan.model.entity.Role;
import ir.marjan.model.entity.User;
import ir.marjan.model.service.RolesService;
import ir.marjan.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

//    @RequestMapping(value = "/goToRegister.do/{action_name}",method = RequestMethod.GET)
    @RequestMapping(value = "/register.do",method = RequestMethod.GET)
    public String goToRegister() {
        return "actions/register";
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(@RequestParam("firstname") String firstname,
                                 @RequestParam("lastname") String lastname,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password) {
            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setUsername(username);
            user.setPassword(password);

            userService.save(user);

            Role role = new Role();
            role.setUsername(username);
            role.setPermission("user");

            rolesService.save(role);
        return "redirect:/actions/login.jsp";
    }


}

