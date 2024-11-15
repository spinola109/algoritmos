package br.com.unifacisa.BinaryTree;

public class ArvoreBinariaMatriz {
	private final int[] arvore;
	private final int capacidade;

	public ArvoreBinariaMatriz(int capacidade) {
		this.capacidade = capacidade;
		this.arvore = new int[capacidade];
		for (int i = 0; i < capacidade; i++) {
			arvore[i] = -1; // Inicializa com -1 para indicar posições vazias
		}
	}

	public void insert(int valor) {
		insert(0, valor);
	}

	private void insert(int indice, int valor) {
		if (indice >= capacidade) {
			System.out.println("A árvore está cheia.");
			return;
		}
		if (arvore[indice] == -1) {
			arvore[indice] = valor;
			System.out.println("Inserido " + valor + " na posição " + indice);
		} else if (valor < arvore[indice]) {
			insert(2 * indice + 1, valor);
		} else {
			insert(2 * indice + 2, valor);
		}
	}

	public void emOrdem(int indice) {
		if (indice >= capacidade || arvore[indice] == -1) return;
		emOrdem(2 * indice + 1);
		System.out.print(arvore[indice] + " ");
		emOrdem(2 * indice + 2);
	}

	public void preOrdem(int indice) {
		if (indice >= capacidade || arvore[indice] == -1) return;
		System.out.print(arvore[indice] + " ");
		preOrdem(2 * indice + 1);
		preOrdem(2 * indice + 2);
	}

	public void posOrdem(int indice) {
		if (indice >= capacidade || arvore[indice] == -1) return;
		posOrdem(2 * indice + 1);
		posOrdem(2 * indice + 2);
		System.out.print(arvore[indice] + " ");
	}

	public void mostrarRaiz() {
		if (arvore[0] == -1) {
			System.out.println("A árvore está vazia!");
		} else {
			System.out.println("Raiz: " + arvore[0]);
		}
	}
}
