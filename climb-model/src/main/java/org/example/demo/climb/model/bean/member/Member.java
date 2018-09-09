package org.example.demo.climb.model.bean.member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(
                name = "findAllMembers",
                /*query = "from Member m where m.login != :name"*/
                query = "from Member"
        ),
        @NamedQuery(
                name = "findByLogin",
                query = "from Member m where m.login = :login"
        )
})
@Entity

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min = 3, max = 100)
    private String login;

    @NotNull
    @Size(min = 5, max = 100)
    private String password;
    @NotNull
    @Size(min = 1, max = 1000)
    private String description;

    public Member() {
    }

    /*@ManyToMany(mappedBy = "studentList", fetch = FetchType.EAGER)*/
   /* private List<Laptop> laptop = new ArrayList<Laptop>();

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
