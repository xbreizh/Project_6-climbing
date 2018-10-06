package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min = 1, max = 50)
    private String continent;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @OneToMany(mappedBy = "country", fetch=FetchType.EAGER)
    private List<Spot> spotList= new ArrayList<>();

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", continent='" + continent + '\'' +
                ", name='" + name + '\'' +
                ", spotList=" + spotList +
                '}';
    }
}
