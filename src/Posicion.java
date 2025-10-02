import java.util.List;
import java.util.Objects;

public class Posicion {
    private static int contador = 1;
    private int posicion;
    private Vehiculo vehiculo;
    private Propietario propietario;
    private List<String> autorizados;
    private TipoPosicion tipoPosicion;

    public Posicion(Vehiculo vehiculo, List<String> autorizados, Propietario propietario, TipoPosicion tipoPosicion) {
        this.vehiculo = vehiculo;
        this.propietario = propietario;
        this.autorizados = autorizados;
        this.tipoPosicion = tipoPosicion;
        this.posicion = contador++;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<String> getAutorizados() {
        return autorizados;
    }

    public void setAutorizados(List<String> autorizados) {
        this.autorizados = autorizados;
    }

    public String mostrarAutorizados(List<String> autorizados) {
        StringBuilder resultado = new StringBuilder();

        for (String autorizado : autorizados) {
            resultado.append(autorizado);
        }
        return resultado.toString();
    }

    public TipoPosicion getTipoPosicion() {
        return tipoPosicion;
    }

    public void setTipoPosicion(TipoPosicion tipoPosicion) {
        this.tipoPosicion = tipoPosicion;
    }

    public int getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {

        return "[Posicion" +
                "Numero: " + posicion +
                ", Vehiculo: " + vehiculo.toString() +
                ", propietario: " + propietario.toString() +
                ", autorizados: " + mostrarAutorizados(autorizados) +
                ", tipoPosicion: " + tipoPosicion +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return Objects.equals(vehiculo.getPatente(), posicion.vehiculo.getPatente());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vehiculo.getPatente());
    }
}
