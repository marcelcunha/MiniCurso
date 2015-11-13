/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.ControleTela;
import com.ferramentas.IControleTela;
import com.model.Pessoa;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Marcel
 */
public class AppController  implements Initializable, IControleTela {
    private ControleTela controle;
    private List<Pessoa> lista;  
   
    @FXML
    public void irCadastro(ActionEvent e){
        controle.fixarTela("cadastro");
    }
    
    @FXML
    public void irContatos(ActionEvent e){
        //consegue o controle da classe de controle
        ApresentacaoController a = (ApresentacaoController) controle.getControle("contatos");
        
        //passa a lista de pessoas para classe de controle
        a.setLista(lista);
        
        //troca a tela inicial pela tela que mostra os contatos
        controle.fixarTela("contatos");
    }   

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @Override
    public void setControleTela(ControleTela c) {
        this.controle = c;
    }
    
}
