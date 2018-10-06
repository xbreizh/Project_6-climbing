package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

    @Entity
    public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min = 3, max = 100)
    private String region;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 10, max = 100)
    private String description;

    private int rateMore;

    private int rateLess;

    @NotNull
    @ManyToOne
    private Country country;

    @NotNull
    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "spot", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Route> routeList= new ArrayList<>();

    @OneToMany(mappedBy = "spot", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Comment> commentList= new ArrayList<>();

    public Spot() {
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
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

        public Member getMember() {
            return member;
        }

        public void setMember(Member member) {
            this.member = member;
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

        @Override
        public String toString() {
            return "Spot{" +
                    "id=" + id +
                    ", region='" + region + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", rateMore=" + rateMore +
                    ", rateLess=" + rateLess +
                    ", country=" + country +
                    ", member=" + member +
                    ", routeList=" + routeList +
                    ", commentList=" + commentList +
                    '}';
        }
    }
