package io.github.lucianodacunha.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import io.github.lucianodacunha.client.ClienteWeb;
import io.github.lucianodacunha.domain.Abrigo;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbrigoService {

    private final ClienteWeb clienteWeb;

    public AbrigoService(ClienteWeb clienteWeb){
        this.clienteWeb = clienteWeb;
    }
    public void cadastrarAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        Abrigo abrigo = new Abrigo(nome, telefone, email);

        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = clienteWeb.post(uri, abrigo);
        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }
    public void listarAbrigos() throws IOException, InterruptedException {
        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = clienteWeb.get(uri);
        String responseBody = response.body();
        Abrigo[] abrigos = new ObjectMapper().readValue(responseBody, Abrigo[].class);
        List<Abrigo> abrigoList = Arrays.stream(abrigos).toList();
        if (abrigoList.isEmpty()){
            System.out.println("Não há abrigos cadastrados");
        } else {

            mostrarAbrigos(abrigoList);
        }
    }

    private static void mostrarAbrigos(List<Abrigo> abrigoList) {
        System.out.println("Abrigos cadastrados:");
        for (Abrigo abrigo : abrigoList) {
            long id = abrigo.getId();
            String nome = abrigo.getNome();
            System.out.println(id +" - " +nome);
        }
    }
}
