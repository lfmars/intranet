package lt.marius.intranet.service;

import lt.marius.intranet.models.poll.Poll;
import lt.marius.intranet.models.poll.PollAnswer;

import java.util.List;

public interface PollService {
    Poll createPoll(Poll poll, List<PollAnswer> pollAnswers);
    Poll save(Poll poll);
}
