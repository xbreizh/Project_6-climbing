package org.example.demo.climb.model.bean.member;

import org.example.demo.climb.model.bean.Spot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "findAllMembers",
               /* query = "from Member m where m.login != :name"*/
                query = "from Member"
        ),
        @NamedQuery(
                name = "findByLogin",
                query = "from Member m where m.login = :login"
        )
})
@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min = 3, max = 100)
    private String login;

    @NotNull
    private String login2;

    @NotNull
    private boolean active;

    @NotNull
    @Size(min = 3, max = 8)
    private String password;

    @Size( max = 255)
    private String description;

    @NotNull
    private Date datejoin;

    private Date dateLastConnect;

    @NotNull
    private String email;

    @OneToMany(mappedBy = "creatorSpot", fetch=FetchType.EAGER)
    private List<Spot> spotList= new ArrayList<>();

    public Member() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatejoin() {
        return datejoin;
    }

    public void setDatejoin(Date datejoin) {
        this.datejoin = datejoin;
    }

    public Date getDateLastConnect() {
        return dateLastConnect;
    }

    public void setDateLastConnect(Date dateLastConnect) {
        this.dateLastConnect = dateLastConnect;
    }



    public String getLogin2() {
        return login2;
    }

    public void setLogin2(String login2) {
        this.login2 = login2;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }



    public List<Spot> getSpotList() {
        return spotList;
    }

    public void addSpot(Spot spot) {
        this.spotList.add(spot);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", login2='" + login2 + '\'' +
                ", active=" + active +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", datejoin=" + datejoin +
                ", dateLastConnect=" + dateLastConnect +
                ", email='" + email + '\'' +
                ", spotList=" + spotList +
                '}';
    }
}
