/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class loginUser {

    private String usuario;
    private String password;
    private int puntos;
    private String fechaIngreso;
    private boolean activo;
    public static String[] usuarios = new String[100];
    private static String[] contraseñas = new String[100];
    public static int[] puntosArr = new int[100];
    private static String[] fechasIngreso = new String[100];
    public static boolean[] activos = new boolean[100];
    private static String[] posiciones = new String[100]; // Nuevo arreglo para posiciones de usuarios
    private static int[] totalPartidas = new int[100];
    private static int[] partidasHeroes = new int[100];
    private static int[] partidasVillanos = new int[100];

    public static int count = 0;
    private static String usuarioLogueado;

    private static String[] bandosSeleccionados = new String[100]; // Arreglo para almacenar los bandos seleccionados
    public static String[][] logs = new String[100][100]; // Arreglo para guardar los logs de cada usuario
    public static int[] logsCount = new int[100]; // Contador de logs por usuario
    private static final int MAX_USERS = 100; // O el número máximo de usuarios que deseas permitir

    private static int[] victoriasHeroes = new int[MAX_USERS];
    private static int[] victoriasVillanos = new int[MAX_USERS];

    public loginUser() {
    }

    public loginUser(String user, String password) {
        this.usuario = user;
        this.password = password;
        this.puntos = 0;
        this.fechaIngreso = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.activo = true;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public boolean ingreso(String usuario, String password) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuario) && contraseñas[i].equals(password) && activos[i]) {
                String message = "Bienvenido " + usuario;
                System.out.println(message);
                JOptionPane.showMessageDialog(null, message);
                usuarioLogueado = usuario;
                return true;
            }
        }
        String message = "Nombre de usuario o contraseña no válidos";
        System.out.println(message);
        JOptionPane.showMessageDialog(null, message);
        return false;
    }

    public boolean crearUsuario(String usuario, String password) {
        if (usuario.length() == 0 || password.length() != 5) {
            JOptionPane.showMessageDialog(null, "Contraseña no válida, debe tener exactamente 5 caracteres.");
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuario)) {
                if (activos[i]) {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe, favor elegir otro nombre de usuario.");
                    return false;
                } else {
                    // Resetear los datos del usuario existente
                    contraseñas[i] = password;
                    puntosArr[i] = 0;
                    activos[i] = true;
                    posiciones[i] = String.valueOf(i + 1);
                    totalPartidas[i] = 0;
                    partidasHeroes[i] = 0;
                    partidasVillanos[i] = 0;
                    logs[i] = new String[100];
                    logsCount[i] = 0;
                    victoriasHeroes[i] = 0;
                    victoriasVillanos[i] = 0;

                    usuarioLogueado = usuario;
                    return true;
                }
            }
        }

        // Código existente para crear un nuevo usuario si no existía
        if (count < usuarios.length) {
            usuarios[count] = usuario;
            contraseñas[count] = password;
            puntosArr[count] = 0;
            fechasIngreso[count] = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            activos[count] = true;
            posiciones[count] = String.valueOf(count + 1);

            count++;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más usuarios.");
            return false;
        }
    }

    public static boolean cambiarContraseña(String contraseñaActual, String nuevaContraseña) {
        if (nuevaContraseña.length() != 5) {
            JOptionPane.showMessageDialog(null, "Nueva contraseña no válida, debe tener exactamente 5 caracteres.");
            return false;
        }

        if (contraseñaActual.equalsIgnoreCase(nuevaContraseña)) {
            JOptionPane.showMessageDialog(null, "La nueva contraseña no puede ser la misma que la contraseña actual.");
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuarioLogueado)) {
                if (contraseñas[i].equals(contraseñaActual)) {
                    contraseñas[i] = nuevaContraseña;
                    JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta.");
                    return false;
                }
            }
        }
        return false;
    }

    public static String[] obtenerOponentesDisponibles() {
        if (count <= 1) {
            return new String[0];
        }

        int countOponentes = 0;
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && !usuarios[i].equalsIgnoreCase(usuarioLogueado) && activos[i]) {
                countOponentes++;
            }
        }

        if (countOponentes == 0) {
            return new String[0];
        }

        String[] oponentesDisponibles = new String[countOponentes];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && !usuarios[i].equalsIgnoreCase(usuarioLogueado) && activos[i]) {
                oponentesDisponibles[index++] = usuarios[i];
            }
        }
        return oponentesDisponibles;
    }

    public static String obtenerUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static String obtenerBandoSeleccionado() {
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuarioLogueado)) {
                return bandosSeleccionados[i];
            }
        }
        return null;
    }

    public static void establecerBandoSeleccionado(String bando) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuarioLogueado)) {
                bandosSeleccionados[i] = bando;
                break;
            }
        }
    }

    public static void sumarPuntosAlJugador(String jugador, int puntos) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(jugador)) {
                puntosArr[i] += puntos;
                break;
            }
        }
    }

    public static boolean eliminarCuenta(String contraseña) {
        if (usuarioLogueado == null) {
            JOptionPane.showMessageDialog(null, "No hay ningún usuario logueado.");
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuarioLogueado)) {
                if (contraseñas[i].equals(contraseña)) {
                    // Eliminar completamente los datos del usuario
                    usuarios[i] = null;
                    contraseñas[i] = null;
                    puntosArr[i] = 0;
                    activos[i] = false;
                    posiciones[i] = null;
                    logs[i] = new String[100];
                    logsCount[i] = 0;
                    victoriasHeroes[i] = 0;
                    victoriasVillanos[i] = 0;
                    // Globales Batallas 
                    //totalPartidas[i] = 0;
                    //partidasHeroes[i] = 0;
                    //partidasVillanos[i] = 0;

                    usuarioLogueado = null;
                    JOptionPane.showMessageDialog(null, "Cuenta eliminada exitosamente.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
                    return false;
                }
            }
        }
        return false;
    }

    public static int obtenerPuntos() {
        String usuario = obtenerUsuarioLogueado();
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuario)) {
                return puntosArr[i];
            }
        }
        return 0;
    }

    public static int obtenerTotalPartidas() {
        String usuario = obtenerUsuarioLogueado();
        int totalPartidas = 0;
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuario)) {
                totalPartidas = logsCount[i];
                break;
            }
        }
        return totalPartidas;
    }

    public static int obtenerPartidasHeroes() {
        String usuario = obtenerUsuarioLogueado();
        int partidasHeroes = 0;
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuario)) {
                for (int j = 0; j < logsCount[i]; j++) {
                    // Count only logs with "Heroes" and the logged-in user
                    if (logs[i][j] != null && logs[i][j].contains("Bando: Heroes")) {
                        partidasHeroes++;
                    }
                }
                break;
            }
        }
        return partidasHeroes;
    }

    public static int obtenerPartidasVillanos() {
        String usuario = obtenerUsuarioLogueado();
        int partidasVillanos = 0;
        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuario)) {
                for (int j = 0; j < logsCount[i]; j++) {
                    // Count only logs with "Villanos" and the logged-in user
                    if (logs[i][j] != null && logs[i][j].contains("Bando: Villanos")) {
                        partidasVillanos++;
                    }
                }
                break;
            }
        }
        return partidasVillanos;
    }

    public static void incrementarTotalPartidas() {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(usuarioLogueado)) {
                totalPartidas[i]++;
                break;
            }
        }
    }

    public static void incrementarPartidasHeroes() {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(usuarioLogueado)) {
                partidasHeroes[i]++;
                break;
            }
        }
    }

    public static void incrementarPartidasVillanos() {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(usuarioLogueado)) {
                partidasVillanos[i]++;
                break;
            }
        }
    }

    public static void registrarPartidaJugado(String usuario, String bando, boolean victoria, boolean actualizarGlobal, String logMessage) { // Bandera para asegurar que la partida solo se registre una vez

        for (int i = 0; i < count; i++) {
            if (usuarios[i] != null && usuarios[i].equalsIgnoreCase(usuario)) {
                String logFormateado = "- " + "Bando: " + bando + " - " + logMessage + "\n\n";
                if (logs[i] == null) {
                    logs[i] = new String[100];
                }
                logs[i][logsCount[i]] = logFormateado;
                logsCount[i]++;

                // Update global stats if needed
                if (actualizarGlobal) {
                    if (bando.equalsIgnoreCase("Heroes")) {
                        partidasHeroes[i]++;
                        if (victoria) {
                            victoriasHeroes[i]++;
                        }
                    } else if (bando.equalsIgnoreCase("Villanos")) {  // Ensure this condition only applies to Villains
                        partidasVillanos[i]++;
                        if (victoria) {
                            victoriasVillanos[i]++;
                        }
                    }
                    totalPartidas[i]++;  // This should be the total of all games, so it’s fine to increment
                }
                break;
            }
        }
    }
