package br.com.acbueno.resource;

import br.com.acbueno.services.CarServices;
import br.com.acbueno.services.Ranking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cars")
public class RankResource {

    private final CarServices carServices;

    public RankResource(CarServices carServices) {
        this.carServices = carServices;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Ranking getTopCars() {
        return carServices.getTopCars();
    }
}
