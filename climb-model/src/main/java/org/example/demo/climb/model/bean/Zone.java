package org.example.demo.climb.model.bean;

import org.example.demo.climb.model.bean.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(
                name = "findAllZones",
                /*query = "from Member m where m.login != :name"*/
                query = "from Zone"
        )/*,
        @NamedQuery(
                name = "findByZoneName",
                query = "from Zone m where m.name = :name"
        )*/
})
@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull
    @Size(min = 1, max = 50)
    private String continent;
    @NotNull
    @Size(min = 1, max = 100)
    private String country;
   /* @NotNull*/
    @Size(min = 1, max = 100)
    private String region;

    public Zone() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

}
