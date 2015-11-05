/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import entidade.Cliente;
import entidade.Pessoa;
import entidade.Tipoveiculo;
import entidade.Veiculostipoestatus;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import visao.FormPrincipal;

/**
 *
 * @author Daiane
 */
public class Utility {

    public static String pegaSenhaLogin(String login) {
        Session sessao = null;
        try {
            String s = "";

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            Query query = (Query) sessao.createQuery("SELECT senha FROM Funcionario WHERE login LIKE '%" + login + "%'");
            System.out.println("login: " + login);

            s = query.list().get(0).toString();

            System.out.println("senha user: " + s);
            sessao.getTransaction().commit();
            return s;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro pegar dadosLogin = " + he);
            return "";
        } finally {
            sessao.close();
        }
    }

    public static boolean alteraSenha(String login, String senhaatual, String senhanova, String senhanovaconfirma) {
        boolean ok = false;
        String senha = pegaSenhaLogin(login);
        if (senha.equals(senhaatual)) {
            if (!senhanova.equals(senhanovaconfirma)) {
                JOptionPane.showMessageDialog(null, "Senha NOVA não confere...", "Atenção", JOptionPane.ERROR_MESSAGE);
                return (ok = false);
            } else if (senhaatual.equals(senhanova)) {
                JOptionPane.showMessageDialog(null, "Senha NOVA igual ATUAL...", "Atenção", JOptionPane.ERROR_MESSAGE);
                return (ok = false);
            } else if (senha.equals(senhaatual)) {
                Session sessao = null;
                try {
                    sessao = HibernateUtil.getSessionFactory().openSession();
                    Transaction t = sessao.beginTransaction();

                    String hqlUpdate = ("UPDATE Funcionario SET"
                            + " senha = '" + senhanova + "' "
                            + " WHERE login = '" + login + "'");
                    int updatedEntities = sessao.createQuery(hqlUpdate).executeUpdate();

                    sessao.getTransaction().commit();

                } catch (HibernateException he) {
                    he.printStackTrace();
                    System.out.println("Erro atualizar Senha = " + he);
                    return (ok = false);
                } finally {
                    sessao.close();

                }
                //  JOptionPane.showMessageDialog(null, "Senha trocada com sucesso");
                return (ok = true);
            }
        } else if (!senha.equals(senhaatual)) {
            JOptionPane.showMessageDialog(null, "Senha ATUAL não confere...", "Atenção", JOptionPane.ERROR_MESSAGE);
            return (ok = false);
        }
        return ok;
    }

    public static void permit(JButton novo, JButton salvar, JButton editar, JButton excluir, JInternalFrame jif) {

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Iterator qr = sessao.createQuery("select pe.ler, pe.inserir, pe.editar, "
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

    public static void popularTabelaVeiculosTipoEStatus(JTable tb) {
        Session sessao = null;
        try {
            DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
            tabelaModelo.setNumRows(0);

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

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
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro popular = " + he);

        } finally {
            sessao.close();

        }

    }

    public static List consultaPessoa(String criterio) {

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        Query query = (Query) sessao.createQuery(" FROM Pessoa WHERE nome LIKE '%" + criterio + ")");

        List<Pessoa> dadosPessoa = (List<Pessoa>) query.list();
        sessao.getTransaction().commit();

        return dadosPessoa;

    }

    public static String salvarTipoVeiculo(Tipoveiculo tipoVeiculo) {
        Session sessao = null;
        String retorno = "";
        
        if (tipoVeiculo.getIdtipoVeiculo() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(tipoVeiculo);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Tipoveículo: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(tipoVeiculo);

                sessao.getTransaction().commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar TipoVeiculo = " + he);

            }
            
        }
        return retorno;
    }
}
