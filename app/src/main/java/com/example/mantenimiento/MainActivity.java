package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText usernameInput;
    private EditText passwordInput;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login);
        usernameInput = findViewById(R.id.input_user);
        passwordInput = findViewById(R.id.input_password);
        progressBar = findViewById(R.id.progressBar);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreU = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                //Intent intent = new Intent(MainActivity.this, Menu.class);
                //startActivity(intent);
                login(nombreU, password);
            }
        });

    }



    private void login(String username, String password){

        if(TextUtils.isEmpty(username)){
            usernameInput.setError("El nombre de usuario es requerido");
            usernameInput.requestFocus();
            progressBar.setVisibility(View.GONE);
            return;
        }

        if(TextUtils.isEmpty(password)){
            passwordInput.setError("La contraseña es requerida");
            passwordInput.requestFocus();
            progressBar.setVisibility(View.GONE);
            return;
        }

        ApiService apiService = ApiClient.getClient();
        progressBar.setVisibility(View.VISIBLE);

        Call<LoginResponse> call = apiService.login(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    String token = loginResponse.getToken();
                    int idUsuario = loginResponse.getUserId();

                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    intent.putExtra("idUsuario", idUsuario);
                    intent.putExtra("token", token);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error de conexión: "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}