package br.edu.ifsp.scl.ads.pdm.aa3rafaelyuki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DisciplinaActivity extends AppCompatActivity {

    private EditText txtDisciplina;
    private Button btnOK3;
    private Button btnCancelar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        txtDisciplina = findViewById(R.id.txtDisciplina);
        btnOK3 = findViewById(R.id.btnOK3);
        btnCancelar3 = findViewById(R.id.btnCancelar3);

        btnOK3.setOnClickListener( new DisciplinaActivity.EscutadorBotaoOK3() );
        btnCancelar3.setOnClickListener( new DisciplinaActivity.EscutadorBotaoCancelar3() );

    }

    private class EscutadorBotaoOK3 implements View.OnClickListener{
        public void onClick(View view){
            Intent iVoltaPrincipalDisc = new Intent();
            String nomeDisciplina = txtDisciplina.getText().toString();


            iVoltaPrincipalDisc.putExtra("disciplina", nomeDisciplina);
            setResult(RESULT_OK, iVoltaPrincipalDisc);

            finish();
        }
    }

    private class EscutadorBotaoCancelar3 implements View.OnClickListener{
        public void onClick(View view){
            Intent iVoltaPrincipalDisc2 = new Intent();

            setResult(RESULT_CANCELED, iVoltaPrincipalDisc2);
            finish();
        }
    }
}