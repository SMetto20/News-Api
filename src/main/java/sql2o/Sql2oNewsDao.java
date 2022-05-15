package sql2o;

import DB.DB;
import Dao.NewsDao;
import Models.Department;
import Models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {
    private final Sql2o sql2o;
    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    public void add (News news) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO news (general,departmental,department_id) values(:general,:departmental,:department_id)";
            con.createQuery(sql)
//                    .addParameter("name", this.name)
//                    .addParameter("age", this.age)
//                    .addParameter("health", this.health)
                    .bind(news)
                    .executeUpdate();
        }
    }
    public static List<News> getAll() {
        String sql = "SELECT * FROM News";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(News.class);
        }

    }
    public void update (News news) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "UPDATE news SET name = :name WHERE id=:id";
            con.createQuery(sql)
                    .bind(news)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e.getMessage());

        }
    }
    public void deleteByGeneral(String general){
        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE  FROM news WHERE general=:general";
            con.createQuery(sql)
                    .addParameter("general", general)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e.getMessage());

        }
    }
}
