import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    private  String codigo;
    private String nombre;

    private ArrayList<Estudiante> listaEstudiantes;


    //Un metodo static es el que se puede usar sin tener que instanciar la clase, basicamente termina siendo una variable global
    private static int index = 1;

    public Curso(String codigo, String nombre){
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Scanner objScan){
        objScan.nextLine();
        System.out.println("Ingrese el nombre del nuevo estudiante");
        String nombre = objScan.nextLine();

        System.out.println("Ingrese el Email del nuevo estudiante");
        String email = objScan.next();

        Estudiante objEstudiante = new Estudiante(index, nombre, email);
        index++;

        this.listaEstudiantes.add(objEstudiante);
        System.out.println("Estudiante agregado correctamente");

    }

    public void listarEstudiantes(){
        if (this.listaEstudiantes.isEmpty()){
            System.out.println("No hay estudiantes en el curso".concat(this.nombre));

        }else {

            System.out.println("Lista de estudiantes del curso".concat(this.nombre));

            for (Estudiante temporal : this.listaEstudiantes){
                System.out.println(temporal.toString());
            }

        }
    }

    public void eliminarEstudiante(Scanner objScan){
        this.listarEstudiantes();

        System.out.println("Ingrese el Id del estudiante a eliminar");
        int idEliminar = objScan.nextInt();

        //Elminamos el estudiante si su ID coincide con el id que se desea eliminar
        boolean eliminado = this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == idEliminar);

        System.out.println(!eliminado
                ? "No se pudo eliminar el estudiante"
                : "Estudiante eliminado correctamente");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }
}
