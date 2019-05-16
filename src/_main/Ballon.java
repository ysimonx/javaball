package _main;

public class Ballon {

	int x, y;//coordonees du ballon
	
	//Constructeur de la classe (avec arguments x et y de coordonées initiale)
	public Ballon(int x, int y) {
		//affecte les arguements au variable de la classe
		this.x = x;
		this.y = y;
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

}
