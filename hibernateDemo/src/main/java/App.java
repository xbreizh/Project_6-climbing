import beans.Laptop;
import beans.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App {

    public static void main(String[] args) {

        /*Laptop laptop = new Laptop();
        laptop.setLid(3);
        laptop.setLname("Lenovo");
*/
        Student stu=null;
        /*

        Student student = new Student();
        student.setName("Pal");
        student.setRollno(1);
        student.setMarks(51);
        student.getLaptop().add(laptop);
        laptop.getStudentList().add(student);*/

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();


        Session session1 = sf.openSession();
        session1.beginTransaction();

        Query q1 = session1.createQuery("from Student");
        q1.setCacheable(true);


        System.out.println(q1.getResultList());
        session1.getTransaction().commit();
        session1.close();


    }
}
