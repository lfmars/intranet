package lt.marius.intranet;

import lt.marius.intranet.models.Users;
import lt.marius.intranet.models.poll.Poll;
import lt.marius.intranet.models.poll.PollAnswer;
import lt.marius.intranet.models.security.Role;
import lt.marius.intranet.models.security.UsersRole;
import lt.marius.intranet.service.PollService;
import lt.marius.intranet.service.UserService;
import lt.marius.intranet.utils.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class IntranetApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
	private PollService pollService;

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Users users = new Users();
		//users.setBday(java.sql.Date.valueOf(java.time.LocalDate.now()));
		users.setBday(Date.valueOf("1996-11-03"));
		users.setName("Jonas");
		users.setLastName("Jonaitis");
		users.setUsername("user");
		users.setPassword(SecurityUtility.passwordEncoder().encode("user"));
		Set<UsersRole>usersRoles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(1);
		role.setName("USER");
		usersRoles.add(new UsersRole(users,role));
		userService.createUser(users, usersRoles);

		List<Users>usersList = userService.findByDate();
		//System.out.println(usersList.size()); --cia isprintina kiek useriu svencia gimtadieni, mini test

		System.out.println("userio id = " + users.getId());
		Poll firstPoll = new Poll();
		firstPoll.setUserId(users.getId());
		firstPoll.setQuestion("Ar gerai tau?");
		List<PollAnswer> pollAnswers = new ArrayList<>();
		PollAnswer answer1 = new PollAnswer();
		answer1.setAnswer("Ne");
		PollAnswer answer2 = new PollAnswer();
		answer2.setAnswer("Taip");
		pollAnswers.add(answer1);
		pollAnswers.add(answer2);

		pollService.createPoll(firstPoll, pollAnswers);



	}
}
