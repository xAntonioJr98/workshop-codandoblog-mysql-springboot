package com.torresantonio.codeblog.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torresantonio.codeblog.entities.Post;
import com.torresantonio.codeblog.repositories.CodeblogRepository;
import com.torresantonio.codeblog.services.CodeblogService;

@Service
public class CodeblogServiceImp implements CodeblogService {
	
	@Autowired
	CodeblogRepository codeblogRepository;

	@Override
	public List<Post> ListarTudo() {
		
		return codeblogRepository.findAll();
	}

	@Override
	public Post ListaId(long id) {
		
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post salvar(Post post) {
		
		return codeblogRepository.save(post);
	}
	

}
