package com.in28minutes.rest.website.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static final List<User> users = new ArrayList<>();

	private static int usersCount = 0;

	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(10)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int userNumber) {
		return users.stream()
					.filter(user -> user.getUserId() == userNumber).findFirst().orElse(null);
	}

	public User save(User user) {
		// 여기서 실수가 있었음
		// user.setUserId 후 user.add를 해버려서 users값에 들어가지 않았음.
		
		user.setUserId(++usersCount);
		users.add(user);

		System.out.println(user.getUserId() + " " + user.getName());
		return user;
	}

	public void deleteById(int userId) {
		Predicate<? super User> predicate = user -> user.getUserId().equals(userId);
		users.removeIf(predicate);
	}

	// public Boolean delete(User user) {
	// 	return users.remove(user);
	// }
	//   public User findOne(int id) {
	//      Predicate<? super User> predicate = user -> user.getId().equals(id);
	//      return users.stream().filter(predicate).findFirst().get();
	//   }
}
