/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import entidade.Tipoveiculo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class DAO {
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

    public static String deletarTipoVeiculo(int idTipoVeiculo) {
        String retorno = "";

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            String hqlDelete = ("DELETE Tipoveiculo WHERE idtipo_veiculo = '" + idTipoVeiculo + "'");

            int deleteEntities = sessao.createQuery(hqlDelete).executeUpdate();

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("Erro ao excluir = " + he);

        }
        return retorno;
    }
    
    
}
