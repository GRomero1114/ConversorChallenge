package com.alurachallenge.conversor.recursos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;

/*En este caso Conversor se encarga de la conexión con el servidor
 y la conversion mediante una de las opciones del mismo*/

public class Conversor {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public TipoDeCambio convertir(String monedaBase, String monedaTarget, double monto)  {
        String url= String.format("https://v6.exchangerate-api.com/v6/6e9d8b6f12eebbc3d6e57f19/pair/%s/%s/%f",monedaBase,monedaTarget,monto).replace(",",".");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            TipoDeCambio tipoDeCambio = new Gson().fromJson(response.body(), TipoDeCambio.class);
            return tipoDeCambio;
        } catch (IOException | InterruptedException | InputMismatchException e) {
            throw new RuntimeException("Ocurrio un error"+e.getMessage());
        }
    }
}
