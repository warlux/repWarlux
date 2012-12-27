package com.warlux.domain.objetos.items;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.warlux.domain.objetos.ItemEfecto;

public class IJefe extends Item{

	public IJefe(String tipo) {
		super();
		imagen = new ImageIcon(
				"src/main/resources/modeloObjetos/iJefe1.png");
		permanente = false;
		estado = false;
		nombre = tipo;
	}
}
