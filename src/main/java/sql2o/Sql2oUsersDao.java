package sql2o;

import DB.DB;
import Dao.UsersDao;
import Models.Department;
import Models.News;
import Models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

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
    public  List<Users> getAll() {
        String sql = "SELECT * FROM users";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Users.class);
        }

    }
    public void update (Users users) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "UPDATE users SET name = :name WHERE id=:id";
            con.createQuery(sql)
                    .bind(users)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e.getMessage());

        }
    }
    public void deleteByName(String name){
        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE  FROM users WHERE name=:name";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e.getMessage());

        }
    }
}
