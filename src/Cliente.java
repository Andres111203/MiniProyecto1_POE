public class Cliente
{

    private String nombre;
    private String cedula;
    private String fecha_Creacion;
    private double nivel_Ingresos;
    private double dinero_Ahorrado;
   
    public Cliente(String nombre, String cedula, String fecha_Creacion, double nivel_Ingresos, double dinero_Ahorrado) 
    {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nivel_Ingresos = nivel_Ingresos;
        this.fecha_Creacion = fecha_Creacion;
        this.dinero_Ahorrado = dinero_Ahorrado;
    }
    public Cliente()
    {

    }
    public String getNombre() {
        return nombre;
    }
    public double getDinero_Ahorrado() {
        return dinero_Ahorrado;
    }
    public void setDinero_Ahorrado(double dinero_Ahorrado) {
        this.dinero_Ahorrado = dinero_Ahorrado;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public double getNivel_Ingresos() {
        return nivel_Ingresos;
    }
    public void setNivel_Ingresos(double nivel_Ingresos) {
        this.nivel_Ingresos = nivel_Ingresos;
    }
    public String getFecha_Creacion() {
        return fecha_Creacion;
    }
    public void setFecha_Creacion(String fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }


}
