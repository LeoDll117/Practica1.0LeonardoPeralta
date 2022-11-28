
package Vista.ModeloTabla;

import Modelo.Persona;
import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Leonardo 117
 */
public class TablaEmpleado  extends AbstractTableModel{
    
    SimpleDateFormat  f = new SimpleDateFormat("dd/MM/yyy");
    
    private Persona person[];
    
    public Persona[] getPersona(){
        return person;
    }
    
    public void setPersona(Persona[] person){
        this.person = person;
    }
    @Override
    public int getRowCount(){
        return person.length;
    }
    @Override
    public int getColumnCount(){
        return 7;
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Designacion";
            case 4:
                return "Bono";
            case 5:
                return "sueldo";
            case 6:
                return "Tiempo";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int filas, int columnas) {
        Persona E = person[filas];
        switch (columnas){
            case 0:
                return (filas +1);
            case 1:
                return (E != null) ? E.getNombre(): "Sin Definir";
            case 2: 
                return (E != null) ? E.getApellido(): "Sin Definir";
            case 3:
                return (E != null) ? E.getTipoEmpleado() : "Sin definir";
            case 4: 
                return (E != null) ? E.getBono()+"%" : "0";
            case 5:
                return (E != null) ? E.getSueldo()+"$$" : "00.00";
            case 6:
                return (E != null) ? E.getTiempoEmpleo()+" dias": "Sin Definir";
            default:
                return null;
        }
    }
}
