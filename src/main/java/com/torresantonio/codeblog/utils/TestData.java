package com.torresantonio.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.torresantonio.codeblog.entities.Post;
import com.torresantonio.codeblog.repositories.CodeblogRepository;

@Component
public class TestData {
	
	@Autowired
			CodeblogRepository codeblogRepository;
	//Anotação comentada pois ela popula o banco toda vez que rodar a aplicação
	//@PostConstruct
	public void savePosts() {
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		
		post1.setAutor("Antonio Carlos");
		post1.setData(LocalDate.now());
		post1.setTitulo("Git Hub");
		post1.setTexto("GitHub é uma plataforma de hospedagem de código-fonte com controle de versão usando o Git. Ele permite que programadores, utilitários ou qualquer usuário cadastrado na plataforma contribuam em projetos privados e/ou Open Source de qualquer lugar do mundo");
		
		Post post2 = new Post();
		post2.setAutor("Torres Junior");
		post2.setData(LocalDate.now());
		post2.setTitulo("API REST");
		post2.setTexto("Representational State Transfer, em português Transferência Representacional de Estado, é um estilo de arquitetura de software que define um conjunto de restrições a serem usadas para a criação de web services");
		
		postList.add(post1);
		postList.add(post2);
		
		for(Post post:postList) {
			Post postSaved = codeblogRepository.save(post);
			System.out.println(postSaved.getId());
		}
		
		
			
			
			
			
		}
}
