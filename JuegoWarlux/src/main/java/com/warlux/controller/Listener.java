package com.warlux.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.warlux.controller.gamestates.Commons;
import com.warlux.controller.gamestates.Commons.GameState;
import com.warlux.controller.gamestates.Playing;
import com.warlux.domain.objetos.Puntero;
import com.warlux.view.editorNivel.VistaCrearNivel;

public class Listener extends KeyAdapter implements Commons {

	private Engine engine;

	public Listener(Engine engine) {
		this.engine = engine;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (Engine.currentState == GameState.Playing) {
			switch (key) {
			case KeyEvent.VK_RIGHT:
				engine.getPlaying().getPuntero().setDireccion("este");
				engine.getPlaying().getPuntero().setDx(engine.SPEED);
				break;
			case KeyEvent.VK_LEFT:
				engine.getPlaying().getPuntero().setDireccion("oeste");
				engine.getPlaying().getPuntero().setDx(-engine.SPEED);
				break;
			case KeyEvent.VK_UP:
				engine.getPlaying().getPuntero().setDireccion("norte");
				engine.getPlaying().getPuntero().setDy(-engine.SPEED);
				break;
			case KeyEvent.VK_DOWN:
				engine.getPlaying().getPuntero().setDireccion("sur");
				engine.getPlaying().getPuntero().setDy(engine.SPEED);
				break;
			case KeyEvent.VK_CONTROL:
				engine.getPlaying().getUi().cambiarSiguienteItem();
				break;
			case KeyEvent.VK_SPACE:
				engine.getPlaying().usarItem();
				break;
			}
		} else {
			if (Engine.currentState == GameState.Overworld) {
				switch (key) {
				case KeyEvent.VK_RIGHT:
					engine.getOverworld().moverPuntero("este");
					break;
				case KeyEvent.VK_LEFT:
					engine.getOverworld().moverPuntero("oeste");
					break;
				case KeyEvent.VK_UP:
					engine.getOverworld().moverPuntero("norte");
					break;
				case KeyEvent.VK_DOWN:
					engine.getOverworld().moverPuntero("sur");
					break;
				case KeyEvent.VK_ENTER:
					engine.entrarNivel();
				}
			}
			if (Engine.currentState == GameState.MenuScreen) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					engine.entrarOverworld();		
				}
				if (e.getKeyCode() == KeyEvent.VK_E) {
					new VistaCrearNivel().setVisible(true);
					engine.getPrincipal().setVisible(false);
				}

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (Engine.currentState == GameState.Playing) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_UP)
				engine.getPlaying().getPuntero().setDy(0);
			if (key == KeyEvent.VK_DOWN)
				engine.getPlaying().getPuntero().setDy(0);
			if (key == KeyEvent.VK_RIGHT)
				engine.getPlaying().getPuntero().setDx(0);
			if (key == KeyEvent.VK_LEFT)
				engine.getPlaying().getPuntero().setDx(0);
		}
	}
}
