package org.example.demo.climb.model.bean;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String city;

    @NotNull
    @Size(min = 1, max = 20)
    private String type;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Size(min = 3, max = 250)
    private String description;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    private int rateMore;

    private int rateLess;

    @NotNull
    @ManyToOne
    private Country country;

    @NotNull
    @ManyToOne
    private Member memberSpot;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private List<Topo> topos;

    @OneToMany(mappedBy = "spot", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Route> routeList = new ArrayList<>();

    @OneToMany(mappedBy = "spot", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    public Spot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRateMore() {
        return rateMore;
    }

    public void setRateMore(int rateMore) {
        this.rateMore = rateMore;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRateLess() {
        return rateLess;
    }

    public void setRateLess(int rateLess) {
        this.rateLess = rateLess;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Member getMemberSpot() {
        return memberSpot;
    }

    public void setMemberSpot(Member memberSpot) {
        this.memberSpot = memberSpot;
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


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", rateMore=" + rateMore +
                ", rateLess=" + rateLess +
                ", country=" + country.getName() +
                ", memberSpot=" + memberSpot.getLogin() +
                ", topos=" + topos.size() +
                ", routeList=" + routeList.size() +
                ", commentList=" + commentList.size() +
                '}';
    }
}
