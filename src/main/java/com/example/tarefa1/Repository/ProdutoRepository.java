package com.example.tarefa1.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.tarefa1.Models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
  @Autowired
  private EntityManager entityManager;

  @Transactional
  public Produto inserir(Produto produto) {
      entityManager.merge(produto);
      return produto;
  }

  @Transactional
  public Produto editar(Produto produto){
    entityManager.merge(produto);
    return produto;
  }

  @Transactional
  public void excluir(Produto produto){
    entityManager.remove(produto);
  }

  @Transactional
  public List<Produto> excluirPorId(int id){
    Produto produto = entityManager.find(Produto.class, id);
    if (produto != null) {
      entityManager.remove(produto);
      return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    } else {
      throw new Error("Nenhum produto encontrado!");
    }
  }

  public List<Produto> selecionarTodos() {
    return entityManager.createQuery("from Produto",
    Produto.class).getResultList();
  }

  public List<Produto> selecionarPorId(int id) {
      String jpql = " select p from Produto p where p.id = :id";
      TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
      query.setParameter("id", id);
      return query.getResultList();
  }
}
