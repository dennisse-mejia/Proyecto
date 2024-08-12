package Modelo;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ataques {

    private static int indiceHeroeVencido = 0;
    private static int indiceVillanoVencido = 0;

    public static boolean atacar(JButton[][] tablero, JButton origen, JButton destino, JPanel heroesVencidos, JPanel villanosVencidos) {
        Icon iconoAtacante = origen.getIcon();
        Icon iconoDefensor = destino.getIcon();

        if (iconoAtacante != null && iconoDefensor != null) {
            int rangoAtacante = obtenerRango(iconoAtacante);
            int rangoDefensor = obtenerRango(iconoDefensor);

            if (esOponente(iconoAtacante, iconoDefensor) && esAdyacenteOrtogonalmente(tablero, origen, destino)) {
                String nombreAtacante = extraerNombreIcono(iconoAtacante.toString());
                String nombreDefensor = extraerNombreIcono(iconoDefensor.toString());
                String resultado;

                if (esPumpkinBomb(iconoDefensor) || esNovaBlast(iconoDefensor)) {
                    if (esRango3Heroe(iconoAtacante) || esRango3Villano(iconoAtacante)) {
                        destino.setIcon(iconoAtacante); // Mover atacante a la posición del defensor

                        destino.setIcon(null); // Eliminar PumpkinBomb o NovaBlast
                        resultado = String.format("%s vs %s . Ganó %s", nombreAtacante, nombreDefensor, nombreAtacante);
                        mostrarDetalleAtaque(resultado);
                        agregarFichaVencida(heroesVencidos, villanosVencidos, nombreDefensor, false);

                        return true;
                    } else {
                        origen.setIcon(null); // Eliminar ficha atacante
                        resultado = String.format("%s vs %s . Ganó %s", nombreAtacante, nombreDefensor, nombreDefensor);

                        mostrarDetalleAtaque(resultado);
                        agregarFichaVencida(heroesVencidos, villanosVencidos, nombreAtacante, true);

                        return true;
                    }
                } else {
                    if (rangoAtacante == 1 && rangoDefensor == 10) {
                        destino.setIcon(iconoAtacante); // Mover atacante a la posición del defensor

                        destino.setIcon(null); // Eliminar ficha defensora
                        resultado = String.format("%s vs %s . Ganó %s", nombreAtacante, nombreDefensor, nombreAtacante);
                        mostrarDetalleAtaque(resultado);
                        agregarFichaVencida(heroesVencidos, villanosVencidos, nombreDefensor, false);

                        return true;
                    } else if (rangoAtacante > rangoDefensor) {
                        destino.setIcon(iconoAtacante); // Mover atacante a la posición del defensor

                        destino.setIcon(null); // Eliminar ficha defensora
                        resultado = String.format("%s vs %s . Ganó %s", nombreAtacante, nombreDefensor, nombreAtacante);
                        mostrarDetalleAtaque(resultado);
                        agregarFichaVencida(heroesVencidos, villanosVencidos, nombreDefensor, false);

                        return true;
                    } else if (rangoAtacante == rangoDefensor) {

                        origen.setIcon(null); // Eliminar ficha atacante
                        destino.setIcon(null); // Eliminar ficha defensora
                        resultado = String.format("%s vs %s . Rangos iguales, ambos son vencidos", nombreAtacante, nombreDefensor);
                        agregarFichaVencida(heroesVencidos, villanosVencidos, nombreAtacante, true);
                        agregarFichaVencida(heroesVencidos, villanosVencidos, nombreDefensor, false);

                        mostrarDetalleAtaque(resultado);

                        return true;
                    } else {
                        // No se puede atacar si el rango del atacante es menor que el del defensor
                        return false;
                    }
                }
            }
        }

        return false;
    }

    private static String extraerNombreIcono(String rutaIcono) {
        String[] partes = rutaIcono.split("/");
        String nombreArchivo = partes[partes.length - 1];
        return nombreArchivo.split("\\.")[0];
    }

    private static void agregarFichaVencida(JPanel heroesVencidos, JPanel villanosVencidos, String nombreFicha, boolean atacante) {
        String nombreFichaVencida = nombreFicha + "S";
        Icon iconoVencido = new ImageIcon(Ataques.class.getResource("/resources/" + nombreFichaVencida + ".png"));

        if (esHeroe(nombreFicha)) {
            if (indiceHeroeVencido < heroesVencidos.getComponentCount()) {
                ((JButton) heroesVencidos.getComponent(indiceHeroeVencido)).setIcon(iconoVencido);
                indiceHeroeVencido++;
            }
        } else {
            if (indiceVillanoVencido < villanosVencidos.getComponentCount()) {
                ((JButton) villanosVencidos.getComponent(indiceVillanoVencido)).setIcon(iconoVencido);
                indiceVillanoVencido++;
            }
        }
    }

    public static void reiniciarIndicesFichasVencidas() {
        indiceHeroeVencido = 0;
        indiceVillanoVencido = 0;
    }

    private static void mostrarDetalleAtaque(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Detalle del Ataque", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean esOponente(Icon atacante, Icon defensor) {
        String nombreAtacante = atacante.toString();
        String nombreDefensor = defensor.toString();

        boolean atacanteEsHeroe = esHeroe(nombreAtacante);
        boolean defensorEsHeroe = esHeroe(nombreDefensor);

        // Retornar true si uno es héroe y el otro es villano
        return atacanteEsHeroe != defensorEsHeroe;
    }

    private static boolean esHeroe(String nombreIcono) {
        // Verificar si el nombre del icono pertenece a los héroes
        return nombreIcono.contains("BlackWidowHero") || nombreIcono.contains("CaptainAmerica")
                || nombreIcono.contains("DrStrange") || nombreIcono.contains("Elektra")
                || nombreIcono.contains("EmmaFrost") || nombreIcono.contains("Daredevil")
                || nombreIcono.contains("Gambit") || nombreIcono.contains("Hulk")
                || nombreIcono.contains("HumanTorch") || nombreIcono.contains("IceMan")
                || nombreIcono.contains("InvisibleWoman") || nombreIcono.contains("IronMan")
                || nombreIcono.contains("NickFury") || nombreIcono.contains("Wolverine")
                || nombreIcono.contains("Blade") || nombreIcono.contains("SpiderMan")
                || nombreIcono.contains("Thor") || nombreIcono.contains("ProfessorX")
                || nombreIcono.contains("Namor") || nombreIcono.contains("SilverSurfer")
                || nombreIcono.contains("Cyclops") || nombreIcono.contains("GhostRider")
                || nombreIcono.contains("Punisher") || nombreIcono.contains("Thing")
                || nombreIcono.contains("SheHulk") || nombreIcono.contains("Beast")
                || nombreIcono.contains("GiantMan") || nombreIcono.contains("Colossus")
                || nombreIcono.contains("SpiderGirl") || nombreIcono.contains("Storm")
                || nombreIcono.contains("Phoenix") || nombreIcono.contains("Nightcrawler")
                || nombreIcono.contains("NovaBlast") || nombreIcono.contains("PlanetEarthHeroes")
                || nombreIcono.contains("MrFantastic");
    }

    private static boolean esRangoSuperior(Icon atacante, Icon defensor) {
        return obtenerRango(atacante) > obtenerRango(defensor);
    }

    public static int obtenerRango(Icon icono) {
        String iconoNombre = icono.toString();
        if (iconoNombre.contains("MrFantastic") || iconoNombre.contains("DrDoom")) {
            return 10;
        }
        if (iconoNombre.contains("CaptainAmerica") || iconoNombre.contains("Galactus")) {
            return 9;
        }
        if (iconoNombre.contains("NickFury") || iconoNombre.contains("ProfessorX") || iconoNombre.contains("Kingpin") || iconoNombre.contains("Magneto")) {
            return 8;
        }
        if (iconoNombre.contains("SpiderMan") || iconoNombre.contains("Wolverine") || iconoNombre.contains("Namor") || iconoNombre.contains("Apocalypse") || iconoNombre.contains("GreenGoblin") || iconoNombre.contains("Venom")) {
            return 7;
        }
        if (iconoNombre.contains("Daredevil") || iconoNombre.contains("SilverSurfer") || iconoNombre.contains("Hulk") || iconoNombre.contains("IronMan") || iconoNombre.contains("Bullseye") || iconoNombre.contains("OmegaRed") || iconoNombre.contains("Onslaught") || iconoNombre.contains("RedSkull")) {
            return 6;
        }
        if (iconoNombre.contains("Thor") || iconoNombre.contains("HumanTorch") || iconoNombre.contains("Cyclops") || iconoNombre.contains("InvisibleWoman") || iconoNombre.contains("Mystique") || iconoNombre.contains("Mysterio") || iconoNombre.contains("DrOctopus") || iconoNombre.contains("Deadpool")) {
            return 5;
        }
        if (iconoNombre.contains("GhostRider") || iconoNombre.contains("Punisher") || iconoNombre.contains("Blade") || iconoNombre.contains("Thing") || iconoNombre.contains("Abomination") || iconoNombre.contains("Thanos") || iconoNombre.contains("BlackCat") || iconoNombre.contains("Sabretooth")) {
            return 4;
        }
        if (iconoNombre.contains("EmmaFrost") || iconoNombre.contains("SheHulk") || iconoNombre.contains("GiantMan") || iconoNombre.contains("Beast") || iconoNombre.contains("Colossus") || iconoNombre.contains("Juggernaut") || iconoNombre.contains("Rhino") || iconoNombre.contains("Carnage") || iconoNombre.contains("MoleMan") || iconoNombre.contains("Lizard")) {
            return 3;
        }
        if (iconoNombre.contains("Gambit") || iconoNombre.contains("SpiderGirl") || iconoNombre.contains("IceMan") || iconoNombre.contains("Storm") || iconoNombre.contains("Phoenix") || iconoNombre.contains("DrStrange") || iconoNombre.contains("Elektra") || iconoNombre.contains("Nightcrawler") || iconoNombre.contains("MrSinister") || iconoNombre.contains("Sentinel1") || iconoNombre.contains("Sentinel2") || iconoNombre.contains("Ultron") || iconoNombre.contains("Sandman") || iconoNombre.contains("Leader") || iconoNombre.contains("Viper") || iconoNombre.contains("Electro")) {
            return 2;
        }
        if (iconoNombre.contains("BlackWidowHero") || iconoNombre.contains("BlackWidowVillain")) {
            return 1;
        }
        return 0; // Rango no identificado
    }

    private static boolean esAdyacenteOrtogonalmente(JButton[][] tablero, JButton origen, JButton destino) {
        int[] origenPos = encontrarPosicion(tablero, origen);
        int[] destinoPos = encontrarPosicion(tablero, destino);

        if (origenPos != null && destinoPos != null) {
            int filaOrigen = origenPos[0];
            int colOrigen = origenPos[1];
            int filaDestino = destinoPos[0];
            int colDestino = destinoPos[1];

            // Verifica si el destino está ortogonalmente adyacente
            return (filaOrigen == filaDestino && Math.abs(colOrigen - colDestino) == 1)
                    || (colOrigen == colDestino && Math.abs(filaOrigen - filaDestino) == 1);
        }
        return false;
    }

    private static int[] encontrarPosicion(JButton[][] tablero, JButton boton) {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int col = 0; col < tablero[fila].length; col++) {
                if (tablero[fila][col] == boton) {
                    return new int[]{fila, col};
                }
            }
        }
        return null;
    }

    private static boolean esPumpkinBomb(Icon icono) {
        return icono.toString().contains("PumpkinBomb");
    }

    private static boolean esNovaBlast(Icon icono) {
        return icono.toString().contains("NovaBlast");
    }

    private static boolean esRango3Heroe(Icon icono) {
        String iconoNombre = icono.toString();
        return iconoNombre.contains("EmmaFrost") || iconoNombre.contains("SheHulk")
                || iconoNombre.contains("GiantMan") || iconoNombre.contains("Beast")
                || iconoNombre.contains("Colossus");
    }

    private static boolean esRango3Villano(Icon icono) {
        String iconoNombre = icono.toString();
        return iconoNombre.contains("Juggernaut") || iconoNombre.contains("Rhino")
                || iconoNombre.contains("Carnage") || iconoNombre.contains("MoleMan")
                || iconoNombre.contains("Lizard");
    }

    public static boolean esCasillaDeAtaqueValida(JButton[][] tablero, JButton origen, JButton destino) {
        Icon iconoAtacante = origen.getIcon();
        Icon iconoDefensor = destino.getIcon();

        if (iconoAtacante != null && iconoDefensor != null) {
            int rangoAtacante = obtenerRango(iconoAtacante);
            int rangoDefensor = obtenerRango(iconoDefensor);

            if (esOponente(iconoAtacante, iconoDefensor) && esAdyacenteOrtogonalmente(tablero, origen, destino)) {
                if (esPumpkinBomb(iconoDefensor) || esNovaBlast(iconoDefensor)) {
                    // Permitir cualquier ataque ortogonal a PumpkinBomb o NovaBlast
                    return true;
                } else {
                    if (rangoAtacante == 1 && rangoDefensor == 10) {
                        return true;
                    } else if (rangoAtacante > rangoDefensor) {
                        return true;
                    } else if (rangoAtacante == rangoDefensor) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
