package com.fatec.gerenciadortcc;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RelatorioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        // Inicializa as Views
        AutoCompleteTextView autoCompleteTipoItem = findViewById(R.id.autoCompleteTipoItem);
        AutoCompleteTextView filtroDisciplina = findViewById(R.id.filtro_disciplina);
        AutoCompleteTextView filtroTipoTcc = findViewById(R.id.filtro_tipo_tcc);
        Button btnGerarRelatorio = findViewById(R.id.btnGerarRelatorio);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        TextView resultadoRelatorioText = findViewById(R.id.resultado_relatorio_text);

        // Configura os adaptadores para os menus
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.tipos_cadastro));
        autoCompleteTipoItem.setAdapter(itemAdapter);

        ArrayAdapter<String> disciplinaAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.filtro_disciplina));
        filtroDisciplina.setAdapter(disciplinaAdapter);

        ArrayAdapter<String> tipoTccAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.filtro_tipo_tcc));
        filtroTipoTcc.setAdapter(tipoTccAdapter);

        // Listeners
        btnVoltar.setOnClickListener(v -> finish());

        btnGerarRelatorio.setOnClickListener(v -> {
            // Lógica para coletar os filtros e gerar o relatório
            resultadoRelatorioText.setText("Gerando relatório com os filtros selecionados...");
            Toast.makeText(this, "Relatório gerado! (lógica a ser implementada)", Toast.LENGTH_SHORT).show();
        });
    }
}