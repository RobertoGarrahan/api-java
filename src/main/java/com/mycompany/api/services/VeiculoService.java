package com.exemplo.veiculosapi.services;

import com.exemplo.veiculosapi.models.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private final List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public Veiculo buscarVeiculoPorId(int id) {
        if (id >= 0 && id < veiculos.size()) {
            return veiculos.get(id);
        }
        return null;
    }

    public Veiculo deletarVeiculo(int id) {
        if (id >= 0 && id < veiculos.size()) {
            return veiculos.remove(id);
        }
        return null;
    }
}
