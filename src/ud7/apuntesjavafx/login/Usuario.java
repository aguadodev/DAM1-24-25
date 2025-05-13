package ud7.apuntesjavafx.login;

public class Usuario {
    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario [username=" + username + "]";
    }

    boolean login() {
        return username.equals("admin") && password.equals("admin");
    }
    
}
