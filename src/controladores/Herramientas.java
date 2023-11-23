package controladores;

import java.awt.Component;
import java.awt.Rectangle;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

public class Herramientas {

    public static void limpiarTabla(DefaultTableModel tableModel) {
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    public static Rectangle bondsDeDialogs(Component padre, JDialog jDialog) {
        return new Rectangle(padre.getX() + 10, padre.getY() + 10, jDialog.getWidth(), jDialog.getHeight());
    }

    private static final DecimalFormat DECIMAL_FORMAT_PRECIO = new DecimalFormat("0.00");

    public static BigDecimal stringABigDecimalPrecio(String numeroEnTexto) throws ParseException {
        if (!numeroEnTexto.matches("^[0-9]+(?:\\.[0-9]{1,2})?$")) {
            throw new ParseException("", 0);
        }
        return BigDecimal.valueOf(DECIMAL_FORMAT_PRECIO.parse(numeroEnTexto).doubleValue());
    }

    private static final DecimalFormat DECIMAL_FORMAT_ENTERO = new DecimalFormat("0");

    public static BigDecimal stringABigDecimalEntero(String numeroEnTexto) throws ParseException {
        if (!numeroEnTexto.matches("^[0-9]+$")) {
            throw new ParseException("", 0);
        }
        return BigDecimal.valueOf(DECIMAL_FORMAT_ENTERO.parse(numeroEnTexto).longValue());
    }

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static String dateAStringFormateado(Date fecha) {
        return SIMPLE_DATE_FORMAT.format(fecha);
    }

    public static Date stringADateFormateado(String fecha) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(fecha);
    }

    public static String[] mensajes = new String[]{
        //FacturaJDialog
        //gestión de facturas
        "Debe proporcionar un número de factura.",//0
        "El número de factura proporcionado no tiene un formato válido.",//1
        "No se puede crear la factura porque ya existe una factura con ese código.",//2
        "El cliente proporcionado no existe.",//3
        "El fecha de factura proporcionada no tiene un formato válido.",//4
        "No se pudo crear la factura.\nDescripción del error:\n",//5
        "No existe una factura con el número proporcionado.",//6
        "No se pudo modificar la factura.\nDescripción del error:\n",//7
        "No se pudo borrar la factura.\nDescripción del error:\n",//8
        //gestión de líneas
        "Debe proporcionar un código de artículo y un número de factura.",//9
        "No existe un artículo con el código proporcionado.",//10
        "Ya existe una línea con ese mismo artículo para la factura proporcionada",//11
        "No se pudo crear la línea de factura.\nDescripción del error:\n",//12
        "No existe una línea con ese artículo para la factura proporcionada",//13
        "No se pudo borrar la línea de factura.\nDescripción del error:\n",//14
        "",//15
        "",//16
        "",//17
        "",//18
        "",//19
        "",//20
        "",//21
        "",//22
        "",//23
        "",//24
        "",//25
        "",//26
        "",//27
        "",//28
        "",//29
        "",//30
        "",//31
        "",//32
        "",//33
        "",//34
        "",//35
        "",//36
        "",//37
        "",//38
        "",//39
        "",//40
    };

}
