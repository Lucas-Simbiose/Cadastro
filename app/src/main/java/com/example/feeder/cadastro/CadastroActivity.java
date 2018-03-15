package com.example.feeder.cadastro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CadastroActivity extends AppCompatActivity {

//    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRef = rootRef.child("usuarios");
    private FormularioHelper helper;
    private CollectionReference mColRef = FirebaseFirestore.getInstance().collection("usuarios");


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
                    mColRef.document(usuario.getRa()).set(usuario).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.w("firestore", "document saved");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("firestore", "document not saved", e);
                        }
                    });

                }else {
                    Usuario usuario = helper.getUsuario();
                    myRef.child(usuario.getRa()).setValue(usuario);
//                    mDocRef.set(usuario).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Log.w("firestore", "document saved");
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.w("firestore", "document not saved", e);
//                        }
//                    });
//                    Task<Void> mDocRef = mColRef.document(usuario.getRa()).set(usuario).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Log.w("firestore", "document saved");
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.w("firestore", "document not saved", e);
//                        }
//                    });
                    mColRef.document(usuario.getRa()).set(usuario).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.w("firestore", "document saved");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("firestore", "document not saved", e);
                        }
                    });

                    Intent intencao = new Intent(CadastroActivity.this, MainActivity.class);
                    startActivity(intencao);
                }


            }
        });
    }
}
