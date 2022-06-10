package br.edu.ifsp.scl.ads.pdm.aa3rafaelyuki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfessorActivity extends AppCompatActivity {
    private EditText txtNome;
    private EditText txtTitulacao;
    private Button btnOK2;
    private Button btnCancelar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        txtNome = findViewById(R.id.txtNome);
        txtTitulacao = findViewById(R.id.txtTitulacao);
        btnOK2 = findViewById(R.id.btnOK2);
        btnCancelar2 = findViewById(R.id.btnCancelar2);

        btnOK2.setOnClickListener( new EscutadorBotaoOK2() );
        btnCancelar2.setOnClickListener( new EscutadorBotaoCancelar2() );
    }

    private class EscutadorBotaoOK2 implements View.OnClickListener{
        public void onClick(View view){
           Intent iVoltaPrincipal = new Intent();
           String nomeProfessor = txtNome.getText().toString();
           String titulacaoProfessor = txtTitulacao.getText().toString();

           iVoltaPrincipal.putExtra("professor", nomeProfessor);
           iVoltaPrincipal.putExtra("titulacao", titulacaoProfessor);
           setResult(RESULT_OK, iVoltaPrincipal);

           finish();
        }
    }

    private class EscutadorBotaoCancelar2 implements View.OnClickListener{
        public void onClick(View view){
           Intent iVoltaPrincipal2 = new Intent();

           setResult(RESULT_CANCELED, iVoltaPrincipal2);
           finish();
        }
    }


}