package lt.marius.intranet.service.imp;

import lt.marius.intranet.models.Users;
import lt.marius.intranet.models.security.UsersRole;
import lt.marius.intranet.repository.RoleRepository;
import lt.marius.intranet.repository.UsersRepository;
import lt.marius.intranet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class UserServiceImp implements UserService  {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Users createUser(Users users, Set<UsersRole> usersRoles) throws Exception {
        Users localUser = usersRepository.findByUsername(users.getUsername());
        if(localUser != null){
            LOG.info("User Exist, operation stoped");
        }else {
         for (UsersRole ur: usersRoles){
             roleRepository.save(ur.getRole());
         }
         users.getUsersRoles().addAll(usersRoles);
            localUser = usersRepository.save(users);
        }
        return localUser;
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public List<Users> findByDate() {
        return usersRepository.usersByDate();
    }


}
