package com.simicius.dao;

import java.util.List;

import com.simicius.user.User;

public interface IUserDAO {
    public User selectUserById (String id);
    public List <User> selectAllUsers ();
    public void updateUser (String id, String em, String se);
    public void deleteUser (String id);
    public void createUser (User user);
}
