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
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Manuel Mora Monge
 */
public class CM_TextField extends JTextField{

    private final Image backgroundImage;
    
    public CM_TextField(){
        super();
        
        
        // Cargar la imagen de fondo desde el directorio assets
        backgroundImage = new ImageIcon("src/assets/TextField.png").getImage();
        setBorder(new EmptyBorder(1,1,1,1));
        setOpaque(false);
        repaint();
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo escalada al tamaño del panel
        if (backgroundImage != null) {
            // g.drawImage (Imagen, posición x, posición y, ancho, largo, objeto)
            g.drawImage(backgroundImage, 1, 1, getWidth()-3, getHeight()-3, this);
        }
    }
    
    @Override
    public Insets getInsets() {
        // Definir los insets hard-coded
        return new Insets(10, 10, 10, 10); // Márgenes de 10 píxeles en cada lado
    }

}
