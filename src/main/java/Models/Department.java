package Models;

public class Department {
    private int id;
    private String name;
    private String description;
    private int news_id;
    private int users_id;



    public Department(String name, String description, int news_id, int users_id){
        this.name=name;
        this.description=description;
        this.news_id=news_id;
        this.users_id=users_id;

    }

    public Department(int id, String name, String description, int news_id, int users_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.news_id = news_id;
        this.users_id = users_id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNews_id() {
        return news_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public void setId(int id) {
    }

    public int getId() {
        return id;
    }
}
