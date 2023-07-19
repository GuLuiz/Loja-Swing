package br.com.gustavo.loja.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MenuPrincipalUi implements ActionListener{
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    public JMenuBar getMenuBar() {
        return menuBar;
    }


    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }


    public JMenu getMenu() {
        return menu;
    }


    public void setMenu(JMenu menu) {
        this.menu = menu;
    }


    public JMenuItem getMenuItem() {
        return menuItem;
    }


    public void setMenuItem(JMenuItem menuItem) {
        this.menuItem = menuItem;
    }


    public JFrame getFrame() {
        return frame;
    }


    public void setFrame(JFrame frame) {
        this.frame = frame;
    }


    private JFrame frame;

    public MenuPrincipalUi (JFrame frame){

        this.frame = frame;
        menuBar = new JMenuBar(); // barra de menu
        menu = new JMenu("Cadastro"); // opcao do menu
        menuBar.add(menu); // adicionando na barra de menu a opção Cadastro

        menuItem = new JMenuItem("Usuario", KeyEvent.VK_U); // itens do menu
        menuItem.addActionListener(this);
        menu.add(menuItem); // adicionando o item a opção do menu

        menuItem = new JMenuItem("Produto", KeyEvent.VK_P);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu.addSeparator();

        
        menuItem = new JMenuItem("Sair", KeyEvent.VK_S);
        menuItem.addActionListener(this);
        menu.add(menuItem);

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Command : " + e.getActionCommand());
        System.out.println("ID: " + e.getID());

        if(e.getActionCommand().equals("Usuario")){
            UsuarioUi usuario = new UsuarioUi(); // instancia o painel de cadastro de usuário
            this.frame.getContentPane().removeAll(); // remove todos os paineis do frame
            this.frame.getContentPane().add(usuario); // adiciona o painel de cadastro de usuario ao frame
            this.frame.validate();
            this.frame.repaint(); // atualiza o frame visualmente com os novos componentes

        }
        if(e.getActionCommand().equals("Produto")){
            ProdutoUi produto = new ProdutoUi();
            this.frame.getContentPane().removeAll();
            this.frame.getContentPane().add(produto);
            this.frame.validate();
            this.frame.repaint();
        }
        if(e.getActionCommand().equals("Sair")){
            System.exit(0); // encerra a aplicação

        }
        
    }
    
}
