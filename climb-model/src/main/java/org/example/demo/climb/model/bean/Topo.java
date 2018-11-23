package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

    @Entity
    public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @ManyToOne
    private Country country;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Size(min = 2, max = 50)
    private String edition;

    @NotNull
    @Size(min = 2, max = 50)
    private String author;

    @NotNull
    private int publishedYear;

    @NotNull
    @Size(min = 3, max = 350)
    private String description;

    @NotNull
    @Size(min = 3, max = 350)
    private String keywords;

    @NotNull
    @ManyToOne
    private Member owner;

    @OneToMany(mappedBy = "topo",  fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Booking> listBookings = new ArrayList<>();

    @ManyToMany(targetEntity=org.example.demo.climb.model.bean.Spot.class,
            mappedBy = "topos", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Spot> spots = new ArrayList<>();

    @NotNull
    private boolean available;

    public Topo() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
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

    public String getEdition() {
        return edition;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    public List<Booking> getListBookings() {
        return listBookings;
    }

    public void setListBookings(List<Booking> listBookings) {
        this.listBookings = listBookings;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

        public List<Spot> getSpots() {
            return spots;
        }

        public void setSpots(List<Spot> spots) {
            this.spots = spots;
        }

        @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edition='" + edition + '\'' +
                ", author='" + author + '\'' +
                ", publishedYear=" + publishedYear +
                ", description=" + description +
                ", keywords='" + keywords + '\'' +
                ", owner=" + owner +
                ", listBookings=" + listBookings +
                ", available=" + available +
                '}';
    }
}
