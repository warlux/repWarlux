package com.warlux.domain.jefes;

import com.warlux.domain.objetos.items.ILlaveN;
import com.warlux.domain.objetos.items.Item;
import com.warlux.domain.pistas.Pista;

public class Jefe {
	
	private String tipo;
	private int x;
	private int y;
	private int vida;
	private Item recompenza;


	public Jefe(Pista pistaJefe){
		tipo = pistaJefe.getItem().getNombre();
		x = pistaJefe.getX();
		y = pistaJefe.getY();
		vida = 2;
		recompenza = new ILlaveN();
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
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


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
	public Item getRecompenza() {
		return recompenza;
	}


	public void setRecompenza(Item recompenza) {
		this.recompenza = recompenza;
	}

}
