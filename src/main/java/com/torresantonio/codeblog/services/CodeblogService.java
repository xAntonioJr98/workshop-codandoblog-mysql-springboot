package com.torresantonio.codeblog.services;

import java.util.List;

import com.torresantonio.codeblog.models.Post;

public interface CodeblogService {
	
	List<Post> ListarTudo();
	Post ListaId (long id);
	Post salvar (Post post);
	

}
