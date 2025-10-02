public class Camioneta extends Vehiculo implements Cierre{
    private TipoCamioneta tipoCamioneta;

    public Camioneta(String marca, String modelo, String patente, TipoVehiculo tipoVehiculo, TipoCamioneta tipoCamioneta) {
        super(marca, modelo, patente, tipoVehiculo);
        this.tipoCamioneta = tipoCamioneta;
    }

    public TipoCamioneta getTipoCamioneta() {
        return tipoCamioneta;
    }

    public void setTipoCamioneta(TipoCamioneta tipoCamioneta) {
        this.tipoCamioneta = tipoCamioneta;
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
            return " Destrabando Caja ";
        }else  {
            return " La caja se encuentra destrabada ";
        }
    }
    @Override
    public String toString() {
        return super.toString() + " Tipo de Camioneta: " + tipoCamioneta;
    }
}
