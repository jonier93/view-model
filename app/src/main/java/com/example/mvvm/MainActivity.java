package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText apellido;
    private TextView txvName;
    private TextView txvApellido;
    private Button btnIngresar;
    private MyViewModel objViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objViewModel.setName(name.getText().toString());
                objViewModel.setApellido(apellido.getText().toString());
                Toast.makeText(MainActivity.this, "Datos ingresados", Toast.LENGTH_SHORT).show();
            }
        });

        Observer<String> objObserver1 = new Observer<String>() {
            @Override
            public void onChanged(String dataName) {
                txvName.setText(dataName);
            }
        };

        objViewModel.getName().observe(MainActivity.this, objObserver1);

        Observer<String> objObserver2 = new Observer<String>() {
            @Override
            public void onChanged(String dataApellido) {
                txvApellido.setText(dataApellido);
            }
        };

        objViewModel.getApellido().observe(MainActivity.this, objObserver2);

    }
    private void inicializar(){
        name = findViewById(R.id.txtName);
        apellido = findViewById(R.id.txtApellido);
        txvName = findViewById(R.id.txvDataName);
        txvApellido = findViewById(R.id.txvDataApellido);
        btnIngresar = findViewById(R.id.btnIngresar);
        objViewModel = new ViewModelProvider(MainActivity.this).get(MyViewModel.class);
    }
}