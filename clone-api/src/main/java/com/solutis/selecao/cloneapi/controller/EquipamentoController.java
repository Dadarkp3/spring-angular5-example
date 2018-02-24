package com.solutis.selecao.cloneapi.controller;

/*import com.solutis.selecao.cloneapi.model.Clone;*/
import com.solutis.selecao.cloneapi.model.Equipamento;
import com.solutis.selecao.cloneapi.service.IEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("v1/equipamentos")
public class EquipamentoController {
    @Autowired
    private IEquipamentoService equipamentoService;

    @GetMapping("equipamento/{id}")
    public ResponseEntity<Equipamento> getCloneById(@PathVariable("id") Long id) {
        Equipamento equipamento = equipamentoService.getEquipamentoById(id);
        return new ResponseEntity<>(equipamento, HttpStatus.OK);
    }
    @GetMapping("todos")
    public ResponseEntity<List<Equipamento>> getAllArticles() {
        List<Equipamento> list = equipamentoService.getAllEquipamento();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
