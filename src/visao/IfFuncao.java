/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.DAO;
import conf.HibernateUtil;
import conf.Popula;
import conf.Utility;
import entidade.Cidade;
import entidade.Estado;
import entidade.Funcao;
import entidade.Tipoveiculo;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class IfFuncao extends javax.swing.JInternalFrame {

    private org.apache.log4j.Logger logger = Logger.getLogger(DgLogin.class.getName());
    int idFuncao = 0;

    /**
     * Creates new form IfFuncao
     */
    public IfFuncao() {
        initComponents();
        Utility.permit(btNovo, btSalvar, btEditar, btExcluir, this);
        habilitaCampos(false);
        this.pesquisa();
        jTabbedPane1StateChanged(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncoes = new javax.swing.JTable();
        tfPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setTitle("Cadastro de Funções");

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

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jLabel2.setText("Nome função*:");

        tfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDescricaoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro funções", jPanel1);

        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });

        jLabel3.setText("Busca");

        tbFuncoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFuncoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFuncoes);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta funções", jPanel2);

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
        btExcluir.setPreferredSize(new java.awt.Dimension(71, 39));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btExcluir);

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bEditar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btEditar);
        jToolBar1.add(jSeparator1);

        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar_32x32.png"))); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        jToolBar1.add(btFechar);

        jLabel7.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(9, 9, 9))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        Session sessao = null;
        if (tfDescricao.getText().trim().length() > 0) {

            Funcao f = new Funcao();

            f.setIdfuncao(idFuncao);
            f.setDescricao(tfDescricao.getText());
            
            DAO.salvarFuncao(f);

            pesquisa();
            habilitaCampos(false);
            btNovo.setEnabled(true);
            btSalvar.setEnabled(false);
            tfDescricao.requestFocus();

        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        habilitaCampos(true);
        jTabbedPane1.setSelectedIndex(0);
        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (jTabbedPane1.getSelectedIndex() == 1) {
            if (tbFuncoes.getSelectedRow() >= 0) {
                String cod = String.valueOf(tbFuncoes.getValueAt(tbFuncoes.getSelectedRow(), 0));
                int codigo = Integer.parseInt(cod);
                List<Funcao> l = Popula.popularTabelaFuncao(codigo, String.valueOf(codigo), tbFuncoes);
                for (Funcao lin : l) {
                    idFuncao = lin.getIdfuncao();
                    tfDescricao.setText(lin.getDescricao());

                }
                jTabbedPane1.setSelectedIndex(0);
                habilitaCampos(true);
                btNovo.setEnabled(false);
                btSalvar.setEnabled(true);

                tfDescricao.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione algum registro!");
            }
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 1) {
            habilitaCampos(false);
            pesquisa();
            btSalvar.setEnabled(false);
            btEditar.setEnabled(true);
            btNovo.setEnabled(true);
            btExcluir.setEnabled(true);
        } else if (jTabbedPane1.getSelectedIndex() == 0) {
            btSalvar.setEnabled(false);
            btEditar.setEnabled(false);
            btNovo.setEnabled(true);
            btExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained

    }//GEN-LAST:event_jPanel2FocusGained

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        pesquisa();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        pesquisa();
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained

    }//GEN-LAST:event_jPanel1FocusGained

    private void tfDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescricaoKeyTyped

    }//GEN-LAST:event_tfDescricaoKeyTyped

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jTabbedPane1.getSelectedIndex() == 1) {
            if (tbFuncoes.getSelectedRow() >= 0) {
                Object[] options = {" Sim ", " Não "};
                String descricao = String.valueOf(tbFuncoes.getValueAt(tbFuncoes.getSelectedRow(), 1));
                int opcaoExcluir = JOptionPane.showOptionDialog(this.getContentPane(), "Deseja excluir o registro "
                        + descricao + "?",
                        "Informação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);

                if (opcaoExcluir == 0) {
                    int id = (int) tbFuncoes.getValueAt(tbFuncoes.getSelectedRow(), 0);
                    System.out.println("id a ser excluido:" + id);
                    if (DAO.deletarFuncao(id)) {
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

    private void tbFuncoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncoesMouseClicked
        if (evt.getClickCount() > 1) {
            btEditarActionPerformed(null);
        }
    }//GEN-LAST:event_tbFuncoesMouseClicked

    public void habilitaCampos(Boolean tf) {
        if (tf == false) {
            limpaCampos();
        }
        tfDescricao.setEnabled(tf);
    }

    public void limpaCampos() {
        tfDescricao.setText("");
    }

    public void pesquisa() {
        int cod = 0;
        if (tfPesquisa.getText().length() > 0 && tfPesquisa.getText().matches("[0-9]")) {
            cod = Integer.parseInt(tfPesquisa.getText());
        }
        Popula.popularTabelaFuncao(cod, tfPesquisa.getText(), tbFuncoes);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbFuncoes;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
