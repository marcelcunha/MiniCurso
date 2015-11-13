/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.ControleTela;
import com.ferramentas.IControleTela;
import com.model.Pessoa;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class CadastroController implements Initializable, IControleTela {
    private ControleTela controle;
    private List<Pessoa> lista;
    @FXML TextField nome;
    @FXML TextField sobrenome;
    @FXML TextField nascimento;
    @FXML TextField endereco;
    @FXML TextField cidade;
    @FXML TextField telefone;
    @FXML TextField estado;
    
    public void limparCampos(ActionEvent e){
        nome.setText("");
        sobrenome.setText("");
        nascimento.setText("");
        endereco.setText("");
        cidade.setText("");
        telefone.setText("");
        estado.setText("");     
    }
    
    @FXML
    public void salvarContato(ActionEvent e){
        lista.add(new Pessoa(nome.getText(), 
                            sobrenome.getText(),
                            endereco.getText(), 
                            cidade.getText(),
                            estado.getText(),
                            telefone.getText()));
        limparCampos(null);
    }
    
    @FXML
    public void voltar(){
        controle.fixarTela("app");
    }
    
    @FXML
    public void setList(List<Pessoa> lista){
        this.lista = lista;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @Override
    public void setControleTela(ControleTela c) {
        this.controle = c;
    }
}
