package lt.marius.intranet.controller;

import lt.marius.intranet.models.Users;
import lt.marius.intranet.models.poll.Poll;
import lt.marius.intranet.models.poll.PollAnswer;
import lt.marius.intranet.service.PollService;
import lt.marius.intranet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PollController {

    @Autowired
    private PollService pollService;

    @Autowired
    private UserService userService;


    @RequestMapping (value = "/addPoll", method = RequestMethod.GET)
    public String addUser(Model model){
        return "addPoll";
    }

    @RequestMapping("/test1")
    public String test1(@RequestParam("q1") String q1, @RequestParam("ans") String[] ansList, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = userService.findByUsername(auth.getName());
        Poll newPoll = new Poll();
        newPoll.setQuestion(q1);
        newPoll.setUserId(users.getId());
        List<PollAnswer>pollAnswers = new ArrayList<>();
        for(String answer : ansList){
            PollAnswer pollAnswer = new PollAnswer();
            pollAnswer.setAnswer(answer);
            pollAnswers.add(pollAnswer);
        }
        pollService.createPoll(newPoll,pollAnswers);
        return "redirect:/";
    }
}
