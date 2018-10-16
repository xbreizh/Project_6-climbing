package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String edition;

    @NotNull
    private String author;

    @NotNull
    private int publishedYear;

    @NotNull
    private String description;

    @NotNull
    private String keywords;

    @NotNull
    @ManyToOne
    private Member owner;

    @OneToMany(mappedBy = "topo",  fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Borrow> ListBorrows = new ArrayList<>();

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

    public List<Borrow> getListBorrows() {
        return ListBorrows;
    }

    public void setListBorrows(List<Borrow> listBorrows) {
        ListBorrows = listBorrows;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
                ", ListBorrows=" + ListBorrows +
                ", available=" + available +
                '}';
    }
}
