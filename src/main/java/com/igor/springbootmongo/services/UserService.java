package com.igor.springbootmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.springbootmongo.domain.User;
import com.igor.springbootmongo.repository.UserRepository;
import com.igor.springbootmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
	 	Optional<User> obj = repo.findById(id);

	 	// vai dar um get no User, se não tiver, vai lançar a exceção
	 	return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
}
