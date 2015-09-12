package unicauca.movil.peliculas.models;

/**
 * Created by Dario Chamorro on 11/09/2015.
 */
public class Pelicula {

    String nombre;

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public Pelicula() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
