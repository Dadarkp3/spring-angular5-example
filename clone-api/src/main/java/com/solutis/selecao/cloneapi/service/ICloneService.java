package com.solutis.selecao.cloneapi.service;

import com.solutis.selecao.cloneapi.model.Clone;

import java.util.List;

public interface ICloneService {
    List<Clone> getAllClones();
    Clone getCloneById(Long id);
    void addClone(Clone clone);
    void deleteClone(Long id);
    Clone findByNome(String nome);
}
