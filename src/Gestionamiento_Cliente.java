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

            }
        }
        if (!NombreEncontrado)
        {
            System.out.println("No se ha encontrado al cliente "+NombreBuscado);
        }
    }

       

    public void listar_clientes()
    {
        if(listaClientes.isEmpty())
        {
            System.out.println("La lista esta vacia");
        }
        else
        {
            System.out.println("Lista de clientes: ");
            for(Cliente cliente1 : listaClientes)
            {
                System.out.println("Nombre: "+ cliente1.getNombre() + " cedula: " + cliente1.getCedula());
            }
        }
        
    }


    public void Solicitar_prestamo() {
        System.out.println("Ingrese la cédula del cliente que solicita el préstamo: ");
        String cedulaCliente = entrada.nextLine();
        
        Cliente cliente = null;
        for (Cliente c : listaClientes) {
            if (c.getCedula().equals(cedulaCliente)) {
                cliente = c;
                break;
            }
        }
        
        if (cliente != null) {
            double dineroAhorrado = cliente.getDinero_Ahorrado();
            double creditoDisponible = dineroAhorrado * 2;
    
            System.out.println("Ingrese el monto del préstamo que desea solicitar: ");
            double montoPrestamo = entrada.nextDouble();
            entrada.nextLine(); 
    
            if (montoPrestamo >= 1 && montoPrestamo <= creditoDisponible) {
                if (montoPrestamo <= dineroAhorrado) {
                    double nuevoSaldo = dineroAhorrado - montoPrestamo;
                    cliente.setDinero_Ahorrado(nuevoSaldo);
                    System.out.println("Préstamo aprobado. Su nuevo saldo es: " + nuevoSaldo);
                } else {
                    double deuda = montoPrestamo - dineroAhorrado;
                    System.out.println("Préstamo aprobado. Debe pagar una deuda de: " + deuda);
                }
            } else {
                System.out.println("El monto del préstamo excede el crédito disponible. Se procederá a calcular el préstamo en 6 cuotas mensuales con un interés compuesto del 2% efectivo anual.");

            double tasaInteresAnual = 0.02;
            int plazoMeses = 6; 

            double cuotaMensual = montoPrestamo * (tasaInteresAnual / 12) / (1 - Math.pow(1 + (tasaInteresAnual / 12), -plazoMeses));

            System.out.println("El valor de la cuota mensual es: " + cuotaMensual);
        }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }


    public void solicitar_Cdt() 
    {
        System.out.println("Digite la cedula del cliente que solicita el CDT: ");
        String ceduCliente = entrada.nextLine();
        Cliente cliente = null;

        for(Cliente clien : listaClientes)
        {
            if(clien.getCedula().equals(ceduCliente))
            {
                cliente = clien;
                break;
            }

    
        }
        if (cliente != null)
        {
    
            Double DineroAhorrado = cliente1.getDinero_Ahorrado();
            if (DineroAhorrado <= 0)
            {
                System.out.println("El cliente no tiene fondos en su cuenta. No puede solicitar un CDT");
                return;

            }
            Scanner entrada = new Scanner(System.in);
            int option;
    
            System.out.println("");
            System.out.println("Recordatorio: El cdt se hara con monto de sus ahorros.");
            System.out.println("");
            System.out.println("------------ Menu de CDT -----------");
            System.out.println("1. CDt del 3% en 3 meses");
            System.out.println("2. CDt del 5% en 6 meses");
            
            System.out.println("Digite la opcion a elegir: ");
            option = entrada.nextInt();
    
            int Selection;
            Selection = option;
            
    
            if((Selection == 1) || (Selection == 2))
            {   

                if(Selection == 1)
                {
                    double Cdt = DineroAhorrado * ((0.03)/(360/(3)));
                    System.out.println("su cdt de 3 meses sera: "+Cdt);
                    double Result = (DineroAhorrado*Cdt)/100 ;
                    double Monto = DineroAhorrado+Result ;
                    System.out.println("El monto que se lograra: "+Monto);
                }
    
                else
                {
                    double Cdt = DineroAhorrado * ((0.05)/(360/(6)));
                    System.out.println("su cdt de 6 meses sera: "+Cdt);
                    double Result = (DineroAhorrado*Cdt)/100 ;
                    double Monto = DineroAhorrado+Result ;
                    System.out.println("El monto que se lograra: "+Monto); 
                }
            }
            else
            {
                System.out.println("Por favor marcar dentro de los parametros establecidos");
            }
            entrada.close();

        }
        else
        {
            System.out.println("Cliente no encontrado :c");
        }
    }
    
    
}
      


