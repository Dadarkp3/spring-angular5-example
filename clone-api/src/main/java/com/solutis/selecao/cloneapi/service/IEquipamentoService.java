package com.solutis.selecao.cloneapi.service;

import com.solutis.selecao.cloneapi.model.Equipamento;

import java.util.List;

public interface IEquipamentoService {
    List<Equipamento> getAllEquipamento();
    Equipamento getEquipamentoById(Long id);
    void addEquipamento(Equipamento equipamento);
}
