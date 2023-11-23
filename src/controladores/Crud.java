package controladores;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Crud {

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
    //Ya que es requisito fundamental que las clases POJO que representan las
    //entidades de la base de datos implementen Serializable, me voy a apoyar
    //en esa misma interfaz para pedir los parámetros en las funciones.

    //CREATE, UPDATE, DELETE----------------------------------------------------
    /**
     * CREATE
     *
     * @param s El objeto que se pretende crear en la BD. Debe implementar
     * Serializable.
     * @return Un {@code String} que será vacío si todo ha ido bien (isEmpty ==
     * true). En caso contrario, devuelve un {@code String} con el texto "Error
     * al crear + [nombre de la clase] + [toString del objeto que se intentó
     * crear]".
     */
    public String create(Serializable s) {//OK
        String error = "";
        try {
            iniciarOperacion();
            ss.save(s);
            tx.commit();
        } catch (HibernateException e) {
            error = "Error al crear " + s.getClass() + " -> " + s.toString();
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
        return error;
    }

    /**
     * UPDATE
     *
     * @param s El objeto que se pretende actualizar en la BD. Debe implementar
     * Serializable.
     * @return Un {@code String} que será vacío si todo ha ido bien (isEmpty ==
     * true). En caso contrario, devuelve un {@code String} con el texto "Error
     * al actualizar + [nombre de la clase] + [toString del objeto que se
     * intentó actualizar]".
     */
    public String update(Serializable s) {
        String error = "";
        try {
            iniciarOperacion();
            ss.update(s);
            tx.commit();
        } catch (HibernateException e) {
            error = "Error al actualizar " + s.getClass() + " -> " + s.toString();
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
        return error;
    }

    /**
     * DELETE
     *
     * @param s El objeto que se pretende borrar de la BD. Debe implementar
     * Serializable.
     * @return Un {@code String} que será vacío si todo ha ido bien (isEmpty ==
     * true). En caso contrario, devuelve un {@code String} con el texto "Error
     * al eliminar + [nombre de la clase] + [toString del objeto que se intentó
     * borrar]".
     */
    public String delete(Serializable s) {
        String error = "";
        try {
            iniciarOperacion();
            ss.delete(s);
            tx.commit();
        } catch (HibernateException e) {
            error = "Error al eliminar " + s.getClass() + " -> " + s.toString();
            tx.rollback();
        } finally {
            cerrarOperacion();
        }
        return error;
    }

    //Lecturas -----------------------------------------------------------------
    /**
     * READ
     *
     * @param c La clase sobre la que se realiza la lectura.
     * @param pk La clave primaria del objeto que se pretende leer.
     * @return El objeto leído. En caso de no poder realizar la lectura, se
     * devuelve null.
     */
    public Object read(Class c, Serializable pk) {
        Object o;
        try {
            ss = sf.openSession();
            o = ss.get(c, pk);
        } catch (HibernateException e) {
            o = null;
        } finally {
            cerrarOperacion();
        }
        return o;
    }

    /**
     * READALL usando HQL Query
     *
     * @param from La sentencia HQL sobre la que se realizará la lectura,
     * haciendo referencia a la entidad de la base de datos (p.e: "from Familias
     * f").
     * @return Una lista {@code List} con todos los registros de la entidad
     * referida. En caso de no existir la entidad o haber sido imposible la
     * lectura, se devuelve null.
     */
    public List readAllHQL(String from) {
        List lista;
        try {
            ss = sf.openSession();
            q = ss.createQuery(from);
            lista = q.list();
        } catch (HibernateException e) {
            lista = null;
        } finally {
            cerrarOperacion();
        }
        return lista;
    }

    /**
     * READALL usando Criteria
     *
     * @param clase La clase sobre la que se realizará la lectura, haciendo
     * referencia a la entidad de la base de datos (p.e: Familias.class).
     * @return Una lista {@code List} con todos los registros de la entidad
     * referida. En caso de no existir la entidad o haber sido imposible la
     * lectura, se devuelve null.
     */
    public List readAllCRITERIA(Class clase) {
        List lista;
        try {
            ss = sf.openSession();
            c = ss.createCriteria(clase);
            lista = c.list();
        } catch (HibernateException e) {
            lista = null;
        } finally {
            cerrarOperacion();
        }
        return lista;
    }
}
