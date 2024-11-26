package com.exemplo.veiculosapi.controllers;

import com.exemplo.veiculosapi.models.Veiculo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final List<Veiculo> veiculos = new ArrayList<>();

    @PostMapping
    public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
        veiculos.add(veiculo);
        return veiculo;
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    @GetMapping("/{id}")
    public Veiculo buscarVeiculoPorId(@PathVariable int id) {
        if (id >= 0 && id < veiculos.size()) {
            return veiculos.get(id);
        }
        throw new RuntimeException("Veículo não encontrado");
    }

    @DeleteMapping("/{id}")
    public Veiculo deletarVeiculo(@PathVariable int id) {
        if (id >= 0 && id < veiculos.size()) {
            return veiculos.remove(id);
        }
        throw new RuntimeException("Veículo não encontrado");
    }
}
