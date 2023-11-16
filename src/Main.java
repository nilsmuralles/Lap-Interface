
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 10/11/23
 * @modificationDate 15/11/23
 * @description Clase Main que contiene la vista del menú para el usuario
 */

import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Kayak kayak = new Kayak();

        boolean seguir = true;
        while (seguir) { // Menú principal del programa
            System.out.println("\n---BIENVENIDO---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción válida: ");
            String opcion = input.nextLine();

            try {
                int op = Integer.parseInt(opcion);

                switch (op) {
                    case 1:
                        System.out.println("\n---INICIO DE SESIÓN---");
                        System.out.print("Username: ");
                        String usernameInicio = input.nextLine();

                        System.out.print("Contraseña: ");
                        String passwordInicio = input.nextLine();

                        Usuario usuario = kayak.login(usernameInicio, passwordInicio);

                        if (usuario != null) {
                            boolean seguirEnMenuPrincipal = true;

                            while (seguirEnMenuPrincipal) {
                                System.out.println("\n---BIENVENIDO " + usuario.getUsername().toUpperCase() + "---");
                                System.out.println("1. Hacer reservación");
                                System.out.println("2. Modificar perfil");
                                System.out.println("3. Salir");
                                System.out.print("Seleccione una opción: ");
                                String opcionMenuPrincipal = input.nextLine();

                                try {
                                    int opMP = Integer.parseInt(opcionMenuPrincipal);

                                    switch (opMP) {
                                        case 1:
                                            Boolean tipoVuelo = null;
                                            int cantidadB = 0;
                                            String clase = null;

                                            System.out.println("\n---NUEVA RESERVACIÓN---");
                                            System.out.print("Fecha de viaje (dd/MM/YYYY): ");
                                            String fechaViaje = input.nextLine();

                                            System.out.print("¿Es de ida y vuelta? (Y/N): ");
                                            String idaYVuelta = input.nextLine();

                                            System.out.print("Cantidad de boletos: ");
                                            String cantidadBoletos = input.nextLine();

                                            System.out.print("Aerolínea: ");
                                            String aerolinea = input.nextLine();

                                            System.out.println("\n---MODO CONFIRMACIÓN---");
                                            System.out.print("Número de tarjeta: ");
                                            String numeroTarjeta = input.nextLine();

                                            try {

                                                if (idaYVuelta.equals("Y")) {
                                                    tipoVuelo = true;
                                                } else if (idaYVuelta.equals("N")) {
                                                    tipoVuelo = false;
                                                }

                                                cantidadB = Integer.parseInt(cantidadBoletos);

                                                kayak.reservacion(fechaViaje, tipoVuelo, cantidadB, aerolinea,
                                                        usuario.getUsername());

                                            } catch (Exception NumberFormatException) {
                                                System.out.println("Error. Vuelva a ingresar los datos de la reserva");
                                            }

                                            if (usuario.isTipo()) {
                                                System.out.print("Número de asiento: ");
                                                String numDeAsiento = input.nextLine();

                                                System.out.print("Cantidad de maletas: ");
                                                String cantidadMaletas = input.nextLine();

                                                try {
                                                    int cantMaletas = Integer.parseInt(cantidadMaletas);

                                                    kayak.confirmacion(numeroTarjeta, 1, "PrimeraClase", numDeAsiento,
                                                            cantMaletas);

                                                } catch (Exception NumberFormatException) {
                                                    System.out
                                                            .println(
                                                                    "Error. Vuelva a ingresar los datos de confirmación");
                                                }

                                            } else {
                                                System.out.print("Cantidad de cuotas (1-24): ");
                                                String cantidadCuotas = input.nextLine();

                                                System.out.print("Clase para vuelo (Coach/Primera clase): ");
                                                String claseVuelo = input.nextLine();

                                                try {
                                                    int cuotas = Integer.parseInt(cantidadCuotas);

                                                    if (claseVuelo.equals("Coach")) {
                                                        clase = "Coach";
                                                    } else if (claseVuelo.equals("Primera Clase")) {
                                                        clase = "PrimeraClase";
                                                    }

                                                    if (clase != null) {
                                                        kayak.confirmacion(numeroTarjeta, cuotas, clase, "NA", 1);
                                                    }

                                                } catch (Exception e) {
                                                    System.out
                                                            .println(
                                                                    "Error. Vuelva a ingresar los datos de confirmación");
                                                }
                                            }

                                            kayak.guardarReserva();

                                            break;

                                        case 2:
                                            boolean seguirModificando = true;
                                            while (seguirModificando) {
                                                System.out.println("\n---MODIFICAR PERFIL---");
                                                System.out.println("1. Cambiar contraseña");
                                                System.out.println("2. Cambiar tipo de usuario");
                                                System.out.println("3. Salir");
                                                System.out.print("¿Qué desea hacer? ");
                                                String opModificar = input.nextLine();

                                                try {
                                                    int opM = Integer.parseInt(opModificar);

                                                    switch (opM) {
                                                        case 1:
                                                            System.out.print("\nNueva contraseña: ");
                                                            String newPassword = input.nextLine();
                                                            kayak.cambiarPassword(newPassword);
                                                            System.out.println("¡Contraseña modificada exitosamente!");
                                                            break;

                                                        case 2:
                                                            if (usuario.isTipo()) {
                                                                System.out.println("Ya es un usuario premium");
                                                            } else {
                                                                kayak.cambiarTipoUsuario();
                                                                System.out.println("¡Felicidades! Ahora eres premium");
                                                            }
                                                            break;

                                                        case 3:
                                                            seguirModificando = false;
                                                            break;

                                                        default:
                                                            System.out.println(
                                                                    "Seleeccione una opción del menú por favor");
                                                            break;
                                                    }

                                                } catch (Exception e) {
                                                    System.out.println("Seleccione un número por favor");
                                                }

                                            }

                                            break;

                                        case 3:
                                            seguirEnMenuPrincipal = false;
                                            break;

                                        default:
                                            System.out.println("Seleccione una opción válida del menú principal");
                                            break;
                                    }

                                } catch (Exception NumberFormatException) {
                                    System.out.println("Seleccione un número");
                                }
                            }

                        } else {
                            System.out.println("Usuario no encontrado o inexistente");
                        }

                        break;

                    case 2:
                        System.out.println("\n---REGISTRO---");
                        System.out.print("Username: ");
                        String username = input.nextLine();

                        System.out.print("Contraseña: ");
                        String password = input.nextLine();

                        System.out.println("\n---TIPO DE USUARIO---");
                        System.out.println("1. Premium");
                        System.out.println("2. Base");
                        System.out.print("Seleccione el tipo de usuario: ");
                        String tipoUsuario = input.nextLine();

                        try {
                            int tipo = Integer.parseInt(tipoUsuario);

                            switch (tipo) {
                                case 1:
                                    kayak.registroUsuario(username, password, "Premium");
                                    System.out.println("¡Usuario premium registrado con éxito!");
                                    break;

                                case 2:
                                    kayak.registroUsuario(username, password, "Base");
                                    System.out.println("¡Usuario base registrado con éxito!");
                                    break;

                                default:
                                    System.out.println("Seleccione premium o base");
                                    break;
                            }

                        } catch (Exception NumberFormatException) {
                            System.out.println("Seleccione un tipo de usuario válido");
                        }

                        break;

                    case 3:
                        seguir = false;
                        break;

                    default:
                        System.out.println("Seleccione una de las opciones del menú");
                        break;
                }

            } catch (Exception NumberFormatException) {
                System.out.println("Debe seleccionar un número");

            }
        }

        input.close();
    }

}
