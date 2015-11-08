/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import entidade.Documentos;
import entidade.Funcao;
import entidade.Statusveiculo;
import entidade.Tipoveiculo;
import entidade.Veiculo;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class DAO {
    
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
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(veiculo);

                sessao.getTransaction().commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Veiculo = " + he);

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
    
    public static String salvarStatusVeiculo( Statusveiculo statusVeiculo) {
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
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(statusVeiculo);

                sessao.getTransaction().commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Status Veiculo = " + he);

            }

        }
        return retorno;
    }
    
    public static String salvarDocumento( Documentos documentos) {
        Session sessao = null;
        String retorno = "";

        if (documentos.getIddocumentos() == 0) { //insert

            try {

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.save(documentos);
                t.commit();
            } catch (HibernateException he) {
                System.out.println("Erro salvar Documentos: \n" + he);
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(documentos);

                sessao.getTransaction().commit();

            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro atualizar Status Veiculo = " + he);

            }

        }
        return retorno;
    }


    public static String salvarFuncao( Funcao funcao) {
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
            }

        } else { //update

            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();

                sessao.update(funcao);

                sessao.getTransaction().commit();

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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
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

            sessao.getTransaction().commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);
            retorno = false;

        }
        return retorno;
    }

}
