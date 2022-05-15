package sql2o;

import Dao.NewsDao;
import Models.Department;
import Models.News;
import Models.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sql2oNewsDaoTest {
    String connect = "jdbc:postgresql://localhost:5432/news";
    Sql2o sql2o = new Sql2o(connect,"postgres","123");
    private Sql2oNewsDao newsDao = new Sql2oNewsDao(sql2o);
    private Sql2oDepartmentDao  DepartmentDao = new Sql2oDepartmentDao(sql2o);
    private  Sql2oUsersDao UsersDao = new Sql2oUsersDao(sql2o);

    @Test
    public void  add_addsNews_true(){
        Department department = new Department("fishing", "wildlife",1, 2);
        DepartmentDao.add(department);
        News news = new News("general", "music",department.getId());
        newsDao.add(news);
        assertEquals("general",news.getGeneral());

    }
    @Test
    public void  geAll_returnsAllNews_true(){
       News news = new News("world news", "music", 3);
       News news2 = new News("weather", "business", 2);
        newsDao.add(news);
        newsDao.add(news2);
        int expected = 19;
        Assert.assertEquals(expected, newsDao.getAll().size());
    }
    @Test
    public void update_updatesNewsDetails_true(){
        News news = new News("world news", "music", 3);
        newsDao.add(news);
        news.setDepartmental("History");
        newsDao.update(news );
        Assert.assertEquals("History", news.getDeparmental());
    }
    @Test
    public void delete_deletesNews_true(){
        News news = new News ("Fashion", "weather", 2);
        newsDao.add(news);
        newsDao.deleteByGeneral(news.getGeneral());
        Assert.assertEquals(29, DepartmentDao.getAll().size());
    }
}

