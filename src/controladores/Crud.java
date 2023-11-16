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
     * Devuelve una colección {@code List} de todos los registros de la clase
     * consultada.
     * @param from indica la clase a consultar. Debe respetar
     * el nombre exacto de la clase del modelo.
     * @return 
     * {@code null} - si la clase indicada en el {@code from} no existe.<br><br>
     * {@code List size 0} - si la clase existe, pero no contiene registros.<br><br>
     * {@code List size !0} - si la clase existe y contiene registros, crea un 
     * List de los registros. Si la clase consultada en el {@code from} mapea una
     * colección de otra clase (set), dará excepción al manipular los elementos
     * de la colección, si el atributo {@code lazy} del set es {@code true}.
     */
    public List readAll(String from) {
        List coleccion = null;
        try {
            ss = sf.openSession();
            coleccion = ss.createQuery(from).list();
        } catch (HibernateException e) {
            coleccion = null;
        } catch (Exception e) {
            coleccion = null;
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
