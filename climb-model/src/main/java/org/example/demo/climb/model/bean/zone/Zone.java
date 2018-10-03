package org.example.demo.climb.model.bean.zone;

import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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
   /* @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull
    @Size(min = 1, max = 50)
    private String continent;
    @NotNull
    @Size(min = 1, max = 100)
    private String country;
    @NotNull
    @Size(min = 1, max = 100)
    private String region;
    @OneToMany(mappedBy = "zone", fetch=FetchType.EAGER)
    private List<Spot> spotList= new ArrayList<>();

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
