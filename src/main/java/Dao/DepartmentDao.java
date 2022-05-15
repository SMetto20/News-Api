package Dao;

import Models.Department;

import java.util.List;

public interface DepartmentDao {
    //CRUD
    public void add(Department department);
    List<Department> getAll();


    void update(Department department1);

    void deleteByName(String name);
}
