package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.model.bean.member.Utilisateur;
import org.example.demo.climb.model.bean.projet.Projet;

import java.util.List;

public class GestionProjetAction extends ActionSupport {

    private Integer id;

    private List<Projet> listProjet;

    private Projet projet;

    private List<Utilisateur> listUtilisateur;

    /*Getters / Setters*/
    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public int getId() {
        return id;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Projet> getListProjet() {
        return listProjet;
    }

    public Projet getProjet() {
        return projet;
    }

    /*Methodes*/

    public String doList(){
        /* listProjet = WebappHelper.getManagerFactory().getProjetManager().getListProjet();*/
        return ActionSupport.SUCCESS;
    }

    public String doDetail(){
       /* if(id == null){
            this.addActionError("vous devez indiquer un id de projet");
        }else {
            try {
                projet = WebappHelper.getManagerFactory().getProjetManager().getProjet(id);
            } catch (NotFoundException e) {
                this.addActionError("Projet non trouvé: "+id);
            }
        }*/
        return(this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate(){
        String vResult = ActionSupport.INPUT;
        /*if(this.projet != null){
            if(this.projet.getResponsable() == null ||
            this.projet.getResponsable().getId()==null){
                this.addFieldError("projet.responsable.id", "ne doit pas être vide");
            }else{
                try {
                    Utilisateur vUtilisateur = WebappHelper.getManagerFactory().getManager().getMember(this.projet.getResponsable().getId());
                    this.projet.setResponsable(vUtilisateur);
                } catch (NotFoundException e) {
                   this.addFieldError("projet.responsable.id", e.getMessage());
                }
            }
            this.projet.setDateCreation(new Date());

            if(!this.hasErrors()){
                try {
                    WebappHelper.getManagerFactory().getProjetManager().insertProjet(this.projet);
                    vResult=ActionSupport.SUCCESS;
                    this.addActionMessage("Projet ajouté avec succès");
                } catch (FunctionalException e) {
                    this.addActionError(e.getMessage());
                } catch (TechnicalException e) {
                    this.addActionError(e.getMessage());
                    return ActionSupport.ERROR;
                }
            }
        }
        if(vResult.equals(ActionSupport.INPUT)){
            this.listUtilisateur = WebappHelper.getManagerFactory().getManager().getListMember();
        }*/

        return vResult;
    }
}
