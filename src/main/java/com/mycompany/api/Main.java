package com.exemplo.veiculosapi;

import io.javalin.Javalin;
import com.exemplo.veiculosapi.controllers.VeiculoController;

public class Main {
    public static void main(String[] args) {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8081"));

        Javalin app = Javalin.create().start(port);

        VeiculoController veiculoController = new VeiculoController();

        // Rotas com a nova sintaxe
        app.post("/veiculos", veiculoController::inserirVeiculo);
        app.get("/veiculos", veiculoController::listarVeiculos);
        app.get("/veiculos/{id}", veiculoController::buscarVeiculoPorId);
        app.delete("/veiculos/{id}", veiculoController::deletarVeiculo);
    }
}
