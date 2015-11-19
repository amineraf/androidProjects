package model;

/**
 * Created by arafla on 27/10/2015.
 */
public class Compte {

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String login;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String password;
}
