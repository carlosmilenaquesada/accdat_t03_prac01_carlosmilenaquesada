package controladores;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

public class Herramientas {

    public static void limpiarTabla(DefaultTableModel tableModel) {
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    public static void habilitarComponentes(JComponent[] componentes) {
        for (JComponent jc : componentes) {
            jc.setEnabled(true);
        }
    }

    public static void deshabilitarComponentes(JComponent[] componentes) {
        for (JComponent jc : componentes) {
            jc.setEnabled(false);
        }
    }

    public static Rectangle bondsDeDialogs(Component padre, JDialog jDialog) {
        return new Rectangle(padre.getX() + 10, padre.getY() + 10, jDialog.getWidth(), jDialog.getHeight());
    }
    
    public static List actualizarList(Class c) {
        return new Crud().readAll("from " + c.getName());
    }

}
