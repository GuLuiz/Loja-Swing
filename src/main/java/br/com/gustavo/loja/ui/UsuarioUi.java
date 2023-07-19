package br.com.gustavo.loja.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import br.com.gustavo.loja.entity.UsuarioEntity;
import br.com.gustavo.loja.service.UsuarioService;

public class UsuarioUi extends JPanel implements ActionListener, ListSelectionListener {

    private JButton btnSalvar = new JButton();
    private JButton btnLimpar = new JButton();
    private JButton btnExcluir = new JButton();
    private JLabel  lblId = new JLabel();
    private JLabel lblNome = new JLabel();
    private JLabel lblEmail = new JLabel();
    private JLabel lblSenha = new JLabel();
    private JTextField txtId = new JTextField();
    private JTextField txtNome = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JPasswordField txtSenha = new JPasswordField();
    private String []tituloColunas = {"ID","Nome","Email","Senha"};
    private JTable tblUsuario = new JTable(){
        public boolean editCellAt(int row, int column, java.util.EventObject a){ //não permite eidição
            return false;
        }
    };

    private JScrollPane scroll = new JScrollPane(tblUsuario); //barra de rolagem na tabela


    public UsuarioUi(){
        componentes();
    }

    void componentes(){
        this.setLayout(null); //layout é o programador que define a posição dos componentes
        lblId.setText("ID"); //configura o texto do componente
        lblId.setBounds(10,10,80,25); // primeiro numero é o x, segundo o y, terceiro é a largura e ultimo a altura
        this.add(lblId);
        txtId.setBounds(10,30,80,25);
        txtId.setEnabled(false); // torna o campo desativado para digitar
        this.add(txtId);
        lblNome.setText("Nome");
        lblNome.setBounds(10,60,80,25);
        this.add(lblNome);
        txtNome.setBounds(10,80,80,25);
        this.add(txtNome);
        lblEmail.setText("Email");
        lblEmail.setBounds(10,120,80,25);
        this.add(lblEmail);
        txtEmail.setBounds(10,140,80,25);
        this.add(txtEmail);
        lblSenha.setText("Senha");
        lblSenha.setBounds(10,180,80,25);
        this.add(lblSenha);
        txtSenha.setBounds(10,200,80,25);
        this.add(txtSenha);
        btnSalvar.setText("Salvar");
        btnSalvar.setBounds(120,200,80,25);
        this.add(btnSalvar);
        btnLimpar.setText("Limpar");
        btnLimpar.setBounds(200,200,80,25);
        this.add(btnLimpar);
        btnExcluir.setText("Excluir");
        btnExcluir.setBounds(280,200,80,25);
        this.add(btnExcluir);
        scroll.setBounds(10,250,600,400);
        this.add(scroll);
        btnSalvar.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnExcluir.addActionListener(this);
        tblUsuario.getSelectionModel().addListSelectionListener(this); // configura a captura de evento na tabela
        tblUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarTabela();
        txtNome.requestFocus();
        
        
    }

    public void atualizarTabela(){

        UsuarioService usuarioService = new UsuarioService();

        List<UsuarioEntity> lista = usuarioService.listar();
        DefaultTableModel modelo = (DefaultTableModel) tblUsuario.getModel();
        modelo.setColumnIdentifiers(tituloColunas);
        modelo.setRowCount(0);
        lista.forEach(usuario ->{
            modelo.addRow(new Object[]{
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
            });
        });
        }
        
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Command : " + e.getActionCommand());
        if ( e.getActionCommand().equals("Salvar")){
          UsuarioEntity usuarioEntity = new UsuarioEntity(
            Integer.valueOf("0"+txtId.getText()),
            txtNome.getText(),
            txtEmail.getText(),
            String.valueOf(txtSenha.getPassword())
            );
            UsuarioService usuarioService = new UsuarioService();
            usuarioService.salvar(usuarioEntity);
            atualizarTabela();
            return;
        } if ( e.getActionCommand().equals("Limpar")){
            txtId.setText("");
            txtNome.setText("");
            txtEmail.setText("");
            txtSenha.setText("");
            txtNome.requestFocus();
            return;
        }
        
    } 
    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Line : " + tblUsuario.getSelectedRow());

        if (tblUsuario.getSelectedRow()>0) return;

        int linha = tblUsuario.getSelectedRow();
        txtId.setText(tblUsuario.getModel().getValueAt(linha, 0).toString());
        txtNome.setText(tblUsuario.getModel().getValueAt(linha, 1).toString());
        txtEmail.setText(tblUsuario.getModel().getValueAt(linha, 2).toString());
        txtSenha.setText(tblUsuario.getModel().getValueAt(linha, 3).toString());
    }
    
}
