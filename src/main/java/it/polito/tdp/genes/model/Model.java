package it.polito.tdp.genes.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {

	GenesDao dao = new GenesDao();
	private Graph<Integer, DefaultWeightedEdge> grafo;
	
	public String creaGrafo() {
		// TODO Auto-generated method stub
		this.grafo= new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		List<Integer> cromosomi = dao.getChromosomes();
		Graphs.addAllVertices(this.grafo, cromosomi);
		//aggiungo gli archi
		for(Edge e : dao.getAllEdges()) {
			Graphs.addEdge(this.grafo, e.getChromosome1(), e.getChromosome2(), e.getWeight());
		}
		
		return "Grafo creato:"+this.grafo.vertexSet().size()+"vertici e "
		+this.grafo.edgeSet().size()+" archi";
	}
	public Graph getGrafo() {
		return this.grafo;	
	}
	

}