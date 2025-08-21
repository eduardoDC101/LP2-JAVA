package com.empresa.model;

//Representa o modelo de um produto da loja

public class Produto {
    
    //Atributos da classe
    String nome;
    double preco;
    int quantidadeEmEstoque;
    
    /* Construtor d aClasse Produto
    Um construtor é um método especial usado para inicializar um projeto recém-criado
    Ele é chamado automaticamente quando usamos a palavra chave 'new'.
    @param nome Nome do produto
    @param preco Preço unitário do produto
    @param quantidadeEmEstoque Quantidade Disponível em estoque
    */
    public Produto(String nome, double preco, int quantidadeEmEstoque){
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        
        
    }
    
    public void exibirInformacoes(){
        System.out.println("------------------------------");
        System.out.println("Produto: " + this.nome);
        System.out.printf("Preço: R$ %.2f\n", this.preco); //usnado printf para formatar
        System.out.println("Estoque: " + this.quantidadeEmEstoque);
    }
    
    
   
}
