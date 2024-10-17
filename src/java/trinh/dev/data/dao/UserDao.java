package trinh.dev.data.dao;

import java.util.List;

import trinh.dev.data.model.User;

public interface UserDao {
	public boolean insert(User user);
	public boolean update(User user);
	public boolean delete(int userId);
	public User find(int userId);
        public User findEmail(String email);
        public User find(String email, String password);
	public List<User> findAll();
        public List<Integer> getAllUserIds();
}
