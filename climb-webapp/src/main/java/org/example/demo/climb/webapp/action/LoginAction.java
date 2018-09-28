package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
@Named
public class LoginAction extends ActionSupport implements SessionAware {
    private String login;
    private String pwd;

    private Map<String, Object> session;

    @Inject
    private MemberManager memberManager;

    //Getters / Setters

    public Map<String, Object> getSession() {
        return session;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //Méthodes

    public String doLogin(){
        String vResult= ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, pwd)) {
           Member member = memberManager.connect(login,pwd);
            if(member!=null){
                System.out.println("trying to get member: ");
                this.session.put("user", member);
                System.out.println("Session: "+session.entrySet().toString());
                vResult = ActionSupport.SUCCESS;
                System.out.println("Member from the session creation: "+session.values());
            }else{
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
