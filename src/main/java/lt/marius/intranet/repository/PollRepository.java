package lt.marius.intranet.repository;

import lt.marius.intranet.models.poll.Poll;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long>{
    Poll findByQuestion(String question);

    @Query("SELECT max(p.pollId) from Poll p")
    Long getLastId();
}
