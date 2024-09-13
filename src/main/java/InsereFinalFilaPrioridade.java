import java.util.ArrayList;
import java.util.NoSuchElementException;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair par = new Pair(elemento, prioridade);
		fila.add(par);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		if (fila.isEmpty()) throw new NoSuchElementException();
		int iMaior = 0;
		Pair maxPrio = this.fila.get(0);
		for(int i = 0; i < this.fila.size(); i++){
			if(fila.get(i).getPrioridade() > maxPrio.getPrioridade()){
				maxPrio = fila.get(i);
				iMaior = i;
			} 
		}
		this.fila.remove(iMaior);
		return maxPrio.getElemento();
	}

}
