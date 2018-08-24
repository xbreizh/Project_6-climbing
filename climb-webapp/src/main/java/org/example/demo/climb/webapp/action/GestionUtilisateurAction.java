package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.webapp.WebappHelper;
import org.example.demo.climb.model.bean.utilisateur.Utilisateur;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.Collections;
import java.util.List;

public class GestionUtilisateurAction extends ActionSupport {

    private Integer id;



    private Utilisateur utilisateur;



    private List<Utilisateur> listUtilisateur;


    /*Getters / Setters*/

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }
    public Integer getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*Méthodes*/

    public String doList(){
        listUtilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getListUtilisateur();
        return ActionSupport.SUCCESS;
    }


    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.user.missing.id"));
        } else {
            try {
                utilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(id)) );
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
