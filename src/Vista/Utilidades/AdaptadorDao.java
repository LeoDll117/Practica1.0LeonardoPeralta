package Vista.Utilidades;

/**
 *
 * @author Leonardo 117
 */

import Modelo.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdaptadorDao {

    public static String DIRCARPDATA = "DatosJson";

    public static boolean guardarArchivo(Persona[] empleados) {
        try {
            File archivo = new File(DIRCARPDATA + File.separatorChar + "Empleados.dat");
            FileOutputStream salida = new FileOutputStream(archivo);
            ObjectOutputStream ous = new ObjectOutputStream(salida);
            ous.writeObject(empleados);
            ous.flush();
            ous.close();
            salida.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static Persona[] cargarArchivo() {
        Persona[] personas = null;
        try {
            File archivo = new File(DIRCARPDATA + File.separatorChar + "Empleados.dat");
            FileInputStream entrada = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(entrada);
            personas = (Persona[]) ois.readObject();
            ois.close();
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return personas;
    }

    public static boolean guardarJson(Persona[] persons) {
        try {
            FileWriter archivo = new FileWriter(DIRCARPDATA + File.separatorChar + "Empleados.json");
            Gson arreglo = new GsonBuilder().setPrettyPrinting().create();
            archivo.write(arreglo.toJson(persons));
            archivo.flush();
            archivo.close();
            System.out.println(arreglo.toJson(persons));
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    public static Persona [] cargarJson() {
        Persona[] empleado = null;
        try {
            FileReader archivo = new FileReader(DIRCARPDATA + File.separatorChar + "Empleados.json");
            empleado = new GsonBuilder().create().fromJson(archivo, Persona[].class);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return empleado;
    }
}
