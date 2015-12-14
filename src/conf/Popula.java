/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import entidade.Cidade;
import entidade.Cliente;
import entidade.Contatopessoas;
import entidade.Documentos;
import entidade.Funcao;
import entidade.Funcionario;
import entidade.Locacao;
import entidade.Manutencao;
import entidade.Permissao;
import entidade.Pessoa;
import entidade.Pessoafisica;
import entidade.Pessoajuridica;
import entidade.Populartabelacliente;
import entidade.Populartabelafornecedor;
import entidade.Populartabelafuncionario;
import entidade.Populartabelalocacao;
import entidade.Populartabelareserva;
import entidade.Reserva;
import entidade.Statusveiculo;
import entidade.Tipocontato;
import entidade.Tipoveiculo;
import entidade.Veiculo;
import entidade.Veiculosstatus;
import entidade.Veiculostipoestatus;
import entidade.Veiculostipoestatusreserva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class Popula {

    public static List popularTabelaVeiculo(int codigo, String criterio, JTable tb, String status) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        status = status.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Veiculosstatus v WHERE (lower(v.descricaoveiculo) LIKE '%" + criterio + "%'"
                + " OR lower(v.marca) LIKE '%" + criterio + "%'"
                + " OR lower(v.descricaotipo) LIKE '%" + criterio + "%'"
                + " OR v.idveiculo = " + codigo + " ) AND lower(v.descricaostatus) LIKE '%" + status + "%'");
        List<Veiculosstatus> dadosVeiculos = (List<Veiculosstatus>) query.list();

        for (Veiculosstatus lin : dadosVeiculos) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdveiculo(),
                lin.getDescricaoVeiculo(),
                lin.getMarca(),
                lin.getAnoModelo(),
                lin.getValorDiaria(),
                lin.getDescricaoTipo(),
                lin.getDescricaoStatus()

            });

        }
        t.commit();
        return dadosVeiculos;

    }

    public static List popularTabelaContatos(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;
        List<Contatopessoas> dadosContatos = new ArrayList<Contatopessoas>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            criterio = criterio.toLowerCase();
            Query query = (Query) sessao.createQuery(" FROM Contatopessoas c WHERE"
                    //+ " (lower(c.nomepessoa) LIKE '%" + criterio + "%'"
                    //+ " OR lower(c.descricaotipocontato) LIKE '%" + criterio + "%'"
                    //+ " OR lower(c.descricaocontato) LIKE '%" + criterio + "%')"
                    //+ " AND "
                    + " c.idpessoa = " + cod + "");
            dadosContatos = (List<Contatopessoas>) query.list();

//        Iterator qr = sessao.createQuery("SELECT c.idcontato, c.descricao, t.descricao,"
//                + "  p.nome  FROM Contato c, Tipocontato t, Pessoa p WHERE ("
//                + " c.pessoa_idpessoa.id = p.idpessoa"
//                + " AND t.idtipoContato=c.tipocontato.id)"
//                + " AND c.pessoa_idpessoa.id = " + cod + "").list().iterator();
//
//        while (qr.hasNext()) {
//            Object[] tuple = (Object[]) qr.next();
//            tabelaModelo.addRow(new Object[]{
//                tuple[0],
//                tuple[1],
//                tuple[2],
//                tuple[3]
//            });
//        }
            for (Contatopessoas lin : dadosContatos) {
                tabelaModelo.addRow(new Object[]{
                    lin.getIdcontato(),
                    lin.getDescricaocontato(),
                    lin.getDescricaotipocontato(),
                    lin.getNomepessoa()
                });
            }
            t.commit();
            return dadosContatos;
        } catch (HibernateException he) {
            System.out.println("Erro popularTabelaContatos: \n" + he);
        }
        return dadosContatos;
    }

    public static Veiculo alteraStatusVeiculo(String descricao, Veiculo v) {
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            descricao = descricao.toLowerCase();
            Query queryRetornaStatus = (Query) sessao.createQuery(
                    " FROM Statusveiculo s WHERE("
                    + " lower(s.descricao) LIKE '%" + descricao + "%')"
            );
            List<Statusveiculo> dadosStatus = (List<Statusveiculo>) queryRetornaStatus.list();
            t.commit();

            t = sessao.beginTransaction();
            int idStatusVeiculo = 0;
            String descVeiculo = "";
            for (Statusveiculo lin : dadosStatus) {
                v.setStatusveiculo(lin);
                descVeiculo = v.getDescricao();
                idStatusVeiculo = lin.getIdstatusVeiculo();
            }
            String hqlUpdate = ("UPDATE Veiculo SET"
                    + " statusveiculo = " + idStatusVeiculo + " "
                    + " WHERE descricao = '" + descVeiculo + "'");
            int updatedEntities = sessao.createQuery(hqlUpdate).executeUpdate();

            t.commit();
            sessao.close();
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro atualizar Veiculo = " + he);
        }

        return v;
    }

    public static List popularTabelaLocacao(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelalocacao p WHERE (lower(p.descricaoveiculo) LIKE '%" + criterio + "%'"
                + " OR lower(p.nomecliente) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaotipoveiculo) LIKE '%" + criterio + "%'"
                + " OR p.idlocacao = " + codigo + ")");
        List<Populartabelalocacao> dadosLocacao = (List<Populartabelalocacao>) query.list();

        for (Populartabelalocacao lin : dadosLocacao) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdlocacao(),
                Formatacao.ajustaDataDMA(String.valueOf(lin.getDtLocacao())),
                lin.getNomecliente(),
                lin.getDescricaoVeiculo(),
                lin.getDescricaoTipoVeiculo()});

        };
        t.commit();
        return dadosLocacao;
    }
    
    public static List popularTabelaPagamentos(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelalocacao p WHERE (lower(p.descricaoveiculo) LIKE '%" + criterio + "%'"
                + " OR lower(p.nomecliente) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaotipoveiculo) LIKE '%" + criterio + "%'"
                + " OR p.idlocacao = " + codigo + ")");
        List<Populartabelalocacao> dadosLocacao = (List<Populartabelalocacao>) query.list();

        for (Populartabelalocacao lin : dadosLocacao) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdlocacao(),
                Formatacao.ajustaDataDMA(String.valueOf(lin.getDtLocacao())),
                lin.getNomecliente(),
                lin.getDescricaoVeiculo(),
                lin.getDescricaoTipoVeiculo()});

        };
        t.commit();
        return dadosLocacao;
    }
    
    
    
    
    
    

    public static List popularTabelaManutencao(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Iterator qr = sessao.createQuery("SELECT m.idmanutencao, m.motivo, m.dtManutencao,"
                + " m.dtRetorno, v.descricao, p.nome  FROM Manutencao m, Veiculo v, Pessoa p WHERE ("
                + " m.pessoajuridica.id = p.idpessoa"
                + " AND m.veiculo.id=v.idveiculo)"
                + " AND (lower(m.motivo) LIKE '%" + criterio + "%'"
                + " OR lower(p.nome) LIKE '%" + criterio + "%'"
                + " OR m.idmanutencao = " + cod + ")"
                + " ORDER BY m.idmanutencao").list().iterator();

        Query query = (Query) sessao.createQuery(" FROM Manutencao m WHERE ("
                + " m.idmanutencao = " + cod + ")");
        List<Manutencao> dadosManut = (List<Manutencao>) query.list();

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
            tabelaModelo.addRow(new Object[]{
                tuple[0],
                tuple[1],
                Formatacao.ajustaDataDMA(String.valueOf(tuple[2])),
                Formatacao.ajustaDataDMA(String.valueOf(tuple[3])),
                tuple[4],
                tuple[5]
            });

        }
        t.commit();
        return dadosManut;
    }

    public static List popularTabelaDevolucao(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Iterator qr = sessao.createQuery("SELECT DISTINCT d.iddevolucao, d.dtDevolucao, "
                + " d.kmRodados, v.descricao, p.nome  FROM Devolucao d, Locacao l, Veiculo v, Pessoa p WHERE ("
                + " d.locacao.id = l.idlocacao"
                + " AND l.cliente.id = p.idpessoa"
                + " AND l.veiculo.id = v.idveiculo)"
                + " AND (d.kmRodados = '" + cod + "' "
                + " OR lower(p.nome) LIKE '%" + criterio + "%'"
                + " OR lower(v.descricao) LIKE '%" + criterio + "%'"
                + " OR d.iddevolucao = " + cod + ")"
                + " ORDER BY d.iddevolucao").list().iterator();

        Query query = (Query) sessao.createQuery(" FROM Devolucao d WHERE ("
                + " d.iddevolucao = " + cod + ")");
        List<Manutencao> dadosManut = (List<Manutencao>) query.list();

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
            tabelaModelo.addRow(new Object[]{
                tuple[0],
                Formatacao.ajustaDataDMA(String.valueOf(tuple[1])),
                tuple[2],
                tuple[3],
                tuple[4]
            });

        }
        t.commit();
        return dadosManut;
    }

    public static void popularTabelaReserva(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelareserva p WHERE (lower(p.descricaoveiculo) LIKE '%" + criterio + "%'"
                + " OR lower(p.nomecliente) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaotipo) LIKE '%" + criterio + "%'"
                + " OR p.idreserva = " + cod + ")"
                + " ORDER BY p.idreserva");
        List<Populartabelareserva> dadosReserva = (List<Populartabelareserva>) query.list();

        for (Populartabelareserva lin : dadosReserva) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdreserva(),
                Formatacao.ajustaDataDMA(String.valueOf(lin.getDtReserva())),
                Formatacao.ajustaDataDMA(String.valueOf(lin.getDtLocacao())),
                Formatacao.ajustaDataDMA(String.valueOf(lin.getDtDevolucao())),
                lin.getNomecliente(),
                lin.getDescricaoVeiculo(),
                lin.getDescricaoTipo()
            });

        }
        t.commit();

    }

    public static List popularTabelaFuncionario(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelafuncionario p WHERE (lower(p.nome) LIKE '%" + criterio + "%'"
                + " OR lower(p.cpf) LIKE '%" + criterio + "%'"
                + " OR lower(p.login) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaofuncao) LIKE '%" + criterio + "%'"
                + " OR p.idpessoa = " + codigo + ")");
        List<Populartabelafuncionario> dadosFunc = (List<Populartabelafuncionario>) query.list();

        for (Populartabelafuncionario lin : dadosFunc) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdpessoa(),
                lin.getNome(),
                lin.getLogin(),
                lin.getCpf(),
                lin.getRg(),
                lin.getDescricaocontato(),
                lin.getDescricaofuncao()
            });

        }
        t.commit();
        return dadosFunc;
    }

    public static List popularTabelaFornecedor(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelafornecedor p WHERE (lower(p.nome) LIKE '%" + criterio + "%'"
                + " OR lower(p.cnpj) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaoendereco) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaocidade) LIKE '%" + criterio + "%'"
                + " OR p.idpessoa = " + codigo + ")");
        List<Populartabelafornecedor> dadosFornecedor = (List<Populartabelafornecedor>) query.list();

        for (Populartabelafornecedor lin : dadosFornecedor) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdpessoa(),
                lin.getNome(),
                lin.getCnpj(),
                lin.getDescricaocontato(),
                lin.getDescricaoendereco(),
                lin.getBairro(),
                lin.getDescricaocidade()
            });

        }

        t.commit();
        return dadosFornecedor;
    }

    public static Object retornaDadosPessoas(int codpess) {
        Session sessao = null;
        Object[] object;
        object = new Object[6];
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        Query queryRetornaPesJur = (Query) sessao.createQuery(" FROM Pessoajuridica p WHERE ("
                + " p.pessoaIdpessoa = " + codpess + ")");
        Query queryRetornaPes = (Query) sessao.createQuery(" FROM Pessoa p WHERE ("
                + " p.idpessoa = " + codpess + ")");
        Query queryRetornaPesFis = (Query) sessao.createQuery(" FROM Pessoafisica p WHERE ("
                + " p.pessoaIdpessoa = " + codpess + ")");
        Query queryRetornaCliente = (Query) sessao.createQuery(" FROM Cliente p WHERE ("
                + " p.pessoaIdpessoa = " + codpess + ")");
        Query queryRetornaFunc = (Query) sessao.createQuery(" FROM Funcionario p WHERE ("
                + " p.pessoaIdpessoa = " + codpess + ")");
        Query queryRetornaContatos = (Query) sessao.createQuery(" FROM Contato p WHERE ("
                + " p.pessoa_idpessoa.id = " + codpess + ")");

        List<Pessoajuridica> dadosPesJur = (List<Pessoajuridica>) queryRetornaPesJur.list();
        List<Pessoa> dadosPes = (List<Pessoa>) queryRetornaPes.list();
        List<Pessoafisica> dadosPesFis = (List<Pessoafisica>) queryRetornaPesFis.list();
        List<Cliente> dadosCliente = (List<Cliente>) queryRetornaCliente.list();
        List<Funcionario> dadosFunc = (List<Funcionario>) queryRetornaFunc.list();
        List<Contatopessoas> dadosContatos = (List<Contatopessoas>) queryRetornaContatos.list();
        t.commit();
        object[0] = dadosPesJur;
        object[1] = dadosPes;
        object[2] = dadosPesFis;
        object[3] = dadosCliente;
        object[4] = dadosFunc;
        object[5] = dadosContatos;

        return object;
    }

    public static Object retornaVeiculo(int codveiculo) {
        Session sessao = null;
        Object[] object;
        object = new Object[2];
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        Query queryRetornaVeiculo = (Query) sessao.createQuery(" FROM Veiculo v WHERE ("
                + " v.idveiculo = " + codveiculo + ")");

        List<Veiculo> dadosVeiculo = (List<Veiculo>) queryRetornaVeiculo.list();

        t.commit();
        object[0] = dadosVeiculo;

        return object;
    }

    public static Object retornaTipoContato(int codcontato) {
        Session sessao = null;
        Object[] object;
        object = new Object[2];
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        Query queryRetornaVeiculo = (Query) sessao.createQuery(" FROM Tipocontato t WHERE ("
                + " t.idtipoContato = " + codcontato + ")");

        List<Veiculo> dadosContato = (List<Veiculo>) queryRetornaVeiculo.list();

        t.commit();
        object[0] = dadosContato;

        return object;
    }

    public static Object retornaReserva(int codreserva) {
        Session sessao = null;
        Object[] object;
        object = new Object[2];
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        Query queryRetornaReserva = (Query) sessao.createQuery(" FROM Reserva r WHERE ("
                + " r.idreserva = " + codreserva + ")");

        List<Reserva> dadosReserva = (List<Reserva>) queryRetornaReserva.list();

        t.commit();
        object[0] = dadosReserva;

        return object;
    }

    public static Object retornaLocacao(int codlocacao) {
        Session sessao = null;
        Object[] object;
        object = new Object[2];
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        Query queryRetornaLocacao = (Query) sessao.createQuery(" FROM Locacao l WHERE ("
                + " l.idlocacao = " + codlocacao + ")");

        List<Locacao> dadosLocacao = (List<Locacao>) queryRetornaLocacao.list();

        t.commit();
        object[0] = dadosLocacao;

        return object;
    }

    public static Object retornaCidade(int codCidade) {
        Session sessao = null;
        Object[] object;
        object = new Object[2];
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        Query queryRetornaCidade = (Query) sessao.createQuery(" FROM Cidade c WHERE ("
                + " c.idcidade = " + codCidade + ")");

        List<Cidade> dadosCidade = (List<Cidade>) queryRetornaCidade.list();

        t.commit();
        object[0] = dadosCidade;

        return object;
    }

    public static List retornaPessoa(int codPessoa) {
        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Query queryRetornaPes = (Query) sessao.createQuery(" FROM Pessoa p WHERE ("
                + " p.idpessoa = " + codPessoa + ")");
        List<Pessoa> dadosPessoa = (List<Pessoa>) queryRetornaPes.list();

        return dadosPessoa;
    }

    public static List popularTabelaDocumento(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Iterator qr = sessao.createQuery("SELECT d.iddocumentos, d.descricao, v.descricao, "
                + "d.dtInclusao, d.tipo, d.observacoes  FROM Documentos d, Veiculo v WHERE ("
                + " lower(d.descricao) LIKE '%" + criterio + "%'"
                + " OR lower(d.tipo) LIKE '%" + criterio + "%'"
                + " OR lower(d.observacoes) LIKE '%" + criterio + "%'"
                + " OR lower(v.descricao) LIKE '%" + criterio + "%'"
                + " OR d.iddocumentos = " + cod + ")"
                + " AND v.idveiculo=d.veiculo.id"
                + " ORDER BY d.iddocumentos").list().iterator();

        Query query = (Query) sessao.createQuery(" FROM Documentos d WHERE ("
                //+ " lower(d.descricao) LIKE '%" + criterio + "%'"
                + " d.iddocumentos = " + cod + ")");
        List<Documentos> dadosDocumento = (List<Documentos>) query.list();

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
            tabelaModelo.addRow(new Object[]{
                tuple[0],
                tuple[1],
                tuple[2],
                tuple[3],
                tuple[4],
                tuple[5]
            });

        }
        t.commit();
        return dadosDocumento;
    }

    public static List popularTabelaCliente(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelacliente p WHERE (lower(p.nome) LIKE '%" + criterio + "%'"
                + " OR lower(p.cpf) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaoendereco) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaocidade) LIKE '%" + criterio + "%'"
                + " OR p.idcliente = " + codigo + ")");
        List<Populartabelacliente> dadosClientes = (List<Populartabelacliente>) query.list();

        for (Populartabelacliente lin : dadosClientes) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdcliente(),
                lin.getNome(),
                lin.getCpf(),
                lin.getRg(),
                lin.getDescricaocontato(),
                lin.getDescricaoendereco(),
                lin.getDescricaocidade()});

        }
        t.commit();
        return dadosClientes;
    }

    public static void popularTabelaPermissao(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Iterator qr = sessao.createQuery("SELECT per.idpermissao, per.ler, per.inserir, per.editar, "
                + " per.inativar, per.idtela, t.descricao, per.idpessoa, p.nome  "
                + " FROM Permissao per, Funcionario f, Funcao fu, Pessoa p, Tela t "
                + " WHERE (per.idpermissao = " + cod + ""
                + " OR lower(t.descricao) LIKE '%" + criterio + "%'"
                + " OR lower(p.nome) LIKE '%" + criterio + "%')"
                + " AND (per.idpessoa=f.pessoaIdpessoa"
                + " AND f.funcao.id=fu.idfuncao"
                + " AND p.idpessoa=per.idpessoa"
                + " AND t.idtela=per.idtela)").list().iterator();

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
            tabelaModelo.addRow(new Object[]{
                tuple[0],
                tuple[1],
                tuple[2],
                tuple[3],
                tuple[4],
                tuple[5],
                tuple[6],
                tuple[7],
                tuple[8]
            });

        }

        t.commit();

    }

    public static List popularTabelaTipoContato(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Tipocontato t WHERE ("
                + " lower(t.descricao) LIKE '%" + criterio + "%'"
                + " OR t.idtipoContato = " + cod + ")"
                + " ORDER BY t.idtipoContato");
        List<Tipocontato> dadosTipoContato = (List<Tipocontato>) query.list();

        for (Tipocontato lin : dadosTipoContato) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdtipoContato(),
                lin.getDescricao()
            });

        }
        t.commit();
        return dadosTipoContato;
    }

    public static List popularTabelaTipoVeiculo(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Tipoveiculo t WHERE ("
                + " lower(t.descricao) LIKE '%" + criterio + "%'"
                + " OR lower(t.especificacoes) LIKE '%" + criterio + "%'"
                + " OR lower(t.observacoes) LIKE '%" + criterio + "%'"
                + " OR t.idtipoVeiculo = " + cod + ")"
                + "ORDER BY t.idtipoVeiculo");
        List<Tipoveiculo> dadosTipoVeiculo = (List<Tipoveiculo>) query.list();

        for (Tipoveiculo lin : dadosTipoVeiculo) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdtipoVeiculo(),
                lin.getDescricao(),
                lin.getValorDiaria(),
                lin.getEspecificacoes(),
                lin.getObservacoes()
            });

        }
        t.commit();
        return dadosTipoVeiculo;
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

            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro popular = " + he);

        } finally {
            sessao.close();

        }

    }

    public static void popularTabelaVeiculosTipoeStatusReserva(JTable tb) {
        Session sessao = null;
        try {
            DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
            tabelaModelo.setNumRows(0);

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            Query query = (Query) sessao.createQuery(" FROM Veiculostipoestatusreserva");
            List<Veiculostipoestatusreserva> dadosVTS = (List<Veiculostipoestatusreserva>) query.list();

            for (Veiculostipoestatusreserva v : dadosVTS) {
                tabelaModelo.addRow(new Object[]{
                    Formatacao.ajustaDataDMA(String.valueOf(v.getDtReserva())),
                    v.getDescricaoVeiculo(),
                    v.getDescricaoTipo(),
                    Formatacao.ajustaDataDMA(String.valueOf(v.getDtLocacao())),
                    Formatacao.ajustaDataDMA(String.valueOf(v.getDtDevolucao())),
                    v.getNomecliente(),});
            }

            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro popular = " + he);

        } finally {
            sessao.close();

        }

    }

    public static List popularTabelaStatusVeiculo(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Statusveiculo s WHERE ("
                + " lower(s.descricao) LIKE '%" + criterio + "%'"
                + " OR s.idstatusveiculo = " + cod + ")"
                + " ORDER BY s.idstatusveiculo");
        List<Statusveiculo> dadosStatusVeiculo = (List<Statusveiculo>) query.list();

        for (Statusveiculo lin : dadosStatusVeiculo) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdstatusVeiculo(),
                lin.getDescricao()
            });

        }
        t.commit();
        return dadosStatusVeiculo;
    }

    public static List popularTabelaFuncao(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Funcao f WHERE ("
                + " lower(f.descricao) LIKE '%" + criterio + "%'"
                + " OR f.idfuncao = " + cod + ")"
                + " ORDER BY f.idfuncao");
        List<Funcao> dadosFuncao = (List<Funcao>) query.list();

        for (Funcao lin : dadosFuncao) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdfuncao(),
                lin.getDescricao()
            });

        }
        t.commit();
        return dadosFuncao;
    }

    public static List popularTabelaCidade(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Iterator qr = sessao.createQuery("SELECT c.idcidade, c.descricao, e.uf FROM Cidade c, Estado e WHERE (lower(c.descricao) LIKE '%" + criterio + "%'"
                + " OR lower(e.uf) LIKE '%" + criterio + "%'"
                + " OR c.idcidade = " + codigo + ")"
                + " AND e.idestado=c.estado.id").list().iterator();

        Query query = (Query) sessao.createQuery(" FROM Cidade c WHERE (lower(c.descricao) LIKE '%" + criterio + "%'"
                + " OR c.idcidade = " + codigo + ")"
        );
        List<Cidade> dadosCidade = (List<Cidade>) query.list();

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
            tabelaModelo.addRow(new Object[]{
                tuple[0],
                tuple[1],
                tuple[2]
            });

        }
        t.commit();
        return dadosCidade;
    }
}
