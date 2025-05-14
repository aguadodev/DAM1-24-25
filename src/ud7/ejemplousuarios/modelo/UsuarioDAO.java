package ud7.ejemplousuarios.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ud7.ejemplousuarios.Util;

/**
 * Clase que gestiona la persistencia de Usuarios.
 * Primero con un usuario administrador por defecto, una lista de usuarios y métodos estáticos para:
 * * - Login y registro de usuarios
 * * - Cambiar la contraseña de un usuario
 * * - Obtener la lista de usuarios
 * *
 * La persistencia se puede realizar de varias formas:
 * 1. Primero en memoria (ArrayList, HashMap, etc.)
 * 2. Luego cargando y salvando de ficheros de texto (CSV, XML, JSON, etc.) y binarios (DAT)
 * 3. Después con una base de datos relacional (MySQL, SQLite, etc.)
 * 4. Por último con una capa de persistencia objeto-relacional (Hibernate, JPA, etc.)
 * @author Oscar
 * @version 1.0
 */
public class UsuarioDAO {
    private static Usuario[] tUsuarios = {
        new Usuario("admin", Util.generarStringHash2Y("admin"), true),
    };
    private static List<Usuario> usuarios = new ArrayList<Usuario>(List.of(tUsuarios));


    public static Usuario login(String username, String password) {
        Usuario usuario = new Usuario(username);
        int i = usuarios.indexOf(usuario);
        if (i == -1) {
            usuario = null; // El usuario no existe
        } else {
                // Si existe el usuario valida la contraseña con BCrypt
                if (Util.validarHash2Y(password, usuarios.get(i).getPassword())) {
                    usuario = usuarios.get(i);
                    usuario.setLastLogin(LocalDateTime.now());
                } else {
                    usuario = null;
                }
            }
        return usuario;
    }    


   public static Usuario registrar(String usuario, String password) {
        Usuario nuevoUsuario = new Usuario(usuario, Util.generarStringHash2Y(password));
        if (usuarios.contains(nuevoUsuario)) {
            return null; // El usuario ya existe
        }
        // Si no existe el usuario lo añade a la lista
        usuarios.add(nuevoUsuario);
        nuevoUsuario.setCreatedAt(LocalDateTime.now());
        nuevoUsuario.setLastLogin(LocalDateTime.now());
        
        return nuevoUsuario;
    }


    public static void cambiarPassword(Usuario usuario, String nuevoPassword) {
        usuario.setPassword(Util.generarStringHash2Y(nuevoPassword));
        usuario.setUpdatedAt(LocalDateTime.now());
    }

    
    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

}
