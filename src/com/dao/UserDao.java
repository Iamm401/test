package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.User;

public interface UserDao extends BaseDao<User> {

	User getUserByAccount(String account);

	List<User> getUserList();

	User getUserById(Integer id);

	void updateById(Map<String, Object> params, Integer id);

	void deleteById(Integer id);

	void add(User user);

}
