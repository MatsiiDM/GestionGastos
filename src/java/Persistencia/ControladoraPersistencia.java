package Persistencia;

import Logica.Persona;
import Persistencia.exceptions.NonexistentEntityException;
import com.sun.istack.internal.logging.Logger;
import java.util.List;
import sun.util.logging.PlatformLogger;

public class ControladoraPersistencia {
    
    PersonaJpaController perJPA = new PersonaJpaController();
    
    
    //Creo una nueva persona para la base de datos
    public void crearPersona(Persona per){
        perJPA.create(per);
    }
    
    //Obtengo las personas que estan en la base de datos
    public List<Persona> getPersonas(){
        List <Persona> listaPersonas;
        listaPersonas = perJPA.findPersonaEntities();
        return listaPersonas;
        
    }
    //Borra un usuario
    public void borrarPersona(long dni) throws NonexistentEntityException {
        try {
            perJPA.destroy(dni);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex));
        }
    }
}
