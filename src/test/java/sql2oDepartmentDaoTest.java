import Models.Department;
import Models.News;
import Models.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.sql2o.Sql2o;
import org.sql2o.Sql2o;
import sql2o.Sql2oDepartmentDao;
import sql2o.Sql2oNewsDao;
import sql2o.Sql2oUsersDao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class sql2oDepartmentDaoTest {


    String connect = "jdbc:postgresql://localhost:5432/news";
    Sql2o sql2o = new Sql2o(connect,"postgres","123");
    private Sql2oNewsDao newsDao = new Sql2oNewsDao(sql2o);
    private Sql2oDepartmentDao  DepartmentDao = new Sql2oDepartmentDao(sql2o);
    private  Sql2oUsersDao UsersDao = new Sql2oUsersDao(sql2o);

    @Test
    public void  add_addsDepartment_true(){
        Department department = new Department("fishing", "wildlife",1, 2);
        DepartmentDao.add(department);
        News news = new News("general", "music",department.getId());
        newsDao.add(news);
        Users users = new Users("Dwayne","manger","deptlead",3);
        UsersDao.add(users);
        Department department1 = new Department("sports","latest sports news", news.getId(), users.getId());
        int id = department1.getId();
        DepartmentDao.add(department1);
        assertEquals("sports",department1.getName());

    }
    @Test
    public void  geAll_returnsAllDepartments_true(){
        Department department= new Department("fishing","fishing news",2,4);
        Department department2 = new Department("Business","Business news",3 ,8);
        DepartmentDao.add(department);
        DepartmentDao.add(department2);
        int expected = 20;
        Assert.assertEquals(expected,DepartmentDao.getAll().size());
    }
    @Test
    public void update_updatesDepartmentDetails_true(){
        Department department = new Department("fashion","fashion news",20,3);
        DepartmentDao.add(department);
        department.setName("weather");
        DepartmentDao.update(department );
        Assert.assertEquals("weather", department.getName());
    }
    @Test
    public void delete_deletesDepartmentDetails_true(){
        Department department = new Department("European", "African news", 20,25);
        DepartmentDao.add(department);
        DepartmentDao.deleteByName(department.getName());
       Assert.assertEquals(27, DepartmentDao.getAll().size());
    }
}
