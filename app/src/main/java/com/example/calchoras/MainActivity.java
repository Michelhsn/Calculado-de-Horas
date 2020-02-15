package com.example.calchoras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void resetar(View v)
    {
        final EditText chegada = (EditText) findViewById(R.id.editText3);
        chegada.setText("");

        final EditText durante = (EditText) findViewById(R.id.editText);
        durante.setText("");

        final EditText saida = (EditText) findViewById(R.id.editText2);
        saida.setText("");
    }

    public void calcular(View v)
    {
        final EditText chegada = (EditText) findViewById(R.id.editText3);
        String horaChegada = chegada.getText().toString();

        final EditText durante = (EditText) findViewById(R.id.editText);
        String horaDuracao = durante.getText().toString();

        final EditText saida = (EditText) findViewById(R.id.editText2);
        String horaSaida = saida.getText().toString();


        if (horaChegada.equals("")){


            String[] horaSplitD = horaDuracao.split(":");


            String[] horaSplitS = horaSaida.split(":");
            if(horaSplitD.length < 2 || horaSplitS.length < 2){
                Toast.makeText(this, "Digite um formato de hora válido", Toast.LENGTH_LONG).show();
            } else{
                Integer minutosDuracao = Integer.parseInt(horaSplitD[0]) * 60 + Integer.parseInt(horaSplitD[1]);
                Integer minutosSaida = Integer.parseInt(horaSplitS[0]) * 60 + Integer.parseInt(horaSplitS[1]);

                Integer minutosChegada = minutosSaida - minutosDuracao;

                String horaTotal = minutosChegada/60 + ":"+ (minutosChegada%60>=10 ? minutosChegada%60 : "0" + minutosChegada%60);


                chegada.setText(horaTotal);
            }






        } else if (horaDuracao.equals("")){

            String[] horaSplitC = horaChegada.split(":");


            String[] horaSplitS = horaSaida.split(":");

            if(horaSplitC.length < 2 || horaSplitS.length < 2){
                Toast.makeText(this, "Digite um formato de hora válido", Toast.LENGTH_LONG).show();
            } else {

                Integer minutosChegada = Integer.parseInt(horaSplitC[0]) * 60 + Integer.parseInt(horaSplitC[1]);
                Integer minutosSaida = Integer.parseInt(horaSplitS[0]) * 60 + Integer.parseInt(horaSplitS[1]);

                Integer minutosDuracao = minutosSaida - minutosChegada;

                String horaTotal = minutosDuracao / 60 + ":" + (minutosDuracao % 60 >= 10 ? minutosDuracao % 60 : "0" + minutosDuracao % 60);


                durante.setText(horaTotal);

            }




        } else if (horaSaida.equals("")){

            String[] horaSplitC = horaChegada.split(":");


            String[] horaSplitD = horaDuracao.split(":");

            if(horaSplitC.length < 2 || horaSplitD.length < 2){
                Toast.makeText(this, "Digite um formato de hora válido", Toast.LENGTH_LONG).show();
            } else {
                Integer minutosChegada = Integer.parseInt(horaSplitC[0]) * 60 + Integer.parseInt(horaSplitC[1]);
                Integer minutosDuracao = Integer.parseInt(horaSplitD[0]) * 60 + Integer.parseInt(horaSplitD[1]);

                Integer minutosSaida = minutosChegada + minutosDuracao;

                String horaTotal = minutosSaida / 60 + ":" + (minutosSaida % 60 >= 10 ? minutosSaida % 60 : "0" + minutosSaida % 60);

                saida.setText(horaTotal);
            }

        } else {
            Toast.makeText(this, "Deixe um espaço desejado em branco", Toast.LENGTH_LONG).show();
        }






    }
}
