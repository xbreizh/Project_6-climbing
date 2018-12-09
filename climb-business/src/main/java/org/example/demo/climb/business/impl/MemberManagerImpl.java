package org.example.demo.climb.business.impl;

import org.apache.log4j.Logger;
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
public class MemberManagerImpl implements MemberManager {

    private final String pepper = "Tipiak";
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Class cl = Member.class;
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
        member.setPassword(encryptPassword(member.getPassword())); // encrypting password
        logger.info("password crypted");
        member.setDatejoin(new Date());
        member.setRole("admin");
        logger.info("Member to be added: " + member);
        memberDao.add(member);
        logger.info("Checking if member is added: " + getMemberById(member.getId()));
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
        if (!member.isActive()) {
            m.setLogin("Inactive Member");
            m.setActive(false);
        } else {
            if (member.getPassword() != null) { // checks if any password passed

                m.setPassword(encryptPassword(member.getPassword()));
            }
            m.setEmail(member.getEmail());
            m.setLogin(m.getLogin2());
            m.setActive(true);
            m.setDescription(member.getDescription());
        }
        logger.info("member from manager: " + m);
        memberDao.update(m);

    }

    // Disable Member
    @Override
    public void disableMember(int id) {
        Member m = (Member) memberDao.getById(id);
        logger.info("member received to disable: " + m);
        m.setActive(false);
        m.setLogin("Inactive User");

        memberDao.update(m);
    }

    // Enable Member
    @Override
    public void enableMember(int id) {
        Member m = (Member) memberDao.getById(id);
        logger.info("member received to enable: " + m);
        m.setActive(true);
        m.setLogin(m.getLogin2());

        memberDao.update(m);
    }

    // switch role admin <--> superadmin
    @Override
    public void updateRole(int id) {
        Member m = (Member) memberDao.getById(id);
        if (m.getRole().equals("admin")) {
            m.setRole("superadmin");
        } else {
            m.setRole("admin");
        }

        memberDao.update(m);
    }

    // Delete Member
    @Override
    public void deleteMember(Member member) {
        logger.info("from manager: " + member);
        memberDao.delete(member);
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
                if (!m.isActive()) {
                    logger.info("member exista but inactive: " + m.getLogin());
                }
                return m;
            }
        } catch (NoResultException e) {
            logger.info("wrong login or pwd");
        }
        return null;
    }

    @Override
    public String encryptPassword(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String pwd = bcrypt.encode(password + pepper);
        logger.info("hashed pwd: " + pwd);
        return pwd;
    }

    @Override
    public boolean checkPassword(String pwd1, String pwd2) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        return bcrypt.matches(pwd1 + pepper, pwd2);
    }

    // Logout
    @Override
    public void disconnect(String login) {
        Member m;
        if (((m = getMemberByLogin(login.toUpperCase())) != null)) {
            m.setDateLastConnect(new Date());
        }
    }

    // Update Password
    @Override
    public boolean updatePassword(String login, String email, String password) {
        logger.info("member received: " + login);
        logger.info("email received: " + email);
        logger.info("pwd received: " + password);

        if (exists(login.toUpperCase())) {
            Member m = getMemberByLogin(login.toUpperCase());
            if (m.getEmail().equals(email)) {
                logger.info("email passed");
                m.setPassword(encryptPassword(password));
                memberDao.update(m);
                return true;
            }
        } else {
            logger.info("member couldn't be found");
        }
        return false;
    }


}
