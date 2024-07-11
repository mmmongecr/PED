/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author Manuel Mora Monge
 */
public class Custom_TextField extends JTextField{

    private final Image backgroundImage;
    
    public Custom_TextField(){
        super();
        
        
        // Cargar la imagen de fondo desde el directorio assets
        backgroundImage = new ImageIcon("src/assets/TextField.png").getImage();
        setOpaque(false);
        repaint();
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo escalada al tamaño del panel
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    @Override
    public Insets getInsets() {
        // Definir los insets hard-coded
        return new Insets(10, 10, 10, 10); // Márgenes de 10 píxeles en cada lado
    }

}
