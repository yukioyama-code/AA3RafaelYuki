package br.edu.ifsp.scl.ads.pdm.aa3rafaelyuki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Rafael Bianchi Presta e Yuki Hiroji Oyama


   private EditText txtEscola;
   private Button btnOK;
   private Button btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtEscola = findViewById(R.id.txtEscola);
        btnOK = findViewById(R.id.btnOK);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener( new EscutadorBotaoCancelar());
        btnOK.setOnClickListener( new EscutadorBotaoOK() );
    }

    private class EscutadorBotaoOK implements View.OnClickListener{
        public void onClick(View view){
            String escola;
            escola = txtEscola.getText().toString();

            Intent i = new Intent(getApplicationContext(),PrincipalActivity.class);

            i.putExtra("escola", escola);
            startActivity(i);
            finish();
        }
    }

    private class EscutadorBotaoCancelar implements View.OnClickListener{
        public void onClick(View view) {
            finish();
        }
    }
}