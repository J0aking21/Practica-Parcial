public class Moto extends Vehiculo{
    private boolean arranqueELectrico;

    public Moto(String marca, String modelo, String patente, TipoVehiculo tipoVehiculo, boolean arranqueELectrico) {
        super(marca, modelo, patente, tipoVehiculo);
        this.arranqueELectrico = arranqueELectrico;
    }

    public boolean getArranqueELectrico() {
        return arranqueELectrico;
    }

    public void setArranqueELectrico(boolean arranqueELectrico) {
        this.arranqueELectrico = arranqueELectrico;
    }

    @Override
    public String toString() {
        if(arranqueELectrico){
            return super.toString() + " tiene arranque electrico";
        }else{
            return super.toString() + " no tiene arranque electrico";
        }
    }
}
