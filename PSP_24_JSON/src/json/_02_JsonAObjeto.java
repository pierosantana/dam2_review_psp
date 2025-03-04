package json;

import com.google.gson.Gson;
import entidad.Persona;

public class _02_JsonAObjeto {
    public static void main(String[] args) {
        String personaJson = "{'idPersona':93,'nombre':'Piero','apellido':'Santana','edad':31}";

        Gson gson = new Gson();
        Persona persona = gson.fromJson(personaJson, Persona.class);
        System.out.println(persona);
    }
}
