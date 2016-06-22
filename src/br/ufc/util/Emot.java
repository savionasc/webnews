package br.ufc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Emot {
	
	public String inserir(String texto){
		List<String> lista = new ArrayList<String>();
		lista.add("smile");
		lista.add("triste-lagrimas");
		
		HashMap<String, String> referencia = new HashMap<String, String>();
		
		referencia.put(lista.get(0), ":)");
		referencia.put(lista.get(1), ":'(");
		
		
		
		for (String sbst : lista) {
			String path = "resources/img/emoticons/"+sbst+".png";
			String textao = "<img height="+32+" src="+path+" /> ";
			texto = texto.replace(referencia.get(sbst), textao);
			
		}
		
		
		return texto;
	}
}
