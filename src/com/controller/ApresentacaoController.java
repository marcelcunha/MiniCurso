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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class ApresentacaoController implements Initializable, IControleTela {
    private ControleTela controle;
    private ObservableList<Pessoa> OList = FXCollections.observableArrayList();
    private List<Pessoa> lista;
    @FXML TableView<Pessoa> tabela;
    @FXML TableColumn<Pessoa,String> colunaNome;
    @FXML TableColumn<Pessoa,String> colunaSobrenome;
    @FXML Label nome;
    @FXML Label sobrenome;
    @FXML Label nascimento;
    @FXML Label endereco;
    @FXML Label cidade;
    @FXML Label telefone;
    @FXML Label estado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       colunaNome.setText("Nome");
       colunaSobrenome.setText("Sobrenome");
       
       
       colunaNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Pessoa, String>, ObservableValue<String>>() {

           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<Pessoa, String> param) {
               return new SimpleStringProperty(param.getValue().getNome());
           }
       });
       
       colunaSobrenome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Pessoa, String>, ObservableValue<String>>() {

           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<Pessoa, String> param) {
               return new SimpleStringProperty(param.getValue().getSobrenome());
           }
       });
       
       //adiciona um listener para chamar o método mostraInformacao() 
       //toda vez que uma linha da tabela é clicada
       tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pessoa>() {

            @Override
            public void changed(ObservableValue<? extends Pessoa> observable, Pessoa oldValue, Pessoa newValue) {
                mostraInformacao(newValue);
            }
        });
    } 
    
     @FXML
    public void voltar(ActionEvent e){
        controle.fixarTela("app");
    }
    @FXML
    public void delete(ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setContentText("Deseja apagar o contato?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == ButtonType.OK){
            int selectedIndex = tabela.getSelectionModel().getSelectedIndex();
            
            tabela.getItems().remove(selectedIndex);
            lista.remove(selectedIndex);
            limpaInformacao();
        }
        
    }
    
    /**
     * Mostra os campos da pessoa cujo nome é clicado na tabela 
     * @param p 
     */
    public void mostraInformacao(Pessoa p){
        if(p!=null){
             nome.setText(p.getNome());
            sobrenome.setText(p.getSobrenome());
            //nascimento.setText();
            endereco.setText(p.getEndereco());
            cidade.setText(p.getCidade());
            telefone.setText(p.getTelefone());
            estado.setText(p.getEstado()); 
       }
        
    }
    public void limpaInformacao(){
        nome.setText("");
            sobrenome.setText("");
            //nascimento.setText();
            endereco.setText("");
            cidade.setText("");
            telefone.setText("");
            estado.setText(""); 
    }
    public void setLista(List<Pessoa> lista){
        this.lista = lista;
        OList.setAll(this.lista);
        tabela.getItems().clear();
        tabela.getItems().addAll(OList);
        
    }
    
   
     @Override
    public void setControleTela(ControleTela c) {
        this.controle = c;
    }
}
