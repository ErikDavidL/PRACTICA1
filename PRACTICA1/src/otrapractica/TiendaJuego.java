
package otrapractica;

import java.util.Scanner;

public class TiendaJuego {
    
    Scanner datosTienda = new Scanner(System.in);
    int contador = 0,opcion;
    protected final float kitMayor = 50f,kitMenor =25f;
    Arma armasCreadas = new Arma();
    OpcionArmas armasGuardadas[] = new OpcionArmas[200];    
    float arregloKit[] = new float[200];
    //metodo para crear armas
    public void crearArmas(){
        armasGuardadas[contador] = new OpcionArmas(armasCreadas);
        armasGuardadas[contador].mostrarArmas();
        armasGuardadas[contador].definirArma();
        contador++;
        crearDenuevo();
    }
    //metodo para el menu de opciones de la tienda
    public void tienda(){
        menuTienda();
        opcionMenu();
        seleccionarOpcion();
    }
    //metodo para el menu de la tienda
    public void menuTienda(){
        System.out.println("\n\n    ---TIENDA DEL JUEGO---");
        System.out.println("| OBJETOS DISPONIBLES: ");
        System.out.println("| 1. Listado de Armas.");
        System.out.println("| 2. KIT REPARADOR MAYOR.");
        System.out.println("| 3. KIT REPARADOR MENOR.");
        System.out.println("| 4. OBJETO RESTAURADOR.");            
        System.out.print("| SELECCIONE UNA OOPCIÓN: ");
    }
    int opcionMenu;
    //metodo para el valor de la opcion
    public int opcionMenu(){
        opcionMenu = datosTienda.nextInt();
        return opcionMenu;
    }
    //metodo para definir que opcion eligio el usuario
    public void seleccionarOpcion(){
        switch(opcionMenu){
            case 1:
                listaArmas();
                break;
            case 2:
                kitMayor();
                valorCompraKit();
                break;
            case 3:
                kitMenor();
                valorCompraKit();
                break;
            case 4:
                
                break;        
        }
    
    }
    //metodo para los kits menores
    public void kitMenor(){
        System.out.println("\n|COMPRAR KIT MENOR------PRECIO Q 25.00");
        System.out.println("| 1. SI ");
        System.out.println("| 2. NO");
        System.out.println("| ELIJA UNA OPCIÓN: ");
    }
    //metodo para los kits mayores
    public void kitMayor(){
        System.out.println("\n|COMPRAR KIT MAYOR------PRECIO Q 50.00");
        System.out.println("| 1. SI ");
        System.out.println("| 2. NO");
        System.out.println("| ELIJA UNA OPCIÓN: ");
    }
    int opcionCompra;
    public int valorCompraKit(){
        opcionCompra =datosTienda.nextInt();
        return opcionCompra;
    }
    //metodo para volver a comprar 
    public void crearDenuevo(){
        System.out.println("\nDesea crear otra arma");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("Elija una opción: ");
        opcion = datosTienda .nextInt();
            switch(opcion){
                case 1:
                    crearArmas();
                    break;
                case 2:
                    System.out.println("\n--------------------- \n| REGRESARÁ AL MENÚ |\n---------------------");
                    break;
            }
    }
    //metodo para elegir las armas
    public void elegirArma(){
        crearArmas();
    }
    //metodo para mostrar las armas creadas
    public void listaArmas(){    
        for (int x=0; x < contador ; x++) {
             armasGuardadas[x].listadoArmas();
        }
    }
    
}
