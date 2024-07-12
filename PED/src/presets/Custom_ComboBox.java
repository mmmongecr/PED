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
import javax.swing.plaf.basic.BasicComboBoxUI;

public class Custom_ComboBox<E> extends JComboBox<E> {

    
    
    private Image background;
    private Image arrowIcon;
    private Image itemBackground;

    public Custom_ComboBox() {
        super();

        this.background = new ImageIcon("src/assets/TextField.png").getImage();
        this.arrowIcon = new ImageIcon("src/assets/CB_Arrow.png").getImage();
        this.itemBackground = new ImageIcon("src/assets/item.png").getImage();
        setUI(new CustomComboBoxUI());
        setRenderer(new CustomComboBoxRenderer());
        setOpaque(false);
        
        
    }

    private class CustomComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton button = new JButton("");
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
            g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
            super.paint(g, c);
        }
    }

    private class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<E> {
        public CustomComboBoxRenderer() {
            setOpaque(true);
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

            if (index >= 0 && itemBackground != null) {
                setIcon(new ImageIcon(itemBackground));
            } else {
                setIcon(null);
            }
            
            Border paddingBorder = BorderFactory.createEmptyBorder(2, 5, 2, 2);
            setBorder(paddingBorder);

            return this;
        }
        
        
    }
    
    
}
