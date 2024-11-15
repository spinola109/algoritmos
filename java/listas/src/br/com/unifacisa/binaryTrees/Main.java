package br.com.unifacisa.BinaryTree;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int input = 20;
		String result;
		int capacidade = 31;  // Defina o tamanho máximo da árvore
		ArvoreBinariaMatriz tree = new ArvoreBinariaMatriz(capacidade);

		while (input != 0) {

			result = showMenu();

			if (result.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
				result = showMenu();
			} else {
				input = Integer.parseInt(result);

				switch (input) {
					case 1:
						String item = JOptionPane.showInputDialog("Digite um numero para inserir na árvore!");
						tree.insert(Integer.parseInt(item));
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Função de remoção não suportada na implementação de matriz.");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "O valor da raiz será exibido no console.");
						tree.mostrarRaiz();
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Ordem simétrica será exibida no console.");
						System.out.println("Ordem simétrica:");
						tree.emOrdem(0);
						System.out.println("");
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Pré-ordem será exibida no console.");
						System.out.println("Pré-ordem:");
						tree.preOrdem(0);
						System.out.println("");
						break;
					case 6:
						JOptionPane.showMessageDialog(null, "Pós-ordem será exibida no console.");
						System.out.println("Pós-ordem:");
						tree.posOrdem(0);
						System.out.println("");
						break;
				}
			}
		}
	}

	public static String showMenu() {
		String result = JOptionPane.showInputDialog(
				"Digite:" +
						"\n 1: Para inserir " +
						"\n 2: Para remover (não suportado na implementação de matriz)" +
						"\n 3: Para exibir a raiz" +
						"\n 4: Para exibir em ordem simétrica" +
						"\n 5: Para exibir pré-ordem" +
						"\n 6: Para exibir pós-ordem" +
						"\n 0: Para sair");

		if (result == null) {
			result = "";
		}

		return result;
	}
}
