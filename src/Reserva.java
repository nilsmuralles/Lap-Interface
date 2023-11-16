/**
 * @author Nils Muralles
 * @version 1.0
 * @since 10/11/23
 * @modificationDate 15/11/23
 * @description Clase que modela una reserva
 */

public class Reserva {

    private String fechaVuelo;
    private boolean tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private String username;
    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private String numeroAsiento;
    private int cantidadMaletas;

    /**
     * Constructor de reserva
     * 
     * @param fechaVuelo      Fecha del vuelo
     * @param tipoVuelo       Tipo del vuelo (ida y vuelta o no)
     * @param cantidadBoletos Cantidad de boletos del vuelo
     * @param aerolinea       Aerolínea del vuelo
     * @param username        Username del usuario que hace la reserva
     * @param numeroTarjeta   Numero de tarjeta del usuario que hace la reserva
     * @param cuotas          Cuotas para el pago del vuelo para usuarios no premium
     * @param claseVuelo      Clase del vuelo (coch o primera clase) para usuarios
     *                        premium
     * @param numeroAsiento   Numero del asiento de la reserva para el usuario
     *                        premium
     * @param cantidadMaletas Cantidad de maletas para el usuario premium
     */
    public Reserva(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username,
            String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas) {
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.username = username;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
    }

    /**
     * Devuelve la fecha del vuelo
     * 
     * @return Fecha del vuelo
     */
    public String getFechaVuelo() {
        return fechaVuelo;
    }

    /**
     * Actualiza la fecha del vuelo
     * 
     * @param fechaVuelo Fecha del vuelo
     */
    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    /**
     * Devuelve si el vuelo es de ida y vuelga
     * 
     * @return Tipo de vuelo
     */
    public boolean isTipoVuelo() {
        return tipoVuelo;
    }

    /**
     * Actualiza el tipo de vuelo
     * 
     * @param tipoVuelo Tipo de vuelo
     */
    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    /**
     * Devuelve la cantidad de boletos
     * 
     * @return Cantidad de boletos
     */
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    /**
     * Actualiza la cantidad de boletos
     * 
     * @param cantidadBoletos Cantidad de boletos
     */
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    /**
     * Devuelva la aerolinea del vuelo
     * 
     * @return Aerolínea del vuelo
     */
    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * Actualiza la aerolínea del vuelo
     * 
     * @param aerolinea Aerolínea del vuelo
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * Devuelve el username de la persona que hace la reserva
     * 
     * @return Username del usuario que hace la reserva
     */
    public String getUsername() {
        return username;
    }

    /**
     * Actualiza el username de la persona que hace la reserva
     * 
     * @param username Username del usuario que hace la reserva
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devuelve el número de tarjeta de la reserva
     * 
     * @return Número de tarjeta de la reserva
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Actualiza el número de tarjeta
     * 
     * @param numeroTarjeta Número de tarjeta de la reserva
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Devuelve la cantidad de cuotas
     * 
     * @return Cantidad de cuotas
     */
    public int getCuotas() {
        return cuotas;
    }

    /**
     * Actualiza la cantidad de cuotas
     * 
     * @param cuotas Cantidad de cuotas
     */
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * Devuelve la clase de vuelo
     * 
     * @return Clase de vuelo
     */
    public String getClaseVuelo() {
        return claseVuelo;
    }

    /**
     * Actualiza la clase de vueli
     * 
     * @param claseVuelo Clase de vuelo
     */
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    /**
     * Devuelve el número de asiento
     * 
     * @return Número de asiento
     */
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    /**
     * Actualiza el número de asiento
     * 
     * @param numeroAsiento Número de asiento
     */
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Devuelve la cantidad de maletas
     * 
     * @return Cantidad de maletas
     */
    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    /**
     * Actualiza la cantidad de maletas
     * 
     * @param cantidadMaletas Cantidad de maletas
     */
    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    /**
     * Cadena que representa una reserva
     */
    @Override
    public String toString() {
        return "Reserva [fechaVuelo=" + fechaVuelo + ", tipoVuelo=" + tipoVuelo + ", cantidadBoletos=" + cantidadBoletos
                + ", aerolinea=" + aerolinea + ", username=" + username + ", numeroTarjeta=" + numeroTarjeta
                + ", cuotas=" + cuotas + ", claseVuelo=" + claseVuelo + ", numeroAsiento=" + numeroAsiento
                + ", cantidadMaletas=" + cantidadMaletas + "]";
    }

}
