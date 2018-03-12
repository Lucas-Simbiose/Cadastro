package com.example.feeder.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CadastroActivity extends AppCompatActivity {

//    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRef = rootRef.child("usuarios");
    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button) findViewById(R.id.btn_inserir);
        helper = new FormularioHelper(this);

        final Usuario alunoSelecionado = (Usuario) getIntent().getSerializableExtra("alunoSelecionado");
        if(alunoSelecionado != null) {
            helper.carregaUsuario(alunoSelecionado);
            EditText campoRa = (EditText) findViewById(R.id.edt_ra);
            campoRa.setEnabled(false);
            botao.setText("Alterar");
        }
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alunoSelecionado != null){
                    Usuario usuario = helper.getUsuario();
                    myRef.child(usuario.getRa()).setValue(usuario);

                }else {
                    Usuario usuario = helper.getUsuario();
                    myRef.child(usuario.getRa()).setValue(usuario);

                    Intent intencao = new Intent(CadastroActivity.this, MainActivity.class);
                    startActivity(intencao);
                }


            }
        });
    }
}
