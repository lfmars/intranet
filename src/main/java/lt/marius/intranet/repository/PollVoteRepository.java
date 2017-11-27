package lt.marius.intranet.repository;

import lt.marius.intranet.models.poll.PollVote;
import org.springframework.data.repository.CrudRepository;

public interface PollVoteRepository extends CrudRepository<PollVote, Long> {
}
