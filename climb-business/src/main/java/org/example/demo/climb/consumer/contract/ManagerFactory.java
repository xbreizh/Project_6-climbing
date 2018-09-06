package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.consumer.contract.manager.MemberManager;


/**
 * Factory des Managers
 */
public interface ManagerFactory {

    /* ProjetManager getProjetManager();*/

    MemberManager getMemberManager();
}
