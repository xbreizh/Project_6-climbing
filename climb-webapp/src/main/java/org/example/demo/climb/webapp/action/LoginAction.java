package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.model.bean.utilisateur.Utilisateur;
import org.example.demo.climb.model.exception.NotFoundException;
import org.example.demo.climb.webapp.WebappHelper;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private String login;
    private String pwd;
    private Map<String, Object> session;

    public String getLogin() {
        return login;
    }

    /*Getters / Setters*/
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /*Méthodes*/

    public String doLogin(){
        String vResult=ActionSupport.INPUT;
        if(!StringUtils.isAllEmpty(login, pwd)){
            try {
                Utilisateur vUtilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(login, pwd);
                this.session.put("user", vUtilisateur);
                vResult = ActionSupport.SUCCESS;
            } catch (NotFoundException e) {
                this.addActionError("Identifiant ou mot de passe invalide");
            }
        }
        return vResult;
    }

    public String doLogout(){
        session.remove("user");
        return ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
