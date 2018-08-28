package org.example.demo.climb.business.impl.manager;


import org.apache.commons.lang3.StringUtils;
import org.example.demo.climb.business.contract.MemberDao;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.bean.member.Utilisateur;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("memberManager")
public class MemberManagerImpl extends AbstractManager implements MemberManager {

    private Member vMember = null;
    @Inject
    private MemberDao memberDao;



    @Override
    public Member getMember(Integer pId) {
        memberDao.getmemberById(pId);
        /*if (pId < 0) {
            throw new NotFoundException("Utilisateur non trouvé : ID=" + pId);
        }
        vMember = newMember(pId);*/
        return vMember;
    }


    @Override
    public Member getMember(String pLogin, String pPassword) throws NotFoundException {

        String name = memberDao.getmemberById(4).getLogin();
        /*String password = memberDao.getmemberById(1).*/
        if (StringUtils.equals(pLogin, name) && StringUtils.equals(pPassword, "joe")) {
            return newMember(0);
        }
        /*System.out.println("plok: "+ u.getNom());*/
        throw new NotFoundException("Aucun utilisateur correspondant au couple login/password fourni.");
    }

    @Override
    public void addMember(Member member) {
        memberDao.addMember(member);
    }


    @Override
    public List<Member> getListMember() {

        /* List<Member> vList = new ArrayList<>();*/
        List<Member> vList = memberDao.getMemberList();
        /*for (int vI = 0; vI < 9; vI++) {
            Member vMember = newMember(vI);
            vList.add(vMember);
        }*/
        return vList;
    }


    /**
     * Crée une instance d'{@link Utilisateur}
     * @param pId -
     * @return Utilisateur
     */
    private Member newMember(Integer pId) {
        final String[] vPrenoms = {
            "Joe", "William", "Jack", "Averell"
        };
        /*vMember = new Utilisateur(pId);
        vMember.setPrenom(vPrenoms[Math.abs(pId) % vPrenoms.length]);
        vMember.setNom("Dalton");*/
        return vMember;
    }

}
