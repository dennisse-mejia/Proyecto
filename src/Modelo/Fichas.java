package Modelo;

import Modelo.Ruta;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Random;

public class Fichas {

    public static void colocarFichas(JButton[][] tablero) {
        Random aleatorio = new Random();
        ArrayList<Icon> usados = new ArrayList<>();

        // Definición de iconos para los héroes y villanos por rango
        Icon[] rango10Heroes = cargarIconos(new String[]{
            Ruta.MrFantastic
        });

        Icon[] rango9Heroes = cargarIconos(new String[]{
            Ruta.CaptainAmerica
        });

        Icon[] rango8Heroes = cargarIconos(new String[]{
            Ruta.NickFury, Ruta.ProfessorX
        });

        Icon[] rango7Heroes = cargarIconos(new String[]{
            Ruta.SpiderMan, Ruta.Wolverine, Ruta.Namor
        });

        Icon[] rango6Heroes = cargarIconos(new String[]{
            Ruta.Daredevil, Ruta.SilverSurfer, Ruta.Hulk, Ruta.IronMan
        });

        Icon[] rango5Heroes = cargarIconos(new String[]{
            Ruta.Thor, Ruta.HumanTorch, Ruta.Cyclops, Ruta.InvisibleWoman
        });

        Icon[] rango4Heroes = cargarIconos(new String[]{
            Ruta.GhostRider, Ruta.Punisher, Ruta.Blade, Ruta.Thing
        });

        Icon[] rango3Heroes = cargarIconos(new String[]{
            Ruta.EmmaFrost, Ruta.SheHulk, Ruta.GiantMan, Ruta.Beast, Ruta.Colossus
        });

        Icon[] rango2Heroes = cargarIconos(new String[]{
            Ruta.Gambit, Ruta.SpiderGirl, Ruta.IceMan, Ruta.Storm, Ruta.Phoenix, Ruta.DrStrange, Ruta.Elektra, Ruta.Nightcrawler
        });

        Icon[] rango1Heroes = cargarIconos(new String[]{
            Ruta.BlackWidowHero
        });

        Icon[] rango10Villains = cargarIconos(new String[]{
            Ruta.DrDoom
        });

        Icon[] rango9Villains = cargarIconos(new String[]{
            Ruta.Galactus
        });

        Icon[] rango8Villains = cargarIconos(new String[]{
            Ruta.Kingpin, Ruta.Magneto
        });

        Icon[] rango7Villains = cargarIconos(new String[]{
            Ruta.Apocalypse, Ruta.GreenGoblin, Ruta.Venom
        });

        Icon[] rango6Villains = cargarIconos(new String[]{
            Ruta.Bullseye, Ruta.OmegaRed, Ruta.Onslaught, Ruta.RedSkull
        });

        Icon[] rango5Villains = cargarIconos(new String[]{
            Ruta.Mystique, Ruta.Mysterio, Ruta.DrOctopus, Ruta.Deadpool
        });

        Icon[] rango4Villains = cargarIconos(new String[]{
            Ruta.Abomination, Ruta.Thanos, Ruta.BlackCat, Ruta.Sabretooth
        });

        Icon[] rango3Villains = cargarIconos(new String[]{
            Ruta.Juggernaut, Ruta.Rhino, Ruta.Carnage, Ruta.MoleMan, Ruta.Lizard
        });

        Icon[] rango2Villains = cargarIconos(new String[]{
            Ruta.MrSinister, Ruta.Sentinel1, Ruta.Sentinel2, Ruta.Ultron, Ruta.Sandman, Ruta.Leader, Ruta.Viper, Ruta.Electro
        });

        Icon[] rango1Villains = cargarIconos(new String[]{
            Ruta.BlackWidowVillain
        });

        Icon[] todosHeroes = concat(rango10Heroes, rango9Heroes, rango8Heroes, rango7Heroes, rango6Heroes, rango5Heroes, rango4Heroes, rango3Heroes, rango2Heroes, rango1Heroes);
        Icon[] todosVillains = concat(rango10Villains, rango9Villains, rango8Villains, rango7Villains, rango6Villains, rango5Villains, rango4Villains, rango3Villains, rango2Villains, rango1Villains);

        // Iconos de PlanetEarth y sus fichas alrededor
        Icon planetEarthHero = new ImageIcon(Fichas.class.getResource(Ruta.PlanetEarthHeroes));
        Icon planetEarthVillain = new ImageIcon(Fichas.class.getResource(Ruta.PlanetEarthVillains));
        Icon novaBlast = new ImageIcon(Fichas.class.getResource(Ruta.NovaBlast));
        Icon pumpkinBomb = new ImageIcon(Fichas.class.getResource(Ruta.PumpkinBomb));

        // Colocar PlanetEarthHero en la fila 0 (evitar columnas 0 y 9)
        int columnaHero;
        do {
            columnaHero = aleatorio.nextInt(8) + 1; // Rango [1, 8]
        } while (tablero[0][columnaHero].getIcon() != null);
        tablero[0][columnaHero].setIcon(planetEarthHero);
        colocarFichasAlrededorHero(tablero, 0, columnaHero, novaBlast);

        // Colocar PlanetEarthVillain en la fila 9 (evitar columnas 0 y 9)
        int columnaVillain;
        do {
            columnaVillain = aleatorio.nextInt(8) + 1; // Rango [1, 8]
        } while (tablero[9][columnaVillain].getIcon() != null);
        tablero[9][columnaVillain].setIcon(planetEarthVillain);
        colocarFichasAlrededorVillain(tablero, 9, columnaVillain, pumpkinBomb);

        // Colocar 3 NovaBlast aleatoriamente en las filas 0 y 1
        colocarFichasAleatorias(tablero, novaBlast, aleatorio, 3, 0, 1);

        // Colocar 3 PumpkinBomb aleatoriamente en las filas 8 y 9
        colocarFichasAleatorias(tablero, pumpkinBomb, aleatorio, 3, 8, 9);

        // Colocar las fichas de rango 2 héroes en las filas 2 y 3
        colocarFichasPorRango(tablero, rango2Heroes, aleatorio, 2, 3, usados);

        // Colocar las fichas de rango 2 villanos en las filas 6 y 7
        colocarFichasPorRango(tablero, rango2Villains, aleatorio, 6, 7, usados);

        // Colocar las demás fichas de héroes no utilizadas aleatoriamente en los espacios vacíos de las filas 0 a 3
        for (Icon icono : todosHeroes) {
            if (!usados.contains(icono)) {
                colocarFichaEnRango(tablero, icono, aleatorio, 0, 3);
            }
        }

        // Colocar las demás fichas de villanos no utilizadas aleatoriamente en los espacios vacíos de las filas 6 a 9
        for (Icon icono : todosVillains) {
            if (!usados.contains(icono)) {
                colocarFichaEnRango(tablero, icono, aleatorio, 6, 9);
            }
        }
    }

