import javax.swing.*;
import javax.swing.ImageIcon;

public class Tablero extends JFrame {

    ImageIcon icono;
    ImageIcon fondoImagen;

    JLabel fondo;

    public Tablero(){

        fondoImagen = new ImageIcon(this.getClass().getResource("img/tapete.jpg"));
        fondo = new JLabel();
        fondo.setIcon(fondoImagen);
        fondo.setVerticalAlignment(JLabel.CENTER);
        fondo.setHorizontalAlignment(JLabel.CENTER);

        this.setTitle("Escoba");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        icono = new ImageIcon(this.getClass().getResource("/img/icon.png"));
        this.setIconImage(icono.getImage());

        this.add(fondo);
    }

}
