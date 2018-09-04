package org.example.demo.climb.model.bean.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
/*@Table(name="student")*/
/*@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)*/
public class Member {

    @Id
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
