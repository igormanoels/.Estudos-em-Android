package com.fatec.gerenciadortcc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTipoCadastro;
    private LinearLayout formTurma, formProfessor, formGrupoTcc, formCurso, formOrientador, formAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        autoCompleteTipoCadastro = findViewById(R.id.autoCompleteTipoCadastro);
        formTurma = findViewById(R.id.form_turma);
        formProfessor = findViewById(R.id.form_professor);
        formGrupoTcc = findViewById(R.id.form_grupo_tcc);
        formCurso = findViewById(R.id.form_curso);
        formOrientador = findViewById(R.id.form_orientador);
        formAluno = findViewById(R.id.form_aluno);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        Button btnSalvar = findViewById(R.id.btnSalvarCadastro);

        String[] tiposCadastro = getResources().getStringArray(R.array.tipos_cadastro);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, tiposCadastro);
        autoCompleteTipoCadastro.setAdapter(adapter);

        autoCompleteTipoCadastro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                updateFormVisibility(selection);
            }
        });

        btnVoltar.setOnClickListener(v -> finish());

        btnSalvar.setOnClickListener(v -> {
            // Futuramente, a lógica para salvar os dados do formulário visível será adicionada aqui
            Toast.makeText(CadastroActivity.this, "Cadastro salvo! (lógica a ser implementada)", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateFormVisibility(String selection) {
        formTurma.setVisibility(View.GONE);
        formProfessor.setVisibility(View.GONE);
        formGrupoTcc.setVisibility(View.GONE);
        formCurso.setVisibility(View.GONE);
        formOrientador.setVisibility(View.GONE);
        formAluno.setVisibility(View.GONE);

        if ("Turma".equals(selection)) {
            formTurma.setVisibility(View.VISIBLE);
        } else if ("Professor".equals(selection)) {
            formProfessor.setVisibility(View.VISIBLE);
        } else if ("Grupo TCC".equals(selection)) {
            formGrupoTcc.setVisibility(View.VISIBLE);
        } else if ("Curso".equals(selection)) {
            formCurso.setVisibility(View.VISIBLE);
        } else if ("Orientador".equals(selection)) {
            formOrientador.setVisibility(View.VISIBLE);
        } else if ("Aluno".equals(selection)) {
            formAluno.setVisibility(View.VISIBLE);
        }
    }
}