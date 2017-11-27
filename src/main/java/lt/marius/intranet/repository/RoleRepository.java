package lt.marius.intranet.repository;

import lt.marius.intranet.models.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<Role, Long>{
    Role findByName(String name);
}
