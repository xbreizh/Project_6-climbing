package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.apache.commons.lang3.ObjectUtils.allNotNull;

@Named
public class LoginAction extends ActionSupport implements SessionAware {
    private String login;
    private String email;
    private String emailCheck;
    private String password;
    private String passwordCheck;

    private Map<String, Object> session;

    @Inject
    private MemberManager memberManager;


    // LOGIN
    public String doLogin(){
        String vResult= ActionSupport.INPUT;

        if (!StringUtils.isAllEmpty(login, password)) {
           Member member = memberManager.connect(login,password);
            if(member!=null){
                this.session.put("user", member);
                vResult = ActionSupport.SUCCESS;
            }else{
                this.addFieldError("login","Identifiant ou mot de passe invalide");
            }

        }
        return vResult;
    }

    // LOGIN
    public void updateSessionUser(int id) throws NotFoundException {
                this.session.remove("user");

                this.session.put("user", memberManager.getMemberById(id));

    }

    // LOGOUT
    public String doLogout(){
        try{
            Member m = (Member) session.get("user");
            System.out.println("trying to update the lastconnect date before disconnecting: "+m.getLogin());
            System.out.println("last connect: "+m.getDateLastConnect());
            System.out.println("role: "+session.get("user.role"));
            memberManager.disconnect(m.getLogin());
            System.out.println("session: "+session.get("user"));
            session.remove("user");
        }catch(NullPointerException e){
            this.addActionError(e.getMessage());
            this.addActionError("Disconnection error");
        }
        session.remove("user");
        System.out.println("session: "+session.get("user"));
        return ActionSupport.SUCCESS;
    }

    // RESET PASSWORD
    public String doReset(){
        String vResult = ActionSupport.INPUT;


        if(login != null && email!= null && password != null && passwordCheck != null ){
            if (login.equals("")) {
                this.addFieldError("login", "you must provide a login");
                return vResult;
            } else if (this.email.equals("")) {
                this.addFieldError("email", "you must provide an email");
                return vResult;
            } else if (this.password.length() < 3 || this.password.length() > 8) {
                this.addFieldError("password", "Password must be between 3 and 8 characters");
                return vResult;
            } else if (!this.password.equals(passwordCheck)) {
                this.addFieldError("password", "password mismatch");
                return vResult;
            } else if (memberManager.updatePassword(login, email, password)) {
                return vResult = ActionSupport.SUCCESS;
            } else {
                this.addFieldError("login", "Login or Email incorrect");
            }
        }else{
            System.out.println("all is null");
        }
        return vResult;
    }

    // CREATING SESSION
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

   /***********************************************************************/
    /************************ GETTERS - SETTERS ***************************/
    /***********************************************************************/

    public Map<String, Object> getSession() {
        return session;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCheck() {
        return emailCheck;
    }

    public void setEmailCheck(String emailCheck) {
        this.emailCheck = emailCheck;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
}