    private static Icon[] cargarIconos(String[] rutas) {
        Icon[] iconos = new Icon[rutas.length];
        for (int i = 0; i < rutas.length; i++) {
            java.net.URL imgURL = Fichas.class.getResource(rutas[i]);
            if (imgURL != null) {
                iconos[i] = new ImageIcon(imgURL);
            } else {
                System.err.println("No se pudo encontrar el recurso: " + rutas[i]);
                iconos[i] = null; // Puede asignar un icono por defecto si es necesario
            }
        }
        return iconos;
    }

    private static void colocarFichasPorRango(JButton[][] tablero, Icon[] fichas, Random aleatorio, int filaInicio, int filaFin, ArrayList<Icon> usados) {
        for (Icon ficha : fichas) {
            if (ficha != null) {
                colocarFichaEnRango(tablero, ficha, aleatorio, filaInicio, filaFin);
                usados.add(ficha);
            }
        }
    }

    private static void colocarFichaEnRango(JButton[][] tablero, Icon icono, Random aleatorio, int filaInicio, int filaFin) {
        int fila, columna;

        do {
            fila = aleatorio.nextInt((filaFin - filaInicio) + 1) + filaInicio;
            columna = aleatorio.nextInt(tablero[0].length);
        } while (tablero[fila][columna].getIcon() != null || esPosicionRestringida(fila, columna));

        tablero[fila][columna].setIcon(icono);
    }

    private static boolean esPosicionRestringida(int fila, int columna) {
        // Evitar posiciones específicas
        return (fila == 4 || fila == 5);
    }

    private static void colocarFichasAlrededorHero(JButton[][] tablero, int fila, int columna, Icon icono) {
        if (columna > 0 && tablero[fila][columna - 1].getIcon() == null) {
            tablero[fila][columna - 1].setIcon(icono); // Izquierda
        }
        if (columna < tablero[0].length - 1 && tablero[fila][columna + 1].getIcon() == null) {
            tablero[fila][columna + 1].setIcon(icono); // Derecha
        }
        if (fila < tablero.length - 1 && tablero[fila + 1][columna].getIcon() == null) {
            tablero[fila + 1][columna].setIcon(icono); // Enfrente
        }
    }

    private static void colocarFichasAlrededorVillain(JButton[][] tablero, int fila, int columna, Icon icono) {
        if (columna > 0 && tablero[fila][columna - 1].getIcon() == null) {
            tablero[fila][columna - 1].setIcon(icono); // Izquierda
        }
        if (columna < tablero[0].length - 1 && tablero[fila][columna + 1].getIcon() == null) {
            tablero[fila][columna + 1].setIcon(icono); // Derecha
        }
        if (fila > 0 && tablero[fila - 1][columna].getIcon() == null) {
            tablero[fila - 1][columna].setIcon(icono); // Enfrente
        }
    }

    private static void colocarFichasAleatorias(JButton[][] tablero, Icon icono, Random aleatorio, int cantidad, int filaInicio, int filaFin) {
        int colocadas = 0;
        while (colocadas < cantidad) {
            int fila = aleatorio.nextInt((filaFin - filaInicio) + 1) + filaInicio;
            int columna = aleatorio.nextInt(tablero[0].length);
            if (tablero[fila][columna].getIcon() == null) {
                tablero[fila][columna].setIcon(icono);
                colocadas++;
            }
        }
    }

    private static Icon[] concat(Icon[]... arrays) {
        int length = 0;
        for (Icon[] array : arrays) {
            length += array.length;
        }
        Icon[] result = new Icon[length];
        int pos = 0;
        for (Icon[] array : arrays) {
            for (Icon element : array) {
                result[pos++] = element;
            }
        }
        return result;
    }

}
