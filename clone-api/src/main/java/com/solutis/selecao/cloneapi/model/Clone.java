package com.solutis.selecao.cloneapi.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Clone {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;

    @Column(updatable = false)
    private Date dataCriacao;

    @ManyToMany
    private List<Equipamento> equipamentos = new ArrayList<>();

    public Clone() {
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Clone{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataCriacao=" + dataCriacao +
                ", equipamentos=" + equipamentos +
                '}';
    }

    @PrePersist
    public void prePersist(){
        setDataCriacao(new Date());
    }
}
