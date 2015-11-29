/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import entidade.Cancelamento;
import entidade.Cidade;
import entidade.Cliente;
import entidade.Contato;
import entidade.Devolucao;
import entidade.Documentos;
import entidade.Endereco;
import entidade.Funcao;
import entidade.Funcionario;
import entidade.Locacao;
import entidade.Manutencao;
import entidade.Pessoa;
import entidade.Pessoafisica;
import entidade.Pessoajuridica;
import entidade.Reserva;
import entidade.Statusveiculo;
import entidade.Tipocontato;
import entidade.Tipoveiculo;
import entidade.Veiculo;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class DAO {
    
    private static org.apache.log4j.Logger logger = Logger.getLogger(DAO.class.getName());

    public static String salvarVeiculo(Veiculo veiculo) {
        Session sessao = null;
        String retorno = "";

        if (veiculo.getIdveiculo() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(veiculo);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Veículo: \n" + he);
                logger.error("erro ao salvar veiculo" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(veiculo);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Veiculo = " + he);

            }

        }
        return retorno;
    }

    public static String salvarContato(Contato contato, String fazer) {
        Session sessao = null;
        String retorno = "";

        if (fazer.equals("salvar")) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(contato);
                t.commit();
            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro salvar Contato: \n" + he);
                logger.error("Erro salvar Contato: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(contato);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Contato = " + he);
                logger.error("Erro atualizar Contato = " + he);

            }

        }
        return retorno;
    }

    
    public static String salvarCancelamento(Cancelamento cancel) {
        Session sessao = null;
        String retorno = "";

        if (cancel.getIdcancelamento() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(cancel);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Cancelamento: \n" + he);
                logger.error("Erro salvar Cancelamento: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(cancel);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Cancelamento = " + he);
                logger.error("Erro atualizar Cancelamento = " + he);

            }

        }
        return retorno;
    }

    public static String salvarDevolucao(Devolucao devolucao) {
        Session sessao = null;
        String retorno = "";

        if (devolucao.getIddevolucao() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(devolucao);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Devolução: \n" + he);
                logger.error("Erro ao salvar devolução");
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(devolucao);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Devolução = " + he);

            }

        }
        return retorno;
    }

    public static String salvarManutencao(Manutencao manut) {
        Session sessao = null;
        String retorno = "";

        if (manut.getIdmanutencao() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(manut);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Manutenção: \n" + he);
                logger.error("Erro ao salvar manutenção");
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(manut);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Manutenção = " + he);
                logger.error("erro ao atualizar manutenção");

            }

        }
        return retorno;
    }

    public static String salvarCidade(Cidade cidade) {
        Session sessao = null;
        String retorno = "";

        if (cidade.getIdcidade() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(cidade);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Cidade: \n" + he);
                logger.error("Erro salvar Cidade: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(cidade);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Cidade = " + he);
                logger.error("Erro atualizar Cidade = " + he);

            }

        }
        return retorno;
    }

    public static String salvarEndereco(Endereco endereco) {
        Session sessao = null;
        String retorno = "";

        if (endereco.getIdendereco() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(endereco);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Endereco: \n" + he);
                logger.error("Erro salvar Endereco: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(endereco);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Endereco = " + he);
                logger.error("Erro atualizar Endereco = " + he);
            }

        }
        return retorno;
    }

    public static String salvarReserva(Reserva reserva) {
        Session sessao = null;
        String retorno = "";

        if (reserva.getIdreserva() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(reserva);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Reserva: \n" + he);
                logger.error("Erro salvar Reserva" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(reserva);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Reserva = " + he);
                logger.error("Erro atualizar Reserva = " + he);

            }

        }
        return retorno;
    }

    public static String salvarLocacao(Locacao locacao) {
        Session sessao = null;
        String retorno = "";

        if (locacao.getIdlocacao() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(locacao);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Locação: \n" + he);
                logger.error("Erro salvar Locação: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(locacao);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Locação = " + he);
                logger.error("Erro atualizar Locação = " + he);

            }

        }
        return retorno;
    }

    public static String salvarFuncionario(Funcionario funcionario, String fazer) {
        Session sessao = null;
        String retorno = "";

        if (fazer.equals("salvar")) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(funcionario);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Funcionario: \n" + he);
                logger.error("Erro salvar Funcionario: \n" + he);
                

            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(funcionario);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Funcionario = " + he);
                logger.error("Erro atualizar Funcionario = " + he);

            }

        }
        return retorno;
    }

    public static String salvarPessoa(Pessoa pessoa) {
        Session sessao = null;
        String retorno = "";

        if (pessoa.getIdpessoa() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(pessoa);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Pessoa: \n" + he);
                logger.error("Erro salvar Pessoa: \n" + he);

            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(pessoa);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Pessoa = " + he);
                logger.error("Erro atualizar Pessoa = " + he);

            }

        }
        return retorno;
    }

    public static String salvarCliente(Cliente cliente, String fazer) {
        Session sessao = null;
        String retorno = "";

        if (fazer.equals("salvar")) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(cliente);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Cliente: \n" + he);
                logger.error("Erro salvar Cliente: \n" + he);

            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(cliente);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Cliente = " + he);
                logger.error("Erro atualizar Cliente = " + he);

            }

        }
        return retorno;
    }

    public static String salvarPessoaFisica(Pessoafisica pf, String fazer) {
        Session sessao = null;
        String retorno = "";

        if (fazer.equals("salvar")) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(pf);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Pessoa física: \n" + he);
                logger.error("Erro salvar Pessoa física: \n" + he);

            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(pf);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Pessoa física = " + he);
                logger.error("Erro atualizar Pessoa física = " + he);

            }

        }
        return retorno;
    }

    public static String salvarPessoaJuridica(Pessoajuridica pj, String fazer) {
        Session sessao = null;
        String retorno = "";

        if (fazer.equals("salvar")) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(pj);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Pessoa jurídica: \n" + he);
                logger.error("Erro salvar Pessoa jurídica: \n" + he);

            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(pj);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Pessoa jurídica = " + he);
                logger.error("Erro atualizar Pessoa jurídica = " + he);
            }

        }
        return retorno;
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
                logger.error("Erro salvar Tipoveículo: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(tipoVeiculo);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar TipoVeiculo = " + he);
                logger.error("Erro atualizar TipoVeiculo = " + he);

            }

        }
        return retorno;
    }

    public static String salvarTipoContato(Tipocontato tipoContato) {
        Session sessao = null;
        String retorno = "";

        if (tipoContato.getIdtipoContato() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(tipoContato);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Tipocontato: \n" + he);
                logger.error("Erro salvar Tipocontato: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(tipoContato);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Tipocontato = " + he);
                logger.error("Erro atualizar Tipocontato = " + he);

            }

        }
        return retorno;
    }

    public static String salvarStatusVeiculo(Statusveiculo statusVeiculo) {
        Session sessao = null;
        String retorno = "";

        if (statusVeiculo.getIdstatusVeiculo() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(statusVeiculo);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Status: \n" + he);
                logger.error("Erro salvar Status: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(statusVeiculo);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Status Veiculo = " + he);
                logger.error("Erro atualizar Status Veiculo = " + he);
                

            }

        }
        return retorno;
    }

    public static String salvarDocumento(Documentos documentos) {
        Session sessao = null;
        String retorno = "";

        if (documentos.getIddocumentos() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(documentos);
                t.commit();
            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro ao salvar Documentos: \n" + he);
                logger.error("Erro ao salvar Documentos: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(documentos);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Documento = " + he);
                logger.error("Erro atualizar Documento = " + he);

            }

        }
        return retorno;
    }

    public static String salvarFuncao(Funcao funcao) {
        Session sessao = null;
        String retorno = "";

        if (funcao.getIdfuncao() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(funcao);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Funcao: \n" + he);
                logger.error("Erro salvar Funcao: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(funcao);

                t.commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar funcao = " + he);

            }

        }
        return retorno;
    }

    public static Boolean deletarTipoVeiculo(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Tipoveiculo WHERE idtipo_veiculo = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir = " + he);
            retorno = false;
        }
        return retorno;
    }

    public static Boolean deletarCidade(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Cidade WHERE idcidade = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir = " + he);
            retorno = false;

        }
        return retorno;
    }
    
    public static Boolean deletarContato(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Contato WHERE idcontato = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir = " + he);
            retorno = false;

        }
        return retorno;
    }

    public static Boolean deletarDocumento(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Documentos WHERE iddocumentos = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir documento = " + he);
            retorno = false;

        }
        return retorno;
    }

    public static Boolean deletarPermissao(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Permissao WHERE idpermissao = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir permissão = " + he);
            logger.error("Erro ao excluir permissão = " + he);
            retorno = false;

        }
        return retorno;
    }

    public static Boolean deletarFuncao(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Funcao WHERE idfuncao = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir funcao= " + he);
            retorno = false;

        }
        return retorno;
    }

    public static Boolean deletarStatusVeiculo(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Statusveiculo WHERE idstatusveiculo = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir Status= " + he);
            retorno = false;

        }
        return retorno;
    }

    public static Boolean deletarTipoContato(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Tipocontato WHERE idtipoContato = " + id + "");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir = " + he);
            retorno = false;

        }
        return retorno;
    }

    public static Boolean deletarFornecedor(int id) {
        Boolean retorno = false;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            Query querye = (Query) sessao.createQuery("SELECT endereco.id FROM Pessoa WHERE idpessoa = ?").setInteger(0, id);
            int idEndereco = (int) querye.list().get(0);
            // Query queryc = (Query) sessao.createQuery("SELECT contato_idcontato FROM contato_pessoa WHERE idpessoa = ?").setInteger(0, id);
            // int idContato = (int) queryc.list().get(0);

            String hqlDeletePJ = ("DELETE Pessoajuridica WHERE pessoa_idpessoa = " + id + "");
            String hqlDeleteP = ("DELETE Pessoa WHERE idpessoa = " + id + "");
            String hqlDeleteE = ("DELETE Endereco WHERE idendereco = " + idEndereco + "");
            // String hqlDeleteC = ("DELETE Contato WHERE idcontato = " + idContato + "");

            int deleteEntities = sessao.createQuery(hqlDeletePJ).executeUpdate();
            deleteEntities = sessao.createQuery(hqlDeleteP).executeUpdate();
            deleteEntities = sessao.createQuery(hqlDeleteE).executeUpdate();
            // deleteEntities = sessao.createQuery(hqlDeleteC).executeUpdate();

            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            logger.error("Erro ao excluir fornecedor= " + he);
            retorno = false;

        }
        return retorno;
    }

}
