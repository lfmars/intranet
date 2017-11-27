package lt.marius.intranet.service.imp;

import lt.marius.intranet.models.poll.Poll;
import lt.marius.intranet.models.poll.PollAnswer;
import lt.marius.intranet.repository.PollAnswerRepository;
import lt.marius.intranet.repository.PollRepository;
import lt.marius.intranet.repository.PollVoteRepository;
import lt.marius.intranet.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollServiceImp implements PollService {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private PollAnswerRepository pollAnswerRepository;

    @Autowired
    private PollVoteRepository pollVoteRepository;

    @Override
    public Poll createPoll(Poll poll, List<PollAnswer> pollAnswers) {
        Poll newPoll = pollRepository.findByQuestion(poll.getQuestion());
        if(newPoll != null){
            System.out.println("LOOOGAS, poolas jau sukurtas");
        }else {

         //   poll.getPollAnswers().addAll(pollAnswers);
            newPoll = pollRepository.save(poll);
            for (PollAnswer answer : pollAnswers){
                answer.setPollId(newPoll.getPollId());
                pollAnswerRepository.save(answer);
            }
        }
        return newPoll;
    }



    @Override
    public Poll save(Poll poll) {
        return pollRepository.save(poll);
    }
}
