package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.ManagerFactory;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;
import org.example.demo.climb.webapp.WebappHelper;

import javax.inject.Inject;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private String login;
    private String pwd;
    private Map<String, Object> session;
    @Inject
    private ManagerFactory managerFactory;
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
                Member vMember = WebappHelper.getManagerFactory().getMemberManager().getMember(login, pwd);
                this.session.put("user", vMember);
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
