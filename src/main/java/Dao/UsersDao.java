package Dao;

import Models.Department;
import Models.Users;

import java.util.List;

public interface UsersDao {
    public void add(Users users);
    List<Users> getAll();


    void update(Users users);

    void deleteByName(String name);
}
