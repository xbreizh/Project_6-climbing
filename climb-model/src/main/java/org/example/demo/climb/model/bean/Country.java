package org.example.demo.climb.model.bean;

import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/*@NamedQueries({
        @NamedQuery(
                name = "findAllCountries",
                *//*query = "from Member m where m.login != :name"*//*
                query = "from Country"
        )*//*,
        @NamedQuery(
                name = "findByZoneName",
                query = "from Zone m where m.name = :name"
        )*//*
})
@Entity*/
public class Country {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull
    @Size(min = 1, max = 50)
    private String continent;
    @NotNull
    @Size(min = 1, max = 100)
    private String country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                '}';
    }*/
}
