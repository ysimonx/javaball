package _main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Ppan extends JPanel implements Runnable{

	boolean boucle = true;//boolean true=en jeux, false=en pause
	Ballon b = new Ballon(200,200);//nouvel objet ballon au coordonées 200,200
	
	Random ry = new Random();//initialisation du random d�finnissant la trajectoire de la balle a chaque rebond sur les raquettes
	int dx = 0, dy = 0;//Mouvement du ballon sous forme vectorielle (d�placement initial de x mis a 1 pour lancer le jeux)
	//Constructeur de la classe
	public Ppan() {
		Random ry = new Random();//initialisation du random d�finnissant la trajectoire de la balle a chaque rebond sur les raquettes
		
		dx = ry.nextInt(6)-3;
		dy = ry.nextInt(6)-3;
		
		Thread ga = new Thread(this);//Initialisation de la fonction de rafraichissement de la fenetre
		ga.start();//debut de la fonction de raffraichissement
		this.setFocusable(true);
		this.setBackground(Color.BLACK);//D�ffinissement de la couleur du fond � noir
	}
	
	//Fonction de déplacement du ballon
	public void move() {
		//Vérifie si le ballon touche le sol ou le plafond
		if(b.getY()<=0 || b.getY()>=470) {
			dy = -dy;
			dx = ry.nextInt(4) - 2 ;

		}
		
		
		//Vérifie si le ballon touche les murs de droite ou gauche
		if(b.getX()<=0  || b.getX()+15>=500) {
			dx= -dx;
			dy = ry.nextInt(4) - 2;

		}
		
		//Change la position du ballon en fonction des vecteurs dx et dy
		b.setX(b.getX()+dx);
		b.setY(b.getY()+dy);
		
			
	}
	
	//Fonction le ballon
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;//Initialisation d'un Objet Graphics2D permettant de dessiner des composants en 2D
		move();//appel de la fonction du calcul du deplacement
		g2.setColor(Color.WHITE);//d�finition de la couleur de dessin
		g2.fillOval(b.getX(), b.getY(), 15, 15);//Dessine un Rond de 15pixs de diam�tre aux coordon�es de la balle
		
		
	}
	
	//fonction de raffraichissement du jeux
	@Override
	public void run() {
		//si le jeux n'est pas en pause
		while(boucle==true) {
			//appel la fonction paintComponent d�crite pr�cedement
			this.repaint();
			//Attends 10ms avant de refaire un tour de boucle
			try{Thread.sleep(10);}catch(Exception e){}
		}
	}

}
