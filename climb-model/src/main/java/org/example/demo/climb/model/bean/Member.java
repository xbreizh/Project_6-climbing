package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

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
    private String role;

    @NotNull
    private boolean active;

    @NotNull
    @Size(min = 3, max = 8)
    private String password;

    @Size(max = 255)
    private String description;

    @NotNull
    private Date datejoin;

    private Date dateLastConnect;

    @NotNull
    private String email;

    @OneToMany(mappedBy = "memberSpot", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Spot> spotList = new ArrayList<>();

    @OneToMany(mappedBy = "memberRoute", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Route> routeList = new ArrayList<>();

    @OneToMany(mappedBy = "memberComment", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE })
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "owner",  fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Topo> topoListOwned = new ArrayList<>();

    @OneToMany(mappedBy = "booker",  fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Booking> listBookings = new ArrayList<>();

    public Member() {
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

    public String getLogin2() {
        return login2;
    }

    public void setLogin2(String login2) {
        this.login2 = login2;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Topo> getTopoListOwned() {
        return topoListOwned;
    }

    public void setTopoListOwned(List<Topo> topoListOwned) {
        this.topoListOwned = topoListOwned;
    }

    public List<Booking> getListBookings() {
        return listBookings;
    }

    public void setListBookings(List<Booking> listBookings) {
        this.listBookings = listBookings;
    }
}