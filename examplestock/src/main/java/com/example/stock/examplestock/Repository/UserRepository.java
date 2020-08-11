package com.example.stock.examplestock.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.stock.examplestock.UserSample;

public interface UserRepository extends CrudRepository <UserSample,Integer>{

	
	UserSample getByEmailAndPassword(String email, String password);

	List<String> findBytype(String type);

}
