package com.warlux.domain.jefes;

import java.util.ArrayList;

import com.warlux.domain.objetos.items.IJefe;
import com.warlux.domain.pistas.Nivel;
import com.warlux.domain.pistas.Pista;

public class JefeController {
	
	private Nivel nivel;
	
	public JefeController(Nivel nivel){
		this.nivel = nivel;
	}

	public ArrayList<Jefe> inicializarJefes(){
		ArrayList<Jefe> jefes = new ArrayList<>();
		for (int i = 0; i < nivel.getAncho(); i++) {
			for (int j = 0; j < nivel.getAlto(); j++) {
				if (nivel.getPosicion()[i][j]!= null && nivel.getPosicion()[i][j].getItem()!= null && nivel.getPosicion()[i][j].getItem().getNombre().contains("jefe")) {
					Jefe jefe = new Jefe(nivel.getPosicion()[i][j]);
					jefes.add(jefe);
				}
			}
		}
		return jefes;
	}

}
