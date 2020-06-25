package com.torresantonio.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@GetMapping(value = "/newpost")
	public String getPostForm() {
		return "postForm";
	}
	
	@PostMapping(value="/newpost")
	public String savePost (@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/newpost";
		
	}
		post.setData(LocalDate.now());
		codeblogService.salvar(post);
		return "redirect:/posts";
}
}