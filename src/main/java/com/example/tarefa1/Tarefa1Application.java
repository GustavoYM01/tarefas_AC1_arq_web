package com.example.tarefa1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa1.Models.CategoriaProduto;
import com.example.tarefa1.Models.Produto;
import com.example.tarefa1.Repository.CategoriaProdutoRepository;
import com.example.tarefa1.Repository.ProdutoRepository;

@SpringBootApplication
public class Tarefa1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository, @Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
		return args -> {
			System.out.println("******** Produtos inseridos ********\n\r");
			produtoRepository.inserir(new Produto(1, "Caneta", 10));
			produtoRepository.inserir(new Produto(2, "RTX 3080TI", 20));

			System.out.println("******** Ex. Selecionar todos os produtos ********");
			List<Produto> listaProdutos = produtoRepository.selecionarTodos();
			listaProdutos.forEach(System.out::println);
			System.out.println("\n\r");

			System.out.println("******** Ex. Selecionar produto por id ********");
			listaProdutos = produtoRepository.selecionarPorId(1);
			listaProdutos.forEach(System.out::println);
			System.out.println("\n\r");

			System.out.println("******** Ex. Editar produto ********");
			Produto p = listaProdutos.get(0);
			p.atualizar(1, "Lápis", 15);
			produtoRepository.editar(p);
			listaProdutos.forEach(System.out::println);
			System.out.println("\n\r");

			System.out.println("******** Ex. Excluir produto ********");
			listaProdutos = produtoRepository.excluirPorId(2);
			System.out.println("******** Registro(s) restante(s) ********");
			listaProdutos.forEach(System.out::println);
			System.out.println("\n\r");

			// ================================= CATEGORIA =================================	

			System.out.println("******** Categorias inseridas ********\n\r");
			categoriaProdutoRepository.inserir(new CategoriaProduto(1,"Material Escolar", "Produtos para uso acadêmico e demais áreas"));
			categoriaProdutoRepository.inserir(new CategoriaProduto(2,"Hardware", "Produtos para computadores"));

			System.out.println("******** Ex. Selecionar todos as categorias ********");
			List<CategoriaProduto> listaCategoriaProduto = categoriaProdutoRepository.selecionarTodos();
			listaCategoriaProduto.forEach(System.out::println);
			System.out.println("\n\r");

			System.out.println("******** Ex. Selecionar categoria por id ********");
			listaCategoriaProduto = categoriaProdutoRepository.selecionarPorId(1);
			listaCategoriaProduto.forEach(System.out::println);
			System.out.println("\n\r");

			System.out.println("******** Ex. Editar categoria ********");
			CategoriaProduto cp = listaCategoriaProduto.get(0);
			cp.atualizar(1, "Veículo", "Veículos automotores");
			categoriaProdutoRepository.editar(cp);
			listaCategoriaProduto.forEach(System.out::println);
			System.out.println("\n\r");

			System.out.println("******** Ex. Excluir categoria ********");
			listaCategoriaProduto = categoriaProdutoRepository.excluirPorId(1);
			System.out.println("******** Registro(s) restante(s) ********");
			listaCategoriaProduto.forEach(System.out::println);
			System.out.println("\n\r");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Tarefa1Application.class, args);
	}

}
