
package proyecto_curso;

import java.util.ArrayList;


public class Curso 
{
  String NombreCurso;
  int id;
  ArrayList<Alumno> a=new ArrayList<Alumno>();

    public Curso() {
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Alumno> getA() {
        return a;
    }

    public void setA(ArrayList<Alumno> a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Curso{" + "NombreCurso=" + NombreCurso + ", id=" + id + ", a=" + a + '}';
    }
    
    
    
    
}
