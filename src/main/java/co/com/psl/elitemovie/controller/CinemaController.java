package co.com.psl.elitemovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.elitemovie.controller.dto.CinemaDto;
import co.com.psl.elitemovie.controller.dto.DtoTransformer;
import co.com.psl.elitemovie.model.Cinema;
import co.com.psl.elitemovie.repository.CinemaRepository;

@RestController
@RequestMapping("/rest")
public class CinemaController {

	@Autowired(required = false)
	private CinemaRepository cinemaRepository;

	@RequestMapping(value="/cinemas", method=RequestMethod.GET)
	public List<CinemaDto> findAll() {
		return DtoTransformer.toDto(cinemaRepository.findAll(),
				CinemaDto.class);
	}

	@RequestMapping(value="/cinemas/{id}", method=RequestMethod.GET)
	public CinemaDto findById(@PathVariable int id ) {
		Cinema cinema = cinemaRepository.findById(id);
		CinemaDto dto = DtoTransformer.toDto(cinema, CinemaDto.class);
		return dto;
	}

	@RequestMapping(value="/cinemas", method=RequestMethod.POST)
	public CinemaDto save(@RequestBody CinemaDto CinemaDto) {
		Cinema cinema = DtoTransformer.toEntity(CinemaDto, Cinema.class);
		cinemaRepository.save(cinema);
		return DtoTransformer.toDto(cinema, CinemaDto.class);
	}

	@RequestMapping(value="/cinemas/{id}", method=RequestMethod.PUT)
	public CinemaDto update(@RequestBody CinemaDto CinemaDto, @PathVariable int id) {
		Cinema cinema = DtoTransformer.toEntity(CinemaDto, Cinema.class);
		cinemaRepository.update(cinema);
		return DtoTransformer.toDto(cinema, CinemaDto.class);
	}

}
