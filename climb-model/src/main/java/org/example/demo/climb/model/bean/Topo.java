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
    @ManyToOne
    private Member owner;

    @OneToMany(mappedBy = "topo",  fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Borrow> ListBorrows = new ArrayList<>();

    @NotNull
    private boolean available;

    public Topo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
