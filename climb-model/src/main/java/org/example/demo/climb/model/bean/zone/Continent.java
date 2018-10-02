package org.example.demo.climb.model.bean.zone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


    @Entity
    public class Continent {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        private int id;
        @NotNull
        @Size(min = 1, max = 50)
        private String name;

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

        @Override
        public String toString() {
            return "Continent{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
