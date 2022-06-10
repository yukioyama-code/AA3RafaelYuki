package br.edu.ifsp.scl.ads.pdm.aa3rafaelyuki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    String disciplina = "";
    private TextView lblEscola;
    private Button btnProfessor;
    private Button btnDisciplina;
    private RadioGroup radioGroup;
    private RadioButton radDisc1;
    private RadioButton radDisc2;
    private RadioButton radDisc3;
    private TextView lblProf;
    private TextView lblTitulo;
    private TextView lblDisc1;
    private TextView lblDisc2;
    private TextView lblDisc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        lblEscola = findViewById(R.id.lblEscola);
        btnProfessor = findViewById(R.id.btnProfessor);
        btnDisciplina = findViewById(R.id.btnDisciplina);
        radioGroup = findViewById(R.id.radioGroup);
        radDisc1  =findViewById(R.id.radDisc1);
        radDisc2  =findViewById(R.id.radDisc2);
        radDisc3  =findViewById(R.id.radDisc3);
        lblProf = findViewById(R.id.lblProf);
        lblTitulo = findViewById(R.id.lblTitulo);
        lblDisc1 = findViewById(R.id.lblDisc1);
        lblDisc2 = findViewById(R.id.lblDisc2);
        lblDisc3 = findViewById(R.id.lblDisc3);

        Intent iPrincipal = getIntent();
        String escola = iPrincipal.getStringExtra("escola");
        lblEscola.setText(escola);


        btnProfessor.setOnClickListener( new EscutadorBotaoProfessor() );
        btnDisciplina.setOnClickListener( new EscutadorBotaoDisciplina() );
    }

    private class EscutadorBotaoProfessor implements View.OnClickListener{
        public void onClick(View view ){
            Intent i = new Intent(getApplicationContext(),ProfessorActivity.class);
            startActivityForResult(i, 1);
        }
    }

    private class EscutadorBotaoDisciplina implements View.OnClickListener{

        public void onClick( View view ){
            Intent iDisciplina = new Intent(getApplicationContext(), DisciplinaActivity.class);


            int idDisciplina = radioGroup.getCheckedRadioButtonId();
            if( idDisciplina == R.id.radDisc1){
                disciplina = "disciplina1";
            }
            if (idDisciplina == R.id.radDisc2){
                disciplina = "disciplina2";
            }

            if(idDisciplina == R.id.radDisc3){
                disciplina = "disciplina3";
            }

            iDisciplina.putExtra("disciplina", disciplina);
            startActivityForResult(iDisciplina, 2);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == 1 ){
            if ( resultCode == RESULT_OK ){
                boolean erro = false;

                String professor = data.getStringExtra("professor");
                String titulacao = data.getStringExtra("titulacao");

                if(professor.isEmpty()){
                    lblProf.setText("Não informado...");
                    erro = true;
                }

                if(titulacao.isEmpty()){
                    lblTitulo.setText("Não informado...");
                    erro = true;
                }

                if(erro == false){
                    lblProf.setText(professor);
                    lblTitulo.setText(titulacao);
                }

            }

            if(resultCode == RESULT_CANCELED){
                lblProf.setText("Não informado...");
                lblTitulo.setText("Não informado...");
            }
        }

        if(requestCode == 2){
            if(resultCode == RESULT_OK){

                if (disciplina.equals("")){
                    Toast.makeText(this, "Disciplina não selecionada", Toast.LENGTH_SHORT).show();
                }


                if(disciplina.equals("disciplina1")){
                    String nomeDisciplina = data.getStringExtra("disciplina");
                    lblDisc1.setText(nomeDisciplina);
                }

                if(disciplina.equals("disciplina2")){
                    String nomeDisciplina = data.getStringExtra("disciplina");
                    lblDisc2.setText(nomeDisciplina);
                }

                if(disciplina.equals("disciplina3")){
                    String nomeDisciplina = data.getStringExtra("disciplina");
                    lblDisc3.setText(nomeDisciplina);
                }

            }

            if(resultCode == RESULT_CANCELED){
                if(disciplina.equals("disciplina1")){
                    lblDisc1.setText("Não informado...");
                }

                if(disciplina.equals("disciplina2")){
                    lblDisc2.setText("Não iformado...");
                }

                if(disciplina.equals("disciplina3")){
                    lblDisc3.setText("Não informado...");
                }
            }
        }
    }



}