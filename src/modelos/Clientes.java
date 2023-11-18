package modelos;
// Generated 18-nov-2023 1:53:26 by Hibernate Tools 4.3.1

import java.util.HashSet;
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

    public Clientes(String codcliente, String nomcliente, String domiciliocli) {
        this.codcliente = codcliente;
        this.nomcliente = nomcliente;
        this.domiciliocli = domiciliocli;
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

}
