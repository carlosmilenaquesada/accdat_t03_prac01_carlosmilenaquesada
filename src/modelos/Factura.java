package modelos;
// Generated 18-nov-2023 1:53:26 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura implements java.io.Serializable {

    private BigDecimal numFactura;
    private Cliente cliente;
    private Date fechaFactura;
    private Set listaArticulos = new HashSet(0);

    public Factura() {
    }

    public Factura(BigDecimal numFactura) {
        this.numFactura = numFactura;
    }

    public Factura(BigDecimal numFactura, Cliente cliente, Date fechaFactura, Set listaArticulos) {
        this.numFactura = numFactura;
        this.cliente = cliente;
        this.fechaFactura = fechaFactura;
        this.listaArticulos = listaArticulos;
    }

    public Factura(BigDecimal numFactura, Date fechaFactura) {
        this.numFactura = numFactura;
        this.fechaFactura = fechaFactura;
    }

    public Factura(BigDecimal numFactura, Cliente cliente, Date fechaFactura) {
        this.numFactura = numFactura;
        this.cliente = cliente;
        this.fechaFactura = fechaFactura;
    }

    public BigDecimal getNumFactura() {
        return this.numFactura;
    }

    public void setNumFactura(BigDecimal numFactura) {
        this.numFactura = numFactura;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaFactura() {
        return this.fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Set getListaArticulos() {
        return this.listaArticulos;
    }

    public void setListaArticulos(Set listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    //Funciones creadas por mí
    //Función de añadir un artículo al set de artículos de una factura (factura es el slave, artículos el el master).
    public void addArticulo(Articulo articulo) {
        this.getListaArticulos().add(articulo);
        articulo.addFactura(this);
    }

    public void replaceArticulo(Articulo oldArticulo, Articulo newArticulo) {
        this.getListaArticulos().remove(oldArticulo);
        oldArticulo.getListaFacturas().remove(this);
        this.addArticulo(newArticulo);
    }

    public void removeArticulo(Articulo articulo) {
        this.getListaArticulos().remove(articulo);
        articulo.getListaFacturas().remove(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numFactura);
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
        final Factura other = (Factura) obj;
        if (!Objects.equals(this.numFactura, other.numFactura)) {
            return false;
        }
        return true;
    }

}
