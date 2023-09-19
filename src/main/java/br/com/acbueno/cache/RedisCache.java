package br.com.acbueno.cache;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.string.SetArgs;
import io.quarkus.redis.datasource.string.StringCommands;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.function.Supplier;
import br.com.acbueno.services.Ranking;

@ApplicationScoped
public class RedisCache {

    private final StringCommands<String, Ranking> commands;

    public RedisCache(RedisDataSource ds) {
        this.commands = ds.string(Ranking.class);
    }

    public Ranking get(String key) {
        return commands.get(key);
    }

    public void set(String key, Ranking result) {
        commands.set(key, result, new SetArgs().ex(Duration.ofSeconds(10)));
    }

    public void evict(String key) {
        commands.getdel(key);
    }

    public Ranking getOrSetIfAbsent(String key, Supplier<Ranking> computation) {
        var cached = get(key);

        if (cached != null) {
            return cached;
        } else {
            var result = computation.get();
            set(key, result);
            return result;
        }
    }

}
