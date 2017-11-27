package lt.marius.intranet.service;

import lt.marius.intranet.models.Users;
import lt.marius.intranet.models.security.UsersRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    Users createUser(Users users, Set<UsersRole>usersRoles)throws Exception;
    Users save(Users users);
    Users findByUsername(String username);
    List<Users> findByDate();
}
