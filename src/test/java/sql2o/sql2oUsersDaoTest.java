package sql2o;

import Models.Department;
import Models.News;
import Models.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class sql2oUsersDaoTest { String connect = "jdbc:postgresql://localhost:5432/news";
    Sql2o sql2o = new Sql2o(connect,"postgres","123");
    private Sql2oNewsDao newsDao = new Sql2oNewsDao(sql2o);
    private Sql2oDepartmentDao  DepartmentDao = new Sql2oDepartmentDao(sql2o);
    private  Sql2oUsersDao UsersDao = new Sql2oUsersDao(sql2o);

    @Test
    public void  add_addsUsers_true(){
        Users users = new Users("Dwayne","manger","deptlead",3);
        UsersDao.add(users);
        assertEquals("Dwayne",users.getName());

    }
    @Test
    public void  geAll_returnsAllUsers_true(){
        Users users = new Users("Dwayne","manger","deptlead",3);
        Users users2 = new Users("Phil","manager","supervisor",4);
        UsersDao.add(users);
        UsersDao.add(users2);
        int expected = 25;
        Assert.assertEquals(expected, UsersDao.getAll().size());
    }
    @Test
    public void update_updatesUsersDetails_true(){
        Users users = new Users("Dwayne","manger","deptlead",3);
        UsersDao.add(users);
        users.setName("Chris");
        UsersDao.update(users);
        Assert.assertEquals("Chris", users.getName());
    }
    @Test
    public void delete_deletesUsers_true(){
        Users users = new Users("Dwayne","manger","deptlead",3);
        UsersDao.add(users);
        UsersDao.deleteByName(users.getName());
        Assert.assertEquals(6, UsersDao.getAll().size());
    }
}
