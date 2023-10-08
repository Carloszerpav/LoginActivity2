package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent; // Importa la clase Intent

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsuario, editTextContrasena;
    private Button botonIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsuario = findViewById(R.id.usuario);
        editTextContrasena = findViewById(R.id.contrasena);
        botonIniciarSesion = findViewById(R.id.boton1);

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String usuario = editTextUsuario.getText().toString();
                String contrasena = editTextContrasena.getText().toString();

                if (validarCredenciales(usuario, contrasena)) {
                    // Las credenciales son válidas
                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Crear un Intent para abrir MainActivity2
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    // Las credenciales son incorrectas
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarCredenciales(String usuario, String contrasena) {
        String usuarioValido = "carlos"; // USUARIO PARA PROBAR LOGIN
        String contrasenaValida = "1234"; // CONTRASEÑA PARA PROBAR LOGIN

        return usuario.equals(usuarioValido) && contrasena.equals(contrasenaValida);
    }
}
