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
    public Vehiculo cargarVehiculo(String marca, String modelo, String patente, TipoVehiculo tipoVehiculo,TipoAuto tipoAuto,TipoCamioneta tipoCamioneta, boolean arrElectrico){
        Vehiculo vehiculo;
        if( tipoVehiculo.equals(TipoVehiculo.AUTO)){
            if(tipoAuto.equals(TipoAuto.HATCHBACK)){
                vehiculo = new Auto(marca,modelo,patente,tipoVehiculo, TipoAuto.HATCHBACK);
            }else{
                vehiculo = new Auto(marca,modelo,patente,tipoVehiculo,TipoAuto.SEDAN);
            }
        }else if (tipoVehiculo.equals(TipoVehiculo.CAMIONETA)){
            if(tipoCamioneta.equals(TipoCamioneta.PICKUP)){
                vehiculo = new Camioneta(marca,modelo,patente,tipoVehiculo,TipoCamioneta.PICKUP);
            }else {
                vehiculo = new Camioneta(marca,modelo,patente,tipoVehiculo,TipoCamioneta.SUV);
            }
        }else{
            if(arrElectrico){
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
                if(buscarPosicion(pos2) != -1 && !posiciones.contains(posicion)){
                    posicion.setVehiculo(vehiculo);
                }
                return " Vehiculo cambiado de posicion correctamente ";
            }else{
                return " No hay ningun vehiculo cargado en esta posicion ";
            }
        }
        return " No hay posiciones cargadas ";
    }
    public String agregarAutorizadoPorNumero(int pos, String dni){
        for (Posicion posicion : posiciones) {
            if (buscarPosicion(pos) != -1 && !posicion.getAutorizados().contains(dni)){
                posicion.setAutorizados(autorizados);
                return " Autorizado ingresado exitosamente ";
            }else{
                return " El autorizado ya existe ";
            }
        }
        return " La posicion solicitada no esta cargada ";
    }
    public String limpiarAutorizadosPorNumero(int pos){
        for (Posicion posicion : posiciones) {
            if (buscarPosicion(pos) != -1){
                posicion.getAutorizados().clear();
                return " Autorizados eliminados correctamente ";
            }else{
                return " No hay autorizados cargados en esta posicion ";
            }
        }
        return " La posicion solicitada no esta cargada o no existe ";
    }
    public String cargarMovimiento(Date fecha, int hora, int posicion, String autorizado, TipoMovimiento tipoMovimiento){
        Movimiento movimiento;
        if (tipoMovimiento.equals(TipoMovimiento.ENTRADA)){
            movimiento = new Movimiento(fecha, hora, posicion, autorizado,TipoMovimiento.ENTRADA);
        }else{
            movimiento = new Movimiento(fecha, hora, posicion, autorizado, TipoMovimiento.SALIDA);
        }
        if(!movimientos.contains(movimiento)){
            movimientos.add(movimiento);
        }else{
            return " Ya se registro el movimiento ";
        }
        return " Movimiento registrado Correctamente ";
    }
    public String verMovimientosPorPosicion(int pos){
        for (Posicion posicion : posiciones) {
            if (buscarPosicion(pos) != -1){
                for( Movimiento movimiento : movimientos ){
                    if(movimiento.getPosicion() == pos ){
                        StringBuilder respuesta = new StringBuilder();
                        respuesta.append(movimiento);
                        return respuesta.toString();
                    }else{
                        return " La posicion no tiene movimientos cargados ";
                    }
                }
            }else{
                return " La posicion solicitada no existe o no esta cargada ";
            }
        }
        return " No se encuentran posiciones cargadas ";
    }
}
