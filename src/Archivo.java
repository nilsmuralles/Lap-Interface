
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 10/11/23
 * @modificationDate 15/11/23
 * @description Clase archivo que maneja la persistencia
 */

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Archivo {

    private File archivoUsuarios;
    private File archivoReservas;

    /**
     * Constructor de Archivo
     */
    public Archivo() {
        this.archivoUsuarios = new File("usuariosKayak.CSV");
        this.archivoUsuarios = new File(archivoUsuarios.getAbsolutePath());
        this.archivoReservas = new File("reservasKayak.CSV");
        this.archivoReservas = new File(archivoReservas.getAbsolutePath());
    }

    /**
     * Clase que escribe usuarios en el CSV
     * 
     * @param usuarios lista de usuarios
     * @throws Exception Otra clase maneja las excepciones
     */
    public void escribirUsuarios(ArrayList<Usuario> usuarios) throws Exception {

        // Writer
        PrintWriter writer = new PrintWriter(new FileWriter(archivoUsuarios, true));

        for (Usuario usuario : usuarios) {
            String linea = usuario.getUsername() + "," + usuario.getPassword();

            if (usuario.isTipo()) {
                linea = linea + ",Premium";
            } else {
                linea = linea + ",Base";
            }

            writer.println(linea);
            writer.close();

        }

    }

    /**
     * Clase que lee los usuarios del CSV
     * 
     * @return ArrayList con los usuarios
     * @throws Exception Otra clase maneja las excepciones
     */
    public ArrayList<Usuario> leerUsuarios() throws Exception {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios));

        String usuario;
        while ((usuario = br.readLine()) != null) {
            String[] datos = usuario.split(",");

            if (datos[2].equals("Premium")) {
                usuarios.add(new Usuario(datos[0], datos[1], true));

            } else if (datos[2].equals("Base")) {
                usuarios.add(new Usuario(datos[0], datos[1], false));
            }
        }

        br.close();
        return usuarios;
    }

    /**
     * Método que guarda reservas en el CSV
     * 
     * @param reservas Lista de reservas
     * @throws Exception Otra clase maneja las excepciones
     */
    public void escribirReservas(ArrayList<Reserva> reservas) throws Exception {

        // Writer
        PrintWriter writer = new PrintWriter(new FileWriter(archivoReservas, true));

        for (Reserva reserva : reservas) {
            String linea = reserva.getFechaVuelo() + ",";

            if (reserva.isTipoVuelo()) {
                linea = linea + "Si," + reserva.getCantidadBoletos()
                        + "," + reserva.getAerolinea() + "," + reserva.getUsername() + "," + reserva.getNumeroTarjeta()
                        + "," + reserva.getCuotas();

            } else {
                linea = linea + "No," + reserva.getCantidadBoletos() + ","
                        + reserva.getAerolinea() + "," + reserva.getUsername() + "," + reserva.getNumeroTarjeta() + ","
                        + reserva.getCuotas();
            }

            if (reserva.getClaseVuelo().equals("PrimeraClase")) {
                linea = linea + ",PrimeraClase," + reserva.getNumeroAsiento() + ","
                        + reserva.getCantidadMaletas();
            } else if (reserva.getClaseVuelo().equals("Coach")) {
                linea = linea + ",Coach," + reserva.getNumeroAsiento() + "," + reserva.getCantidadMaletas();
            }

            writer.println(linea);
            writer.close();

        }
    }
}
