import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        int opc;
        Gestionamiento_Cliente gest_Cliente = new Gestionamiento_Cliente();
        Scanner scanner = new Scanner(System.in);
    
        do{
    
            System.out.println("------------ Menu de Opciones -----------");
            System.out.println("1. Ingresar Clientes");
            System.out.println("2. Insertar dinero ahorrado");
            System.out.println("3. Actualizar dinero ahorrado");
            System.out.println("4. Eliminar dinero ahorrado");
            System.out.println("5. Buscar cliente por nombre y ver su ahorro");
            System.out.println("6. Listar todos los clientes");
            System.out.println("7. Solicitar dinero prestado");
            System.out.println("8. Solicitar un CDT \n");


            System.out.println("ingrese la opcion que desea realizar");
            opc = scanner.nextInt(); //opcion que desea realizar el usuario
            
    
            switch(opc){

                case 0: 
                    System.out.println("Saliendo de la aplicacion.......");
                    return;
    
                case 1: gest_Cliente.insertarCliente(); 
                    break;
                        
                case 2: gest_Cliente.insertarDineroAhorrado();
                    break;
    
                case 3: gest_Cliente.actualizarDineroAhorrado();
                    break;
    
                case 4: gest_Cliente.eliminarDineroAhorrado();
                    break;
    
                case 5: gest_Cliente.buscarCliente_por_Nombre();
                    break;

                case 6: gest_Cliente.listarClientes();
                    break;

                case 7: gest_Cliente.solicitar_prestamo();
                    break;

                case 8: gest_Cliente.solicitar_Cdt();
                    break;

                default:
                    System.out.println("Opcion invalida dentro de la aplicacion.......");
                    break;
    
            }
    
        }while(opc != 0);
    }
}