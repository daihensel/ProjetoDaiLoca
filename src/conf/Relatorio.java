/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

/**
 *
 * @author Daiane
 */
public class Relatorio {

    
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    SessionImpl sessionImpl = (SessionImpl) sessao;
    Connection conn = sessionImpl.connection();

    public void gerarRelatorioParametroEntreDatas(Date datainicial, Date datafinal) {
        // chamada de relatório, SEM parâmetros
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/relatorio_locacaoentredatas.jrxml"));
//            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/cidades_estados.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();
            parametros.put("datainicial", (datainicial));
            parametros.put("datafinal", (datafinal));
            parametros.put("nomesistema", "ProjetoDaiLoca ® 2015");

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, conn);

            // JasperExportManager.exportReportToPdfFile(impressao, "C:/Users/Daiane/Documents/NetBeansProjects/Assistencia/relatoriossalvos");
            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }

    public void gerarRelatorioParametroEntreDatasVeiculo(Date datainicial, Date datafinal, String veiculo) throws JRException {
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/relatorio_locacaoentredatasveiculo.jrxml"));
//            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/cidades_estados.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();
            parametros.put("datainicial", (datainicial));
            parametros.put("datafinal", (datafinal));
            parametros.put("veiculo", veiculo);
            parametros.put("nomesistema", "ProjetoDaiLoca ® 2015");

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, conn);

            // JasperExportManager.exportReportToPdfFile(impressao, "C:/Users/Daiane/Documents/NetBeansProjects/Assistencia/relatoriossalvos");
            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gerar relatório= " + e);

        }
    }

    public void gerarRelatorioParametroDescricaoAlgo(String relat, String param) {
        // chamada de relatório, SEM parâmetros

        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/relatorio_locacao" + relat + ".jrxml"));
//            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/cidades_estados.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();
            parametros.put(relat, param);
            parametros.put("nomesistema", "ProjetoDaiLoca ® 2015");

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, conn);

            // JasperExportManager.exportReportToPdfFile(impressao, "C:/Users/Daiane/Documents/NetBeansProjects/Assistencia/relatoriossalvos");
            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }

    public void gerarRelatorioLocacao(int idlocacao) {
        // chamada de relatório, SEM parâmetros
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/relatorio_locacao.jrxml"));
//            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/cidades_estados.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            parametros.put("idlocacao", idlocacao);
            parametros.put("nomesistema", "ProjetoDaiLoca ® 2015");

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, conn);

            // JasperExportManager.exportReportToPdfFile(impressao, "C:/Users/Daiane/Documents/NetBeansProjects/Assistencia/relatoriossalvos");
            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }
}
