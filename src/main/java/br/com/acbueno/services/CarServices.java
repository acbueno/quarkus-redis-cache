package br.com.acbueno.services;

import java.util.stream.Collectors;
import br.com.acbueno.cache.RedisCache;
import br.com.acbueno.entity.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CarServices {

    @Inject
    RedisCache cache;

    public Ranking getTopCars() {
        return cache.getOrSetIfAbsent("top", () -> {
            return new Ranking(Car.<Car> listAll()
                    .stream()
                    .sorted((o1, o2) -> Integer.compare(o2.hp, o1.hp))
                    .peek(h -> {
                        nap();
                    })
                    .limit(3)
                    .collect(Collectors.toList()));
        });
    }

    private void nap() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
