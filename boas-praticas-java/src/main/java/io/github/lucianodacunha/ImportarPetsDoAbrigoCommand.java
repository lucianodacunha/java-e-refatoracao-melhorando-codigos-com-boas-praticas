package io.github.lucianodacunha;

import io.github.lucianodacunha.client.ClienteWeb;
import io.github.lucianodacunha.service.PetService;

import java.io.IOException;

public class ImportarPetsDoAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            ClienteWeb clienteWeb = new ClienteWeb();
            PetService petService = new PetService(clienteWeb);

            petService.importarPetsDoAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
