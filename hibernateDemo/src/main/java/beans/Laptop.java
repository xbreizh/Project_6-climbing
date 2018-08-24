package beans;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "laptop")
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {

    @Id
    private int lid;
    private String lname;
    @ManyToMany
    private List<Student> studentList = new ArrayList<Student>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                '}';
    }




}
