package net.javaguides.springbootrestefulwebservice.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j;
import net.javaguides.springbootrestefulwebservice.entity.User;
import net.javaguides.springbootrestefulwebservice.repository.UserRepository;
import net.javaguides.springbootrestefulwebservice.service.UserService;

public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		 Optional<User> optionalUser = repository.findById(userId);
		 return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User existUser = repository.findById(user.getId()).get();
		existUser.setFirstname(user.getFirstname());
		existUser.setLastname(user.getLastname());
		existUser.setEmail(user.getEmail());
		
		User updatedUser = repository.save(existUser);
		return updatedUser;
	}
	

	@Override
	public void deleteUser(Long userId) {
		repository.deleteById(userId);
	}

}
