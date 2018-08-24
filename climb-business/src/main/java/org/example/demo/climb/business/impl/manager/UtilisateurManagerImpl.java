package org.example.demo.climb.business.impl.manager;


import org.apache.commons.lang3.StringUtils;
import org.example.demo.climb.business.contract.manager.UtilisateurManager;
import org.example.demo.climb.model.bean.utilisateur.Utilisateur;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {





    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        if (pId < 0) {
            throw new NotFoundException("Utilisateur non trouvé : ID=" + pId);
        }
        Utilisateur vUtilisateur = newUtilisateur(pId);
        return vUtilisateur;
    }


    @Override
    public Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException {


        if (StringUtils.equals(pLogin, "joe") && StringUtils.equals(pPassword, "joe")) {
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
        Utilisateur vUtilisateur = new Utilisateur(pId);
        vUtilisateur.setPrenom(vPrenoms[Math.abs(pId) % vPrenoms.length]);
        vUtilisateur.setNom("Dalton");
        return vUtilisateur;
    }

}
