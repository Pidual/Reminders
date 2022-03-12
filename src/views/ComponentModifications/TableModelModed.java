package views.ComponentModifications;

import javax.swing.table.DefaultTableModel;

public class TableModelModed extends DefaultTableModel {

    private String[] titulos;
    private Object[][] datos;


    public TableModelModed(String[] titulos, Object[][] datos) {
        this.titulos = titulos;
        this.datos = datos;
        setDataVector(datos,titulos);
    }



}
