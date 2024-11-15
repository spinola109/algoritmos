package br.com.unifacisa.BinaryTree;

public class ArvoreBinariaMatriz {

	private int[] arvore;
	private int capacidade;

	// Construtor que inicializa a árvore com uma capacidade máxima
	public ArvoreBinariaMatriz(int capacidade) {
		this.capacidade = capacidade;
		this.arvore = new int[capacidade];
		for (int i = 0; i < capacidade; i++) {
			arvore[i] = -1; // Inicializamos os nós vazios com -1
		}
	}

	// Inserção na árvore em matriz
	public void insert(int valor) {
		if (arvore[0] == -1) {
			arvore[0] = valor;
		} else {
			insertNaMatriz(0, valor);
		}
	}

	private void insertNaMatriz(int index, int valor) {
		if (index >= capacidade) {
			System.out.println("Capacidade máxima da árvore alcançada!");
			return;
		}

		if (arvore[index] == -1) {
			arvore[index] = valor;
		} else if (valor < arvore[index]) {
			insertNaMatriz(2 * index + 1, valor); // Inserção à esquerda
		} else {
			insertNaMatriz(2 * index + 2, valor); // Inserção à direita
		}
	}

	// Exibir raiz
	public void mostrarRaiz() {
		if (arvore[0] != -1) {
			System.out.println("Raiz: " + arvore[0]);
		} else {
			System.out.println("A árvore está vazia.");
		}
	}

	// Percurso em ordem simétrica
	public void emOrdem(int index) {
		if (index < capacidade && arvore[index] != -1) {
			emOrdem(2 * index + 1);
			System.out.print(arvore[index] + " ");
			emOrdem(2 * index + 2);
		}
	}

	// Percurso pré-ordem
	public void preOrdem(int index) {
		if (index < capacidade && arvore[index] != -1) {
			System.out.print(arvore[index] + " ");
			preOrdem(2 * index + 1);
			preOrdem(2 * index + 2);
		}
	}

	// Percurso pós-ordem
	public void posOrdem(int index) {
		if (index < capacidade && arvore[index] != -1) {
			posOrdem(2 * index + 1);
			posOrdem(2 * index + 2);
			System.out.print(arvore[index] + " ");
		}
	}
}
