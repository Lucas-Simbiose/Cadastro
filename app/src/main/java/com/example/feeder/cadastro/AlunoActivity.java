package com.example.feeder.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class AlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        EditText campoRA = (EditText) findViewById(R.id.edt_ra);
        EditText campoNome = (EditText) findViewById(R.id.edt_nome);
        EditText campoEndereco = (EditText) findViewById(R.id.edt_endereco);
        EditText campoEmail = (EditText) findViewById(R.id.edt_email);

        Intent intencao = getIntent();
        String ra_Aluno = intencao.getExtras().getString("ra_aluno");
        Log.i("tel", ra_Aluno);
    }
}
