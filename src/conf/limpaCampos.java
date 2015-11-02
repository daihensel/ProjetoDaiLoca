package conf;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class limpaCampos {

    public static void limparCampos(Container container) {
        Component c[] = container.getComponents();
        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) c[i];
                field.setValue(null);
            } else if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setText("");
            } else if (c[i] instanceof JScrollPane) {
                 ((JTextArea) ((JScrollPane) c[i]).getViewport().getComponent(0)).setText("");
            } else if (c[i] instanceof JComboBox) {
                JComboBox cb = (JComboBox) c[i];
                cb.setSelectedIndex(-1);
            } else if (c[i] instanceof JCheckBox) {
                JCheckBox ckb = (JCheckBox) c[i];
                ckb.setSelected(false);
            }
        }
    }
} 