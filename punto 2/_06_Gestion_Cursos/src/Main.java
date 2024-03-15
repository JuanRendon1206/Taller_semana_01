import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Instancias
        Scanner objScan = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;

        do{
            System.out.println("""
                    MENU DE OPCIONES
                    1. Administrar Estudiantes.
                    2. Administrar Cursos.
                    3. Salir.
                    
                    Ingrese una opcion: 
                    """);
            option = objScan.nextInt();

            switch (option){

                case 1:
                    int option3 = 0;
                    do{
                        System.out.println("""
                                MENU DE ESTUDIANTES
                                1. Agregar estudiante a un curso
                                2. Listar todos los estudiantes de un curso
                                3. Eliminar estudiante de un curso
                                4. Salir
                                
                                Ingrese una opcion: 
                                """);
                        option3 = objScan.nextInt();
                        switch (option3){
                            case 1:
                                objGestion.listarTodosLosCursos();
                                System.out.println("Ingresa el codigo del curso donde ingresaras el nuevo estudiante");
                                String codigo = objScan.next();

                                Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);

                                if (objCurso == null){
                                    System.out.println("El codigo ingresado no es valido");
                                }else {
                                    objCurso.agregarEstudiante(objScan);
                                }

                                break;

                            case 2:

                                objGestion.listarTodosLosCursos();
                                System.out.println("Ingresa el codigo del curso donde ingresaras el nuevo estudiante");
                                codigo = objScan.next();

                                objCurso = objGestion.buscarCursoPorCodigo(codigo);

                                if (objCurso == null){
                                    System.out.println("El código ingresado no es valido");
                                }else {
                                    objCurso.listarEstudiantes();
                                }

                                break;

                            case 3: //Eliminar estudiantes a un curso en especifico
                                //1. listar los cursos
                                objGestion.listarTodosLosCursos();

                                //2.preguntar el codigo del curso
                                System.out.println("Ingresa el codigo del curso donde deseas eliminar el estudiante");
                                codigo = objScan.next();

                                //3. buscar el curso que tenga ese codigo
                                Curso objcurso = objGestion.buscarCursoPorCodigo(codigo);
                                if (objcurso == null){
                                    System.out.println("El codigo ingresado no coincide con ningun curso");
                                }else{
                                    //4. Eliminar el estudiante del curso encontrado
                                    objcurso.eliminarEstudiante(objScan);
                                    System.out.println("Eliminado correctamente");
                                }


                                break;
                        }

                    }while (option3 != 4);
                    break;


                case 2:
                    int option2 = 0;
                    do {
                        System.out.println("""
                                MENU DE CURSOS
                                1. Agregar Curso.
                                2. Listar Cursos.
                                3. Buscar por Codigo.
                                4. Salir
                                                                
                                Ingrese una opcion: 
                                """);
                        option2 = objScan.nextInt();

                        switch (option2){
                            case 1:
                                objGestion.agregarCurso(objScan);
                                break;
                            case 2:
                                objGestion.listarTodosLosCursos();
                                break;
                            case 3:
                                System.out.println("Ingresa el codigo del curso a buscar: ");
                                String codigo = objScan.next();

                                Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);

                                if (objCurso == null) {
                                    System.out.println("No existe ningun curso con este codigo");
                                }else {
                                    System.out.println(objCurso.toString());
                                }
                                break;
                        }

                    }while (option2 != 4);

                    break;
            }
        }while (option != 3);
    }
}