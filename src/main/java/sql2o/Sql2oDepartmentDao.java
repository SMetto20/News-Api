package sql2o;

import DB.DB;
import Dao.DepartmentDao;
import Models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    public void add(Department department1) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO departments (name,description,news_id, users_id) values(:name,:description,:news_id, :users_id)";
            con.createQuery(sql)
//                    .addParameter("name", this.name)
//                    .addParameter("age", this.age)
//                    .addParameter("health", this.health)
                    .bind(department1)
                    .executeUpdate();
        }
    }
}
