package com.estudojava;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

Button botaoListarCadastros;
ArrayList<Modelcadastro> listaDeCadastrosModel= new ArrayList<>();
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(logging);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("https://603c2f43f4333a0017b673f2.mockapi.io/")
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create()).build();

        botaoListarCadastros = (Button) findViewById(R.id.botaoListarCadastros);
        listView = (ListView) findViewById(R.id.listViewCadastros);


       botaoListarCadastros.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               MockApi mockApi = retrofit.create(MockApi.class);
               Call<List<Modelcadastro>> response = mockApi.listaDecadastros();
               response.enqueue(new Callback<List<Modelcadastro>>() {
                   @Override
                   public void onResponse(Call<List<Modelcadastro>> call, Response<List<Modelcadastro>> response) {
                       listaDeCadastrosModel.clear();

                       listaDeCadastrosModel.addAll(response.body());


                       CustomAdpter listaAdapter = new CustomAdpter(MainActivity.this,listaDeCadastrosModel);
                       listView.setAdapter(listaAdapter);

                   }

                   @Override
                   public void onFailure(Call<List<Modelcadastro>> call, Throwable t) {
                    System.out.println("erro");
                   }
               });
           }
       });


    }




    public void cadastrar(View view) {

        Intent intent1 = new Intent(getApplicationContext(), Formulario2.class);
        startActivity(intent1);
    }



}