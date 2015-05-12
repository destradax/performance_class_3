package co.com.psl.elitemovie.repository;

import java.util.Collection;

import co.com.psl.elitemovie.model.Cinema;

public interface CinemaRepository {

	Collection<Cinema> findAll();

	Cinema findById(int id);

	void save(Cinema cinema);
	
	void update(Cinema cinema);
	
	void delete(int id);
}
