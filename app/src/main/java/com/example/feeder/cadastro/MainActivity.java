package com.example.feeder.cadastro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaAlunos;
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRef = rootRef.child("usuarios");
    CollectionReference mColRef = FirebaseFirestore.getInstance().collection("usuarios");

    @Override
    protected void onStart() {
        super.onStart();
        mColRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                List alunos = new ArrayList();
                for (DocumentSnapshot documentSnapshot: documentSnapshots){
                    Usuario aluno = documentSnapshot.toObject(Usuario.class);
                    alunos.add(aluno);
                }
                final ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(MainActivity.this, android.R.layout.simple_list_item_1, alunos);
                listaAlunos = (ListView) findViewById(R.id.lista_alunos);
                listaAlunos.setAdapter(adapter);
                listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Usuario usuario = (Usuario) adapter.getItem(i);
                        Intent irParaCadastro = new Intent(MainActivity.this, CadastroActivity.class);
                        irParaCadastro.putExtra("alunoSelecionado", usuario);
                        startActivity(irParaCadastro);

                    }
                });
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button) findViewById(R.id.btn_adicionar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao_novo_aluno = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intencao_novo_aluno);
            }
        });
//        a

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                List alunos = new ArrayList();
//                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
//                    Usuario aluno = postSnapshot.getValue(Usuario.class);
//                    alunos.add(aluno);
//                }
//                final ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(MainActivity.this, android.R.layout.simple_list_item_1, alunos);
//                listaAlunos = (ListView) findViewById(R.id.lista_alunos);
//                listaAlunos.setAdapter(adapter);
//                listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Usuario usuario = (Usuario) adapter.getItem(i);
//                        Intent irParaCadastro = new Intent(MainActivity.this, CadastroActivity.class);
//                        irParaCadastro.putExtra("alunoSelecionado", usuario);
//                        startActivity(irParaCadastro);
//
//                    }
//                });
//                listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//                    @Override
//                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        final Usuario usuario = (Usuario) adapter.getItem(i);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                        builder.setMessage("Deseja deletar o Aluno de RA: " + usuario.getRa() + "?").setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                adapter.remove(usuario);
//                                myRef.child(usuario.getRa()).removeValue();
//                            }
//                        })
//                                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                                    }
//                                });
//                        AlertDialog dialog = builder.create();
//                        dialog.show();
//                        return true;
//                    }
//                });
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }
}
