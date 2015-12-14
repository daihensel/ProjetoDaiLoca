/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
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
            t.commit();
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

                    t.commit();

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
                novo.setVisible(inser);
            }
            if (salvar != null) {
                salvar.setVisible(inser);
            }
            Boolean edit = (boolean) tuple[2];
            if (editar != null) {
                editar.setVisible(edit);
            }
            Boolean exc = (boolean) tuple[3];
            if (excluir != null) {
                excluir.setVisible(exc);
            }

            t.commit();

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

        t.commit();
        return false;
    }

    public static String somaVeiculos(int idstatusveiculo) {
        String soma = "";
        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Query qr = (Query) sessao.createQuery("select count(idveiculo) FROM Veiculo v, Statusveiculo sv"
                + " WHERE sv.idstatusveiculo=v.statusveiculo.id"
                + " AND sv.idstatusveiculo= ? ").setInteger(0, idstatusveiculo);

        soma = qr.list().get(0).toString();

        t.commit();
        return soma;
    }

    public static int pegaMaiorIdReserva() {
        int soma = 0;
        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Query qr = (Query) sessao.createQuery("SELECT max(idreserva) FROM Reserva");

        String maior = qr.list().get(0).toString();
        soma = Integer.getInteger(maior);

        t.commit();
        return soma;
    }

    public static int pegaMaiorIdVeiculo() {
        int soma = 0;
        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Query qr = (Query) sessao.createQuery("SELECT max(idveiculo) FROM Veiculo");

        String maior = qr.list().get(0).toString();
        soma = Integer.parseInt(maior);

        t.commit();
        return soma;
    }

    public static boolean confereDataReserva(Date dtlocacao, Date dtdevolucao, int idveiculo) {

        boolean ok = false;
        Session sessao = null;
        try {
            List resultados = new ArrayList();
            List resultados2 = new ArrayList();
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            String sql = "SELECT confereDataLocacaoNaReserva(:dtlocacao,:dtdevolucao,:idveiculo)";
            String sql2 = "SELECT confereDataLocacao(:dtlocacao,:dtdevolucao,:idveiculo)";

            try {
                Query exQuery = sessao.createSQLQuery(sql);
                exQuery.setParameter("dtlocacao", dtlocacao);
                exQuery.setParameter("dtdevolucao", dtdevolucao);
                exQuery.setParameter("idveiculo", idveiculo);
                resultados = exQuery.list();

            } catch (Exception e) {
                System.err.println("" + e);
            }
            try {
                Query exQuery2 = sessao.createSQLQuery(sql2);
                exQuery2.setParameter("dtlocacao", dtlocacao);
                exQuery2.setParameter("dtdevolucao", dtdevolucao);
                exQuery2.setParameter("idveiculo", idveiculo);
                resultados2 = exQuery2.list();

            } catch (Exception e) {
                System.err.println("" + e);
            }

            int retornadoDaProcedure = 0;
            int retornadoDaProcedure2 = 0;
            if (resultados.toString().equals("[null]") == false) {
                retornadoDaProcedure = (int) resultados.get(0);
            }

            if (resultados2.toString().equals("[null]") == false) {
                retornadoDaProcedure2 = (int) resultados2.get(0);
            }

            if (retornadoDaProcedure > 0 || retornadoDaProcedure2 > 0) { //existe retorno na query
                return ok = false;
            } else {
                return ok = true;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro confereLocacao e Reserva= " + he);
            return (ok = false);
        } finally {
            sessao.close();

        }
    }

    public static boolean confereDataLocacao(Date dtlocacao, Date dtdevolucao, int idveiculo) {

        boolean ok = false;
        Session sessao = null;
        try {
            List resultados = new ArrayList();

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            String sql = "SELECT confereDataLocacao(:dtlocacao,:dtdevolucao,:idveiculo)";

            try {
                Query exQuery = sessao.createSQLQuery(sql);
                exQuery.setParameter("dtlocacao", dtlocacao);
                exQuery.setParameter("dtdevolucao", dtdevolucao);
                exQuery.setParameter("idveiculo", idveiculo);
                resultados = exQuery.list();

            } catch (Exception e) {
                System.err.println("" + e);
            }

            int retornadoDaProcedure = 0;
            if (resultados.toString().equals("[null]") == false) {
                retornadoDaProcedure = (int) resultados.get(0);
            }

            if (retornadoDaProcedure > 0) { //existe retorno na query
                return ok = false;
            } else {
                return ok = true;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro confereLocação= " + he);
            return (ok = false);
        } finally {
            sessao.close();

        }
    }

    public static boolean confereDataDentroReserva(Date dt, int idveiculo) {

        boolean ok = false;
        Session sessao = null;
        try {
            List resultados = new ArrayList();

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            String sql = "SELECT confereDataDentroReserva(:dt,:idveiculo)";

            try {
                Query exQuery = sessao.createSQLQuery(sql);
                exQuery.setParameter("dt", dt);
                exQuery.setParameter("idveiculo", idveiculo);
                resultados = exQuery.list();

            } catch (Exception e) {
                System.err.println("" + e);
            }

            int retornadoDaProcedure = 0;
            if (resultados.toString().equals("[null]") == false) {
                retornadoDaProcedure = (int) resultados.get(0);
            }

            if (retornadoDaProcedure > 0) { //existe retorno na query
                return ok = false;
            } else {
                return ok = true;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro confereDataDentroReserva= " + he);
            return (ok = false);
        } finally {
            sessao.close();

        }
    }

    public static boolean confereDataDentroLocacao(Date dt, int idveiculo) {

        boolean ok = false;
        Session sessao = null;
        try {
            List resultados = new ArrayList();

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            String sql = "SELECT confereDataDentroLocacao(:dt,:idveiculo)";

            try {
                Query exQuery = sessao.createSQLQuery(sql);
                exQuery.setParameter("dt", dt);
                exQuery.setParameter("idveiculo", idveiculo);
                resultados = exQuery.list();

            } catch (Exception e) {
                System.err.println("" + e);
            }

            int retornadoDaProcedure = 0;
            if (resultados.toString().equals("[null]") == false) {
                retornadoDaProcedure = (int) resultados.get(0);
            }

            if (retornadoDaProcedure > 0) { //existe retorno na query
                return ok = false;
            } else {
                return ok = true;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro confereDataDentroLocação= " + he);
            return (ok = false);
        } finally {
            sessao.close();

        }
    }
    
    
    public static void desabilitaTriggers() {

        Session sessao = null;
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            String sql = ("ALTER TABLE Cancelamento DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Cidade DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Cliente DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Contato DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Devolucao DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Documentos DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Endereco DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Estado DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Funcao DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Funcionario DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Locacao DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Manutencao DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Parcelaspagamento DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Permissao DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Pessoa DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Pessoafisica DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Pessoajuridica DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Reserva DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Statusveiculo DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Tela DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Tipocontato DISABLE TRIGGER audit;\n"
                    + "ALTER TABLE Tipoveiculo DISABLE TRIGGER audit;");

            //int updatedEntities = sessao.createQuery(sql).executeUpdate();
            int up = sessao.createSQLQuery(sql).executeUpdate();

            t.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro desabilitaTriggers= " + he);

        } finally {
            sessao.close();

        }
    }

    public static void habilitaTriggers() {

        Session sessao = null;
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            String sql = ("ALTER TABLE Cancelamento ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Cidade ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Cliente ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Contato ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Devolucao ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Documentos ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Endereco ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Estado ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Funcao ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Funcionario ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Locacao ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Manutencao ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Parcelaspagamento ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Permissao ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Pessoa ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Pessoafisica ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Pessoajuridica ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Reserva ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Statusveiculo ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Tela ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Tipocontato ENABLE TRIGGER audit;\n"
                    + "ALTER TABLE Tipoveiculo ENABLE TRIGGER audit;");

            //int updatedEntities = sessao.createQuery(sql).executeUpdate();
            int up = sessao.createSQLQuery(sql).executeUpdate();

            t.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro habilitaTriggers= " + he);

        } finally {
            sessao.close();

        }
    }
    
    
    
    

}
