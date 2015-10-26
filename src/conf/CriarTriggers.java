/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Usuário
 */
public class CriarTriggers {
    
    
    static Session ses = HibernateUtil.getSessionFactory().openSession();
    MyWork work = new MyWork(ses);
    private final String nome_procedure = "auditar";

    public CriarTriggers() {
    //    deletarProcedure();
    //    criarProcedure();
        criarTriggersNoBanco();
    }

    private void deletarProcedure() {
        String drop_procedure = "DROP procedure IF EXISTS `" + nome_procedure + "`;";
        executarSQL(drop_procedure);
    }

    private void criarProcedure() {
        String create_procedure = "CREATE PROCEDURE `" + nome_procedure + "` ( "
                + " tabela varchar(100), campo varchar(100), chave int, valorAntigo varchar(200), "
                + " valorNovo varchar(200)) BEGIN "
                + " INSERT INTO auditoria1(tabela, campo, chave, valorAntigo, valorNovo) "
                + " values (tabela, campo, chave, valorAntigo, valorNovo); END";
        executarSQL(create_procedure);
    }

    private void criarTriggersNoBanco() {
        // Monta uma lista de tabelas e cria a trigger para cada uma delas.s
        List<String> tabelas = work.getTabelas();
        String temp;
        for (String tabela : tabelas) {
            //Tabela de auditoria1 não tem auditoria1.
            if (tabela.equals("auditoria1")) {
                continue;
            }
            temp = montarTriggerPorColunas(tabela);
            executarSQL(temp);
        }
    }

    /**
     * Recebe uma tabela e, monta a trigger para todas as colunas desta tabela.
     *
     * @param tabela
     */
    private String montarTriggerPorColunas(String tabela) {

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TRIGGER ");
        sb.append("audit_");
        sb.append(tabela);
        sb.append("\n BEFORE UPDATE ON ");
        sb.append(tabela);
        sb.append("\n FOR EACH ROW BEGIN \n");
        sb.append(montarLinhaTrigger(tabela));
        sb.append("\n END");
        return sb.toString();
    }

    private String montarLinhaTrigger(String tabela) {
        StringBuilder temp = new StringBuilder();
        List<String> colunas = work.getColunas(tabela);
        for (String coluna : colunas) {
            temp.append("\n IF ((IFNULL(OLD.");
            temp.append(coluna);
            temp.append(", '')) <> (IFNULL(NEW.");
            temp.append(coluna);
            temp.append(", ''))) THEN CALL ");
            temp.append(nome_procedure);
            temp.append("('");
            temp.append(tabela);
            temp.append("', '");
            temp.append(coluna);
            temp.append("', old.id, old.");
            temp.append(coluna);
            temp.append(", new."); // Aqui tem que buscar a chave primária
            temp.append(coluna);
            temp.append("); \n END IF; \n");
        }
        return temp.toString();
    }

    private void executarSQL(String sql) {
        try {
            ses = HibernateUtil.getSessionFactory().openSession();
            ses.beginTransaction();
            ses.createSQLQuery(sql).executeUpdate();
            ses.getTransaction().commit();
            ses.close();
        } catch (Exception e) {
           // Log.logar(TipoLog.ERRO, e);
        }
    }
    
    
    
    
    
    
    
}
