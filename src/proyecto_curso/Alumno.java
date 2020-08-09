
package proyecto_curso;

public class Alumno 
{
    String Nombre;
    String Apellido;
    int dni;
    double calificacion;

    public Alumno() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Alumno{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", dni=" + dni + ", calificacion=" + calificacion + '}';
    }
    
    
    
    
    
}
