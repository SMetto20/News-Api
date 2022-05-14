package Models;

public class News {
    private int id;
    String general;
    String departmental;

    private int department_id;



    public News(String general, String departmental, int department_id) {
        this.general = general;
        this.departmental = departmental;
        this.department_id = department_id;
    }

    public News(int id, String general, String departmental, int department_id) {
        this.id = id;
        this.general = general;
        this.departmental = departmental;
        this.department_id = department_id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int getId() {
        return id;
    }

    public String getGeneral() {
        return general;
    }

    public String getDeparmental() {
        return departmental;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public void setDepartmental(String departmental) {
        this.departmental = departmental;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
