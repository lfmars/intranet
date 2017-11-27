package lt.marius.intranet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.marius.intranet.models.poll.Poll;
import lt.marius.intranet.models.poll.PollVote;
import lt.marius.intranet.models.security.Authority;
import lt.marius.intranet.models.security.UsersRole;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.sql.Date;
import java.util.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Users implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String lastName;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bday;

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }


    //security
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UsersRole> usersRoles = new HashSet<>();

    //polls
    @OneToMany
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private List<Poll> polls;

    @OneToMany
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private List<PollVote> pollVotes;


    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public List<PollVote> getPollVotes() {
        return pollVotes;
    }

    public void setPollVotes(List<PollVote> pollVotes) {
        this.pollVotes = pollVotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<UsersRole> getUsersRoles() {
        return usersRoles;
    }

    public void setUsersRoles(Set<UsersRole> usersRoles) {
        this.usersRoles = usersRoles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //visas roles paduodam
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        usersRoles.forEach(usersRole -> authorities.add(new Authority(usersRole.getRole().getName())));
        return authorities;
    }
}
