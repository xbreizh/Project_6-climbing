package org.example.demo.climb.business;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

    @Id
    private int aid;
    private AlienName name;
    private String tech;



    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
