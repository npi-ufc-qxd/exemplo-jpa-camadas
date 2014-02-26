package br.ufc.quixada.npi.service;

import java.util.List;

import br.ufc.quixada.npi.model.Contato;
import br.ufc.quixada.npi.repository.ContatoRepository;
import br.ufc.quixada.npi.repository.jpa.JpaContatoRepositoryImpl;

public class ContatoServiceImpl implements ContatoService {

	private ContatoRepository contatoRepository = new JpaContatoRepositoryImpl();
	
	public void insere() {
		try {
			contatoRepository.beginTransaction();
			contatoRepository.save(new Contato("João", "(88)3452-4567"));
			contatoRepository.save(new Contato("Maria", "(88)3452-4568"));
			contatoRepository.save(new Contato("José", "(88)3452-4569"));
			contatoRepository.commit();
		} catch (Exception e) {
			contatoRepository.rollback();
			System.out.println("Não foi possível realizar a inserção");
		}
		contatoRepository.close();
	}

	public List<Contato> findAll() {
		List<Contato> l = contatoRepository.findAll();
		contatoRepository.close();
		return l;
	}

}
