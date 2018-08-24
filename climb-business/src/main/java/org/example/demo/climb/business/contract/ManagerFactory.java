package org.example.demo.climb.business.contract;

import org.example.demo.climb.business.contract.manager.ProjetManager;
import org.example.demo.climb.business.contract.manager.UtilisateurManager;


/**
 * Factory des Managers
 */
public interface ManagerFactory {

    ProjetManager getProjetManager();

    UtilisateurManager getUtilisateurManager();
}
