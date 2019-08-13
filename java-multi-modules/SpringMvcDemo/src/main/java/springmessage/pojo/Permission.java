package springmessage.pojo;

public class Permission {
    private int user_id;
    private String user_name;
    private int search_m;
    private int add_m;
    private int delete_m_person;
    private int update_m_person;
    private int update_m_group;
    private int delete_m_all;
    private int update_m_all;
    private int update_user_person;
    private int update_user_all;


    public int getSearch_m() {
        return search_m;
    }

    public void setSearch_m(int search_m) {
        this.search_m = search_m;
    }

    public int getAdd_m() {
        return add_m;
    }

    public void setAdd_m(int add_m) {
        this.add_m = add_m;
    }

    public int getDelete_m_person() {
        return delete_m_person;
    }

    public void setDelete_m_person(int delete_m_person) {
        this.delete_m_person = delete_m_person;
    }

    public int getUpdate_m_person() {
        return update_m_person;
    }

    public void setUpdate_m_person(int update_m_person) {
        this.update_m_person = update_m_person;
    }

    public int getUpdate_m_group() {
        return update_m_group;
    }

    public void setUpdate_m_group(int update_m_group) {
        this.update_m_group = update_m_group;
    }

    public int getDelete_m_all() {
        return delete_m_all;
    }

    public void setDelete_m_all(int delete_m_all) {
        this.delete_m_all = delete_m_all;
    }

    public int getUpdate_m_all() {
        return update_m_all;
    }

    public void setUpdate_m_all(int update_m_all) {
        this.update_m_all = update_m_all;
    }

    public int getUpdate_user_person() {
        return update_user_person;
    }

    public void setUpdate_user_person(int update_user_person) {
        this.update_user_person = update_user_person;
    }

    public int getUpdate_user_all() {
        return update_user_all;
    }

    public void setUpdate_user_all(int update_user_all) {
        this.update_user_all = update_user_all;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
