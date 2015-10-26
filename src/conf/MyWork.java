/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

/**
 *
 * @author Usuário
 */
public class MyWork implements Work {
    

    private List<String> result = new ArrayList<>();
    private final String sql_tabelas = "select table_name from information_schema.tables where table_schema = 'app';";
    private String sql_exe = "";
    private final Session ses;

    public MyWork(Session ses) {
        this.ses = ses;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        result = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql_exe)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String temp = rs.getString(1);
                result.add(temp);
            }
        } catch (Exception e) {
            //Log.logar(TipoLog.ERRO, e);
        }
    }

    public List<String> getTabelas() {
        sql_exe = sql_tabelas;
        ses.doWork(this);
        return result;
    }

    public List<String> getColunas(String tabela) {
        sql_exe = montarSqlColunas(tabela);
        ses.doWork(this);
        return result;
    }

    private String montarSqlColunas(String tabela) {
        return "select COLUMN_NAME from information_schema.columns "
                + "where table_schema = 'app' and table_name = '" + tabela + "';";
    }

}

    
    
    
    

