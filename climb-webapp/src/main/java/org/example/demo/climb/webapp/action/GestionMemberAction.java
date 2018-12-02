package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.BookingManager;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.model.bean.*;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;


public class GestionMemberAction extends LoginAction {
    private Member member;
    private int id;
    private int idSession;
    private String login;
    private String email;
    private String emailCheck;
    private String password="";
    private String passwordCheck="";
    private List<Member> listMember;
    private String description;
    private boolean active;
    private List<Spot> spotList;
    private List<Topo> topoList;
    private List<Route> routeList;
    private List<Booking> bookingList;
    private List<Booking> bookedList;
    private  boolean submit = false;
    @Inject
    private MemberManager memberManager;
    @Inject
    private BookingManager bookingManager;



    // CREATE
    public String doCreate() {
        String vResult = ActionSupport.INPUT;

        vResult = validDoCreate(vResult);
        if (this.hasErrors()) {
            vResult = ActionSupport.INPUT;
        }
        return vResult;
    }


    public String doShowMySpace(){
        System.out.println("id passed: "+id);
        try {
            member = memberManager.getMemberById(id);
            spotList = member.getSpotList();
            topoList = member.getTopoListOwned();
            routeList = member.getRouteList();
            bookingList = member.getBookingList();
            bookedList = bookingManager.getBookedListByBooker(member.getId());
            System.out.println(spotList.size());
        } catch (NotFoundException e) {
            return ActionSupport.ERROR;
        }
        return ActionSupport.SUCCESS;
    }



    /*READ ALL*/

    public String doList(){
        listMember = memberManager.getListMember();
        System.out.println("list size: "+listMember.size());
        return ActionSupport.SUCCESS;
    }


    /*READ ONE*/
    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        member = memberManager.getMemberById(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    /*EDIT*/
    public String doEdit() {
        System.out.println("id: "+id);
        try {
            member = memberManager.getMemberById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("doedit id: "+member);
        System.out.println("active: "+member.isActive());
        return ActionSupport.SUCCESS;
    }


    /*UPDATE*/
    public String doUpdate() throws NotFoundException {
        String vResult = ActionSupport.INPUT;
        if(submit) {
            if (this.member != null) {
                System.out.println("member received: " + member);
                /*Member m = memberManager.getMemberById(member.getId());*/
                if (member.getLogin() != null || password != null || passwordCheck != null ||
                        member.getEmail() != null || member.getDescription() != null) {
                    if (member.getLogin().equals("") || member.getLogin().length() < 3 || member.getLogin().length() > 20) {
                        System.out.println("login length should between 3 and 20 characters");
                        this.addFieldError("member.login", "login length should be at least 3 characters");
                        return vResult;
                    } else if (password.length() < 3 || password.length() > 10) {
                        System.out.println("Password must be between 3 and 10 characters");
                        this.addFieldError("password", "Password must be between 3 and 8 characters");
                        return vResult;
                    } else if (!password.equals(passwordCheck)) {
                        System.out.println("password mismatch");
                        System.out.println("password: " + password + " check: " + passwordCheck);
                        this.addFieldError("password", "password mismatch");
                        return vResult;
                    } else if (member.getEmail().length() == 0) {
                        System.out.println("No email passed");
                        this.addFieldError("member.email", "You must type an email");
                        return vResult;
                    } else if (member.getDescription().length() > 255) {
                        System.out.println("description max: 255 characters");
                        this.addFieldError("description", "description max: 255 characters");
                        return vResult;
                    }

                } else {
                    System.out.println("something is missing in the form");
                }
                System.out.println("member before trying to update: " + member);
                if (!password.equals("******")) {
                    System.out.println("pwd unchanged");
                    /*password = member.getPassword();*/
                    member.setPassword(password);
                }
                member.setActive(true);
                memberManager.updateMember(member);
                System.out.println("Member: " + member);
                this.addActionMessage("Profile has been updated");
                System.out.println("id session: "+idSession);
                System.out.println("member id: "+member.getId());
                if(member.getId()==idSession) {
                    vResult = ActionSupport.SUCCESS;
                }else{
                    vResult = "member";
                }

            } else {
                member = memberManager.getMemberById(id);
            }
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    /*DELETE*/
    public String doDelete() {
        String vResult = ActionSupport.SUCCESS;


        memberManager.deleteMember(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

    }



    private String validDoCreate(String vResult) {

        // checking if existing member with the proposed login
        if (this.member != null) {
            boolean exist= memberManager.exists(this.member.getLogin());
            if (this.member.getLogin().equals("")) {
                this.addFieldError("member.login", "is empty");
            }else if (this.member.getLogin().length() < 3 || this.member.getLogin().length() > 10) {
                this.addFieldError("member.login", "Login must be between 3and 10 characters");
            }
            else if(exist){
                System.out.println("Login1: "+member.getLogin()+ "exists: "+exist);
                this.addFieldError("member.login", "Login already exists! Pick another one!");
            }
            else if (this.member.getPassword().length() < 3 || this.member.getPassword().length() > 8) {
                this.addFieldError("member.password", "must be between 3 and 8 characters");
            }
            else if(!this.member.getPassword().equals(passwordCheck)){
                this.addFieldError("member.password", "password mismatch");
            }
            else if(this.member.getEmail().equals("")){
                this.addFieldError("member.email", "You must type an email");
            }
            else if(!this.member.getEmail().equals(emailCheck)){
                this.addFieldError("member.email", "email mismatch");
            }else {
                try {
                    memberManager.addMember(member);
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Account created!");
                } catch (NullPointerException e) {
                    this.addActionError(e.getMessage());
                }
            }
        }else{
            vResult = ActionSupport.INPUT;
        }
        return vResult;
    }

    public Member getMember() {
        return member;
    }

    public String getDescription() {
        return description;
    }
    public boolean isActive() {
        return active;
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

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public void setMember(Member member) {
        this.member = member;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Member> getListMember() {
        return listMember;
    }

    public void setListMember(List<Member> listMember) {
        this.listMember = listMember;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public List<Booking> getBookedList() {
        return bookedList;
    }

    public void setBookedList(List<Booking> bookedList) {
        this.bookedList = bookedList;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }
}
