package io.github.lucianodacunha;

import io.github.lucianodacunha.client.ClienteWeb;
import io.github.lucianodacunha.service.AbrigoService;

import java.io.IOException;

public class CadastrarAbrigoCommand implements Command{
    @Override
    public void execute() {
        try {
            ClienteWeb clienteWeb = new ClienteWeb();
            AbrigoService abrigoService = new AbrigoService(clienteWeb);

            abrigoService.cadastrarAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
