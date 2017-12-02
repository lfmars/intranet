package lt.marius.intranet.controller;

import lt.marius.intranet.models.Users;
import lt.marius.intranet.service.PollService;
import lt.marius.intranet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    PollService pollService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String home(Model model){
        //pasiimam prisijungusio vartotoja duomenis is duomenu bazes
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = userService.findByUsername(auth.getName());
        //paduodam i puslapi
        model.addAttribute("name", users.getName());
        System.out.println("Last poll id --->" +pollService.returnLastPollId());
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


}
