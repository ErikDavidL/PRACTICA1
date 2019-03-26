
package otrapractica;

import java.util.Scanner;

public class Vehiculo {
    protected String nombreVehiculo,tipoVehiculo,movEspecial,descripcionVelocidad;
    protected float ataque,defensa,punteria,velocidad;
    protected int numeroVehiculo;
    Scanner opciones = new Scanner(System.in);
    int  opcion;
    protected final String arma1 = "AK-47" ,arma2 = "Fusil ZMG-9MM",arma3 = "Fusil M101";
    protected int opcionArma;
    protected String armaVehiculo;
    //METODO CONSTRUCTOR PARA LA CLASE VEHICULO
    public Vehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }
    public String getNombreVehiculo() {
        return nombreVehiculo;
    }
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    public float getAtaque() {
        return ataque;
    }
    public float getDefensa() {
        return defensa;
    }
    public float getPunteria() {
        return punteria;
    }
    public float getVelocidad() {
        return velocidad;
    }    
    public int getNumeroVehiculo() {
        return numeroVehiculo;
    }
    public String getArmaVehiculo() {
        return armaVehiculo;
    }
    
    //METODO PARA INGRESAR EL APODO DEL VEHICULO
    public void ingresarNicknameVehicle(){
        System.out.print("| Ingrese el apodo del vehículo: ");
        nombreVehiculo = opciones.nextLine();
        System.out.println(" ");
    }
    //METODO QUE GENERA UN MENU PARA ESCOGER EL TIPO DE VEHICULO
    public void tipoVehicle(){        
        System.out.println("| Elija un tipo de vehiculo:");
        System.out.println("| 1. Tanque");
        System.out.println("| 2. Avión");
        System.out.print("| Ingrese una opcion: ");
        
    }
    public int numeroTipo(){
        opcion = opciones.nextInt();
        return opcion;
    }
    //METODO QUE DEFINE LOS ATRIBUTOS DE ACUERDO AL TIPO DE VEHICULO QUE SE ESCOJA
    public void definirAtributos(){        
        switch(opcion){
            case 1:
                    numeroVehiculo = 1;
                    tipoVehiculo = "Tanque";
                    ataque = 10f;
                    defensa = 6f;
                    punteria = 60f;
                    movEspecial = "MOVIMIENTO ESPECIAL: Disparo con el doble de ataque, el escenario no reduce el ataque.";
                    descripcionVelocidad = " ";
                    break;
            case 2:
                    numeroVehiculo = 2;
                    tipoVehiculo = "Avión";
                    ataque = 7f;
                    defensa = 3f;
                    punteria = 70f;
                    movEspecial = "MOVIMIENTO ESPECIAL: Realiza un disparo con la mitad de ataque que golpea a todos los enemigos.";
                    velocidad = 1f;                    
                    descripcionVelocidad = "Velocidad de disparo inicial es 1, aumenta 0.10 por cada nivel que se alcance";
                break;
            default:
                System.out.println("\n| Opción incorrecta\n");               
                ingresarVehicle();
        }    
    }
    //METODO QUE MUESTRA LOS DATOS GENERALES DE CADA VEHICULO
    public void mostrarDatos(){
        System.out.println("| El Vehículo:            | "+getNombreVehiculo());
        System.out.println("| Es Un Vehículo Tipo:    | "+getTipoVehiculo());
        System.out.println("| SUS ATRIBUTOS SON:");
        System.out.println("| Ataque:                 | "+getAtaque());
        System.out.println("| Defensa:                | "+getDefensa());
        System.out.println("| Puntería:               | "+getPunteria()+" %");
        System.out.println("| Arma Incorporada:       | "+getArmaVehiculo());        
    }
    //metodos para implementar las armas básicas a los vehiculos
    public void opcionArma(){
        menuArma();
        seleccionArma();
        implementarArma();
    }
    public void menuArma(){
        System.out.println("\n| SELECCIONE EL ARMA BÁSICA QUE IMPLEMENTARÁ AL VEHICULO:");
        System.out.println("| 1. AK-47                 (Arma de corto alcance).");
        System.out.println("| 2. Fusil ZMG-9MM         (Arma de corto alcance).");
        System.out.println("| 3. Fusil M101             (Arma de largo alcance).");
    }
    
    public int seleccionArma(){
        System.out.print("| SELECCIONE UN ARMA: ");
        opcionArma = opciones.nextInt();
        return opcionArma;
    }
    
    public String implementarArma(){
        switch(opcionArma){
            case 1:
                armaVehiculo = arma1;
                break;
            case 2:
                armaVehiculo = arma2;
                break;
            case 3:
                armaVehiculo = arma3;
                break;
        }
        return armaVehiculo;
    }
    //METODO QUE LLAMA A LOS METODOS NECESARIOS AL MOMENTO DE INGRESAR UN VEHICULO
    public void ingresarVehicle(){
        tipoVehicle();
        numeroTipo();
        definirAtributos();
    }
    String copiaTipo;
    public String dibujoVehiculo(){
        copiaTipo = tipoVehiculo; 
        return copiaTipo;
    }
    String extraTipo;
    public String tipoVehiculo(){
        switch(copiaTipo){
            case "Avión":
                extraTipo = "Avión ";
                break;
            case "Tanque":
                extraTipo = "Tanque";
                break;        
        }
        return extraTipo;
    }
    
}
