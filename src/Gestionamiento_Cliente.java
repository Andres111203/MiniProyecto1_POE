import java.util.ArrayList;
import java.util.Scanner;

public class Gestionamiento_Cliente
{
    ArrayList <Cliente> listaClientes = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    Cliente cliente1;

    public void insertarCliente()
    {

        cliente1 = new Cliente();
        

        System.out.println("ingrese el nombre del cliente");
        String name = entrada.nextLine();
        cliente1.setNombre(name);

        System.out.println("ingrese el numero de cedula del cliente");
        String cc;
        boolean cedula_unica;
        do
        {
            cedula_unica = true;
            cc = entrada.nextLine();
            for (Cliente cliente : listaClientes)
            {
                if(cliente.getCedula().equals(cc))
                {
                    cedula_unica = false;
                    System.out.println("Esta cedula ya esta registrada...");
                    break;
                }
            }
            
        }
        while(!cedula_unica);
        cliente1.setCedula(cc);

        System.out.println("ingrese la fecha de creacion del cliente en formato DD-MM-AA");
        String fCreacion = entrada.nextLine();
        cliente1.setFecha_Creacion(fCreacion);

        System.out.println("ingrese el nivel de ingresos del cliente");
        double nivIngresos = entrada.nextDouble();
        cliente1.setNivel_Ingresos(nivIngresos);

        entrada.nextLine();
        listaClientes.add(cliente1);

    }

    public void insertarDineroAhorrado()
    {   

       System.out.println("Ingese la cedula del cliente quien va a ingresar dinero ahorrado");
       String CedulaAhorros = entrada.nextLine();
       Cliente AhorrosCliente = null;
       for(Cliente cliente : listaClientes)
       {
            if(cliente.getCedula().equals(CedulaAhorros))
            {
                AhorrosCliente = cliente;
            }
       }

       if (AhorrosCliente != null)
       {
            System.out.println("Ingrese los ahorros que va a ingresar: ");
            Double Ahorro = entrada.nextDouble();
            entrada.nextLine();
            AhorrosCliente.setDinero_Ahorrado(Ahorro);
            System.out.println("Dinero ingresado para el cliente: "+AhorrosCliente.getNombre());
       }
       else
       {
            System.out.println("Cliente no encontrado...");
       }
    }

    public void actualizarDineroAhorrado()
    {
        System.out.println("Ingrese la cedula del cliente cuyo monto sera actualizado: ");
        String CedulaCliente = entrada.nextLine();
        Cliente ClienteAActualizar = null;
        for(Cliente cliente : listaClientes)
        {
            if(cliente.getCedula().equalsIgnoreCase(CedulaCliente))
            {
                ClienteAActualizar = cliente;
                break;
            }
            
        }
        if (ClienteAActualizar != null)
        {
            System.out.println("Ingrese el nuevo monto: ");
            Double NuevoAhorro = entrada.nextDouble();
            entrada.nextLine();

            ClienteAActualizar.setDinero_Ahorrado(NuevoAhorro);
            System.out.println("Monto actualizado para el cliente "+ClienteAActualizar.getNombre());
        }
        else
        {
            System.out.println("Cliente no encontrado :c");
        }

    }

    public void eliminarDineroAhorrado()
    {
        System.out.println("Ingrese la cedula del cliente al cual se le borrara el monto ahorrado: ");
        String CedulaClienteErase = entrada.nextLine();
        Cliente ClienteAhorroBorrrar = null;
        for (Cliente cliente : listaClientes)
        {
            if (cliente.getCedula().equals(CedulaClienteErase))
            {
                ClienteAhorroBorrrar = cliente;
                break;
            }
        }
        if (ClienteAhorroBorrrar != null )
        {
            cliente1.setDinero_Ahorrado(0);
            System.out.println("El dinero ahorrado ha sido eliminado");
        }
        else
        {
            System.out.println("El cliente no ha sido encontrado :c");
        }
        
    }
    
    public void buscarCliente_por_Nombre()
    {

        System.out.println("ingrese el nombre del cliente  que desea buscar: ");
        String NombreBuscado = entrada.nextLine();
        Boolean NombreEncontrado = false;
        for (Cliente cliente : listaClientes)
        {
            if(cliente.getNombre().equalsIgnoreCase(NombreBuscado))
            {
                NombreEncontrado = true;
                System.out.println("---Cliente encontrado---");
                System.out.println("nombre: "+cliente.getNombre());
                System.out.println("Cedula: "+cliente.getCedula());
                System.out.println("Monto ahorrado: "+cliente.getDinero_Ahorrado());
                break;

            }
        }
        if (!NombreEncontrado)
        {
            System.out.println("No se ha encontrado al cliente "+NombreBuscado);
        }
    }
}
