package org.example.dao;

import org.example.model.UserModel;

import java.util.List;

public interface UserDao {
    boolean save(UserModel userModel);
    List<UserModel> getAll();
    UserModel delete(String name);
    UserModel getByGender(String gender);
}
