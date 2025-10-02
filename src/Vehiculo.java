import java.util.Objects;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private String patente;
    private TipoVehiculo tipoVehiculo;

    public Vehiculo(String marca, String modelo, String patente, TipoVehiculo tipoVehiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String toString() {
        return "[Vehiculo " +
                "Marca: " + marca +
                ", Modelo: " + modelo +
                ", Patente: " + patente +
                ", Tipo de Vehiculo: " + tipoVehiculo;
    }


}
