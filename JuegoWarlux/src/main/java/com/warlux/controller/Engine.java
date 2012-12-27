package com.warlux.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.warlux.controller.gamestates.Commons;
import com.warlux.controller.gamestates.GameOver;
import com.warlux.controller.gamestates.IntroScreen;
import com.warlux.controller.gamestates.MenuScreen;
import com.warlux.controller.gamestates.Overworld;
import com.warlux.controller.gamestates.Playing;
import com.warlux.domain.objetos.Scorecard;
import com.warlux.domain.pistas.Nivel;
import com.warlux.view.Itemboard;
import com.warlux.view.Principal;
import com.warlux.view.Scoreboard;
import com.warlux.view.Tablero;

public class Engine implements ActionListener, Commons {

	public static GameState currentState;
	public final int SPEED = 2;

	private Scorecard score;
	private Timer timer;
	private ItemController ic;
	private Tablero tablero;
	private Scoreboard scoreboard;
	private Itemboard itemboard;
	private Principal principal;
	private MenuScreen menuScreen;
	private Playing playing;
	private Overworld overworld;
	private IntroScreen introScreen;
	private GameOver gameOver;

	public Engine() {				
		scoreboard = new Scoreboard();
		itemboard = new Itemboard();
		score = new Scorecard();
		tablero = new Tablero(this);
		timer = new Timer(10, this);
		currentState = GameState.IntroScreen;
		menuScreen = new MenuScreen(tablero);
		introScreen = new IntroScreen(tablero);
		overworld = new Overworld(tablero, score);
		gameOver = new GameOver();
		principal = new Principal(this);
		desactivarFrames();
		timer.setInitialDelay(5000);
		timer.start();
	}

	public void desactivarFrames(){
		scoreboard.setVisible(false);
		itemboard.setVisible(false);
		tablero.aumentarTamaño();
		tablero.setBackground(Color.BLACK);
		principal.pack();
	}
	
	public void activarFrames(){
		scoreboard.setVisible(true);
		itemboard.setVisible(true);
		tablero.reducirTamaño();
		principal.pack();
	}
	
	public void entrarNivel(){
		Nivel nivel = overworld.getOc().getNivelSeleccionado();
		if(nivel != null){
			playing = new Playing(tablero, nivel, score, scoreboard, itemboard);
			activarFrames();
			score.setNivel(nivel.getIdNivel());
			score.inicializarBolsaNivel();
			Engine.currentState = GameState.Playing;
		}
	}
	
	public void entrarOverworld(){
		Engine.currentState = GameState.Overworld;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(currentState == GameState.Playing){
			playing.accion(e);
		} else {
			if(currentState == GameState.Overworld){
				overworld.accion(e);
			} else {
				if(currentState == GameState.IntroScreen){
					currentState = GameState.MenuScreen;
				}
				if(currentState == GameState.GameOver){
					desactivarFrames();
				}
			}			
		}
		tablero.repaint();
	}

	public void paintGame(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(currentState == GameState.Playing){
			playing.draw(g2d);
		} else {
			if(currentState == GameState.Overworld){
				overworld.draw(g2d);
			} else {
				if(currentState == GameState.NivelCompleto){				
					desactivarFrames();
					entrarOverworld();
				}
				if(currentState == GameState.MenuScreen){				
					menuScreen.draw(g2d);
				}
				if(currentState == GameState.IntroScreen){				
					introScreen.draw(g2d);
				}
				if(currentState == GameState.GameOver){
					gameOver.draw(g2d);
				}				
			}
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();

	}
	


	public Tablero getTablero() {
		return tablero;
	}

	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public Itemboard getItemboard() {
		return itemboard;
	}
	
	public Principal getPrincipal() {
		return principal;
	}

	public ItemController getIc() {
		return ic;
	}

	public void setScore(Scorecard score) {
		this.score = score;
	}

	public Scorecard getScore() {
		return score;
	}

	public Playing getPlaying() {
		return playing;
	}

	public MenuScreen getMenuScreen() {
		return menuScreen;
	}

	public void setMenuScreen(MenuScreen menuScreen) {
		this.menuScreen = menuScreen;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}

	public Overworld getOverworld() {
		return overworld;
	}

	public IntroScreen getIntroScreen() {
		return introScreen;
	}

	public GameOver getGameOver() {
		return gameOver;
	}

}
