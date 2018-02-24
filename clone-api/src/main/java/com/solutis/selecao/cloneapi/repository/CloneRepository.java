package com.solutis.selecao.cloneapi.repository;

import com.solutis.selecao.cloneapi.model.Clone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CloneRepository extends CrudRepository<Clone, Long> {

    Clone findByNome(String nome);
}
