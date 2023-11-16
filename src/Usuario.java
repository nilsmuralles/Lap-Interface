/**
 * @author Nils Muralles
 * @version 1.0
 * @since 10/11/23
 * @modificationDate 15/11/23
 * @description Clase que modela un usuario
 */

public class Usuario {

    private String username;
    private String password;
    private boolean tipo;

    /**
     * Constructor de Usuario
     * 
     * @param username Username de los usuarios
     * @param password Contraseña de los usuarios
     * @param tipo     Tipo del usuario
     */
    public Usuario(String username, String password, boolean tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    /**
     * Devuelve el username
     * 
     * @return Username del usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Actualiza el username
     * 
     * @param username Username del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devuelve la contraseña del usuario
     * 
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Actualiza la contraseña del usuario
     * 
     * @param password Contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devuevle true o false en caso de ser premium o base, respectivamente
     * 
     * @return premium o base
     */
    public boolean isTipo() {
        return tipo;
    }

    /**
     * Actualiza el tipo del usuario
     * 
     * @param tipo premium o base
     */
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve una cadena que representa al usuario
     */
    @Override
    public String toString() {
        return "Usuario [username=" + username + ", password=" + password + ", tipo=" + tipo + "]";
    }

}
