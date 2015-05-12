package co.com.psl.elitemovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.elitemovie.controller.dto.CountryDto;
import co.com.psl.elitemovie.controller.dto.DtoTransformer;
import co.com.psl.elitemovie.model.Country;
import co.com.psl.elitemovie.repository.CountryRepository;

@RestController
@RequestMapping("/rest")
public class CountryController {

	@Autowired(required = false)
	private CountryRepository countryRepository;

	@RequestMapping(value="/countries", method=RequestMethod.GET)
	public List<CountryDto> findAll() {
		return DtoTransformer.toDto(countryRepository.findAll(),
				CountryDto.class);
	}
	
	@RequestMapping(value="/countries/name/{name}", method=RequestMethod.GET)
	public CountryDto findByName(@PathVariable String name) {
		Country country = countryRepository.findByName(name);
		if (country != null) {
			return DtoTransformer.toDto(country, CountryDto.class);
		}
		return null;
	}

	@RequestMapping(value="/countries/{id}", method=RequestMethod.GET)
	public CountryDto findById(@PathVariable int id ) {
		Country country = countryRepository.findById(id);
		CountryDto dto = DtoTransformer.toDto(country, CountryDto.class);
		return dto;
	}

	@RequestMapping(value="/countries", method=RequestMethod.POST)
	public CountryDto save(@RequestBody CountryDto countryDto) {
		Country country = DtoTransformer.toEntity(countryDto, Country.class);
		countryRepository.save(country);
		return DtoTransformer.toDto(country, CountryDto.class);
	}
	
	@RequestMapping(value="/countries/{id}", method=RequestMethod.PUT)
	public CountryDto update(@RequestBody CountryDto countryDto, @PathVariable int id) {
		Country country = DtoTransformer.toEntity(countryDto, Country.class);
		countryRepository.update(country);
		return DtoTransformer.toDto(country, CountryDto.class);
	}

	@RequestMapping(value="/countries/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		countryRepository.delete(id);
	}
}
