package br.ufc.quixada.npi.ui;

import java.util.List;

import br.ufc.quixada.npi.model.Contato;
import br.ufc.quixada.npi.service.ContatoService;
import br.ufc.quixada.npi.service.ContatoServiceImpl;

public class Main {

	public static void main(String[] args) {
		ContatoService cs = new ContatoServiceImpl();
		cs.insere();
		
		List<Contato> l = cs.findAll();

	    for (Contato c : l) {
	    	System.out.println(c);
	    }
		
	}
}
