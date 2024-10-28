package br.edu.fateczl.cpflocalizao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    /*
     *@author: Kelvin Santos Guimarães
     */

    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvRes = findViewById(R.id.tvRes);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        String cpf = getIntent().getStringExtra("cpf");
        String nome = getIntent().getStringExtra("nome");
        String registro = getRegistroFromCpf(cpf);

        tvRes.setText("Nome: " + nome + "\nLocal de Registro: " + registro);

        btnVoltar.setOnClickListener(op -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            this.finish();
        });

    }


    private String getRegistroFromCpf(String cpf) {
        if (cpf.length() < 3) return "Registro desconhecido";

        char digit = cpf.charAt(8);
        switch (digit) {
            case '1': return "Distrito Federal";
            case '2': return "Amazonas, Roraima, Amapá";
            case '3': return "Ceará, Maranhão, Piauí";
            case '4': return "Paraíba, Pernambuco, Alagoas, Rio Grande do Norte";
            case '5': return "Bahia, Sergipe";
            case '6': return "Minas Gerais";
            case '7': return "Rio de Janeiro, Espírito Santo";
            case '8': return "São Paulo";
            case '9': return "Paraná, Santa Catarina";
            case '0': return "Rio Grande do Sul";
            default: return "Registro desconhecido";
        }
    }
}