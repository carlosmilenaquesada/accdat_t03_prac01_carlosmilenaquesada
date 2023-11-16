package controladores;

import javax.swing.JComponent;
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

}
