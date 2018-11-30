package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.model.bean.Member;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Named
public class LoginAction extends ActionSupport implements SessionAware {
    private String login;
    private String pwd;

    private Map<String, Object> session;

    @Inject
    private MemberManager memberManager;


    // Methods
    public String doLogin(){
        String vResult= ActionSupport.INPUT;

        if (!StringUtils.isAllEmpty(login, pwd)) {
           Member member = memberManager.connect(login,pwd);
            if(member!=null){
                this.session.put("user", member);
                vResult = ActionSupport.SUCCESS;
            }else{
                this.addActionError("Identifiant ou mot de passe invalide");
            }

        }
        return vResult;
    }

    public String doLogout(){
        try{
            Member m = (Member) session.get("user");
            System.out.println("trying to update the lastconnect date before disconnecting: "+m.getLogin());
            memberManager.disconnect(m.getLogin());
            session.remove("user");
        }catch(NullPointerException e){
            this.addActionError(e.getMessage());
            this.addActionError("Disconnection error");
        }
        session.remove("user");
        return ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

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


}
