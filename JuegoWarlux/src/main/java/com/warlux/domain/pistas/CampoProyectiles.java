package com.warlux.domain.pistas;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.imageio.ImageReader;

import com.warlux.domain.objetos.Tnt;
import com.warlux.view.Tablero;

public class CampoProyectiles {
	
	private ArrayList<Tnt> listaTnt;
	
	public CampoProyectiles(){
		listaTnt = new ArrayList<>();
	}
	
	public void añadirTnt(int x,int y){
		final Tnt tnt = new Tnt(x, y);
		Thread t = new Thread(new Runnable() {
			public void run()
			{
				try {
					listaTnt.add(tnt);
					Thread.sleep(3000);
					tnt.setActiva(true);
					Thread.sleep(3000);
					tnt.setActiva(false);
					listaTnt.remove(tnt);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
	
	public boolean intersectaDmg(Rectangle target){
		for(Tnt tnt: listaTnt){
			if(tnt.isActiva() && tnt.getBounds().intersects(target)){
				tnt.setActiva(false);
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics2D g2d, Tablero tablero){
		for(Tnt tnt: listaTnt){			
			g2d.drawImage(tnt.getImagen(), tnt.getX(), tnt.getY(), tablero);
		}
	}

}
