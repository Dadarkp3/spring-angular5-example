package com.solutis.selecao.cloneapi.controller;

import com.solutis.selecao.cloneapi.exception.CloneExceptions;
import com.solutis.selecao.cloneapi.model.Clone;
import com.solutis.selecao.cloneapi.service.ICloneService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
    @RequestMapping("v1/clones")
public class CloneController {

    @Autowired
    private ICloneService cloneService;

    @GetMapping("clone/{id}")
    public ResponseEntity<Clone> getCloneById(@PathVariable("id") Long id) {
        Clone article = cloneService.getCloneById(id);
        if(article == null){
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(article, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Clone>> getAllArticles() {
        List<Clone> list = cloneService.getAllClones();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("adicionar")
    public ResponseEntity<Void> addArticle(@RequestBody Clone clone, UriComponentsBuilder builder) {
        cloneService.addClone(clone);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(clone.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        cloneService.deleteClone(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
