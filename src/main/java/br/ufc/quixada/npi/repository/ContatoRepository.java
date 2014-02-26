package br.ufc.quixada.npi.repository;

import java.util.List;

import br.ufc.quixada.npi.model.Contato;

public interface ContatoRepository {

	public abstract void beginTransaction();

	public abstract void commit();

	public abstract void rollback();

	public abstract void save(Contato c);

	public abstract List<Contato> findAll();
	
	public void close();

}