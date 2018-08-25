package org.example.demo.climb.business;


import org.example.demo.climb.model.bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        /*Laptop laptop = new Laptop();
        laptop.setLid(3);
        laptop.setLname("Lenovo");
*/
        /* Student stu = null;*/
        /*

        Student student = new Student();
        student.setName("Pal");
        student.setRollno(1);
        student.setMarks(51);
        student.getLaptop().add(laptop);
        laptop.getStudentList().add(student);*/

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        /*.addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);*/
        System.out.println("test");

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        session.beginTransaction();

        Student stu = session.get(Student.class, 1);
        session.getTransaction().commit();
        session.close();

        System.out.println(stu);


    }
}
