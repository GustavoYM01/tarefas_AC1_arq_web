package com.example.tarefa1.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 200, nullable = false)
  private String nome;

  @Column(nullable = false)
  private int qtd;

  @ManyToOne // Muitos para 1
  @JoinColumn(name = "id_categoria") // Chave estrangeira
  private CategoriaProduto categoriaProduto;

  public Produto(Integer id, String nome, int qtd) {
    this.id = id;
    this.nome = nome;
    this.qtd = qtd;
  }

  public void atualizar(Integer id, String nome, int qtd) {
    this.id = id;
    this.nome = nome;
    this.qtd = qtd;
  }

  public Produto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQtd() {
    return qtd;
  }

  public void setQtd(int qtd) {
    this.qtd = qtd;
  }

  public CategoriaProduto getCategoriaProduto() {
    return categoriaProduto;
  }

  public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
    this.categoriaProduto = categoriaProduto;
  }

  @Override
  public String toString() {
    return "Produto [id = " + id + ", nome = " + nome + ", quantidade = " + qtd + "]";
  }
}
