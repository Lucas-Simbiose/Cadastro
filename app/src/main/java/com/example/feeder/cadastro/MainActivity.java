package com.example.feeder.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaAlunos;
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRef = rootRef.child("usuarios");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List alunos = new ArrayList();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
//                    Usuario usuario = new Usuario();
//                    usuario.setRa(dataSnapshot.child("ra").getValue().toString());
//                    Log.i("tet", usuario.getRa());
//                String value = dataSnapshot.getValue(String.class);
                    alunos.add(postSnapshot.child("ra").getValue().toString());
//                alunos.add(value);
                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, alunos);

                    listaAlunos = (ListView) findViewById(R.id.lista_alunos);
                    listaAlunos.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


//        this.listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String aluno = (String) adapter.getItem(i);
//
//                Toast.makeText(MainActivity.this, "Aluno: " + aluno, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        this.listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Toast.makeText(MainActivity.this, "Clique Longo", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }
}
