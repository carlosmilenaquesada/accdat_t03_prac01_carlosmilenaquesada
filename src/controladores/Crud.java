package controladores;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Crud {

    /*
    
    //Critera vs HQL
SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        
        //SON DOS FORMAS DE CONSULTAR LOS REGISTROS DE UNA TABLA, CON CONDICIONES, ORDEN, ETCL.
        //ES DECIR, OBTENER UNA OLEECIÓN DE OBJTOS DE UNA TABLA. EL HQL TAMBIÉN PUEDE IMPLEMENTAR
        //EL JOIN. EN CRITERIA LA CLASE OBTENIDA SIEMPRE ES UNA, EN HQL PODEMOS OBTNERE DIFERENTES
        //CAMPOS DE CADA UNA DE LAS TABLAS DE UNA CONSULTA.
        //Criteria  -> SELECT * FROM UnaTabla WHERE ... ORDER...
        //HQL       -> SELECT * FROM UnaTabla WHERE ... ORDER...
        //HQL       -> SELECT * FROM UnaTabla JOIN OtraTabla
        //HQL teiene método prepareStatement, pero pepe no lo pide
        try {
            //ejemplo criteria.
            Criteria c = ss.createCriteria(Clientes.class)//equivalente a select * from clientes.
                    .addOrder(Order.asc("nombreclientes"));//restricciónes aplicadas al criteria (en este caso, un order)
            List<Clientes> lista = c.list();
            for (Clientes cli : lista) {
                System.out.println(cli);
            }

            //ejemplo de HQL
            Query q = ss.createQuery("from Clientes c order by c.nombreclientes");//equivalente a select * from clieentes order by nombre cliente (igual sentencia que la que hemos hecho el criteria).(no olvidar el alias)
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

        //LOS DELETE, INSERT y UPDATE SE HACEN DESDE EL SESSIÓN
    }
     */
    private SessionFactory sf = NewHibernateUtil.getSessionFactory();
    private Session ss = null;
    private Transaction tx = null;
    private Query q = null;
    private Criteria c = null;

    public Crud() {
    }

    private void iniciarOperacion() throws HibernateException {
        ss = sf.openSession();
        tx = ss.beginTransaction();
    }

    private void cerrarOperacion() {
        if (ss != null && ss.isOpen()) {
            ss.close();
        }
    }

    /**
     * CREATE
     */
    public String create(Serializable s) {
        String error = "";
        try {
            iniciarOperacion();
            ss.save(s);
            tx.commit();
        } catch (HibernateException e) {
            error = e.getCause().getMessage();
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
        return error;
    }

    /**
     * CREATE O UPDATE
     */
    public void createOUpdate(Serializable s) {
        try {
            iniciarOperacion();
            ss.saveOrUpdate(s);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
    }

    /**
     * READ
     */
    public Object read(Class c, Serializable pk) {
        Object o = null;
        try {
            ss = sf.openSession();
            o = ss.get(c, pk);
        } catch (HibernateException e) {

        } finally {
            cerrarOperacion();
        }
        return o;
    }

    /**
     * READALL usando HQL Query
     */
    public List readAllHQL(String from) {
        List lista = null;//comporbar si devuelve null o vacío en caso de qeu no haya registros
        try {
            ss = sf.openSession();
            q = ss.createQuery(from);
            lista = q.list();
        } catch (HibernateException e) {

        } finally {
            cerrarOperacion();
        }
        return lista;
    }

    /**
     * READ Max() de un campo de una clase usando Criteria
     */
    public Object readMaxValueCRITERIA(Class clase, String campo) {
        ss = sf.openSession();
        c = ss.createCriteria(clase).setProjection(Projections.max(campo));
        return c.uniqueResult();
    }

    /**
     * READALL usando Criteria
     */
    public List readAllCRITERIA(Class clase) {
        List lista = null;//comporbar si devuelve null o vacío en caso de qeu no haya registros
        try {
            ss = sf.openSession();
            c = ss.createCriteria(clase);
            lista = c.list();
        } catch (HibernateException e) {

        } finally {
            cerrarOperacion();
        }
        return lista;
    }

    /**
     * UPDATE
     */
    public void update(Serializable s) {
        try {
            iniciarOperacion();
            ss.update(s);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
    }

    /**
     * DELETE
     */
    public String delete(Serializable s) {
        String error = "";
        try {
            iniciarOperacion();
            ss.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            error = e.getCause().getMessage();
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
        return error;
    }

}
