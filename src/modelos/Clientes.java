package modelos;
// Generated 22-nov-2023 1:11:13 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes implements java.io.Serializable {

    private String codcliente;
    private String nomcliente;
    private String domiciliocli;
    private Set facturases = new HashSet(0);

    public Clientes() {
    }

    public Clientes(String codcliente) {
        this.codcliente = codcliente;
    }

    public Clientes(String codcliente, String nomcliente, String domiciliocli, Set facturases) {
        this.codcliente = codcliente;
        this.nomcliente = nomcliente;
        this.domiciliocli = domiciliocli;
        this.facturases = facturases;
    }

    public String getCodcliente() {
        return this.codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public String getNomcliente() {
        return this.nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }

    public String getDomiciliocli() {
        return this.domiciliocli;
    }

    public void setDomiciliocli(String domiciliocli) {
        this.domiciliocli = domiciliocli;
    }

    public Set getFacturases() {
        return this.facturases;
    }

    public void setFacturases(Set facturases) {
        this.facturases = facturases;
    }

    //Métodos generados por mí
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codcliente);
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
        final Clientes other = (Clientes) obj;
        if (!Objects.equals(this.codcliente, other.codcliente)) {
            return false;
        }
        return true;
    }

    //--------------------------------------------------------------------------
   
}
