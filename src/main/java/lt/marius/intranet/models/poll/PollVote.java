package lt.marius.intranet.models.poll;

import javax.persistence.*;

@Entity
public class PollVote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VOTE_ID")
    private Long voteId;

    @Column(name = "POLL_ID")
    private Long pollId;

    @Column(name = "ANSWER_ID")
    private Long answerId;

    @Column(name = "USER_ID")
    private Long userId;

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
