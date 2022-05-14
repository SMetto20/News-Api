package sql2o;

import DB.DB;
import Dao.UsersDao;
import Models.Department;
import Models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oUsersDao implements UsersDao {
  private final Sql2o sql2o;
    public Sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void add(Users users) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO users (name,position,role, department_id) values(:name,:position,:role, :department_id)";
            con.createQuery(sql)
//                    .addParameter("name", this.name)
//                    .addParameter("age", this.age)
//                    .addParameter("health", this.health)
                    .bind(users)
                    .executeUpdate();
        }
    }
}
