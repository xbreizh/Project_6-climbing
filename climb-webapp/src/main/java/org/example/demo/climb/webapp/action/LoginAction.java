package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


@Named
public class LoginAction extends ActionSupport implements SessionAware {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private String login;
    private String email;
    private String emailCheck;
    private String password;
    private String passwordCheck;
    private String error;

    private Map<String, Object> session;

    @Inject
    private MemberManager memberManager;


    // LOGIN
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        logger.info("logger level: " + logger.getLevel());
        if (!StringUtils.isAllEmpty(login, password)) {
            Member member = memberManager.connect(login, password);

            if (member != null) {
                this.session.put("user", member);
                logger.info("Connection ok " + login);
                vResult = ActionSupport.SUCCESS;
            } else {
                error = "Identifiant ou mot de passe invalide";
                this.addFieldError("login", error);
                logger.info(error + login);
            }

        }
        return vResult;
    }

    // LOGIN
    public void updateSessionUser(int id) throws NotFoundException {
        this.session.remove("user");
        logger.info("updating session: " + login);
        this.session.put("user", memberManager.getMemberById(id));

    }

    // LOGOUT
    public String doLogout() {
        try {
            Member m = (Member) session.get("user");
            logger.info("trying to logout: " + m.getLogin());
            memberManager.disconnect(m.getLogin());
            logger.info("deconnection ok");
            session.remove("user");
        } catch (NullPointerException e) {
            this.addActionError(e.getMessage());
            error = "Disconnection error";
            this.addActionError(error);
            logger.warn(error);
        }
        return ActionSupport.SUCCESS;
    }

    // RESET PASSWORD
    public String doReset() {
        String vResult = ActionSupport.INPUT;


        if (login != null && email != null && password != null && passwordCheck != null) {
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
                logger.info("update password form validated: " + login);
                return vResult = ActionSupport.SUCCESS;
            } else {
                this.addFieldError("login", "Login or Email incorrect");
                logger.warn("password reset form issue: " + login);
            }
        } else {
            logger.warn("reset password form is empty");
        }
        return vResult;
    }

    /***********************************************************************/

    public Map<String, Object> getSession() {
        return session;
    }

    /***********************************************************************/
    /************************ GETTERS - SETTERS ***************************/

    // CREATING SESSION
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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
