package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entidad.Persona;

import java.io.*;
import java.util.List;

public class _04_JsonFicheroALista {
    public static void main(String[] args) {

        File file = new File("personas.json");

        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)) {
            String linea = br.readLine();
            Gson gson = new Gson();
            List<Persona> personas = gson.fromJson(linea, new TypeToken<List<Persona>>(){}.getType());

                System.out.println(personas.get(0));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
