/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.ferramentas.IControleTela;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Marcel
 */
public class ControleTela extends StackPane{
    //mantem um vínculo entre as telas criadas e uma string 
    private Map<String, Node> telas = new HashMap<>();
    //mantem um vínculo entre os controles das telas criadas e uma string 
    private Map<String, IControleTela> controle = new HashMap<>();
    
    /**
     * Carrega uma tela tela para memória, adiciona seu conteudo no map telas
     * e seu controle no map controle
     * @param nome nome que será associado a tela
     * @param caminho caminho para o arquivo fxml
     */
    public void carregarTela(String nome, String caminho){
        try{
            //instancia objeto que irá carregar a tela
            FXMLLoader loader = new FXMLLoader();
            
            //seta o caminho para o fxml de sua tela 
             loader.setLocation(getClass().getResource(caminho));
             
            //carrega a tela para um container  
            Parent tela = (Parent) loader.load();
            
            //encontra o controlador da classe de controle
            IControleTela controlador = (IControleTela) loader.getController();
            
            //adiciona esta instância de classe a classe de controle
            controlador.setControleTela(this);
            
            //insere no mapa de telas e controle
            telas.put(nome, tela);
            controle.put(nome, controlador);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Dado um nome mostra a tela para o usuario
     * @param nome nome associado a tela
     */
    public void fixarTela(String nome){
        if(telas.get(nome)!=null){
            /*se há telas carregadas no StackPane, ela é removida e a escolhida é
            trazida a tona*/
            if(!this.getChildren().isEmpty()){
                this.getChildren().remove(0);
                this.getChildren().add(0, telas.get(nome));
            }else{//se não há, ela é adicionada
                this.getChildren().add(telas.get(nome));
            }            
        }
    }
    
    /**
     * Encontra o controle dado um nome
     * @param nome nome associado a tela
     * @return controle da classe
     */
    public IControleTela getControle(String nome){
        if(controle.get(nome)==null){//se nao existir esse imprime o aviso (uma excessão é lançada)
            System.out.println("Não existe uma tela com esse nome!");
        }
        return controle.get(nome);
    }
}
