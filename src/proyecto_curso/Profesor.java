
package proyecto_curso;

import java.util.ArrayList;


public class Profesor 
{

   String Nombre;
   String Apellido;
   int Dni;
   ArrayList<Curso> c=new ArrayList<Curso>();

    public Profesor() {
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
        return Dni;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
    }

    public ArrayList<Curso> getC() {
        return c;
    }

    public void setC(ArrayList<Curso> c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Profesor{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Dni=" + Dni + ", c=" + c + '}';
    }
    
    
    
    
}
