package modelos;
// Generated 22-nov-2023 1:11:13 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Facturas generated by hbm2java
 */
public class Facturas implements java.io.Serializable {

    private BigDecimal numfactura;
    private Clientes clientes;
    private Date fechafactura;
    private Set articuloses = new HashSet(0);

    public Facturas() {
    }

    public Facturas(BigDecimal numfactura) {
        this.numfactura = numfactura;
    }

    public Facturas(BigDecimal numfactura, Clientes clientes, Date fechafactura, Set articuloses) {
        this.numfactura = numfactura;
        this.clientes = clientes;
        this.fechafactura = fechafactura;
        this.articuloses = articuloses;
    }

    public BigDecimal getNumfactura() {
        return this.numfactura;
    }

    public void setNumfactura(BigDecimal numfactura) {
        this.numfactura = numfactura;
    }

    public Clientes getClientes() {
        return this.clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Date getFechafactura() {
        return this.fechafactura;
    }

    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    public Set getArticuloses() {
        return this.articuloses;
    }

    public void setArticuloses(Set articuloses) {
        this.articuloses = articuloses;
    }

    //Métodos generados por mí
    //Esclavo
    public void addArticulo(Articulos articulo){
        this.getArticuloses().add(articulo);
        articulo.addFactura(this);
    }
    
    public void removeArticulo(Articulos articulo){
        this.getArticuloses().remove(articulo);
        articulo.removeFactura(this);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.numfactura);
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
        final Facturas other = (Facturas) obj;
        if (!Objects.equals(this.numfactura, other.numfactura)) {
            return false;
        }
        return true;
    }
    //--------------------------------------------------------------------------s
}
