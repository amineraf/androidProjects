package model;

/**
 * Created by arafla on 27/10/2015.
 */
public class Account {

    private String password;
    private String avatar;
    private String login;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getLogin() {

        return login;
    }

    public String getPassword() {
        return password;
    }
}
