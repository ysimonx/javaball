package _main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public JFrame f = new JFrame("JAVABALL");//Initialise un objet JFrame étant la fenêtre contenant le jeux
	public static JPanel p = new Ppan();//Initialise un objet JPanl étant le contenu de la JFrame du dessus
	
	//COnstructeur de la classe
	public Main() {
		super();
		
		build();//Appel la fonction build()
	}

	//fonction définnissant les paramêtres de la fenêtre
	public void build() {
		f.setSize(500, 500);//Définit ses dimensions
		f.setLocationRelativeTo(null);//Définit sa position initiale dans l'écran
		f.setResizable(false);//Définit si on peut la radimensionner (ici non)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Définit l'action a éxecuter par la fenêtre quand on la ferme
		f.setContentPane(p);//Définit le contenu de la fenêtre (ici le JPanel initialiser plus haut)
		f.setVisible(true);//Définit la fenêtre sur visible
	}
	
	//fonction main, la première a être lue par le programme
	public static void main(String[] args) {
		//D�fini le constructeur de la classe sur la fonction Main()
		Main main = new Main();
	}
}