// Batallas Datos 

    public static int getCantidadUsuariosActivos() {
        int countActivos = 0;
        for (boolean activo : activos) {
            if (activo) {
                countActivos++;
            }
        }
        return countActivos;
    }

    public static int getCantidadUsuariosHistoricos() {
        return count; // Suponiendo que count incluye a los usuarios eliminados
    }

    public static int getCantidadPartidasJugadas() {
        int totalPartidasJugadas = 0;
        for (int partidas : totalPartidas) {
            totalPartidasJugadas += partidas;
        }
        return totalPartidasJugadas;
    }

    public static int getCantidadGanadasHeroes() {
        int totalGanadasHeroes = 0;
        for (int ganadas : partidasHeroes) {
            totalGanadasHeroes += ganadas;
        }
        return totalGanadasHeroes;
    }

    public static int getCantidadGanadasVillanos() {
        int totalGanadasVillanos = 0;
        for (int ganadas : partidasVillanos) {
            totalGanadasVillanos += ganadas;
        }
        return totalGanadasVillanos;
    }

    public static int obtenerVictoriasHeroes() {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(obtenerUsuarioLogueado())) {
                return victoriasHeroes[i];
            }
        }
        return 0;
    }

    public static int obtenerVictoriasVillanos() {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(obtenerUsuarioLogueado())) {
                return victoriasVillanos[i];
            }
        }
        return 0;
    }
}
