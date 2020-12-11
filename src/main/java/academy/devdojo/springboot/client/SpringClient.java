package academy.devdojo.springboot.client;

import academy.devdojo.springboot.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8081/animes/{id}", Anime.class, 2);
        log.info("************ENTITY************");
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8081/animes/{id}", Anime.class, 2);
        log.info("************OBJECT************");
        log.info(object);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8081/animes/all", Anime[].class);
        log.info("************ARRAY************");
        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8081/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});
        log.info("************EXCHANGE************");
        log.info(exchange.getBody());


    }
}
