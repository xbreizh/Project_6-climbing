package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.bean.member.Utilisateur;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface MemberManager {

    /**
     * Renvoie la liste des {@link Utilisateur}
     *
     * @return List
     */
    List<Member> getListMember();

    /**
     * Renvoie l'{@link Utilisateur} demandé
     *
     * @param pId l'identifiant de l'Utilisateur
     * @return Le {@link Utilisateur}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    Member getMember(Integer pId) throws NotFoundException;


    /**
     * Renvoie l'{@link Utilisateur} correspondant au couple login / mot de passe
     *
     * @param pLogin le login de l'Utilisateur
     * @param pPassword le mot de passe de l'Utilisateur
     * @return Le {@link Utilisateur}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    Member getMember(String pLogin, String pPassword) throws NotFoundException;
}
