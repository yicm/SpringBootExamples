package com.xiaobaiai.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private static Map<String, User> userRepo = new HashMap<>();
	static {
		User ethan = new User();
		ethan.setId("1");
		ethan.setName("Ethan");
		userRepo.put(ethan.getId(), ethan);

		User xiaoming = new User();
		xiaoming.setId("2");
		xiaoming.setName("Xiaoming");
		userRepo.put(xiaoming.getId(), xiaoming);
	}
	
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepo.put(user.getId(), user);
	}

	@Override
	public void updateUser(String id, User user) {
		// TODO Auto-generated method stub
		userRepo.remove(id);
		user.setId(id);
		userRepo.put(id, user);
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		userRepo.remove(id);
	}

	@Override
	public Collection<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.values();
	}
}
