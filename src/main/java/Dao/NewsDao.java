package Dao;

import Models.Department;
import Models.News;

import java.util.List;

public interface NewsDao {
    public void add(News news);
    List<News> getAll();


    void update(News news);

    void deleteByGeneral(String general);
}
