import DB.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import sql2o.Sql2oDepartmentDao;
import sql2o.Sql2oNewsDao;
import sql2o.Sql2oUsersDao;

public class App {
    public static void main(String[] args) {
        String connect = "jdbc:postgresql://localhost:5432/news";
        Sql2o sql2o = new Sql2o(connect,"postgres","123");
        Sql2oNewsDao newsDao = new Sql2oNewsDao(sql2o);
        Sql2oDepartmentDao DepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oUsersDao UsersDao = new Sql2oUsersDao(sql2o);
        Connection conn = DB.sql2o.open();
    }
}
