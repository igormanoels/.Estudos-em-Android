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

public class GestaoCadastroActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTipoGestao;
    private AutoCompleteTextView autoCompleteTipoItem;
    private Button btnAcaoPrincipal;
    private Button btnVoltar;
    private FrameLayout alterarFormContainer;
    private TextView resultadoBuscaText;

    private String acaoSelecionada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_cadastro);

        // Inicializa as Views
        autoCompleteTipoGestao = findViewById(R.id.autoCompleteTipoGestao);
        autoCompleteTipoItem = findViewById(R.id.autoCompleteTipoItem);
        btnAcaoPrincipal = findViewById(R.id.btnAcaoPrincipal);
        btnVoltar = findViewById(R.id.btnVoltar);
        alterarFormContainer = findViewById(R.id.alterar_form_container);
        resultadoBuscaText = findViewById(R.id.resultado_busca_text);

        // Configura os adaptadores para os menus
        ArrayAdapter<String> gestaoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.tipos_gestao));
        autoCompleteTipoGestao.setAdapter(gestaoAdapter);

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.tipos_cadastro));
        autoCompleteTipoItem.setAdapter(itemAdapter);

        // Listeners
        autoCompleteTipoGestao.setOnItemClickListener((parent, view, position, id) -> {
            acaoSelecionada = (String) parent.getItemAtPosition(position);
            atualizarUiParaAcao(acaoSelecionada);
        });

        btnVoltar.setOnClickListener(v -> finish());

        btnAcaoPrincipal.setOnClickListener(v -> {
            // Lógica para executar a ação principal (buscar, salvar, deletar)
            // Por enquanto, apenas um Toast
            String mensagem = acaoSelecionada + " efetuada com sucesso! (lógica a ser implementada)";
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();

            // Exemplo de como exibir um resultado de busca
            if (acaoSelecionada.equals("Consultar")) {
                resultadoBuscaText.setText("Resultado da busca aparecerá aqui...");
            }
        });

        // Estado inicial
        atualizarUiParaAcao(null);
    }

    private void atualizarUiParaAcao(String acao) {
        if (acao == null) {
            btnAcaoPrincipal.setEnabled(false);
            alterarFormContainer.setVisibility(View.GONE);
            return;
        }

        btnAcaoPrincipal.setEnabled(true);
        switch (acao) {
            case "Consultar":
                btnAcaoPrincipal.setText("Buscar");
                alterarFormContainer.setVisibility(View.GONE);
                break;
            case "Alterar":
                btnAcaoPrincipal.setText("Salvar Alterações");
                // Após uma busca, o formulário de alteração seria inflado aqui
                alterarFormContainer.setVisibility(View.VISIBLE);
                break;
            case "Remover":
                btnAcaoPrincipal.setText("Deletar");
                alterarFormContainer.setVisibility(View.GONE);
                break;
        }
    }
}