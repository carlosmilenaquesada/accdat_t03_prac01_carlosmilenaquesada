package controladores;

import java.awt.Component;
import java.awt.Rectangle;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static DecimalFormat dfNumEntero = new DecimalFormat("0");

    public static BigDecimal stringABigDecimalNumEntero(String numero) throws ParseException {
        return BigDecimal.valueOf(dfNumEntero.parse(numero).longValue());
    }

    public static DecimalFormat dfPrecio = new DecimalFormat("0.00");

    public static BigDecimal stringABigDecimalPrecio(String precio) throws ParseException {
        return BigDecimal.valueOf(dfPrecio.parse(precio).doubleValue());
    }

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

}
