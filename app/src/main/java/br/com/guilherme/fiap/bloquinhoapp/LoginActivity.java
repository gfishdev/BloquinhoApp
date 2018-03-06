package br.com.guilherme.fiap.bloquinhoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.guilherme.fiap.bloquinhoapp.api.UserAPI;
import br.com.guilherme.fiap.bloquinhoapp.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
    }

    public void login(View v) {
        UserAPI api = getRetrofit().create(UserAPI.class);
        String login = etLogin.getText().toString();
        String pass = etPassword.getText().toString();

        api.findUser(login, pass)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        System.out.println(response.body());
                        //TODO: Verificar se usuario está ativo
                        if (response.isSuccessful() && response.body() != null) {
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            intent.putExtra("user", response.body().getUsername());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getBaseContext(), "Please, check the user and password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Please, check the user and password", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://bloquinho-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
