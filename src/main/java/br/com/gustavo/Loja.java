package br.com.gustavo;

import java.awt.Dimension;

import javax.swing.JFrame;

import br.com.gustavo.loja.ui.MenuPrincipalUi;

public final class Loja {
    private Loja(){
 }


 public static void main(String[] args){

    JFrame frame = new JFrame("Loja"); //Cria o cronstrutor que cria uma janela 

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o comportamento do botão "X"

    MenuPrincipalUi menu =  new MenuPrincipalUi(frame); //instanciam objeto da classe MenuPrincipalUi
    frame.setJMenuBar(menu.getMenuBar());
   


    frame.setPreferredSize(new Dimension(800,800)); //define a altura e altura do frame em pixels
    frame.pack();
    frame.setVisible(true); //torna o frame visivel

 }


}
