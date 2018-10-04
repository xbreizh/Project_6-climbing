package org.example.demo.climb.model.bean;

import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.bean.zone.Zone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/*@NamedQueries({
        @NamedQuery(
                name = "findAllSpots",
                *//*query = "from Member m where m.login != :name"*//*
                query = "from Spot"
        ),
        @NamedQuery(
                name = "findByName",
                query = "from Spot m where m.name = :name"
        )
})*/
    @Entity
    public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    @NotNull
    private int nb_ways;
    @OneToMany(mappedBy = "spot", fetch=FetchType.EAGER)
    private List<Route> routeList= new ArrayList<>();

    @NotNull
    @ManyToOne
    private Member creatorSpot;

    @NotNull
    @ManyToOne
    private Zone zone;

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

    public int getNb_ways() {
        return nb_ways;
    }

    public void setNb_ways(int nb_ways) {
        this.nb_ways = nb_ways;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public Member getCreatorSpot() {
        return creatorSpot;
    }

    public void setCreatorSpot(Member creatorSpot) {
        this.creatorSpot = creatorSpot;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nb_ways=" + nb_ways +
                ", routeList=" + routeList +
                ", creatorSpot=" + creatorSpot +
                ", zone=" + zone +
                '}';
    }
}
