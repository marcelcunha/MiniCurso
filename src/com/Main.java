package com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.controller.AppController;
import com.controller.ApresentacaoController;
import com.controller.CadastroController;
import com.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Marcel
 */
public class Main extends Application {
    private List<Pessoa> listaPessoas = new ArrayList();
    
    
    @Override
    public void start(Stage stage) throws Exception {
         ControleTela c = new ControleTela();
        
         //carrega todas as telas da aplicação
        c.carregarTela("app", "view/app.fxml");
        c.carregarTela("contatos", "view/apresentacao.fxml");
        c.carregarTela("cadastro", "view/cadastro.fxml");
        
        //consegue o controle das classes de controle
        AppController contato = (AppController) c.getControle("app");
        CadastroController cadastro = (CadastroController) c.getControle("cadastro");
                
       // populaLista();
        
        //passa a lista de pessoas para as classes de controle
        cadastro.setList(listaPessoas);
        contato.setLista(listaPessoas);

        //tela que será mostrada
        c.fixarTela("app");
        
        Scene scene = new Scene(c);
        
        stage.setScene(scene);
        stage.show();
    }

    private void populaLista(){
        listaPessoas.add(new Pessoa("Joao", "Silva", "Rua A, 1", "Palmas", "TO","13256"));
        listaPessoas.add(new Pessoa("Pedro", "Sousa", "Rua B, 1", "Recife", "PE","13257"));
        listaPessoas.add(new Pessoa("Maria", "Cavalcanti", "Rua F, 45", "Curitiba", "PR","13258"));
        listaPessoas.add(new Pessoa("Helena", "Vargas", "Rua D, 89", "Palmas", "TO","13259"));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
