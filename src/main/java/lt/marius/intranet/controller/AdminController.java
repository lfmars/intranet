package lt.marius.intranet.controller;


import lt.marius.intranet.models.Users;
import lt.marius.intranet.models.security.Role;
import lt.marius.intranet.models.security.UsersRole;
import lt.marius.intranet.service.UserService;
import lt.marius.intranet.utils.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping (value = "/add", method = RequestMethod.GET)
    public String addUser(Model model){
        Users users = new Users();
        model.addAttribute("user", users);
        return "addUser";
    }

    @RequestMapping (value = "/add", method = RequestMethod.POST)
    public String addUserpost(@ModelAttribute("user") Users users, HttpServletRequest request){
        users.setPassword(SecurityUtility.passwordEncoder().encode(users.getPassword()));
        Set<UsersRole> usersRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(1);
        role.setName("USER");
        usersRoles.add(new UsersRole(users,role));
        try {
            userService.createUser(users, usersRoles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
