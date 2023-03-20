package com.aldahir.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aldahir.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    /////para soportar varios lenguajes hay que primero colocar las cadenas a usar en la app en el archivo strings.xml
    // se debe crear un android resource directory, colocarle el nombre de values-es, las dos últimas letras del nombre
    // representa el idioma  y después agregar un archivo android resources file y en el atributo directory name se deebe colocar
    //el valor de la carpeta creada anteriormente, es decir, si se coloco a la carpeta values-it el archivo string.xml debe tener
    // el directory name como values-it
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///este objeto se crea cuando se transforma el linear layout en data binding
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        /// el método inflate forma un layout

        setContentView(binding.getRoot());

        Log.d("MainActivity", "actividad creada");
        binding.BtnCalcular.setOnClickListener(v -> {
            String age = binding.EditTextEdad.getText().toString();
            Log.d("Calcular", age);
            if(age.compareTo("") != 0)
            {
                int ageInt = Integer.parseInt(age);
                int resultado = (ageInt * 7);
                String ans  = getString(R.string.result_format,  resultado);
                binding.InputTextRespuesta.setText(ans);
            }
            else
            {
                Toast.makeText(this, "Ingresar una edad valida", Toast.LENGTH_LONG).show();
                Log.d("Calcular", "cadena vacia");
            }

        });
    }
}