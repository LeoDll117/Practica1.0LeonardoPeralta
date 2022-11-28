
package Practica1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Leonardo 117
 */
public class main {
    public static void main(String args[]){
         
        
        try{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_inicio = formato.parse("01/11/2022");
        Date fecha_ultima = formato.parse("25/11/2022");
        Date fechaNow = new Date();
         long tiempoTR = fecha_ultima.getTime() - fecha_inicio.getTime();
         
            TimeUnit unidad = TimeUnit.DAYS;
            long dias = unidad.convert(tiempoTR, TimeUnit.MILLISECONDS);
            
            System.out.println(">> "+dias);
            System.out.println(fechaNow);
            System.out.println(formato.format(fechaNow));
        }catch(Exception e){
            System.out.println("Error >:c");
        }
    }
}
