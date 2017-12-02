package lt.marius.intranet.repository;

import lt.marius.intranet.models.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
    List<Users> findByBdayIsLike(String day);
   // @Modifying
    @Query("SELECT c FROM Users c  WHERE date_part('day', bday) = date_part('day', CURRENT_DATE) AND date_part('month', bday) = 11")
   // @Transactional
////    SQL pasitiktint pirma reikia > update webschoolclasses set title = 'title', teacher_id = 5 where school_classes_id = 3
   List<Users> usersByDate();

}
