package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    private String login;
    private String pwd;
    private Map<String, Object> session;
    @Inject
    private MemberManager memberManager;

    public String getLogin() {
        return login;
    }

    //Getters / Setters
    public void setLogin(String login) {
        this.login = login;
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
           /*
            try{Member member = memberManager.connect(login,pwd);
            }catch(NotFoundException e){
                this.addActionError("Identifiant ou mot de passe invalide");
            }*/
           Member member = memberManager.connect(login,pwd);
            if(member!=null){
                System.out.println("trying to get member");
                this.session.put("user", member);
                System.out.println("Session: "+session.entrySet().toString());
                vResult = ActionSupport.SUCCESS;
            }else{
                this.addActionError("Identifiant ou mot de passe invalide");
            }
           /* try {
                if(member) {
                    System.out.println("Member: "+login);
                }
            } catch (NotFoundException e) {

            }*/

          /*  if(memberManager.connect(login, pwd)){
            }else{
                this.addActionError("Identifiant ou mot de passe invalide");
            }*/
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
