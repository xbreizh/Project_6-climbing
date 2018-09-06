package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.ManagerFactory;
import org.example.demo.climb.consumer.contract.manager.MemberManager;
import org.example.demo.climb.consumer.contract.manager.ProjetManager;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Implémentation de la {@link ManagerFactory}.
 */
@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private ProjetManager projetManager;
    @Inject
    private MemberManager memberManager;


    /*@Override*/
    public ProjetManager getProjetManager() {

        return this.projetManager;
    }
    public void setProjetManager(ProjetManager pProjetManager) {

        projetManager = pProjetManager;
    }



    @Override
    public MemberManager getMemberManager() {

        return this.memberManager;
    }

    public void setclimbManager(MemberManager pMemberManager) {
        memberManager = pMemberManager;
    }
}
