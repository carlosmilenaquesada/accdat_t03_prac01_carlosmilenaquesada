package modelos;
// Generated 15-nov-2023 2:06:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Familias generated by hbm2java
 */
public class Familias  implements java.io.Serializable {


     private String codfam;
     private String nomfam;
     private Set articuloses = new HashSet(0);

    public Familias() {
    }

	
    public Familias(String codfam) {
        this.codfam = codfam;
    }
    public Familias(String codfam, String nomfam, Set articuloses) {
       this.codfam = codfam;
       this.nomfam = nomfam;
       this.articuloses = articuloses;
    }
   
    public String getCodfam() {
        return this.codfam;
    }
    
    public void setCodfam(String codfam) {
        this.codfam = codfam;
    }
    public String getNomfam() {
        return this.nomfam;
    }
    
    public void setNomfam(String nomfam) {
        this.nomfam = nomfam;
    }
    public Set getArticuloses() {
        return this.articuloses;
    }
    
    public void setArticuloses(Set articuloses) {
        this.articuloses = articuloses;
    }

    //Métodos creados por mí.
    @Override
    public String toString() {
        return "Familias{" + "codfam=" + codfam + ", nomfam=" + nomfam + ", articuloses=" + articuloses + '}';
    }
    


}


