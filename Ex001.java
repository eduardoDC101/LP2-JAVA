import java.util.Scanner;

public class Main {

  public static int sortearDados(String nome) {
    int dado1 = (int) (Math.random() * 6) + 1;
    int dado2 = (int) (Math.random() * 6) + 1;
    int dado3 = (int) (Math.random() * 6) + 1;

    if ((dado1 == dado2 || dado1 == dado3) || (dado2 == dado3)) {
      System.out.print("(" + nome + ") " + "Dado1 = " + dado1 + " Dado2 = " + dado2 + " Dado3 = " + dado3 + "\n");
      int soma = (dado1 + dado2 + dado3) * 2;
      return soma;
    } else if ((dado1 == dado2 && dado1 == dado3) && (dado2 == dado3)) {
      System.out.print("(" + nome + ") " + "Dado1 = " + dado1 + " Dado2 = " + dado2 + " Dado3 = " + dado3 + "\n");
      int soma = (dado1 + dado2 + dado3) * 3;
      return soma;
    } else {
      System.out.print("(" + nome + ") " + "Dado1 = " + dado1 + " Dado2 = " + dado2 + " Dado3 = " + dado3 + "\n");
      int soma = (dado1 + dado2 + dado3);
      return soma;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite o nome do Jogador 1: ");
    String nome1 = sc.nextLine();
    System.out.print("\nDigite o nome do Jogador 2: ");
    String nome2 = sc.nextLine();
    int valornome1 = sortearDados(nome1);
    int valornome2 = sortearDados(nome2);
    System.out.print(nome1 + "Fez " + valornome1 + " pontos\n");
    System.out.print(nome2 + "Fez " + valornome2 + " pontos\n");
    if (valornome1 > valornome2) {
      System.out.print("O jogador 1 (" + nome1 + ") ganhou");
    } else if (valornome1 == valornome2) {
      System.out.print("Empate");
    } else {
      System.out.print("O jogador 2 (" + nome2 + ") ganhou");
    }

    sc.close();
  }

}
