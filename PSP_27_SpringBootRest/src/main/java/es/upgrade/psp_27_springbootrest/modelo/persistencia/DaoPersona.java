package es.upgrade.psp_27_springbootrest.modelo.persistencia;

import es.upgrade.psp_27_springbootrest.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO para la entidad {@link Persona}.
 *
 * Esta clase simula una capa de persistencia utilizando una lista en memoria.
 * Proporciona métodos para agregar, actualizar, eliminar y buscar objetos de tipo {@link Persona}.
 */
@Component
public class DaoPersona {

    /**
     * Lista que actúa como almacenamiento en memoria para los objetos {@link Persona}.
     */
    public List<Persona> listaPersonas;

    /**
     * Contador utilizado para asignar identificadores únicos a cada nueva {@link Persona}.
     */
    public int id;

    /**
     * Constructor que inicializa la lista de personas y añade tres objetos {@link Persona} por defecto.
     */
    public DaoPersona() {
        listaPersonas = new ArrayList<>();
        Persona persona = new Persona(id++,"Piero","Santana",31);
        Persona persona2 = new Persona(id++,"Oscar","Armando",31);
        Persona persona3 = new Persona(id++,"Daniel","Costas",29);

        listaPersonas.add(persona);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
    }

    /**
     * Obtiene la persona correspondiente al identificador proporcionado.
     *
     * @param id El identificador de la persona a obtener.
     * @return El objeto {@link Persona} si el identificador es válido; en caso contrario, devuelve null.
     */
    public Persona get(int id) {
        if( id < 0 || id >= listaPersonas.size()) return null;
        return listaPersonas.get(id);
    }

    /**
     * Retorna la lista completa de personas.
     *
     * @return La lista de {@link Persona} almacenadas.
     */
    public List<Persona> getPersonas() {
        return listaPersonas;
    }

    /**
     * Agrega una nueva persona a la lista.
     *
     * Se asigna automáticamente un identificador único a la persona.
     *
     * @param persona El objeto {@link Persona} a agregar.
     */
    public void add(Persona persona) {
        persona.setId(id++);
        listaPersonas.add(persona);
    }

    /**
     * Elimina la persona correspondiente al identificador proporcionado.
     *
     * @param id El identificador de la persona a eliminar.
     * @return El objeto {@link Persona} eliminado, o null si el identificador no es válido.
     */
    public Persona remove(int id) {
        if(id < 0 || id >= listaPersonas.size()) return null;
        return listaPersonas.remove(id);
    }

    /**
     * Actualiza la información de la persona correspondiente al identificador proporcionado.
     *
     * @param id El identificador de la persona a actualizar.
     * @param persona El objeto {@link Persona} con los nuevos datos.
     * @return La persona actualizada, o null si el identificador es inválido.
     */
    public Persona update(int id, Persona persona) {
        if(id < 0 || id >= listaPersonas.size()) return null;

        listaPersonas.set(id, persona);
        return listaPersonas.get(id);
    }

    /**
     * Devuelve una lista de personas que coinciden con el nombre proporcionado.
     *
     * La búsqueda se realiza ignorando mayúsculas y minúsculas.
     *
     * @param nombre El nombre utilizado como criterio de búsqueda.
     * @return Una lista de {@link Persona} con el nombre indicado, o null si el nombre es nulo o vacío.
     */
    public List<Persona> ListByNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()) return null;
        List<Persona> personasAux = new ArrayList<>();
        for(Persona persona : listaPersonas) {
            if(persona.getNombre().equalsIgnoreCase(nombre)) personasAux.add(persona);
        }
        return personasAux;
    }

    /**
     * Retorna todas las personas almacenadas.
     *
     * @return La lista completa de {@link Persona}, o null si no hay ninguna persona almacenada.
     */
    public List<Persona> getAllPersonas() {
        if(listaPersonas.size() == 0) return null;
        return listaPersonas;
    }
}