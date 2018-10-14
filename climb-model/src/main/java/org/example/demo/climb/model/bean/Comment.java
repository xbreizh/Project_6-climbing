package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

    @Entity
    public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    private String text;

    @NotNull
    private Date date;


    @NotNull
    @ManyToOne
    private Member memberComment;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Spot spot;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Member getMemberComment() {
        return memberComment;
    }

    public void setMemberComment(Member memberComment) {
        this.memberComment = memberComment;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

}
