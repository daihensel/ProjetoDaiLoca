/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.ComboItens;
import conf.CombosDAO;
import conf.DAO;
import conf.HibernateUtil;
import conf.Popula;
import conf.Utility;
import entidade.Permissao;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class IfPermissao extends javax.swing.JInternalFrame {

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(IfTipoContato.class.getName());

    /**
     * Creates new form IfPermissao
     */
    public IfPermissao() {
        initComponents();
        this.populaCombos();
        Utility.permit(btNovo, btSalvar, null, btExcluir, this);
        habilitaCampos(false);
        btSalvar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbTela = new javax.swing.JComboBox();
        cbUsuario = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cbLer = new javax.swing.JCheckBox();
        cbExcluir = new javax.swing.JCheckBox();
        cbInserir = new javax.swing.JCheckBox();
        cbEditar = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cbFuncao = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPermissao = new javax.swing.JTable();

        setTitle("Cadastro de Permissões");

        jToolBar1.setRollover(true);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/novo_32x32.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btNovo);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar_32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bExcluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setFocusable(false);
        btExcluir.setPreferredSize(new java.awt.Dimension(71, 39));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btExcluir);
        jToolBar1.add(jSeparator1);

        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar_32x32.png"))); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        jToolBar1.add(btFechar);

        jLabel2.setText("Campos obrigatórios*:");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel4FocusGained(evt);
            }
        });

        jLabel6.setText("Tela*:");

        cbTela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Adicionar permissão para usuário*:");

        cbLer.setSelected(true);
        cbLer.setText("Ler");

        cbExcluir.setSelected(true);
        cbExcluir.setText("Excluir");

        cbInserir.setSelected(true);
        cbInserir.setText("Inserir");

        cbEditar.setSelected(true);
        cbEditar.setText("Editar");

        jLabel7.setText("Grupo de usuários*:");

        cbFuncao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbTela, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLer)
                            .addComponent(cbEditar)
                            .addComponent(cbInserir)
                            .addComponent(cbExcluir))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cbLer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbExcluir)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cadastro Permissões", jPanel4);

        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });

        jLabel3.setText("Busca");

        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/procurar_20x20.png"))); // NOI18N
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tbPermissao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Ler", "Inserir", "Editar", "Excluir", "Id Tela", "Nome Tela", "Id Pessoa", "Nome Pessoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPermissao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPermissaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPermissao);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPesquisa)
                .addGap(18, 18, 18)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta Permissões", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        habilitaCampos(true);

        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (cbTela.getSelectedIndex() >= 0 && cbFuncao.getSelectedIndex() > 0 && cbUsuario.getSelectedIndex() > 0) {
            Session sessao = null;
            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                if (cbTela.getSelectedItem() == "Todas") {
                    int somacombotela = cbTela.getItemCount() - 1;
                    for (int i = 1; i <= somacombotela; i++) {
                        Transaction t = sessao.beginTransaction();
                        Permissao p = salvaPerm();
                        System.out.println("é Todas");
                        p.setIdtela(i);
                        sessao.save(p);
                        t.commit();
                    }
                } else {
                    ComboItens cbit = (ComboItens) cbTela.getSelectedItem();
                    Transaction t = sessao.beginTransaction();
                    Permissao p = salvaPerm();
                    System.out.println("é 1 tela só");
                    p.setIdtela(cbit.getCodigo());
                    sessao.save(p);
                    t.commit();
                }
                habilitaCampos(false);
                btNovo.setEnabled(true);
                btSalvar.setEnabled(false);
            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro ao  = " + he.toString());
                System.out.println("Erro ao  = " + he.getStackTrace().toString());
                logger.error("Erro");
            } finally {
                sessao.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
        }


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void jPanel4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel4FocusGained

    }//GEN-LAST:event_jPanel4FocusGained

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        pesquisa();
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        pesquisa();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tbPermissaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPermissaoMouseClicked

    }//GEN-LAST:event_tbPermissaoMouseClicked

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained

    }//GEN-LAST:event_jPanel2FocusGained

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 1) {
            habilitaCampos(false);
            pesquisa();
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btExcluir.setEnabled(true);
        } else if (jTabbedPane1.getSelectedIndex() == 0) {
            btSalvar.setEnabled(false);
            btNovo.setEnabled(true);
            btExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jTabbedPane1.getSelectedIndex() == 1) {
            if (tbPermissao.getSelectedRow() >= 0) {
                Object[] options = {" Sim ", " Não "};
                int id = (int) tbPermissao.getValueAt(tbPermissao.getSelectedRow(), 0);
                int opcaoExcluir = JOptionPane.showOptionDialog(this.getContentPane(), "Deseja excluir o registro "
                        + id + "?",
                        "Informação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);

                if (opcaoExcluir == 0) {
                    System.out.println("id a ser excluido:" + id);
                    if (DAO.deletarPermissao(id)) {
                        JOptionPane.showMessageDialog(null, "Registro excluído!");
                        pesquisa();
                    } else {
                        JOptionPane.showMessageDialog(null, "Problemas ao excluir");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione algum registro!");
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    public void habilitaCampos(Boolean tf) {
        if (tf == false) {
            limpaCampos();
        }
        cbFuncao.setEnabled(tf);
        cbUsuario.setEnabled(tf);
        cbTela.setEnabled(tf);

        cbEditar.setEnabled(tf);
        cbExcluir.setEnabled(tf);
        cbLer.setEnabled(tf);
        cbInserir.setEnabled(tf);
    }

    public void limpaCampos() {

        cbFuncao.setSelectedIndex(0);
        cbUsuario.setSelectedIndex(0);
        cbTela.setSelectedIndex(0);

        cbEditar.setSelected(true);
        cbExcluir.setSelected(true);
        cbLer.setSelected(true);
        cbInserir.setSelected(true);
        populaCombos();
    }

    public Permissao salvaPerm() {
        Permissao p = new Permissao();

        ComboItens cbiu = (ComboItens) cbUsuario.getSelectedItem();
        p.setIdpessoa(cbiu.getCodigo());
        ComboItens cbif = (ComboItens) cbFuncao.getSelectedItem();
        p.setIdFuncao(cbif.getCodigo());

        p.setLer(cbLer.isSelected());
        p.setInserir(cbInserir.isSelected());
        p.setEditar(cbEditar.isSelected());
        p.setInativar(cbExcluir.isSelected());
        return p;
    }

    public void populaCombos() {
        cbTela.removeAllItems();
        cbTela.addItem("Todas");
        new CombosDAO().popularCombo("Tela", "idtela", "descricao", cbTela, "");
        cbTela.removeItemAt(1);
        cbUsuario.removeAllItems();
        new CombosDAO().popularCombo("Funcionario", "pessoaIdpessoa", "login", cbUsuario, "");
        cbFuncao.removeAllItems();
        new CombosDAO().popularCombo("Funcao", "idfuncao", "descricao", cbFuncao, "");
    }

    public void pesquisa() {
        int cod = 0;
        if (tfPesquisa.getText().length() > 0 && tfPesquisa.getText().matches("[0-9]")) {
            cod = Integer.parseInt(tfPesquisa.getText());
        }
        Popula.popularTabelaPermissao(cod, tfPesquisa.getText(), tbPermissao);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox cbEditar;
    private javax.swing.JCheckBox cbExcluir;
    private javax.swing.JComboBox cbFuncao;
    private javax.swing.JCheckBox cbInserir;
    private javax.swing.JCheckBox cbLer;
    private javax.swing.JComboBox cbTela;
    private javax.swing.JComboBox cbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbPermissao;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
