package com.exemplo.veiculosapi.controllers;

import io.javalin.http.Context;
import com.exemplo.veiculosapi.models.Veiculo;
import com.exemplo.veiculosapi.services.VeiculoService;

public class VeiculoController {
    private final VeiculoService veiculoService = new VeiculoService();

    public void inserirVeiculo(Context ctx) {
        Veiculo novoVeiculo = ctx.bodyAsClass(Veiculo.class);
        veiculoService.adicionarVeiculo(novoVeiculo);
        ctx.status(201).json(novoVeiculo);
    }

    public void listarVeiculos(Context ctx) {
        ctx.json(veiculoService.listarVeiculos());
    }

    public void buscarVeiculoPorId(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        if (veiculo != null) {
            ctx.json(veiculo);
        } else {
            ctx.status(404).result("Veículo não encontrado");
        }
    }

    public void deletarVeiculo(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Veiculo veiculo = veiculoService.deletarVeiculo(id);
        if (veiculo != null) {
            ctx.json(veiculo);
        } else {
            ctx.status(404).result("Veículo não encontrado");
        }
    }
}
