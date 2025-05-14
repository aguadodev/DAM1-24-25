package ud7.ejemplousuarios.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {

    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;
    private boolean isAdmin;
    private boolean isActive;


    // Datos personales
    private String dni;
    private String email;    
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String cp;
    private String pais;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String nacionalidad;   
    private String estadoCivil;
    private String ocupacion;
    private String estudios;
    private String aficiones;
    private String intereses;
    private String fotoPerfil;
    private String fotoPortada;
    private String biografia;
    private String webPersonal;
    private String redesSociales;
    private String preferencias;


    // Constructores
    
    public Usuario(String username) {
        this.username = username;
    }
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    // HashCode y equals para comparar usuarios por username

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }


    // Getters y Setters

    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }



    
}