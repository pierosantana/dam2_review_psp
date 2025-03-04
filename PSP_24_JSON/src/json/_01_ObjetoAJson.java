package json;

import com.google.gson.Gson;
import entidad.Persona;

public class _01_ObjetoAJson {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setIdPersona(93);
        persona.setNombre("Piero");
        persona.setApellido("Santana");
        persona.setEdad(31);

        //Libreria de google -> GSON para convertir Objeto a JSON

        Gson gson = new Gson();
        String json = gson.toJson(persona);
        System.out.println(json);

    }


}
