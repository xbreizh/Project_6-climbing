package org.example.demo.climb.model.bean.climb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Spot {

    @Id
    private int id;
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    /*@NotNull*/
    /*private Zone zone;*/
    private int nb_ways;
    /*@NotNull*/
    /* private Member creator;*/

    public Spot() {
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

   /* public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }*/

    public int getNb_ways() {
        return nb_ways;
    }

    public void setNb_ways(int nb_ways) {
        this.nb_ways = nb_ways;
    }

  /*  public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }*/

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                /*", zone=" + zone +*/
                ", nb_ways=" + nb_ways +
                /*  ", creator=" + creator +*/
                '}';
    }
}
