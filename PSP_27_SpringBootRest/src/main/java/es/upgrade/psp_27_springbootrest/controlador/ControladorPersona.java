package es.upgrade.psp_27_springbootrest.controlador;

import es.upgrade.psp_27_springbootrest.modelo.entidad.Persona;
import es.upgrade.psp_27_springbootrest.modelo.persistencia.DaoPersona;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de la entidad {@link Persona}.
 *
 * Esta clase expone los endpoints para realizar operaciones CRUD (crear, leer, actualizar)
 * sobre la entidad Persona a través de una API RESTful.
 *
 * Se utiliza el objeto {@link DaoPersona} para interactuar con la capa de persistencia.
 */
@RestController
public class ControladorPersona {

    /**
     * Inyección del DAO para operaciones de persistencia sobre la entidad Persona.
     */
    @Autowired
    private DaoPersona daoPersona;

    /**
     * Obtiene una persona según su identificador.
     *
     * @param id El identificador de la persona a obtener.
     * @return Un objeto {@link ResponseEntity} que contiene la persona encontrada y el estado HTTP 200,
     *         o HTTP 404 si no se encuentra la persona.
     */
    @GetMapping(path = "personas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> get(@PathVariable("id") int id) {
        Persona persona = daoPersona.get(id);
        if (persona == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    /**
     * Actualiza los datos de una persona existente.
     *
     * @param id El identificador de la persona que se actualizará.
     * @param persona El objeto {@link Persona} con los datos actualizados.
     * @return Un objeto {@link ResponseEntity} que contiene la persona actualizada
     *        y el estado HTTP 200, o HTTP 400 si no se pudo realizar la actualización.
     */
    @PostMapping(path = "personas/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> update(@PathVariable int id, @RequestBody Persona persona) {
        Persona p = daoPersona.update(id, persona);
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    /**
     * Crea una nueva persona.
     *
     * @param persona El objeto {@link Persona} que se desea crear.
     * @return Un objeto {@link ResponseEntity} que contiene la persona creada y el estado HTTP 201.
     */
    @PostMapping(path = "personas", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        daoPersona.add(persona);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }

    /**
     * Obtiene la lista completa de personas.
     *
     * @return Un objeto {@link ResponseEntity} que contiene la lista de personas y el estado HTTP 200,
     *         o HTTP 404 si no se encuentran personas.
     */
    @GetMapping(path = "personas/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> getAll() {
        List<Persona> lista = daoPersona.getAllPersonas();
        if (lista == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}