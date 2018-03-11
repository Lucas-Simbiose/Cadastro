package com.example.feeder.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] alunos = {
                "Fake", "Zellen", "Zinho"
        };

        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);

        this.listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        this.listaAlunos.setAdapter(adapter);

        this.listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String aluno = (String) adapter.getItem(i);

                Toast.makeText(MainActivity.this, "Aluno: " + aluno, Toast.LENGTH_SHORT).show();
            }
        });

        this.listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "Clique Longo", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
