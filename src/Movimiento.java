import java.util.Date;
public class Movimiento {
    private int posicion;
    private String dni;
    private Date fecha;
    private int hora;
    private TipoMovimiento tipoMovimiento;

    public  Movimiento(Date fecha, int hora, Posicion posicion,Propietario autorizado, TipoMovimiento tipoMovimiento) {
        this.dni = autorizado.getDni();
        this.posicion = posicion.getPosicion();
        this.fecha = fecha;
        this.hora = hora;
        this.tipoMovimiento = tipoMovimiento;
    }

    @Override
    public String toString() {
        return "[Movimiento " +
                " Fecha: " + fecha +
                " Hora: " + hora +
                " Entrada/Salida: " + tipoMovimiento +
                " Posicion: " + posicion +
                " Realizado por: " + dni;
    }
}
