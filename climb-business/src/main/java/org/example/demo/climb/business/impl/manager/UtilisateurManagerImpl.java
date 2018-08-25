package org.example.demo.climb.business.impl.manager;


import org.apache.commons.lang3.StringUtils;
import org.example.demo.climb.business.contract.manager.UtilisateurManager;
import org.example.demo.climb.model.bean.Student;
import org.example.demo.climb.model.bean.utilisateur.Utilisateur;
import org.example.demo.climb.model.exception.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    private Utilisateur vUtilisateur = null;



    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        if (pId < 0) {
            throw new NotFoundException("Utilisateur non trouvé : ID=" + pId);
        }
        vUtilisateur = newUtilisateur(pId);
        return vUtilisateur;
    }


    @Override
    public Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();
        /*Student stu = null;*/
        Session session = sf.openSession();
        session.beginTransaction();

        Student stu = session.get(Student.class, 1);
        session.getTransaction().commit();
        session.close();
        String name = stu.getName();
        System.out.println(name);
        if (StringUtils.equals(pLogin, name) && StringUtils.equals(pPassword, "joe")) {
            return newUtilisateur(0);
        }
        /*System.out.println("plok: "+ u.getNom());*/
        throw new NotFoundException("Aucun utilisateur correspondant au couple login/password fourni.");
    }


    @Override
    public List<Utilisateur> getListUtilisateur() {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        List<Utilisateur> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            Utilisateur vUtilisateur = newUtilisateur(vI);
            vList.add(vUtilisateur);
        }
        return vList;
    }


    /**
     * Crée une instance d'{@link Utilisateur}
     * @param pId -
     * @return Utilisateur
     */
    private Utilisateur newUtilisateur(Integer pId) {
        final String[] vPrenoms = {
            "Joe", "William", "Jack", "Averell"
        };
        vUtilisateur = new Utilisateur(pId);
        vUtilisateur.setPrenom(vPrenoms[Math.abs(pId) % vPrenoms.length]);
        vUtilisateur.setNom("Dalton");
        return vUtilisateur;
    }

}
