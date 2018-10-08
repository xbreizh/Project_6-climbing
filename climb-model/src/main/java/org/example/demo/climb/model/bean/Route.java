package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

    @Entity
    public class Route {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        private int id;

        @NotNull
        @Size(min = 1, max = 100)
        private String name;

        @NotNull
        private int height;

        @NotNull
        @Size(min = 1, max = 5)
        private String grade;

        @NotNull
        @Size(min = 1, max = 20)
        private String type;

        @NotNull
        @ManyToOne
        private Member memberRoute;

        @NotNull
        @ManyToOne()
        private Spot spot;

        public Route() {
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

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
                    ", type='" + type + '\'' +
                    ", memberRoute=" + memberRoute +
                    ", spot=" + spot +
                    '}';
        }
    }
