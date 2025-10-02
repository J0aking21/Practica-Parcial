public class Auto extends Vehiculo implements Cierre{
    private TipoAuto tipoAuto;

    public Auto(String marca, String modelo, String patente, TipoVehiculo tipoVehiculo, TipoAuto tipoAuto) {
        super(marca, modelo, patente, tipoVehiculo);
        this.tipoAuto = tipoAuto;
    }

    public TipoAuto getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(TipoAuto tipoAuto) {
        this.tipoAuto = tipoAuto;
    }
    @Override
    public String destrabarPuertas(boolean destrabar) {
        if(destrabar){
            return " Destrabando puertas";
        }else{
            return " Las puertas se encuentran destrabadas";
        }
    }

    @Override
    public String destrabarVentanas(boolean destrabar) {
        if(destrabar){
            return " Destrabando ventanas";
        }else {
            return " Las Ventanas se encuentran destrabadas";
        }
    }

    @Override
    public String destrabarBaul(boolean destrabar) {
        if(destrabar){
            return " Destrabando baul ";
        }else  {
            return " El baul se encuentra destrabado ";
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo de auto: " + tipoAuto;
    }
}
