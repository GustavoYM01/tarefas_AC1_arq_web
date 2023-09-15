package com.example.tarefa1.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.tarefa1.Models.CategoriaProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
  @Autowired
  private EntityManager entityManager;

  @Transactional
  public CategoriaProduto inserir(CategoriaProduto categoriaProduto) {
      entityManager.merge(categoriaProduto);
      return categoriaProduto;
  }

  @Transactional
  public CategoriaProduto editar(CategoriaProduto categoriaCurso){
  entityManager.merge(categoriaCurso);
  return categoriaCurso;
  }

  @Transactional
  public void excluir(CategoriaProduto categoriaProduto){
    entityManager.remove(categoriaProduto);
  }

  @Transactional
  public List<CategoriaProduto> excluirPorId(int id){
    CategoriaProduto categoriaProduto = entityManager.find(CategoriaProduto.class, id);
    if (categoriaProduto != null) {
      entityManager.remove(categoriaProduto);
      return entityManager.createQuery("SELECT cp FROM CategoriaProduto cp", CategoriaProduto.class).getResultList();
    } else {
      throw new Error("Nenhuma categoria encontrada!");
    }
  }

  public List<CategoriaProduto> selecionarTodos() {
    return entityManager.createQuery("from CategoriaProduto",
            CategoriaProduto.class).getResultList();
  }

  public List<CategoriaProduto> selecionarPorId(int id) {
      String jpql = " select cp from CategoriaProduto cp where cp.id = :id";
      TypedQuery<CategoriaProduto> query = entityManager.createQuery(jpql, CategoriaProduto.class);
      query.setParameter("id", id);
      return query.getResultList();
  }
}
