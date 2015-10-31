/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.sql.ResultSet;
import java.util.Iterator;
import javax.swing.JComboBox;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    ResultSet resultado = null;

    public void popularCombo(String tabela, String campo1, String campo2, JComboBox combo, String complementoSQL) {

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");  //deixar uma opção não válida preenchida por primeiro
        combo.addItem(item);

        try {
            Session sessao = null;
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            Iterator resultado = sessao.createQuery("select " + campo1 + ", " + campo2 + " from " + tabela
                    + " " + complementoSQL).list().iterator();

            while (resultado.hasNext()) {
                Object[] tuple = (Object[]) resultado.next();
                item = new ComboItens();
                item.setCodigo((int) tuple[0]);
                item.setDescricao((String) tuple[1]);

                combo.addItem(item);
            }

        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void definirItemCombo(JComboBox combo, ComboItens item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
