package com.empresa.main;

import com.empresa.model.Produto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeEstoque {
    
    public static void main(String[] args){
        String caminhoArquivo = "C:\\Users\\edutn\\OneDrive\\Documentos\\NetBeansProjects\\LeitorDeIntervalo\\csv\\produtos.csv";
        System.out.println("--- Iniciando Leitura do Inventário ---");
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){
            String linha;
            br.readLine(); //Pula a primeira linha do cabeçalho
            double valorTotalInventario = 0.0; //Criando variável acumuladora para o total de inventário
            int totalDeProdutos = 0; //variável acumuladora para o número de produtos
            String[] produtoMaisCaro = {"0", "."}; // criando um array para receber nome e preço e comparar o mais caro
            String[] produtoMaisBarato = {"100000", "."}; // criando um array para receber nome e preço e comparar o mais barato
            
            //Loop para ler todas as linhas de dados do arquivo
            while((linha = br.readLine()) != null){
                String[] dados =linha.split(","); //Divide a linha em um array de String
                
                //Extrai os dados do array
                String nome = dados[0];
                //Converte (parse) o preço de String para double
                double preco = Double.parseDouble(dados[1]);
                //Converte (parse) a quantidade de String para int
                int estoque = Integer.parseInt(dados[2]);
                
                double valortotal = preco*estoque; //calculando o valor de estoque de cada produto
                
                //Produto mais caro
                if(Double.parseDouble(produtoMaisCaro[0]) < preco){
                    produtoMaisCaro[0] = String.valueOf(preco);
                    produtoMaisCaro[1] = nome;
                }
                
                //Produto mais barato
                if(Double.parseDouble(produtoMaisBarato[0]) > preco){
                    produtoMaisBarato[0] = String.valueOf(preco);
                    produtoMaisBarato[1] = nome;
                }
                
                //Cria(instancia) um novo objeto Produto usando o construtor
                Produto produto = new Produto(nome, preco, estoque);
                
                //Chama o método do objeto para exibir suas informações
                produto.exibirInformacoes();
                
                valorTotalInventario += valortotal; //Atribuindo o valor do produto a variável acumuladora
                totalDeProdutos += estoque;
            }
            //valorTotalInventario
            
            System.out.println("\n==============================");
            System.out.printf("VALOR TOTAL DO INVENTÁRIO: R$ %.2f\n", valorTotalInventario); //Mostrando variável acumuladora
            System.out.printf("VALOR MÉDIO POR PRODUTO: R$ %.2f\n", (valorTotalInventario/totalDeProdutos)); //Mostrando variável acumuladora (numero total de produtos)
            System.out.printf("PRODUTO MAIS CARO: %s | VALOR: R$ %.2f\n", produtoMaisCaro[1], Double.parseDouble(produtoMaisCaro[0]));
            System.out.printf("PRODUTO MAIS BARATO: %s | VALOR: R$ %.2f\n", produtoMaisBarato[1], Double.parseDouble(produtoMaisBarato[0]));
            System.out.println("==============================");
            
        }catch(IOException e){
            System.out.println("ERRO: Não foi possível ler o arquivo. Verifique o caminho do arquivo");
            e.printStackTrace(); // Imprime o rastreamento do erro para depuração
        } catch(NumberFormatException e){
            System.out.println("ERRO: Formato numérico inválido em uma das linhas do arquivo");
            e.printStackTrace();
        }
        
        System.out.println("\n--- Leitura do Inventário Concluída ---");
    }
}
