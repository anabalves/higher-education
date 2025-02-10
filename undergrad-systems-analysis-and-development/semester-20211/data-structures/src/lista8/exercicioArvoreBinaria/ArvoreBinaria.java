package lista8.exercicioArvoreBinaria;

public class ArvoreBinaria {
	private No inicio;
	private int tamanho;

	public ArvoreBinaria() {
		inicio = new No();
		tamanho = 0;
	}

	public boolean VerificaArvoreVazia() {
		if (tamanho == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void Adicionar(int elemento) {
		adicionarRecursivo(elemento, inicio);
		tamanho++;
	}

	private void adicionarRecursivo(int elemento, No inicio) {
		if (inicio.getElemento() == null) {
			inicio.setElemento(elemento);
		} else {
			if (elemento >= inicio.getElemento()) {
				if (inicio.getDireita() == null) {
					inicio.setDireita(new No(elemento));
				} else {
					adicionarRecursivo(elemento, inicio.getDireita());
				}
			} else {
				if (inicio.getEsquerda() == null) {
					inicio.setEsquerda(new No(elemento));
				} else {
					adicionarRecursivo(elemento, inicio.getEsquerda());
				}
			}
		}
	}

	public No Remover(Integer elemento) {
		No aux = Buscar(elemento);
		if (aux != null) {
			removerRecursivo(elemento, aux);
		} 
		return aux; 
	}

	private void removerRecursivo(Integer elemento, No aux) {
		if (aux.getDireita() == null && aux.getEsquerda() == null) {
			aux.setElemento(null);
		} else if (aux.getDireita() == null) {
			aux.setElemento(aux.getEsquerda().getElemento());
			aux.setEsquerda(aux.getEsquerda().getEsquerda());
			aux.setDireita(aux.getEsquerda().getDireita());
		} else if (aux.getEsquerda() == null) {
			aux.setElemento(aux.getDireita().getElemento());
			aux.setEsquerda(aux.getDireita().getEsquerda());
			aux.setDireita(aux.getDireita().getDireita());
		} else {
			Integer menorDireita = retornaMenor(aux.getDireita());
			removerRecursivo(menorDireita, aux.getDireita());
			aux.setElemento(menorDireita);
		}
	}

	public Integer retornaMenor() {
		return retornaMenor(inicio);
	}

	private Integer retornaMenor(No direita) {
		if (direita == null) {
			return Integer.MAX_VALUE;
		}

		int menorGeral = direita.getElemento();
		int menorEsquerda = retornaMenor(direita.getEsquerda());
		int menorDireita = retornaMenor(direita.getDireita());
		if (menorEsquerda < menorGeral)
			menorGeral = menorEsquerda;
		if (menorDireita < menorGeral)
			menorGeral = menorDireita;
		return menorGeral;
	}

	public No Buscar(int elemento) {
		return buscarRecursivo(elemento, inicio, 0);
	}

	private No buscarRecursivo(int elemento, No inicio, int nivel) {
		if (inicio == null) {
			return null;
		} else {
			if (inicio.getElemento() == elemento) {
				return inicio;
			} else {
				if (elemento >= inicio.getElemento()) {
					return buscarRecursivo(elemento, inicio.getDireita(), nivel + 1);
				} else {
					return buscarRecursivo(elemento, inicio.getEsquerda(), nivel + 1);
				}
			}
		}
	}

	public int mostraTamanho(No inicio) {
		int resp = 0;
		if (inicio != null) {
			resp = mostraTamanho(inicio.esquerda) + mostraTamanho(inicio.direita) + 1;
		}
		return resp;
	}
	
	public No obtemRaiz() {
		return inicio;
	}

	public void mostraPreOrdem() {
		System.out.print("Pré-ordem: ");
		preOrdem(inicio);
		System.out.println();
	}

	private void preOrdem(No inicio) {
		if (inicio == null || inicio.getElemento() == null) {
			return;
		}

		System.out.print(inicio.getElemento() + " ");
		preOrdem(inicio.getEsquerda());
		preOrdem(inicio.getDireita());
	}

	public void mostraEmOrdem() {
		System.out.print("Em ordem: ");
		emOrdem(inicio);
		System.out.println();
	}

	private void emOrdem(No inicio) {
		if (inicio == null || inicio.getElemento() == null) {
			return;
		}
		emOrdem(inicio.getEsquerda());
		System.out.print(inicio.getElemento() + " ");
		emOrdem(inicio.getDireita());
	}

	public void mostraPosOrdem() {
		System.out.print("Pos ordem: ");
		PosOrdem(inicio);
		System.out.println();
	}

	private void PosOrdem(No inicio) {
		if (inicio == null || inicio.getElemento() == null) {
			return;
		}
		PosOrdem(inicio.getEsquerda());
		PosOrdem(inicio.getDireita());
		System.out.print(inicio.getElemento() + " ");
	}

}
