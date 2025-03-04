package json;

import com.google.gson.Gson;
import entidad.Persona;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _03_ListaAJsonFichero {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setIdPersona(93);
        persona.setNombre("Piero");
        persona.setApellido("Santana");
        persona.setEdad(31);

        Persona persona2 = new Persona();
        persona2.setIdPersona(94);
        persona2.setNombre("Piero A");
        persona2.setApellido("Santana L");
        persona2.setEdad(32);

        Persona persona3 = new Persona();
        persona2.setIdPersona(95);
        persona2.setNombre("Piero Au");
        persona2.setApellido("Santana La");
        persona2.setEdad(33);

        List<Persona> personas = new ArrayList<>();
        personas.add(persona);
        personas.add(persona2);
        personas.add(persona3);

        Gson gson = new Gson();
        String json = gson.toJson(personas);

        File file = new File("personas.json");

        try(FileWriter fw = new FileWriter(file)){
            fw.write(json);
            System.out.println("Fichero creado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
