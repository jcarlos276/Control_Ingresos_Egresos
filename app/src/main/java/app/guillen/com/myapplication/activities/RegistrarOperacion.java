package app.guillen.com.myapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import app.guillen.com.myapplication.R;
import app.guillen.com.myapplication.models.Operacion;
import app.guillen.com.myapplication.repositories.RepositorioOperacion;

public class RegistrarOperacion extends AppCompatActivity {

    private EditText etMonto;
    private RadioGroup rgTipoOp;
    private Spinner spTipoCu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_operacion);

        etMonto = (EditText) findViewById(R.id.etMonto);
        rgTipoOp = (RadioGroup) findViewById(R.id.rgTipoOp);
        spTipoCu = (Spinner) findViewById(R.id.spTipoCu);

    }

    public void registrar(View view){


        Log.d("LOG", rgTipoOp.getCheckedRadioButtonId() +"");
        String montoS = etMonto.getText().toString();
        //String tipoOp = ((RadioButton)findViewById(rgTipoOp.getCheckedRadioButtonId())).getText().toString();
        String tipoCu = spTipoCu.getSelectedItem().toString();

        if(montoS.isEmpty() || rgTipoOp.getCheckedRadioButtonId()== -1 || tipoCu.isEmpty()){
            Toast.makeText(this, "Debe completar todo el formulario", Toast.LENGTH_LONG).show();
            return;
        }

            Operacion operacion = new Operacion(Integer.parseInt(montoS), ((RadioButton)findViewById(rgTipoOp.getCheckedRadioButtonId())).getText().toString(), tipoCu);

            RepositorioOperacion repositorioOperacion = RepositorioOperacion.getInstance();
            repositorioOperacion.setOperaciones(operacion);
            repositorioOperacion.sumarTotales(operacion);

        finish();

    }
}
