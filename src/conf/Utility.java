/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import entidade.Veiculostipoestatus;
import static java.awt.im.InputContext.getInstance;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visao.FormPrincipal;

/**
 *
 * @author Daiane
 */
public class Utility {

    public static void permit(JButton novo, JButton salvar, JButton editar, JButton excluir, JInternalFrame jif) {

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Iterator qr = sessao.createQuery("select pe.ler,pe.inserir, pe.editar,"
                + "pe.inativar from Permissao pe, Pessoa p, Funcionario f, Tela t\n"
                + "WHERE p.idpessoa=pe.idpessoa\n"
                + "AND p.idpessoa=f.pessoaIdpessoa\n"
                + "AND pe.idtela=t.idtela\n"
                + "AND f.login LIKE '" + FormPrincipal.login + "'\n"
                + "AND t.descricao LIKE '" + jif.getClass().getSimpleName() + "' ").list().iterator();

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
//            Boolean ler = (boolean) tuple[0];
//            System.out.println("tuple0:" + l);
//            if (ler == false) {
//                jif.setVisible(false);
//            }
            Boolean inser = (boolean) tuple[1];
            if (novo != null) {
                novo.setEnabled(inser);
            }
            if (salvar != null) {
                salvar.setEnabled(inser);
            }
            Boolean edit = (boolean) tuple[2];
            if (editar != null) {
                editar.setEnabled(edit);
            }
            Boolean exc = (boolean) tuple[3];
            if (excluir != null) {
                excluir.setEnabled(exc);
            }

            sessao.getTransaction().commit();

        }
    }

    

    public static Boolean permitLer(JInternalFrame jif) {

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Iterator qr = sessao.createQuery("select pe.ler,pe.inserir, pe.editar,"
                + "pe.inativar from Permissao pe, Pessoa p, Funcionario f, Tela t\n"
                + "WHERE p.idpessoa=pe.idpessoa\n"
                + "AND p.idpessoa=f.pessoaIdpessoa\n"
                + "AND pe.idtela=t.idtela\n"
                + "AND f.login LIKE '" + FormPrincipal.login + "'\n"
                + "AND t.descricao LIKE '" + jif.getClass().getSimpleName() + "' ").list().iterator();

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
            Boolean l = (boolean) tuple[0];
            return l;

        }

        sessao.getTransaction().commit();
        return false;
    }

    public static String somaVeiculos(int idstatusveiculo) {
        String soma = "";
        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Query qr = (Query) sessao.createQuery("select count(idveiculo) FROM Veiculo v, Statusveiculo sv\n"
                + "WHERE sv.idstatusveiculo=v.idstatusveiculo\n"
                + "AND sv.idstatusveiculo= ? ").setInteger(0, idstatusveiculo);

        soma = qr.list().get(0).toString();

        sessao.getTransaction().commit();
        return soma;
    }

    public static void popularTabelaVeiculos(JTable tb) {
        // try{
        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

//        Iterator query = sessao.createQuery("select v.idveiculo, v.descricao, t.descricao, s.descricao\n"
//                + "FROM Veiculo v, Tipoveiculo t, Statusveiculo s\n"
//                + "WHERE v.tipoveiculo=t.tipoveiculo\n"
//                + "AND s.statusveiculo=v.statusveiculo").list().iterator();
//         Iterator query = sessao.createQuery(" from Veiculostipoestatus").list().iterator();
//        while (query.hasNext()) {
//            Object[] tuple = (Object[]) query.next();
//            Veiculostipoestatus idveiculo = (Veiculostipoestatus) tuple[0]; //id
//            Veiculostipoestatus descricaov = (Veiculostipoestatus) tuple[1]; //desc veiculo
//            Veiculostipoestatus descricaot = (Veiculostipoestatus) tuple[2]; //desc tipo
//            Veiculostipoestatus descricaos = (Veiculostipoestatus) tuple[3]; //desc status
//            tabelaModelo.addRow(tuple);
//        }
        Query query = (Query) sessao.createQuery(" FROM Veiculostipoestatus");
        List<Veiculostipoestatus> dadosVTS = (List<Veiculostipoestatus>) query.list();

        for (Veiculostipoestatus v : dadosVTS) {
            tabelaModelo.addRow(new Object[]{
                //  v.getIdveiculo(),
                v.getDescricaoVeiculo(),
                v.getDescricaoTipo(),
                v.getDescricaoStatus(),});
        }

        sessao.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("erro ao chamar view: " + e);
//        }
    }

}
