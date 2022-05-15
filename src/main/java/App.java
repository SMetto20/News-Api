import DB.DB;
import Models.Department;
import Models.News;
import Models.Users;
import com.google.gson.Gson;
import org.h2.engine.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import response.ResponseArray;
import response.ResponseObject;
import sql2o.Sql2oDepartmentDao;
import sql2o.Sql2oNewsDao;
import sql2o.Sql2oUsersDao;

import java.util.Collections;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String[] args) {
        String connect = "jdbc:postgresql://localhost:5432/news";
        Sql2o sql2o = new Sql2o(connect,"postgres","123");
        Sql2oNewsDao newsDao = new Sql2oNewsDao(sql2o);
        Sql2oDepartmentDao DepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oUsersDao UsersDao = new Sql2oUsersDao(sql2o);
        Connection conn = DB.sql2o.open();

        post("/add_department",(request, response) -> {
            Gson gson = new Gson();
            System.out.println(request.body());
            Department department = gson.fromJson(request.body(),Department.class);
            DepartmentDao.add(department);
            System.out.println(department.getName());
            ResponseObject responseObject = new ResponseObject(200,"Success! department Added");
            responseObject.setData(new Object());
            response.status(200);
            response.type("/add_department");

            return gson.toJson(responseObject);
        });
        get("/get_all_department",(request, response) -> {
            Gson gson = new Gson();
            List<Department> list = DepartmentDao.getAll();
            ResponseArray responseArray =  new ResponseArray(200,"success");
            responseArray.setData(Collections.singletonList(list));
            System.out.println(list.size());
            return gson.toJson(responseArray);
        });
        post("/add_news",(request, response) -> {
            Gson gson = new Gson();
            System.out.println(request.body());
            News news= gson.fromJson(request.body(),News.class);
            newsDao.add(news);
            System.out.println(news.getGeneral());
            ResponseObject responseObject = new ResponseObject(200,"Success! department Added");
            responseObject.setData(new Object());
            response.status(200);
            response.type("/add_news");

            return gson.toJson(responseObject);
        });
        get("/get_all_news",(request, response) -> {
            Gson gson = new Gson();
            List<News> list = newsDao.getAll();
            ResponseArray responseArray =  new ResponseArray(200,"success");
            responseArray.setData(Collections.singletonList(list));
            System.out.println(list.size());
            return gson.toJson(responseArray);
        });
        post("/add_users",(request, response) -> {
            Gson gson = new Gson();
            System.out.println(request.body());
            Users users= gson.fromJson(request.body(), Users.class);
            UsersDao.add(users);
            System.out.println(users.getName());
            ResponseObject responseObject = new ResponseObject(200,"Success! department Added");
            responseObject.setData(new Object());
            response.status(200);
            response.type("/add_users");

            return gson.toJson(responseObject);
        });
        get("/get_all_users",(request, response) -> {
            Gson gson = new Gson();
            List<Users> list = UsersDao.getAll();
            ResponseArray responseArray =  new ResponseArray(200,"success");
            responseArray.setData(Collections.singletonList(list));
            System.out.println(list.size());
            return gson.toJson(responseArray);
        });
    }
}
