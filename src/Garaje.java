import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Garaje {
    private HashSet<Posicion> posiciones;
    private ArrayList<String> autorizados;
    private ArrayList<Movimiento> movimientos;

    public Garaje() {
        this.posiciones = new HashSet<>();
        this.autorizados = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }
    public Propietario cargarPropietario(String nombre, String dni, String telefono){
        Propietario propietario;
        propietario = new Propietario(nombre, dni, telefono);
        return propietario;
    }
    public String cargarAutorizados(String dni){
        if(!this.autorizados.contains(dni)){
            autorizados.add(dni);
        }else{
            return " El autorizado ya existe";
        }
        return " Autorizado ingresado exitosamente";
    }
    public Vehiculo cargarVehiculo(String marca, String modelo, String patente, TipoVehiculo tipoVehiculo, int seleccion){
        Vehiculo vehiculo;
        if( tipoVehiculo.equals(TipoVehiculo.AUTO)){
            if(seleccion == 1){
                vehiculo = new Auto(marca,modelo,patente,tipoVehiculo, TipoAuto.HATCHBACK);
            }else{
                vehiculo = new Auto(marca,modelo,patente,tipoVehiculo,TipoAuto.SEDAN);
            }
        }else if (tipoVehiculo.equals(TipoVehiculo.CAMIONETA)){
            if(seleccion == 1){
                vehiculo = new Camioneta(marca,modelo,patente,tipoVehiculo,TipoCamioneta.PICKUP);
            }else {
                vehiculo = new Camioneta(marca,modelo,patente,tipoVehiculo,TipoCamioneta.SUV);
            }
        }else{
            if(seleccion == 1){
                vehiculo = new Moto(marca,modelo,patente,tipoVehiculo,true);
            }else{
                vehiculo = new Moto(marca,modelo,patente,tipoVehiculo,false);
            }
        }

        return vehiculo;
    }
    public String cargarPosiciones(Vehiculo vehiculo, ArrayList<String> autorizados,Propietario propietario, TipoPosicion tipoPosicion){
        Posicion posicion;
        posicion = new Posicion(vehiculo, autorizados, propietario, tipoPosicion);
        if (!posicion.getVehiculo().equals(vehiculo)) {
            posiciones.add(posicion);
        }else{
            return " La posicion se encuentra ocupada ";
        }
        return " La posicion se cargo con exito ";
    }
    public String cargarMovimientos(Date fecha, int hora, Posicion posicion, Propietario autorizado, TipoMovimiento tipoMovimiento){
        Movimiento movimiento;
        if (tipoMovimiento.equals(TipoMovimiento.ENTRADA)){
            movimiento = new Movimiento(fecha, hora, posicion, autorizado,TipoMovimiento.ENTRADA);
        }else{
            movimiento = new Movimiento(fecha, hora, posicion, autorizado, TipoMovimiento.SALIDA);
        }
        if(movimientos.contains(movimiento)){
            movimientos.add(movimiento);
        }else{
            return " Ya se registro el movimiento ";
        }
        return " Movimiento registrado Correctamente ";
    }
    public String mostrarPosiciones(){
        if(!posiciones.isEmpty()){
            for(Posicion posicion : posiciones){
                return posicion.toString();
            }
        }else{
            return " No se encontro la posicion ";
        }
        return " No hay posiciones registradas";
    }
    public String mostrarMovimientos(){
        if(!movimientos.isEmpty()){
            for(Movimiento movimiento : movimientos){
                return movimiento.toString();
            }
        }else {
            return " No se encontro el movimiento ";
        }
        return " No hay movimientos registrados ";
    }
    public int buscarPosicion(int pos){
        for(Posicion posicion : posiciones){
            if (posicion.getPosicion() == pos){
                return posicion.getPosicion();
            }
        }
        return -1;
    }
    public String mostrarPosicionPorNumero(int pos){
        for(Posicion posicion : posiciones){
            if (buscarPosicion(pos) != -1){
                return posicion.toString();
            }
        }
        return " La posicion ingresada no existe ";
    }
    public String cambiarPropietarioPorNumero(String nombre, String dni, String telefono,int pos){
        for (Posicion posicion : posiciones) {
            if ( buscarPosicion(pos) != -1){
                posicion.setPropietario(cargarPropietario(nombre,dni,telefono));
                return " Propietario modificado correctamente ";
            }
        }
        return " Esta prsona ya es propietaria del vehiculo";
    }
    public String cambiarVehiculoPorNumero(int pos1, int pos2){
        Vehiculo vehiculo;
        for (Posicion posicion : posiciones) {
            if (buscarPosicion(pos1) != -1 && !posiciones.contains(posicion)){
                vehiculo = posicion.getVehiculo();
                posicion.setVehiculo(vehiculo);
                return " Vehiculo cambiado de posicion correctamente ";
            }else{
                return " No hay ningun vehiculo cargado en esta posicion ";
            }
        }
        return " No hay posiciones cargadas ";
    }
}
