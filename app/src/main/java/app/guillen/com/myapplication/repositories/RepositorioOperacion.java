package app.guillen.com.myapplication.repositories;

import java.util.ArrayList;
import java.util.List;

import app.guillen.com.myapplication.models.Operacion;

/**
 * Created by guillen on 11/09/17.
 */

public class RepositorioOperacion {



    //--TRABAJANDO
    private int total=0;
    private int ingresos=0;
    private int egresos=0;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }
    //TRABAJANDO--



    private static RepositorioOperacion _INSTANCE = null;

    private RepositorioOperacion(){}

    public static RepositorioOperacion getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new RepositorioOperacion();
        return _INSTANCE;
    }

    private List<Operacion> operaciones = new ArrayList<>();

    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public void setOperaciones(Operacion operacion) {
        this.operaciones.add(operacion);
    }


    //--TRABAJANDO
    public void sumarTotales(Operacion operacion){
        switch (operacion.getTipoOp()){
            case "Ingreso":
                this.ingresos=this.ingresos+operacion.getMonto();
                break;
            case "Egreso":
                this.egresos=this.egresos+operacion.getMonto();
                break;
        }
        this.total=ingresos+egresos;
    }
    //TRABAJANDO--

}
