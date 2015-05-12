package co.com.psl.elitemovie.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.psl.elitemovie.model.Cinema;

@Component
public class DefaultCinemaRepository implements CinemaRepository {

	@Autowired
	private PersistenceService persistenceService;

	@Override
	public Collection<Cinema> findAll() {
		return persistenceService.executeQuery(Cinema.class, "from Cinema c");
	}

	@Override
	public Cinema findById(int id) {
		return persistenceService.findById(Cinema.class, id);
	}

	@Override
	public void save(Cinema cinema) {
		persistenceService.save(cinema);
	}

	@Override
	public void update(Cinema cinema) {
		persistenceService.update(cinema);
	}

	@Override
	public void delete(int id) {
		Cinema cinema = new Cinema();
		cinema.setId(id);
		persistenceService.remove(cinema);
	}
}
