package application;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyController implements EventHandler<KeyEvent>{
	
	private Player p1;
	private Player p2;
	private boolean pressed;
	
	public KeyController(Player p1, Player p2, boolean pressed){
		this.p1 = p1;
		this.p2 = p2;
		this.pressed = pressed;
	}
	
	@Override
	public void handle(KeyEvent e) {
		switch (e.getCode()){
		case W:		p1.setUp(pressed);   break;
		case S:		p1.setDown(pressed); break;
		case UP: 	p2.setUp(pressed);	 break;
		case DOWN: 	p2.setDown(pressed); break;
		default: return;
		}
	}
}
