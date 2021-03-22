package com.simicius.dao;

import java.util.List;

import com.simicius.user.User;

public interface IUserDAO {
    public User selectUserById (int id);
    public List <User> selectAllUsers ();
    public void updateUser (User user);
    public void deleteUser ();
    public void createUser ();
}
