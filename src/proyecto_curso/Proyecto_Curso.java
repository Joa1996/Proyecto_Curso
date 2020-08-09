/*
 Crear un sistema en la cual  un Profesor,puede tener  uno o varios  Cursos y este curso a su vez puede tener muchos alumnos
 Poder saber el promedio de cada curso
 */
package proyecto_curso;
 /*
   * @author joaquin
 */


import java.util.*;

import java.util.ArrayList;
import proyecto_curso.BD.ConexionMySQL;

public class Proyecto_Curso {

    
    public static void main(String[] args) 
    {
         Scanner sc=new Scanner(System.in);
         
    
   
   
        ArrayList<Profesor> p=new ArrayList<Profesor>(); //Creamos este array para almacenar una cant. x de objetos Profesor
        System.out.println("Ingrese La cantidad de Profesores a cargar ");
        int cc=sc.nextInt();
        
        for(int i=0;i<cc;i++)
        {
            Profesor pr=new Profesor();//Creamos un objt. Profesor para pasarle parametros
            System.out.println("Ingrese el Nombre del profesor");
            pr.setNombre(sc.next());
            System.out.println("Ingrese el Apellido del Profesor");
            pr.setApellido(sc.next());
            System.out.println("Ingrese el DNI");
            pr.setDni(sc.nextInt());
             
             ArrayList<Curso> curso=new ArrayList<Curso>(); //Creamos este ArrayList provisorio para poder pasarle Objetos Curso a Profesor
             System.out.println("Ingrese la Cantidad de Cursos del Profesor");
             int ss=sc.nextInt();
             for(int t=0;t<ss;t++)
             {
                Curso c=new Curso();
                System.out.println("Ingrese el Nombre del Curso");
                c.setNombreCurso(sc.next());
                System.out.println("Ingrese el ID del Curso");
                c.setId(sc.nextInt());
                
                
                  System.out.println("Ingrese la cantidad de Alumnos de este Curso");
                  int tt=sc.nextInt();
                  ArrayList<Alumno> alum=new ArrayList<Alumno>();//Hacemos lo mismo con este arraylist como hicimos con los cursos
                  for(int m=0;m<tt;m++)
                  {    
                     
                      Alumno a=new Alumno();
                      System.out.println("Ingrese el Nombre del Alumno");
                      a.setNombre(sc.next());
                      System.out.println("Ingrese el Apellido del Alumno");
                      a.setApellido(sc.next());
                      System.out.println("Ingrese el DNI del Alumno");
                      a.setDni(sc.nextInt());
                      System.out.println("Ingrese la Calificacion del Alumno");
                      a.setCalificacion(sc.nextDouble());
                      
                      
                      
                      alum.add(a);//Cargamos en el arraylist provisorio el objeto a
                      c.setA(alum);//Pasamos este valor provisorio a la lista alumnos que tenemos en la clase Curso
                      a=null;
                      
                  }
            
             curso.add(c);
            
             pr.setC(curso);
             c=null;  
             }
         p.add(pr);
         pr=null;
        }
          //Imprimimos x consola
   for(Profesor aux:p)
   {
       System.out.println(aux);
   }

   //Cargamos los datos en una DB Mysql
   ConexionMySQL c=new ConexionMySQL();  
           c.conectarBaseDeDatos();//Iniciamos conexion c/la BD
          
           for(Profesor aux:p)
                 {
                  try
           {
            c.sentencia.execute("insert  into  Profesor(Nombre,Apellido,DNI)  values ('"+aux.Nombre+"','"+aux.Apellido+"',"+aux.Dni+")"); 
           }
           catch (Exception e){} 
      
                 }
      //cargamos a la Bd lo datos de Curso  
        for(int g=0;g<p.size();g++)
        {
            for(int t=0;t<p.get(g).getC().size();t++)
            {
              try
           {

   c.sentencia.execute("insert  into  Curso(Nombre,Id) values ('"+p.get(g).getC().get(t).NombreCurso +"',"+ p.get(g).getC().get(t).id+")");           
           
           }
           catch (Exception e){}   
                
                
            }
        }
        
           
  //Para pasar los elementos del ArrayList Alumno, primero debemos recorrer c/un for los Arraylist anteriores que contienen a este ArayList
      for(int mo=0;mo<p.size();mo++)//En la primera iteracion tendra almacenado un arraylist Curso
      {
          
          for(int ma=0;ma<p.get(mo).getC().size();ma++)//Dentro de la iteracion anterior se recorre esta Arraylist
          {
              
              for(int me=0;me<p.get(mo).getC().get(ma).getA().size();me++)//Finalmente llegamos al Arraylist deseado, pero como vemos para poder recorrerlo debemos primero recorrer los arraylist que lo contienen
              {
            try
           {

             c.sentencia.execute("insert  into  Alumno(Nombre,Apellido,Dni,Calificacion)  values ('"+ p.get(mo).getC().get(ma).getA().get(me).Nombre+"','"+ p.get(mo).getC().get(ma).getA().get(me).Apellido+"',"+ p.get(mo).getC().get(ma).getA().get(me).dni+","+ p.get(mo).getC().get(ma).getA().get(me).calificacion+")");           
           
           }
           catch (Exception e){}   
              }
              
          }
     
      }
              
  // c.sentencia.executeQuery(null)
     //c.resultado.getString(null)
            
     
          
      }
            
   
    } 
 
   
      

