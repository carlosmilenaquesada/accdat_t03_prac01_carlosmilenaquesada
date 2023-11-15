package vistas;

import controladores.NewHibernateUtil;
import modelos.Familias;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NewClass {
    public static void main(String[] args){
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        System.out.println(ss.get(Familias.class, "1234"));
        ss.close();
        System.exit(0);
    }
}
