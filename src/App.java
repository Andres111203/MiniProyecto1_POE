import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        int opc;
        Gestionamiento_Cliente gest_Cliente = new Gestionamiento_Cliente();
        Scanner scanner = new Scanner(System.in);
    
        do
        {
            System.out.println("--------Menu de opciones--------");
            System.out.println("1. Ingredar Clientes");
            System.out.println("2. Insertar dinero ahorrado");
            System.out.println("3. Actualizar dinero ahorrado");
            System.out.println("4. Eliminar dinero ahorrado");
            System.out.println("5. Buscar cliente por nombre y ver ahorro");
            System.out.println("6. Listar todos los clientes");
            System.out.println("0. Salir del programa");

            System.out.println("\nSeleccione una oppcion: ");
            opc = scanner.nextInt();

            switch(opc)
            {
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

                case 6: gest_Cliente.listar_clientes();
                    
            }
        }
        while(opc != 0);
        scanner.close();
        

            
    
            
    
    
    
    
            
    }

}
