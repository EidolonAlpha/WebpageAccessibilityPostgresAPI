package postgres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import postgres.model.User;
import postgres.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User create() {
		return userRepo.save(new User());
	}
	
	public Optional<User> getByID(Long id) {
		return userRepo.findById(id);
	}
	
	
}
