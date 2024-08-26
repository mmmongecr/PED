/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presets;

/**
 *
 * @author Manuel Mora Monge
 */



import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class CM_ComboBox<E> extends JComboBox<E> {

    
    
    private Image background;
    private Image arrowIcon;
    private Image itemBackground;

    public CM_ComboBox() {
        super();

        this.background         = new ImageIcon("src/assets/TextField.png").getImage();
        this.arrowIcon          = new ImageIcon("src/assets/CB_Arrow.png").getImage();
        this.itemBackground     = new ImageIcon("src/assets/TextField.png").getImage();
        itemBackground = resizeImage(getSize(), itemBackground);
        setUI(new CustomComboBoxUI());
        setRenderer(new CustomComboBoxRenderer());
        setOpaque(false);
        
        setRenderer(new TranslucentComboBoxRenderer());
        //setEditor(new TranslucentComboBoxEditor());
        setOpaque(false);
        
        
    }
    
    private Image resizeImage(Dimension size, Image img) {
        
        if (size.height == 0 || size.width == 0){
            size = new Dimension(10, 10);
        }
        // Reescalar la imagen de fondo
        return img.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);

    }
    
    
    // Lista del combobox
    private static class TranslucentComboBoxRenderer extends BasicComboBoxRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            c.setBackground(new Color(25, 170, 200, 128)); // Fondo translúcido
            if (isSelected) {
                c.setForeground(Color.WHITE);
                c.setBackground(new Color(10, 100, 120, 255)); // Fondo translúcido al estar seleccionado
            }
            ((JComponent) c).setOpaque(true);
            return c;
        }
    }

    

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f)); // Establece la transparencia
        super.paintComponent(g);
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Flecha
    private class CustomComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton button = new JButton("");
            arrowIcon = resizeImage(button.getSize(), arrowIcon);
            button.setIcon(new ImageIcon(arrowIcon));
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setOpaque(false);
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.CENTER);
            
            return button;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            resizeImage(getSize(), background);
            // g.drawImage (Imagen, posición x, posición y, ancho, largo, objeto)
            g.drawImage(background, 1, 1, c.getWidth()-3, c.getHeight()-3, c);
            c.setBackground(new Color(154, 198, 216, 128));
            c.setOpaque(false);
            
            
            
            
            
            super.paint(g, c);
        }
        
        
        /*@Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            Color backgroundColor;

            if (hasFocus) {
                // Cambia el fondo cuando el JComboBox tiene el foco
                backgroundColor = new Color(0, 0, 0, 0); // Fondo translúcido con foco
            } else if (comboBox.getSelectedIndex() != -1) {
                // Cambia el fondo cuando un ítem está seleccionado
                backgroundColor = new Color(0, 0, 0, 0); // Fondo translúcido con item seleccionado
            } else {
                // Fondo por defecto cuando no hay selección ni foco
                backgroundColor = new Color(0, 0, 0, 0);
            }

            g.setColor(backgroundColor);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }*/

        
        @Override
        public Insets getInsets() {
            // Definir los insets hard-coded
            return new Insets(12, 12, 12, 12); // Márgenes de 10 píxeles en cada lado
        }
    }
    
    private class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<E> {
        public CustomComboBoxRenderer() {
            setOpaque(false);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends E> list, E value, int index, boolean isSelected, boolean cellHasFocus) {
            
            
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setText(value != null ? value.toString() : "");
            
            Border paddingBorder = BorderFactory.createEmptyBorder(2, 10, 2, 2);
            setBorder(paddingBorder);
            setBackground(new Color(0,50,150,60));
            setOpaque(true);

            return this;
        }
        
        
        @Override
        public Insets getInsets() {
            // Definir los insets hard-coded
            return new Insets(10, 10, 10, 10); // Márgenes de 10 píxeles en cada lado
        }
        
        
    }
    
    
    
    
    
}
