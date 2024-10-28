package br.edu.fateczl.cpflocalizao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private EditText cpfEditText;
    private EditText nomeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cpfEditText = findViewById(R.id.cpfEditText);
        nomeEditText = findViewById(R.id.nomeEditText);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(op -> {
            String cpf = cpfEditText.getText().toString();
            String nome = nomeEditText.getText().toString();

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("cpf", cpf);
            intent.putExtra("nome", nome);
            startActivity(intent);
        });

    }
}