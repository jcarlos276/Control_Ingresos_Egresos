package app.guillen.com.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.guillen.com.myapplication.R;
import app.guillen.com.myapplication.models.Operacion;
import app.guillen.com.myapplication.repositories.RepositorioOperacion;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private TextView tvAhorro, tvCredito, tvEfectivo;
    private ProgressBar pgContabilidad;
    private Button btnGraficos;
    private int saAhorro, saCredito, saEfectivo;
    private String tipoOp;
    private String tipoCu;
    private int montoOp;


    //--TRABAJANDO
    private int sumIngresos, sumEgresos, sumTotal, porcentaje;
    //--TRABAJANDO


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAhorro = (TextView) findViewById(R.id.tvAhorro);
        tvCredito = (TextView) findViewById(R.id.tvCredito);
        tvEfectivo = (TextView) findViewById(R.id.tvEfectivo);
        pgContabilidad = (ProgressBar) findViewById(R.id.pgContabilidad);
        btnGraficos = (Button) findViewById(R.id.btnGraficos);

        btnGraficos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChartsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addItem(View view){
        startActivityForResult(new Intent(this, RegistrarOperacion.class), REGISTER_FORM_REQUEST);
    }

    public void actualizarSaldo(){
        tvAhorro.setText(String.valueOf(saAhorro));
        tvEfectivo.setText(String.valueOf(saEfectivo));
        tvCredito.setText(String.valueOf(saCredito));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data

        RepositorioOperacion repositorioOperacion = RepositorioOperacion.getInstance();

        List<Operacion> operaciones = repositorioOperacion.getOperaciones();

        for (Operacion operacion : operaciones) {

            tipoOp = operacion.getTipoOp();
            tipoCu = operacion.getTipoCu();
            montoOp = operacion.getMonto();

            //Toast.makeText(this, tipoOp,Toast.LENGTH_LONG).show();
        }

        switch (tipoOp){
            case "Ingreso":
                switch (tipoCu){
                    case "Tarjeta de Credito":
                        saCredito=saCredito+montoOp;
                        break;
                    case "Ahorro":
                        saAhorro=saAhorro+montoOp;
                        break;
                    case "Efectivo":
                        saEfectivo=saEfectivo+montoOp;
                        break;
                }
                break;
            case "Egreso":
                switch (tipoCu){
                    case "Tarjeta de Credito":
                        saCredito=saCredito-montoOp;
                        break;
                    case "Ahorro":
                        saAhorro=saAhorro-montoOp;
                        break;
                    case "Efectivo":
                        saEfectivo=saEfectivo-montoOp;
                        break;
                }
                break;
        }

        //-- TRABAJANDO
        sumIngresos = repositorioOperacion.getIngresos();
        sumEgresos = repositorioOperacion.getEgresos();
        sumTotal = repositorioOperacion.getTotal();
        porcentaje = ((sumIngresos*100)/sumTotal);
        //Toast.makeText(this, String.valueOf("Ingresos:"+sumIngresos+"Egresos:"+sumEgresos+"Total:"+porcentaje),Toast.LENGTH_LONG).show();
        //Toast.makeText(this, String.valueOf(porcentaje),Toast.LENGTH_LONG).show();
        pgContabilidad.setProgress(porcentaje);
        //TRABAJANDO --

        actualizarSaldo();

    }



}