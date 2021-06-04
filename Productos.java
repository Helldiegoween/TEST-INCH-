import java.util.ArrayList;

public class Productos {
    public String nombre;
    public String precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Productos(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
        ;
    }
}
