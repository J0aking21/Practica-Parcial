import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        int opcion = 0;

        while( opcion != 3 ){
            System.out.println("+--------------------------------+");
            System.out.println("|         Menu Principal         |");
            System.out.println("+--------------------------------+");
            System.out.println("| 1. Cargar Posiciones           |");
            System.out.println("+--------------------------------+");
            System.out.println("| 2. Cargar Movimientos          |");
            System.out.println("+--------------------------------+");
            System.out.println("| 0. Salir                       |");
            System.out.println("+--------------------------------+");
            System.out.println("+--------------------------------+");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    opcionCargaPosiciones(garaje);
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Finalizando Programa");
                    break;
            }
        }
    }
    public static void opcionCargaPosiciones(Garaje garaje){
        String marca, modelo, patente;
        TipoVehiculo tipoVehiculo;
        TipoAuto tipoAuto = null;
        TipoCamioneta tipoCamioneta = null;
        TipoPosicion tipoPosicion;
        boolean arranqueElectrico = true;
        int opcion;

        System.out.println(" Cargando Vehiculo ... ");
        System.out.println("Ingrese la marca del vehiculo: ");
        marca = sc.nextLine();
        System.out.println("Ingrese el modelo del vehiculo: ");
        modelo = sc.nextLine();
        System.out.println("Ingrese la patente del vehiculo: ");
        patente = sc.nextLine();
        System.out.println("Ingrese el tipo de vehiculo");
        System.out.println("1. Auto ");
        System.out.println("2. Camioneta ");
        System.out.println("3. Moto ");
        opcion = sc.nextInt();
        if( opcion == 1){
            tipoVehiculo = TipoVehiculo.AUTO;
        }else if( opcion == 2){
            tipoVehiculo = TipoVehiculo.CAMIONETA;
        }else{
            tipoVehiculo = TipoVehiculo.MOTO;
        }
        if( tipoVehiculo == TipoVehiculo.AUTO){
            System.out.println("Ingrese el tipo de auto");
            System.out.println("1. Sedan ");
            System.out.println("2. HatchBack ");
            opcion = sc.nextInt();
            if( opcion == 1){
                tipoAuto = TipoAuto.SEDAN;
            }else {
                tipoAuto = TipoAuto.HATCHBACK;
            }
        }else if( tipoVehiculo == TipoVehiculo.CAMIONETA){
            System.out.println("Ingrese el tipo de camioneta");
            System.out.println("1. Pick-Up ");
            System.out.println("2. SUV     ");
            opcion = sc.nextInt();
            if( opcion == 1){
                tipoCamioneta = TipoCamioneta.PICKUP;
            }else {
                tipoCamioneta = TipoCamioneta.SUV;
            }
        }else{
            System.out.println("Ingrese si la moto tiene arranque electrico ");
            System.out.println("1. Si ");
            System.out.println("2. No ");
            opcion = sc.nextInt();
            if( opcion != 1){
                arranqueElectrico = false;
            }
        }
        if (tipoVehiculo == TipoVehiculo.AUTO){
            garaje.cargarVehiculo(marca,modelo,patente,tipoVehiculo,tipoAuto,tipoCamioneta,arranqueElectrico);
        }
    }
}