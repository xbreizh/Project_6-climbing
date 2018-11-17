package org.example.demo.climb.model.bean.__to_delete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/*@NamedQueries({
        @NamedQuery(
                name = "findAllZones",
                *//*query = "from Member m where m.login != :name"*//*
                query = "from Zone"
        )*//*,
        @NamedQuery(
                name = "findByZoneName",
                query = "from Zone m where m.name = :name"
        )*//*
})*/
/*@Entity*/
public class Zone {
/*
    @Id
   *//* @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")*//*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull
    @ManyToOne
    private Country country;
    @NotNull
    @Size(min = 1, max = 100)
    private String region;
    @NotNull
    @OneToMany(mappedBy = "zone", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Spot> spotList= new ArrayList<>();

    public Zone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", country=" + country +
                ", region='" + region + '\'' +
                ", spotList=" + spotList +
                '}';
    }*/
}
