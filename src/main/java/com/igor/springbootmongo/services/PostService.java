package com.igor.springbootmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.springbootmongo.domain.Post;
import com.igor.springbootmongo.repository.PostRepository;
import com.igor.springbootmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
	 	Optional<Post> obj = repo.findById(id);

	 	// vai dar um get no Post, se não tiver, vai lançar a exceção
	 	return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
