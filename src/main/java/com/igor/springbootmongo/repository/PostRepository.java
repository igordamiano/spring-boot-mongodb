package com.igor.springbootmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.igor.springbootmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//https://docs.mongodb.com/manual/reference/operator/query/regex/
	//@Query("{ <field>: { $regex: /pattern/ ?0 é o parametro text, $options: '<options>' i=ignora maiusculas e minusculas } }")
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
