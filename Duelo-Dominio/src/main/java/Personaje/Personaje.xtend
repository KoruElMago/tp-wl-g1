package Personaje

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

class Personaje {
	
	@Accessors
	
	var String nombre;
	var Linea rolIdea;
	var List<String> debilidades;
	var List<String> fortalezas;
	
	new(String nombre, Linea rolIdeal, List<String> fortalezas, List<String> debilidades){
		this.nombre = nombre;
		this.rolIdeal = rolIdeal;
		this.debilidades = debilidades;
		this.fortalezas = fortalezas;
	}
	
	
	
}