package org.example.demo.climb.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
/*@Table(name="student")*/
/*@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)*/
public class Member {

    @Id
    private int id;
    private String name;
    private String password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
