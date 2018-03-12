package com.example.feeder.cadastro;

import android.widget.EditText;


/**
 * Created by feeder on 11/03/18.
 */

public class FormularioHelper {
    private EditText campoRA;
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoEndereco;
    private Usuario usuario;

    public FormularioHelper(CadastroActivity activity){
        usuario = new Usuario();

        campoRA = (EditText) activity.findViewById(R.id.edt_ra);
        campoNome = (EditText) activity.findViewById(R.id.edt_nome);
        campoEmail = (EditText) activity.findViewById(R.id.edt_email);
        campoEndereco = (EditText) activity.findViewById(R.id.edt_endereco);
    }

    public Usuario getUsuario() {
        String ra = campoRA.getText().toString();
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String endereco = campoEndereco.getText().toString();

        usuario.setRa(ra);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setEndereco(endereco);

        return usuario;
    }

    public void carregaUsuario(Usuario aluno){
        this.campoRA.setText(aluno.getRa());
        this.campoNome.setText(aluno.getNome());
        this.campoEmail.setText(aluno.getEmail());
        this.campoEndereco.setText(aluno.getEndereco());
    }
}
