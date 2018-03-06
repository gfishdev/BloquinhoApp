package br.com.guilherme.fiap.bloquinhoapp.api;

import br.com.guilherme.fiap.bloquinhoapp.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserAPI {
    @GET("/user/username/{username}/{password}")
    Call<User> findUser(@Path("username") String username, @Path("password") String password);

    @POST("/user")
    Call<Void> save(@Body User user);
}
