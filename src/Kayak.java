
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 10/11/23
 * @modificationDate 15/11/23
 * @description Clase Controlador que maneja la lógica del programa
 */

import java.util.ArrayList;

public class Kayak implements IReserva {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Archivo archivoUsuarios;
    private Archivo archivoReservas;
    private Reserva nuevaReserva;
    private Usuario usuarioEnLogin;

    /**
     * Constructor de Kayak
     */
    public Kayak() {
        reservas = new ArrayList<Reserva>();
        usuarios = new ArrayList<Usuario>();
        archivoUsuarios = new Archivo();
        archivoReservas = new Archivo();
        usuarioEnLogin = new Usuario(null, null, false);
    }

    @Override
    public Usuario login(String username, String password) {

        try {
            usuarios = archivoUsuarios.leerUsuarios();

        } catch (Exception e) {
            System.out.println("Error al leer los usuarios");

        }

        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                usuarioEnLogin = usuario;
                return usuarioEnLogin;
            }
        }

        return usuarioEnLogin;
    }

    @Override
    public void registroUsuario(String username, String password, String tipo) {

        if (tipo.equals("Premium")) {
            usuarios.add(new Usuario(username, password, true));

        } else if (tipo.equals("Base")) {
            usuarios.add(new Usuario(username, password, false));
        }

        guardarUsuario();
    }

    @Override
    public void cambiarPassword(String nuevaPassword) {

        try {
            for (Usuario usuario : archivoUsuarios.leerUsuarios()) {
                if (usuario == usuarioEnLogin) {
                    usuarioEnLogin.setPassword(nuevaPassword);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarTipoUsuario() {

        try {
            for (Usuario usuario : archivoUsuarios.leerUsuarios()) {
                if (usuario == usuarioEnLogin) {
                    usuarioEnLogin.setTipo(true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea,
            String username) {
        nuevaReserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, username, null, 0, null, null, 0);
    }

    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento,
            int cantidadMaletas) {
        nuevaReserva.setNumeroTarjeta(numeroTarjeta);
        nuevaReserva.setCuotas(cuotas);
        nuevaReserva.setClaseVuelo(claseVuelo);
        nuevaReserva.setNumeroAsiento(numeroAsiento);
        nuevaReserva.setCantidadMaletas(cantidadMaletas);
        reservas.add(nuevaReserva);
    }

    @Override
    public String itinerario() {
        return null;
    }

    @Override
    public void leerReserva() {

    }

    @Override
    public void leerUsuario() {

    }

    @Override
    public void guardarReserva() {
        try {
            archivoReservas.escribirReservas(reservas);
            reservas.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarUsuario() {
        try {
            archivoUsuarios.escribirUsuarios(usuarios);
            usuarios.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
