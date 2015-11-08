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
import entidade.Permissao;
import entidade.Pessoa;
import entidade.Pessoafisica;
import entidade.Pessoajuridica;
import entidade.Populartabelacliente;
import entidade.Populartabelafornecedor;
import entidade.Populartabelafuncionario;
import entidade.Populartabelalocacao;
import entidade.Statusveiculo;
import entidade.Tipocontato;
import entidade.Tipoveiculo;
import entidade.Veiculo;
import entidade.Veiculosstatus;
import entidade.Veiculostipoestatus;
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

    public static List popularTabelaVeiculo(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Veiculosstatus v WHERE (lower(v.descricaoveiculo) LIKE '%" + criterio + "%'"
                + " OR lower(v.marca) LIKE '%" + criterio + "%'"
                + " OR lower(v.descricaotipo) LIKE '%" + criterio + "%'"
                + " OR lower(v.descricaostatus) LIKE '%" + criterio + "%'"
                + " OR v.idveiculo = " + codigo + " ) ");
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
        sessao.getTransaction().commit();
        return dadosVeiculos;

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
        sessao.getTransaction().commit();
        return dadosLocacao;
    }

    public static void popularTabelaFuncionario(int codigo, String criterio, JTable tb) {

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
        List<Populartabelafuncionario> dadosClientes = (List<Populartabelafuncionario>) query.list();

        for (Populartabelafuncionario lin : dadosClientes) {
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
        sessao.getTransaction().commit();

    }

    public static void popularTabelaFornecedor(int codigo, String criterio, JTable tb) {

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
        List<Populartabelafornecedor> dadosClientes = (List<Populartabelafornecedor>) query.list();

        for (Populartabelafornecedor lin : dadosClientes) {
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

        sessao.getTransaction().commit();

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
        Query queryRetornaContatos = (Query) sessao.createQuery(" FROM Contatopessoas p WHERE ("
                + " p.idpessoa = " + codpess + ")");

        List<Pessoajuridica> dadosPesJur = (List<Pessoajuridica>) queryRetornaPesJur.list();
        List<Pessoa> dadosPes = (List<Pessoa>) queryRetornaPes.list();
        List<Pessoafisica> dadosPesFis = (List<Pessoafisica>) queryRetornaPesFis.list();
        List<Cliente> dadosCliente = (List<Cliente>) queryRetornaCliente.list();
        List<Funcionario> dadosFunc = (List<Funcionario>) queryRetornaFunc.list();
        List<Contatopessoas> dadosContatos = (List<Contatopessoas>) queryRetornaContatos.list();
        sessao.getTransaction().commit();
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

        sessao.getTransaction().commit();
        object[0] = dadosVeiculo;

        return object;
    }

    public static List popularTabelaDocumento(int cod, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);
        JTable tbAux = new JTable();
        DefaultTableModel tabelaModeloAux = (DefaultTableModel) tbAux.getModel();
        tabelaModeloAux.setNumRows(0);

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

        for (Documentos lin : dadosDocumento) {
            tabelaModeloAux.addRow(new Object[]{
                lin.getIddocumentos(),
                lin.getDescricao(),
                lin.getVeiculo(),
                lin.getDtInclusao(),
                lin.getTipo(),
                lin.getObservacoes()
            });
        }
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
        sessao.getTransaction().commit();
        return dadosDocumento;
    }

    public static void popularTabelaCliente(int codigo, String criterio, JTable tb) {

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
        sessao.getTransaction().commit();

    }

    public static void popularTabelaPermissao(int criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        Query query = (Query) sessao.createQuery(" FROM Permissao p WHERE (p.idpermissao = " + criterio + ""
                + " OR p.idpessoa = " + criterio + ""
                + " OR p.idtela = " + criterio + ")");
        List<Permissao> dadosPerm = (List<Permissao>) query.list();

        for (Permissao lin : dadosPerm) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdpermissao(),
                lin.isLer(),
                lin.isInserir(),
                lin.isEditar(),
                lin.isInativar(),
                lin.getIdtela(),
                lin.getIdpessoa(),
                lin.getIdfuncao()});

        }
        sessao.getTransaction().commit();

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
        sessao.getTransaction().commit();
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
        sessao.getTransaction().commit();
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

            sessao.getTransaction().commit();
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
        sessao.getTransaction().commit();
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
        sessao.getTransaction().commit();
        return dadosFuncao;
    }

    public static List popularTabelaCidade(int codigo, String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);
        JTable tbAux = new JTable();
        DefaultTableModel tabelaModeloAux = (DefaultTableModel) tbAux.getModel();
        tabelaModeloAux.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Iterator qr = sessao.createQuery("SELECT c.idcidade, c.descricao, e.uf FROM Cidade c, Estado e WHERE (lower(c.descricao) LIKE '%" + criterio + "%'"
                + " OR lower(e.uf) LIKE '%" + criterio + "%'"
                + " OR c.idcidade = " + codigo + ")"
                + " AND e.idestado=c.estado.id").list().iterator();

        Query query = (Query) sessao.createQuery(" FROM Cidade c WHERE (lower(c.descricao) LIKE '%" + criterio + "%'"
                //   + " OR lower(e.uf) LIKE '%" + criterio + "%'"
                + " OR c.idcidade = " + codigo + ")"
        //  + " AND e.idestado=c.estado.id"
        );
        List<Cidade> dadosCidade = (List<Cidade>) query.list();

        for (Cidade lin : dadosCidade) {
            tabelaModeloAux.addRow(new Object[]{
                lin.getIdcidade(),
                lin.getDescricao(),
                lin.getEstado()});
        }

        while (qr.hasNext()) {
            Object[] tuple = (Object[]) qr.next();
            tabelaModelo.addRow(new Object[]{
                tuple[0],
                tuple[1],
                tuple[2]
            });

        }
        sessao.getTransaction().commit();
        return dadosCidade;
    }
}
