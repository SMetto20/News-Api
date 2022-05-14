package sql2o;

import DB.DB;
import Dao.NewsDao;
import Models.Department;
import Models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
}
