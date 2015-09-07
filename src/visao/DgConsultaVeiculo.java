/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.HibernateUtil;
import entidade.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Usuário
 */
public class DgConsultaVeiculo extends javax.swing.JDialog {

    public static IfReservaVeiculos tela;

    /**
     * Creates new form DlgConsultaVeiculo
     */
    public DgConsultaVeiculo(IfReservaVeiculos parent, boolean modal) {
        // super(parent, modal);
        this.tela = parent;
        this.setModal(modal);
        initComponents();
        


        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "ProjetoDaiLocaPU");
        EntityManager em = emf.createEntityManager();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        ProjetoDaiLocaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ProjetoDaiLocaPU").createEntityManager();
        veiculoQuery = java.beans.Beans.isDesignTime() ? null : ProjetoDaiLocaPUEntityManager.createQuery("SELECT v FROM Veiculo v");
        veiculoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : veiculoQuery.getResultList();
        veiculoQuery1 = java.beans.Beans.isDesignTime() ? null : ProjetoDaiLocaPUEntityManager.createQuery("SELECT v FROM Veiculo v");
        veiculoList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : veiculoQuery1.getResultList();
        jTextField1 = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVeiculo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/procurar_20x20.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tbVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Statusveiculo", "Km Atual", "Dt Baixa", "Dt Inclusao", "Ano Modelo", "Ano Fabricacao", "Marca", "Descricao", "Tipoveiculo", "Idveiculo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, veiculoList1, tbVeiculo);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${statusveiculo}"));
        columnBinding.setColumnName("Statusveiculo");
        columnBinding.setColumnClass(entidade.Statusveiculo.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${kmAtual}"));
        columnBinding.setColumnName("Km Atual");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dtBaixa}"));
        columnBinding.setColumnName("Dt Baixa");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dtInclusao}"));
        columnBinding.setColumnName("Dt Inclusao");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${anoModelo}"));
        columnBinding.setColumnName("Ano Modelo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${anoFabricacao}"));
        columnBinding.setColumnName("Ano Fabricacao");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${marca}"));
        columnBinding.setColumnName("Marca");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoveiculo}"));
        columnBinding.setColumnName("Tipoveiculo");
        columnBinding.setColumnClass(entidade.Tipoveiculo.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idveiculo}"));
        columnBinding.setColumnName("Idveiculo");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(tbVeiculo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
//Session sessao = null;
//        tbVeiculo.add((Component) sessao.createSQLQuery("select * from PopularTabelaVeiculo"));
//        sessao.close();


    }//GEN-LAST:event_btnPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DgConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DgConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DgConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DgConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DgConsultaVeiculo dialog = new DgConsultaVeiculo(tela, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void PopulartabelaVeiculo(){
        
        DefaultTableModel tabelaModelo = (DefaultTableModel) tbVeiculo.getModel();
        tabelaModelo.setNumRows(0);
              
        Session sessao = null;
        
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            
            
            Query query = (Query) sessao.createQuery("Select * from PopularTabelaVeiculo");
            List<Veiculo> dadosVeiculos = query.getResultList();
            
            for(Veiculo veiculolin : dadosVeiculos ){
                tabelaModelo.addRow(new Object[]{
                        veiculolin.getDescricao(), 
                        veiculolin.getTipoveiculo(),
                        veiculolin.getMarca(),
                        veiculolin.getAnoModelo(),
                        veiculolin.getAnoFabricacao(),
                        veiculolin.getKmAtual(),
                        
                        
                        
                });
                
            }
            sessao.getTransaction().commit();

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ProjetoDaiLocaPUEntityManager;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbVeiculo;
    private java.util.List<entidade.Veiculo> veiculoList;
    private java.util.List<entidade.Veiculo> veiculoList1;
    private javax.persistence.Query veiculoQuery;
    private javax.persistence.Query veiculoQuery1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
