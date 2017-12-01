package lt.marius.intranet.models.poll;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POLL_ID")
    private Long pollId;

    private String question;

    @Column(name = "USER_ID")
    private Long userId;

    private Date creatingTime;



    @OneToMany
    @JoinColumn(name = "POLL_ID", referencedColumnName = "POLL_ID")
    private List<PollAnswer>pollAnswers;

    @OneToMany
    @JoinColumn(name = "POLL_ID", referencedColumnName = "POLL_ID")
    private List<PollVote>pollVotes;

    public List<PollAnswer> getPollAnswers() {
        return pollAnswers;
    }

    public void setPollAnswers(List<PollAnswer> pollAnswers) {
        this.pollAnswers = pollAnswers;
    }

    public List<PollVote> getPollVotes() {
        return pollVotes;
    }

    public void setPollVotes(List<PollVote> pollVotes) {
        this.pollVotes = pollVotes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(Date creatingTime) {
        this.creatingTime = creatingTime;
    }


}
