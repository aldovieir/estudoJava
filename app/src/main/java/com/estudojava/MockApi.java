package com.estudojava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MockApi {

   @GET("TestBloc")
   public  Call<List<Modelcadastro>> listaDecadastros();


   @POST("TestBloc")
   public Call<Modelcadastro> cadastrar(@Body Modelcadastro cadastro);

   @DELETE("TestBlc")
   public Call deletarCadastros(@Body Modelcadastro cadastro);
}
