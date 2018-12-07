package org.example.demo.climb.business.impl;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;
@Transactional
@Named("memberManager")
public class MemberManagerImpl  implements MemberManager {

   /* private Member member;*/
    private Class cl=Member.class;
    @Inject
    private MemberDao memberDao;
    @Inject
    private SpotManager spotManager;



    /***************************************************************************/
    /********************   CRUD Member    ***********************************/
    /***************************************************************************/

    // Creates Member
    @Override
    public void addMember(Member member) {
        member.setActive(true);//activating user
        member.setLogin2(member.getLogin().toUpperCase());//setting backup login
        member.setLogin(member.getLogin().toUpperCase());//setting upper case login
        member.setPassword( encryptPassword(member.getPassword())); // encrypting password
        System.out.println("password crypted");
        member.setDatejoin(new Date());
        member.setRole("admin");
        System.out.println("Member to be added: "+member);
        memberDao.add(member);
        System.out.println("Checking if member is added: "+getMemberById(member.getId()));
    }


    // Read one member by Id
    @Override
    public Member getMemberById(int id) {
        return (Member) memberDao.getById(id);
    }

    // Read one member by Login
    @Override
    public Member getMemberByLogin(String login) {
        return memberDao.getMemberByLogin(login);
    }


    // Read all members
    @Override
    public List<Member> getListMember() {
        return memberDao.getAll();

    }

    // Update Member
    @Override
    public void updateMember(Member member) {
        int id = member.getId();
        Member m = (Member) memberDao.getById(id);
        if(!member.isActive()){
            m.setLogin("Inactive Member");
            m.setActive(false);
        }else{
            if(member.getPassword()!= null) { // checks if any password passed

                m.setPassword(encryptPassword(member.getPassword()));
            }
            m.setEmail(member.getEmail());
            m.setLogin(m.getLogin2());
            m.setActive(true);
            m.setDescription(member.getDescription());
        }
        System.out.println("member from manager: "+m);
        memberDao.update(m);

    }

    // Disable Member
    @Override
    public void disableMember(int id) {
        Member m= (Member) memberDao.getById(id);
        /*spotManager.updateWhenDeletingMember(id);*/
        System.out.println("member received to disable: "+m);
        m.setActive(false);
        m.setLogin("Inactive User");

        memberDao.update(m);
    }

    // Enable Member
    @Override
    public void enableMember(int id) {
        Member m= (Member) memberDao.getById(id);
        /*spotManager.updateWhenDeletingMember(id);*/
        System.out.println("member received to enable: "+m);
        m.setActive(true);
        m.setLogin(m.getLogin2());

        memberDao.update(m);
    }

    // Delete Member
    @Override
    public void deleteMember(int id) {
       Member m= (Member) memberDao.getById(id);
        /*spotManager.updateWhenDeletingMember(id);*/


        memberDao.delete(m);
    }

    // Checks if the login exists
    @Override
    public boolean exists(String login) {
        for (Member m : getListMember()
        ) {
            if (m.getLogin().equals(login.toUpperCase())) {
                return true;
            }
        }
        return false;
    }


    /***************************************************************************/
    /********************   Login Methods    ***********************************/
    /***************************************************************************/
    // Login
    @Override
    public Member connect(String login, String password) {
        Member m;
        try {
            m = getMemberByLogin(login.toUpperCase());
            // checking password match
            if (checkPassword(password, m.getPassword())) {
                if(!m.isActive()){
                    System.out.println("member exista but inactive: " +m.getLogin());
                }
                return m;
            }
        } catch (NoResultException e) {
            System.out.println("wrong login or pwd");
        }
        return null;
    }

    @Override
    public String encryptPassword(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String pwd =bcrypt.encode(password);
        System.out.println("hashed pwd: "+pwd);
        return pwd;
    }

    @Override
    public boolean checkPassword(String pwd1, String pwd2) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();


        return bcrypt.matches(pwd1, pwd2);
    }

    // Logout
    @Override
    public void disconnect(String login) {
        Member m;
        if(((m=getMemberByLogin(login.toUpperCase()))!=null)){
            m.setDateLastConnect(new Date());
        }
    }

    // Update Password
    @Override
    public boolean updatePassword(String login, String email, String password){
        if(exists(login.toUpperCase())){
            Member m = getMemberByLogin(login.toUpperCase());
            if(m.getEmail().equals(email)) {
                m.setPassword(password);
                memberDao.update(m);
                return true;
            }
        }
        return false;
    }


}
