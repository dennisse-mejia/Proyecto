package Modelo;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Movimientos {

    private static final int[] POSICIONES_RESTRINGIDAS = {43, 44, 47, 48, 53, 54, 57, 58};
    // Métodos para mover fichas

    public static boolean intentarMoverFicha(JButton[][] tablero, JButton origen, JButton destino) {
        if (esMovimientoValido(tablero, origen, destino)) {
            moverFicha(tablero, origen, destino);
            return true;
        } else {
            return false;
        }
    }

    // Métodos para mover fichas
    public static void moverFicha(JButton[][] tablero, JButton origen, JButton destino) {
        // Verifica que el destino esté vacío y no esté restringido
        if (destino.getIcon() == null && !esPosicionRestringida(tablero, destino)) {
            // Mueve el ícono al botón de destino
            destino.setIcon(origen.getIcon());
            // Borra el ícono del botón de origen
            origen.setIcon(null);
        }
    }

    public static boolean esMovimientoValido(JButton[][] tablero, JButton origen, JButton destino) {
        if (esFichaRestringida(origen.getIcon())) {
            return false; // No permitir movimiento si la ficha es restringida
        }

        int filaOrigen = -1, columnaOrigen = -1, filaDestino = -1, columnaDestino = -1;

        // Encuentra la posición del botón origen y destino en la matriz
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int col = 0; col < tablero[fila].length; col++) {
                if (tablero[fila][col] == origen) {
                    filaOrigen = fila;
                    columnaOrigen = col;
                }
                if (tablero[fila][col] == destino) {
                    filaDestino = fila;
                    columnaDestino = col;
                }
            }
        }

        // Verifica que el destino esté vacío y no esté restringido
        if (filaDestino != -1 && columnaDestino != -1 && tablero[filaDestino][columnaDestino].getIcon() == null && !esPosicionRestringida(tablero, destino)) {
            if (esFichaRango2(origen.getIcon())) {
                return esMovimientoOrtogonalLargo(tablero, filaOrigen, columnaOrigen, filaDestino, columnaDestino);
            } else {
                return (Math.abs(filaDestino - filaOrigen) == 1 && columnaDestino == columnaOrigen)
                        || (Math.abs(columnaDestino - columnaOrigen) == 1 && filaDestino == filaOrigen);
            }
        }
        return false;
    }

    private static boolean esPosicionRestringida(JButton[][] tablero, JButton boton) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == boton) {
                    int posicion = i * 10 + j + 1; // Convertir a la posición en la matriz 1-100
                    for (int restringida : POSICIONES_RESTRINGIDAS) {
                        if (posicion == restringida) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean esFichaRestringida(Icon icono) {
        return icono != null && (icono.toString().contains("PlanetEarthHeroes")
                || icono.toString().contains("PlanetEarthVillains")
                || icono.toString().contains("NovaBlast")
                || icono.toString().contains("PumpkinBomb"));
    }

    private static boolean esFichaRango2(Icon icono) {
        return icono != null && (icono.toString().contains("Gambit")
                || icono.toString().contains("SpiderGirl")
                || icono.toString().contains("IceMan")
                || icono.toString().contains("Storm")
                || icono.toString().contains("Phoenix")
                || icono.toString().contains("DrStrange")
                || icono.toString().contains("Elektra")
                || icono.toString().contains("Nightcrawler")
                || icono.toString().contains("MrSinister")
                || icono.toString().contains("Sentinel1")
                || icono.toString().contains("Sentinel2")
                || icono.toString().contains("Ultron")
                || icono.toString().contains("Sandman")
                || icono.toString().contains("Leader")
                || icono.toString().contains("Viper")
                || icono.toString().contains("Electro"));
    }

    private static boolean esMovimientoOrtogonalLargo(JButton[][] tablero, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        if (filaOrigen == filaDestino) { // Movimiento horizontal
            int colStep = (columnaDestino > columnaOrigen) ? 1 : -1;
            for (int col = columnaOrigen + colStep; col != columnaDestino; col += colStep) {
                if (tablero[filaOrigen][col].getIcon() != null || esPosicionRestringida(tablero, tablero[filaOrigen][col])) {
                    return false;
                }
            }
            return true;
        } else if (columnaOrigen == columnaDestino) { // Movimiento vertical
            int rowStep = (filaDestino > filaOrigen) ? 1 : -1;
            for (int fila = filaOrigen + rowStep; fila != filaDestino; fila += rowStep) {
                if (tablero[fila][columnaOrigen].getIcon() != null || esPosicionRestringida(tablero, tablero[fila][columnaOrigen])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean hayMovimientosPrevios(JButton[][] tablero) {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int col = 0; col < tablero[fila].length; col++) {
                if (tablero[fila][col].getIcon() != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
