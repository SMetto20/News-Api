import Models.Department;
import Models.News;
import Models.Users;
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
//    @Before
//    public void setup() {
//        String connect = "jdbc:postgresql://localhost:5432/news";
//        Sql2o sql2o = new Sql2o(connect, "postgres", "123");
//        sql2oDepartmentDao = new Sql2oDepartmentDao();
//        sql2oNewsDao = new Sql2oNewsDao();
//        sql2oUsersDao = new Sql2oUsersDao();
//        conn = sql2o.open();
//    }
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
}
