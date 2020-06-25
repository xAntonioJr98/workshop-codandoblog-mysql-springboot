package com.torresantonio.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.torresantonio.codeblog.models.Post;
import com.torresantonio.codeblog.services.CodeblogService;

@Controller
public class CodeblogController {
	
	@Autowired
	CodeblogService codeblogService;
	
	@GetMapping(value = "/posts")
	public ModelAndView getPost() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.ListarTudo();
		mv.addObject("posts", posts);
		return mv;
		
	}
	@GetMapping(value = "/posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeblogService.ListaId(id);
		mv.addObject("post", post);
		return mv;
	

}
}