package com.solutis.selecao.cloneapi.service;

import com.solutis.selecao.cloneapi.exception.CloneExceptions;
import com.solutis.selecao.cloneapi.model.Clone;
import com.solutis.selecao.cloneapi.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CloneService extends CloneExceptions implements ICloneService {

    @Autowired
    private CloneRepository cloneRepository;

    @Override
    public List<Clone> getAllClones() {
        List<Clone> list = new ArrayList<>();
        cloneRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Clone getCloneById(Long id) {
        if(id == null){
            throw new CloneExceptions("Oops, não podemos pesquisar sem id.");
        }
        Clone obj = cloneRepository.findById(id).get();
        return obj;
    }

    @Override
    public void addClone(Clone clone) {
        Clone cloneDb = findByNome(clone.getNome());

        if(clone.getNome() == null){
            throw new CloneExceptions("Não podemos criar clone sem nome.");
        }

        if(!cloneDb.getId().equals(clone.getId()) && clone.getNome().equals(cloneDb.getNome())){
            throw new CloneExceptions("Oops, não podemos criar um clone com nome repetido.");
        }
        if(!clone.getNome().matches("[A-Z]{3}[0-9]{4}")){
            throw new CloneExceptions("Não podemos criar um clone com um nome fora do formato");
        }
        if(clone.getIdade() == null){
            throw new CloneExceptions("Não podemos criar clone sem idade.");
        }
        if(clone.getIdade() < 10 || clone.getIdade() > 20){
            throw new CloneExceptions("Não podemos criar clone com idade menor que 10 anos ou maior que 20.");
        }

        /*if(clone.getId() == null) {
            clone.setDataCriacao(new Date());
        } else {
            clone.setDataCriacao(getCloneById(clone.getId()).getDataCriacao());
        }*/

        try {
            cloneRepository.save(clone);
        } catch (NullPointerException e){
            throw new CloneExceptions("existem dados nulos");
        } catch (Exception e){
            throw new CloneExceptions("houve um erro no servidor", e);
        }

    }

    @Override
    public Clone findByNome(String nome) {
        return cloneRepository.findByNome(nome);
    }

    @Override
    public void deleteClone(Long id) {
        if(id == null){
            throw new CloneExceptions("Id nula, não podemos deletar assim.");
        }
        cloneRepository.delete(getCloneById(id));
    }
}
