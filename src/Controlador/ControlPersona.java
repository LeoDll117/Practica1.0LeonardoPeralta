
package Controlador;

import Modelo.Persona;
import Modelo.TipoEmpleado;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Leonardo 117
 */
public class ControlPersona {
    
    public static String NCOMUN = "SIN DEFINIR";
    private Date fecha0 = new Date();
    private SimpleDateFormat formatt = new SimpleDateFormat();
    private Persona persona;
    private Persona [] person;
    
    private long sueldoBasico = 425;
    private long bonoSenior = 10;
    private long bonoVeterano = 20;
    
    private long sueldoSenior = sueldoBasico*bonoSenior/100; 
    private long sueldoVeterano = sueldoBasico*bonoVeterano/100;
    
    
    public ControlPersona(Integer nEmpleados){
        person = new Persona[nEmpleados];
        
        for(int i =0; i < nEmpleados; i++){
            Persona PR = new Persona();
            PR.setNombre(ControlPersona.NCOMUN);
            PR.setApellido(ControlPersona.NCOMUN);
            PR.setTipoEmpleado(TipoEmpleado.NO_DEFINIDO);
            PR.setFechaIngreso(fecha0);
            PR.setBono(00);
            PR.setSueldo(0);
//          
            person[i]=PR;
        }
    }
    public void CalculoEmpleado(long diasEmpleo, Persona PC, Integer poss){
        System.out.println("::> "+diasEmpleo);
        
        if(diasEmpleo < 1825 ){
            PC.setTipoEmpleado(TipoEmpleado.JUNIOR);
            PC.setBono(0);
            PC.setSueldo(sueldoBasico);          
        }
        if(diasEmpleo > 1825 && diasEmpleo < 5475){
            PC.setTipoEmpleado(TipoEmpleado.SENIOR);
            PC.setBono(bonoSenior);
            PC.setSueldo(sueldoSenior+sueldoBasico);
        }
        if(diasEmpleo > 5475){
            PC.setTipoEmpleado(TipoEmpleado.VETERANO);
            PC.setBono(bonoVeterano);
            PC.setSueldo(sueldoVeterano+sueldoBasico);
        }
    }
    
    public boolean modificarEmpleado( Persona PR, Integer pos)throws  Exception{
        getPersonas()[pos] = PR;
        return true;
    }
    
    public Persona getPersona(){
        if(persona == null){
            persona = new Persona(); 
        }
        return this.persona;
    }
    
    public void setPersona(Persona persona){
        this.persona = persona;
    }
    public Persona[] getPersonas() {
        return person;
    }

    public void setPersonas(Persona[] person) {
        this.person = person;
    }
    
}
