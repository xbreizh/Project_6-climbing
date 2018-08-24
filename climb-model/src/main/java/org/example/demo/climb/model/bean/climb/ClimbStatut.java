package org.example.demo.climb.model.bean.climb;

/**
 * Bean représentant le Statut d'un climb.
 *
 * @author lgu
 */
public class ClimbStatut {

    // ==================== Attributs ====================
    private Integer id;
    private String libelle;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public ClimbStatut() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public ClimbStatut(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String pLibelle) {
        libelle = pLibelle;
    }


    // ==================== Méthodes ====================
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("id=").append(id)
            .append(vSEP).append("libelle=\"").append(libelle).append('"')
            .append("}");
        return vStB.toString();
    }
}
