package controladores;


import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Crud {

    private SessionFactory sf = NewHibernateUtil.getSessionFactory();
    private Session ss = null;
    private Transaction tx = null;

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
    public void create(Serializable s) {
        try {
            iniciarOperacion();
            ss.save(s);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
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
    public void read(Class c, Serializable pk) {
        try {
            iniciarOperacion();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
    }

    /**
     * READALL.
     * Si la clase consultada en el "from" contiene una colección de otra 
     * clase (set), dará excepción si el atributo del set "lazy" es true.
     */
    public List readAll(String from) {
        List coleccion = null;
        try {
            iniciarOperacion();
            coleccion = ss.createQuery(from).list();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
        return coleccion;
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
    public void delete(Serializable s) {
        try {
            iniciarOperacion();
            ss.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
    }
}
