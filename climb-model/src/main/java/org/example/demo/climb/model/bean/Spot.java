package org.example.demo.climb.model.bean;

import org.example.demo.climb.model.bean.member.Member;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(
                name = "findAllSpots",
                /*query = "from Member m where m.login != :name"*/
                query = "from Spot"
        ),
        @NamedQuery(
                name = "findByName",
                query = "from Spot m where m.name = :name"
        )
})
    @Entity
    public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    private int nb_ways;

    @ManyToOne
    private Member creatorSpot;

    public Spot() {
    }

    public Member getCreatorSpot() {
        return creatorSpot;
    }

    public void setCreator(Member creatorSpot) {
        this.creatorSpot = creatorSpot;
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
