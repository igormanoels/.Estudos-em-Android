package com.fatec.gerenciadortcc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class GestaoCadastroActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTipoGestao, autoCompleteTipoItem;
    private Button btnAcaoPrincipal, btnVoltar, btnBuscarGestao;
    private FrameLayout alterarFormContainer, filtrosDinamicosContainer;
    private TextView resultadoBuscaText;

    // Views dos contêineres de filtro
    private View filtrosTurma, filtrosProfessor, filtrosAluno, filtrosOrientador, filtrosGrupoTcc, filtrosCurso;

    private String acaoSelecionada = "";
    private String itemSelecionado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_cadastro);

        // Inicializa as Views
        autoCompleteTipoGestao = findViewById(R.id.autoCompleteTipoGestao);
        autoCompleteTipoItem = findViewById(R.id.autoCompleteTipoItem);
        btnAcaoPrincipal = findViewById(R.id.btnAcaoPrincipal);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnBuscarGestao = findViewById(R.id.btnBuscarGestao);
        alterarFormContainer = findViewById(R.id.alterar_form_container);
        filtrosDinamicosContainer = findViewById(R.id.filtros_dinamicos_container);
        resultadoBuscaText = findViewById(R.id.resultado_busca_text);

        // Inicializa os Contêineres de Filtros
        filtrosTurma = findViewById(R.id.filtros_turma);
        filtrosProfessor = findViewById(R.id.filtros_professor);
        filtrosAluno = findViewById(R.id.filtros_aluno);
        filtrosOrientador = findViewById(R.id.filtros_orientador);
        filtrosGrupoTcc = findViewById(R.id.filtros_grupo_tcc);
        filtrosCurso = findViewById(R.id.filtros_curso);

        // Configura os adaptadores para os menus
        ArrayAdapter<String> gestaoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.tipos_gestao));
        autoCompleteTipoGestao.setAdapter(gestaoAdapter);

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.tipos_cadastro));
        autoCompleteTipoItem.setAdapter(itemAdapter);

        // Listeners
        autoCompleteTipoGestao.setOnItemClickListener((parent, view, position, id) -> {
            acaoSelecionada = (String) parent.getItemAtPosition(position);
            atualizarUiParaAcao();
        });

        autoCompleteTipoItem.setOnItemClickListener((parent, view, position, id) -> {
            itemSelecionado = (String) parent.getItemAtPosition(position);
            atualizarUiParaAcao();
        });

        btnVoltar.setOnClickListener(v -> finish());

        btnBuscarGestao.setOnClickListener(v -> {
            if ("Alterar".equals(acaoSelecionada)) {
                exibirEPreencherFormulario();
                resultadoBuscaText.setVisibility(View.GONE);
            } else {
                resultadoBuscaText.setText("Dados encontrados para a busca.\n...");
            }
            btnAcaoPrincipal.setEnabled(true);
            Toast.makeText(this, "Busca realizada!", Toast.LENGTH_SHORT).show();
        });

        btnAcaoPrincipal.setOnClickListener(v -> {
            if ("Consultar".equals(acaoSelecionada)) {
                resultadoBuscaText.setText("Resultado da busca para " + itemSelecionado + " aparecerá aqui...");
                return;
            }
            String mensagem = itemSelecionado + " " + acaoSelecionada.toLowerCase() + " com sucesso! (lógica a ser implementada)";
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        });

        // Estado inicial
        atualizarUiParaAcao();
    }

    private void exibirEPreencherFormulario() {
        alterarFormContainer.removeAllViews();
        if (itemSelecionado == null || itemSelecionado.isEmpty()) return;

        View formView = null;
        switch (itemSelecionado) {
            case "Aluno":
                formView = getLayoutInflater().inflate(R.layout.form_aluno, alterarFormContainer, false);
                ((TextInputEditText) formView.findViewById(R.id.edit_aluno_nome)).setText("Aluno Exemplo");
                break;
            case "Professor":
                formView = getLayoutInflater().inflate(R.layout.form_professor, alterarFormContainer, false);
                ((TextInputEditText) formView.findViewById(R.id.edit_professor_nome)).setText("Prof. Exemplo");
                break;
            case "Turma":
                formView = getLayoutInflater().inflate(R.layout.form_turma, alterarFormContainer, false);
                ((AutoCompleteTextView) formView.findViewById(R.id.autocomplete_turma_curso)).setText("ADS");
                break;
            case "Orientador":
                formView = getLayoutInflater().inflate(R.layout.form_orientador, alterarFormContainer, false);
                ((TextInputEditText) formView.findViewById(R.id.edit_orientador_nome)).setText("Orientador Exemplo");
                break;
            case "Grupo TCC":
                formView = getLayoutInflater().inflate(R.layout.form_grupo_tcc, alterarFormContainer, false);
                ((TextInputEditText) formView.findViewById(R.id.edit_grupo_tema)).setText("Tema Exemplo");
                break;
            case "Curso":
                formView = getLayoutInflater().inflate(R.layout.form_curso, alterarFormContainer, false);
                 ((TextInputEditText) formView.findViewById(R.id.edit_curso_nome)).setText("Curso Exemplo");
                break;
        }

        if (formView != null) {
            alterarFormContainer.addView(formView);
            alterarFormContainer.setVisibility(View.VISIBLE);
        }
    }

    private void atualizarUiParaAcao() {
        // Reset inicial
        resultadoBuscaText.setVisibility(View.VISIBLE);
        resultadoBuscaText.setText("Aguardando ação...");
        alterarFormContainer.setVisibility(View.GONE);
        alterarFormContainer.removeAllViews();
        btnAcaoPrincipal.setEnabled(false);
        filtrosDinamicosContainer.setVisibility(View.VISIBLE);
        
        // Esconde todos os filtros
        for (int i = 0; i < filtrosDinamicosContainer.getChildCount(); i++) {
            filtrosDinamicosContainer.getChildAt(i).setVisibility(View.GONE);
        }

        // Mostra o filtro correto
        View filtroParaExibir = null;
        switch(itemSelecionado) {
            case "Turma": filtroParaExibir = filtrosTurma; break;
            case "Professor": filtroParaExibir = filtrosProfessor; break;
            case "Aluno": filtroParaExibir = filtrosAluno; break;
            case "Orientador": filtroParaExibir = filtrosOrientador; break;
            case "Grupo TCC": filtroParaExibir = filtrosGrupoTcc; break;
            case "Curso": filtroParaExibir = filtrosCurso; break;
        }
        if (filtroParaExibir != null) {
            filtroParaExibir.setVisibility(View.VISIBLE);
        }

        // Ajusta botões conforme a ação
        btnAcaoPrincipal.setVisibility(View.VISIBLE);
        switch (acaoSelecionada) {
            case "Consultar":
                btnBuscarGestao.setVisibility(View.GONE);
                btnAcaoPrincipal.setText("Buscar");
                btnAcaoPrincipal.setEnabled(true);
                break;
            case "Alterar":
                btnBuscarGestao.setVisibility(View.VISIBLE);
                btnAcaoPrincipal.setText("Salvar Alterações");
                break;
            case "Remover":
                btnBuscarGestao.setVisibility(View.VISIBLE);
                btnAcaoPrincipal.setText("Deletar");
                break;
            default:
                btnBuscarGestao.setVisibility(View.GONE);
                btnAcaoPrincipal.setText("Efetivar Ação");
                filtrosDinamicosContainer.setVisibility(View.GONE);
                break;
        }
    }
}