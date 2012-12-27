package com.warlux.domain.objetos;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Vehiculo {

	private Image imagenN;
	private Image imagenS;
	private Image imagenE;
	private Image imagenO;
	private Image aSaltoN;
	private Image aSaltoS;
	private Image aSaltoE;
	private Image aSaltoO;
	private int potenciaSalto;
	private int almacenamiento;
	private int energiaMax;
	private String habilidad; //crear clase
	
	public Vehiculo(){
		imagenN = new ImageIcon("src/main/resources/modeloObjetos/v1N.png").getImage();		
		imagenS = new ImageIcon("src/main/resources/modeloObjetos/v1S.png").getImage();		
		imagenE = new ImageIcon("src/main/resources/modeloObjetos/v1E.png").getImage();
		imagenO = new ImageIcon("src/main/resources/modeloObjetos/v1O.png").getImage();
		Toolkit t = Toolkit.getDefaultToolkit ();
		aSaltoN = t.createImage("src/main/resources/modeloObjetos/v1NSalto.gif");;
		aSaltoS = t.createImage("src/main/resources/modeloObjetos/v1SSalto.gif");
		aSaltoE=  t.createImage("src/main/resources/modeloObjetos/v1ESalto.gif");
		aSaltoO = t.createImage("src/main/resources/modeloObjetos/v1OSalto.gif");
		potenciaSalto = 0;
		almacenamiento = 3;
		energiaMax = 3;
		habilidad = "";
	}

	public int getPotenciaSalto() {
		return potenciaSalto;
	}

	public void setPotenciaSalto(int potenciaSalto) {
		this.potenciaSalto = potenciaSalto;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public int getEnergiaMax() {
		return energiaMax;
	}

	public void setEnergiaMax(int energiaMax) {
		this.energiaMax = energiaMax;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public Image getImagenN() {
		return imagenN;
	}

	public Image getImagenS() {
		return imagenS;
	}

	public Image getImagenE() {
		return imagenE;
	}

	public Image getImagenO() {
		return imagenO;
	}

	public Image getaSaltoN() {
		return aSaltoN;
	}

	public Image getaSaltoS() {
		return aSaltoS;
	}

	public Image getaSaltoE() {
		return aSaltoE;
	}

	public Image getaSaltoO() {
		return aSaltoO;
	}
	
}
