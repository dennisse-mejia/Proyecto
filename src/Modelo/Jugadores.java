/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Ruta;
import Modelo.loginUser;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Dennisse
 */
public class Jugadores {

    private String jugador1; // El jugador logueado
    private String jugador2; // El oponente
    private boolean turnoJugador1;

    private static final String[] HEROES = {
        "BlackWidowHero", "CaptainAmerica", "DrStrange", "Elektra", "EmmaFrost", "Daredevil",
        "Gambit", "Hulk", "HumanTorch", "IceMan", "InvisibleWoman", "IronMan", "NickFury",
        "Wolverine", "Blade", "SpiderMan", "Thor", "ProfessorX", "Namor", "SilverSurfer",
        "Cyclops", "GhostRider", "Punisher", "Thing", "SheHulk", "Beast", "GiantMan", "Colossus",
        "SpiderGirl", "Storm", "Phoenix", "Nightcrawler", "NovaBlast", "PlanetEarthHeroes", "MrFantastic"
    };

    private static final String[] VILLANOS = {
        "Abomination", "Apocalypse", "BlackCat", "BlackWidowVillain", "Bullseye", "Carnage",
        "Deadpool", "DrDoom", "DrOctopus", "Electro", "Galactus", "GreenGoblin", "Juggernaut",
        "Kingpin", "Leader", "Lizard", "Magneto", "MoleMan", "MrSinister", "Mysterio",
        "Mystique", "OmegaRed", "Onslaught", "PlanetEarthVillains", "PumpkinBomb", "RedSkull",
        "Rhino", "Sabretooth", "Sandman", "Sentinel1", "Sentinel2", "Thanos", "Ultron",
        "Venom", "Viper"
    };

    public Jugadores(String jugador2) {
        this.jugador1 = loginUser.obtenerUsuarioLogueado(); // Usuario logueado como jugador 1
        this.jugador2 = jugador2;
        this.turnoJugador1 = true; // El jugador 1 (logueado) empieza primero
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public boolean esTurnoJugador1() {
        return turnoJugador1;
    }

    public void cambiarTurno() {
        turnoJugador1 = !turnoJugador1;
    }

    public String obtenerRutaImagen(String pieza) {
        if (esHeroe(pieza)) {
            return obtenerRutaImagenHeroe(pieza);
        } else if (esVillano(pieza)) {
            return obtenerRutaImagenVillano(pieza);
        } else {
            return Ruta.MrFantastic; // Ruta por defecto si no se encuentra
        }
    }

    private boolean esHeroe(String pieza) {
        for (String heroe : HEROES) {
            if (heroe.equals(pieza)) {
                return true;
            }
        }
        return false;
    }

    private boolean esVillano(String pieza) {
        for (String villano : VILLANOS) {
            if (villano.equals(pieza)) {
                return true;
            }
        }
        return false;
    }

    private String obtenerRutaImagenHeroe(String pieza) {
        try {
            java.lang.reflect.Field field = Ruta.class.getDeclaredField(pieza);
            return (String) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Ruta.MrFantastic; // Ruta por defecto si no se encuentra
        }
    }

    private String obtenerRutaImagenVillano(String pieza) {
        try {
            java.lang.reflect.Field field = Ruta.class.getDeclaredField(pieza);
            return (String) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Ruta.MrFantastic; // Ruta por defecto si no se encuentra
        }
    }
}
