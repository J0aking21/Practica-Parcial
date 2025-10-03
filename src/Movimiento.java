import java.util.Date;
public class Movimiento {
    private int posicion;
    private String autorizado;
    private Date fecha;
    private int hora;
    private TipoMovimiento tipoMovimiento;

    public  Movimiento(Date fecha, int hora, int posicion,String autorizado, TipoMovimiento tipoMovimiento) {
        this.autorizado = autorizado;
        this.posicion = posicion;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return "[Movimiento " +
                " Fecha: " + fecha +
                " Hora: " + hora +
                " Entrada/Salida: " + tipoMovimiento +
                " Posicion: " + posicion +
                " Realizado por: " + autorizado;
    }
}
