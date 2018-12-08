package org.example.demo.climb.model.bean;

import org.example.demo.climb.model.Grade;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
    public class Route {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        private int id;

        @NotNull
        @Size(min = 3, max = 50)
        private String name;

        @NotNull
        private int height;


        @NotNull
        private int grade;

        @NotNull
        @Size(min = 3, max = 250)
        private String description;

        @NotNull
        @ManyToOne
        private Member memberRoute;

        @NotNull
        @ManyToOne()
        private Spot spot;

        @OneToMany(mappedBy = "route", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE )
        private List<Comment> commentList= new ArrayList<>();

        public Route() {
        }

        public List<Comment> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<Comment> commentList) {
            this.commentList = commentList;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public Member getMemberRoute() {
            return memberRoute;
        }

        public void setMemberRoute(Member memberRoute) {
            this.memberRoute = memberRoute;
        }

        public Spot getSpot() {
            return spot;
        }

        public void setSpot(Spot spot) {
            this.spot = spot;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", height=" + height +
                    ", grade='" + grade + '\'' +
                    ", memberRoute=" + memberRoute +
                    ", spot=" + spot +
                    '}';
        }
    }
