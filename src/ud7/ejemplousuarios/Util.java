package ud7.ejemplousuarios;

import java.nio.charset.StandardCharsets;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Util {
    /*
     * FUNCIONES BCRYPT: generar hash y validar hash
     */
    /**
     * Valida un hash de BCrypt
     * 
     * @param password Contraseña en texto claro
     * @param hash2y   Hash de BCrypt
     * @return true si la contraseña es correcta
     */
    public static boolean validarHash2Y(String password, String hash2y) {
        return BCrypt.verifyer(BCrypt.Version.VERSION_2Y)
                .verifyStrict(password.getBytes(StandardCharsets.UTF_8),
                        hash2y.getBytes(StandardCharsets.UTF_8)).verified;
    }

    /**
     * Genera un hash de BCrypt
     * 
     * @param password Contraseña en texto claro
     * @return Hash de BCrypt
     */
    public static String generarStringHash2Y(String password) {
        char[] bcryptChars = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToChar(13, password.toCharArray());
        return String.valueOf(bcryptChars);
    }

}
