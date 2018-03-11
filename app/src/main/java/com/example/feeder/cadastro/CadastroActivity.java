package com.example.feeder.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button) findViewById(R.id.btn_inserir);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText campoRA = (EditText) findViewById(R.id.edt_ra);
                EditText campoNome = (EditText) findViewById(R.id.edt_nome);
                EditText campoEndereco = (EditText) findViewById(R.id.edt_endereco);
                EditText campoEmail = (EditText) findViewById(R.id.edt_email);

                String ra = campoRA.getText().toString();
                String nome = campoNome.getText().toString();
                String endereco = campoEndereco.getText().toString();
                String email = campoEmail.getText().toString();

                Usuario usuario = new Usuario();
                usuario.setRa(ra);
                usuario.setEmail(email);
                usuario.setNome(nome);
                usuario.setEndereco(endereco);
                DatabaseReference newRef = myRef.push();
                newRef.setValue(usuario);

                Intent intencao = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(intencao);
//                myRef.setValue(ra);
//                myRef.child(ra).child("nome").setValue(nome);
//                myRef.child(ra).child("endereco").setValue(endereco);
//                myRef.child(ra).child("email").setValue(email);


            }
        });
    }
}
