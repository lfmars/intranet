package lt.marius.intranet.models.poll;

import javax.persistence.*;
import java.util.List;

@Entity
public class PollAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ANSWER_ID")
    private Long answerId;

    @Column(name = "POLL_ID")
    private Long pollId;

    @OneToMany
    @JoinColumn(name = "ANSWER_ID", referencedColumnName = "ANSWER_ID")
    private List<PollVote> pollVotes;

    private String answer;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public List<PollVote> getPollVotes() {
        return pollVotes;
    }

    public void setPollVotes(List<PollVote> pollVotes) {
        this.pollVotes = pollVotes;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
