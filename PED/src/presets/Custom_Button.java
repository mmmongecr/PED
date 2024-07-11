/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Manuel Mora Monge
 */
public class Custom_Button extends JButton{
    
    
    private Image btn_Normal, btn_Hover, btn_Pressed;
    
    public Custom_Button(){
        super();
        
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        
        // Inicializa las imagenes para el botón según su estado
        btn_Normal = new ImageIcon("src/assets/BTN_Normal.png").getImage();
        btn_Hover = new ImageIcon("src/assets/BTN_Hover.png").getImage();
        btn_Pressed = new ImageIcon("src/assets/BTN_Pressed.png").getImage();
        
        // MouseListener para cambiar las imágenes según el estado del botón
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(new ImageIcon(btn_Hover));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(new ImageIcon(btn_Normal));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(new ImageIcon(btn_Pressed));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setIcon(new ImageIcon(btn_Hover));
            }
        });
        
        // Alinea el texto sobre la imagen
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(CENTER);
        
        
        // Establece la imagen inicial del botón
        setIcon(new ImageIcon(btn_Normal));
        setText("Iniciar sesión");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // No llamar a super.paintComponent(g) para evitar que el fondo del botón se pinte
        if (getModel().isPressed()) {
            g.drawImage(btn_Pressed, 0, 0, getWidth(), getHeight(), this);
        } else if (getModel().isRollover()) {
            g.drawImage(btn_Hover, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.drawImage(btn_Normal, 20, 0, getWidth(), getHeight(), this);
        }
        
        // Llama al método super.paintComponent(g) para que el texto y otros componentes se dibujen sobre la imagen
        super.paintComponent(g);
    }
    
    
    
    
    
    
}
