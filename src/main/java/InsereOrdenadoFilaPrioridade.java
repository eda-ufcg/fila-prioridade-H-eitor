public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		Pair aux = new Pair(elemento, prioridade);
		
		if (this.head == -1) this.head = 0;
		
		this.last = (this.last + 1) % this.fila.length;
		fila[last] = aux;
		
		int i = last;
		while (aux.getPrioridade() > fila[(i - 1) % this.fila.length].getPrioridade()) {
			Pair newPair = this.fila[i];
			this.fila[i] = this.fila[(i - 1) % this.fila.length];
			this.fila[(i - 1) % this.fila.length] = newPair;
			i = (i - 1) % this.fila.length;
		}

	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		String saida = this.fila[this.head].getElemento();
		if (this.head == this.last){
			this.head = -1;
			this.last = -1;
		} else this.head = (this.head + 1) % this.fila.length;
		return saida;
	}

}
