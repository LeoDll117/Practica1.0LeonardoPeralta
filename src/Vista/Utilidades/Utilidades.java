
package Vista.Utilidades;

import Controlador.ControlPersona;
import Modelo.Persona;
import Modelo.TipoEmpleado;
import javax.swing.JComboBox;

/**
 *
 * @author Leonardo 117
 */
public class Utilidades {
    
    public static JComboBox cargarComboTipo(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoEmpleado tipo : TipoEmpleado.values()) {
            cbx.addItem(tipo);
        }
        return cbx;
    }
    public static TipoEmpleado getTipoCombo(JComboBox cbx) {
        return (TipoEmpleado) cbx.getSelectedItem();
    }
    
    public static Persona getPersonaCombo(JComboBox cbx){
        return(Persona) cbx.getSelectedItem();
    }
    
    public static JComboBox cargarComboEmpleado(JComboBox cbx, ControlPersona cp){
        cbx.removeAllItems();
        for (int i =0;i < cp.getPersonas().length; i++){
            cbx.addItem(cp.getPersonas()[i].getNombre());
        }
        return cbx;
    }
}
