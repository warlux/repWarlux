package com.warlux.domain.pistas.modelo;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PInterseccionTS1WayOE extends Modelo {

	public PInterseccionTS1WayOE() {
		super();
		nombre = "pInterseccionTS1WayOE";
		imagen = new ImageIcon(
				"src/main/resources/modeloPistas/pInterseccionTS1WayOE.png");
		Rectangle colision1 = new Rectangle(0, 0, 100, 30);
		Rectangle colision2 = new Rectangle(0, 70, 30, 30);
		Rectangle colision3 = new Rectangle(70, 70, 30, 30);
		colisiones = new ArrayList<>();
		colisiones.add(colision1);
		colisiones.add(colision2);
		colisiones.add(colision3);
		separadorSur = new Rectangle(30, 98, 40, 2);
		paseSur = new Rectangle(30, 72, 40, 25);
		separadorEste = new Rectangle(98, 30, 2, 40);
		paseEste = new Rectangle(72, 30, 25, 40);
		separadorOeste = new Rectangle(0, 30, 2, 40);
		paseOeste = new Rectangle(3, 30, 25, 40);
		paseInterseccionOeste = new Rectangle(27, 30, 3, 40);
		paseSurCondicional = new Rectangle(30, 70, 40, 3);
		interseccion = true;
	}

	public void cambiarImagenActivada() {
		imagen = new ImageIcon("src/main/resources/modeloPistasFocus/vpInterseccionTS1WayOE1.png");

	}

	public void cambiarImagenDesactivada() {
		imagen = new ImageIcon("src/main/resources/modeloPistas/pInterseccionTS1WayOE.png");

	}
	
	@Override
	public void cambiarImagenCondicional(){
		imagen = new ImageIcon("src/main/resources/modeloPistasFocus/vpInterseccionTS1WayOE2.png");
	}
}
