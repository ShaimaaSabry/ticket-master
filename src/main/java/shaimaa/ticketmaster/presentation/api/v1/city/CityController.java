package shaimaa.ticketmaster.presentation.api.v1.city;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.ticketmaster.application.queries.GetCities.GetCitiesHandler;
import shaimaa.ticketmaster.model.City;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/cities")
@Tag(name = "Cities", description = "List cities.")
class CityController {
    private final GetCitiesHandler getCitiesHandler;

    CityController(
            final GetCitiesHandler getCitiesHandler
    ) {
        this.getCitiesHandler = getCitiesHandler;
    }

    @GetMapping
    Set<CityDTO> getAll() {
        Set<City> cities = this.getCitiesHandler.handle();

        return cities
                .stream()
                .map(CityDTO::from)
                .collect(Collectors.toSet());
    }
}
