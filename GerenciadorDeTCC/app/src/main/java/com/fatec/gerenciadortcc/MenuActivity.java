package com.fatec.gerenciadortcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        Button btnGestaoCadastro = findViewById(R.id.btnGestaoCadastro);
        Button btnRelatorio = findViewById(R.id.btnRelatorio);
        Button btnSair = findViewById(R.id.btnSair);

        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        btnGestaoCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, GestaoCadastroActivity.class);
            startActivity(intent);
        });

        btnRelatorio.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, RelatorioActivity.class);
            startActivity(intent);
        });

        btnSair.setOnClickListener(v -> {
            finish(); // Fecha o menu e volta para a tela de login
        });
    }
}