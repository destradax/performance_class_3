package co.com.psl.elitemovie.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.psl.elitemovie.model.Country;

@Component
public class DefaultCountryRepository implements CountryRepository {
	
	@Autowired
	private PersistenceService persistenceService;

	@Override
	public Collection<Country> findAll() {
		return persistenceService.executeQuery(Country.class, "from Country c");
	}

	@Override
	public Country findById(int id) {
		return persistenceService.findById(Country.class, id);
	}

	@Override
	public void save(Country country) {
		persistenceService.save(country);

	}

	@Override
	public Collection<Country> findAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country findByName(String name) {
		Country country = persistenceService.executeQueryWithSingleResult(Country.class, "from Country c where c.name = ?", name);
		return country;
	}

	@Override
	public void update(Country country) {
		persistenceService.update(country);
	}

}
