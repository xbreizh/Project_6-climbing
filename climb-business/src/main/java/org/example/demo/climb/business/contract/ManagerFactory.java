package org.example.demo.climb.business.contract;

import org.example.demo.climb.business.contract.manager.MemberManager;


/**
 * Factory des Managers
 */
public interface ManagerFactory {

    /* ProjetManager getProjetManager();*/

    MemberManager getMemberManager();
}
