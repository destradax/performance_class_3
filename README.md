# Clase 4

## Ejercicio 1
Crear las interfaces REST para Country de acuerdo a la especificación del controlador CountryController y el repositorio CountryRepository.

- GET http://localhost:8080/rest/countries
- GET http://localhost:8080/rest/countries/1
- GET http://localhost:8080/rest/countries/name/Colombia
- POST http://localhost:8080/rest/countries with the content:
```json
{
	"name": "Japan"
}
```
- PUT http://localhost:8080/rest/countries/1 with the content:
```json
{
	"id": 1,
	"name": "USA"
}
```

## Ejercicio 2
Diseñar e Implementar las interfaces Rest para CinemaController. Modificar showtime para que esté asociado a un cinema. El cinema debe estar asociado a una instancia de Country.
