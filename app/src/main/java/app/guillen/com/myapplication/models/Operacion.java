package app.guillen.com.myapplication.models;

/**
 * Created by guillen on 11/09/17.
 */

public class Operacion {

    private int monto;
    private String tipoOp;
    private String tipoCu;

    public Operacion(int monto, String tipoOp, String tipoCu) {
        this.monto = monto;
        this.tipoOp = tipoOp;
        this.tipoCu = tipoCu;
    }


    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(String tipoOp) {
        this.tipoOp = tipoOp;
    }

    public String getTipoCu() {
        return tipoCu;
    }

    public void setTipoCu(String tipoCu) {
        this.tipoCu = tipoCu;
    }

}
