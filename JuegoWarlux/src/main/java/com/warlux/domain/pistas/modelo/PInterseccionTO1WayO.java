package com.warlux.domain.pistas.modelo;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PInterseccionTO1WayO extends Modelo {

	public PInterseccionTO1WayO() {
		super();
		nombre = "pInterseccionTO1WayO";
		imagen = new ImageIcon(
				"src/main/resources/modeloPistas/pInterseccionTO1WayO.png");
		Rectangle colision1 = new Rectangle(0, 0, 30, 30);
		Rectangle colision2 = new Rectangle(70, 0, 30, 100);
		Rectangle colision3 = new Rectangle(0, 70, 30, 30);
		colisiones = new ArrayList<>();
		colisiones.add(colision1);
		colisiones.add(colision2);
		colisiones.add(colision3);
		separadorNorte = new Rectangle(30, 0, 40, 2);
		paseNorte = new Rectangle(30, 3, 40, 25);
		separadorSur = new Rectangle(30, 98, 40, 2);
		paseSur = new Rectangle(30, 72, 40, 25);
		separadorOeste = new Rectangle(0, 30, 2, 40);
		paseOeste = new Rectangle(3, 30, 25, 40);
		paseInterseccionOeste = new Rectangle(27, 30, 3, 40);
		interseccion = true;
	}

	public void cambiarImagenActivada() {
		imagen = new ImageIcon("src/main/resources/modeloPistasFocus/vpInterseccionTO1WayO1.png");

	}

	public void cambiarImagenDesactivada() {
		imagen = new ImageIcon("src/main/resources/modeloPistas/pInterseccionTO1WayO.png");

	}
	
	@Override
	public void cambiarImagenCondicional(){
		imagen = new ImageIcon("src/main/resources/modeloPistasFocus/vpInterseccionTO1WayO2.png");
	}
}
