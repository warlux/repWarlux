package com.warlux.domain.objetos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Tnt {

	private int x, y;
	private Image imagen;
	private boolean activa;
	
	public Tnt(int x, int y){
		this.x = x;
		this.y = y;
		Toolkit t = Toolkit.getDefaultToolkit ();
		imagen = t.createImage("src/main/resources/modeloObjetos/tnt.gif");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Image getImagen() {
		return imagen;
	}
	
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 40,40);
	}
	
}
