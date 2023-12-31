package modelos;
// Generated 22-nov-2023 1:11:13 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Familias generated by hbm2java
 */
public class Familias implements java.io.Serializable {

    private String codfamilia;
    private String nomfamilia;
    private String descfamilia;
    private Set articuloses = new HashSet(0);

    public Familias() {
    }

    public Familias(String codfamilia) {
        this.codfamilia = codfamilia;
    }

    public Familias(String codfamilia, String nomfamilia, String descfamilia, Set articuloses) {
        this.codfamilia = codfamilia;
        this.nomfamilia = nomfamilia;
        this.descfamilia = descfamilia;
        this.articuloses = articuloses;
    }

    public String getCodfamilia() {
        return this.codfamilia;
    }

    public void setCodfamilia(String codfamilia) {
        this.codfamilia = codfamilia;
    }

    public String getNomfamilia() {
        return this.nomfamilia;
    }

    public void setNomfamilia(String nomfamilia) {
        this.nomfamilia = nomfamilia;
    }

    public String getDescfamilia() {
        return this.descfamilia;
    }

    public void setDescfamilia(String descfamilia) {
        this.descfamilia = descfamilia;
    }

    public Set getArticuloses() {
        return this.articuloses;
    }

    public void setArticuloses(Set articuloses) {
        this.articuloses = articuloses;
    }

    //--------------------------------------------------------------------------
    //Métodos generados por mí
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codfamilia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Familias other = (Familias) obj;
        if (!Objects.equals(this.codfamilia, other.codfamilia)) {
            return false;
        }
        return true;
    }

    //--------------------------------------------------------------------------
    @Override
    public String toString() {
        return getCodfamilia();
    }
}
