package academy.devdojo.springboot.client;

import academy.devdojo.springboot.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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
                new ParameterizedTypeReference<>() {
                });
        log.info("************EXCHANGE************");
        log.info(exchange.getBody());

        /*Anime kingdom = Anime.builder().name("kingdom").build();
        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8081/animes/", kingdom, Anime.class);
        log.info("************POST FOR OBJECT************");
        log.info("Saved anime {}", kingdomSaved);*/

        Anime samuraiChamploo = Anime.builder().name("Samurai Champloo").build();
        ResponseEntity<Anime> samuraiChamplooSaved = new RestTemplate().exchange("http://localhost:8081/animes/",
                HttpMethod.POST,
                new HttpEntity<>(samuraiChamploo, createJsonHeader()),
                Anime.class);
        log.info("************POST FOR EXCHANGE - SAVED************");
        log.info("Saved anime {}", samuraiChamplooSaved);

        Anime animeToBeUpdated = samuraiChamplooSaved.getBody();
        animeToBeUpdated.setName("Samurai Champloo 4");
        ResponseEntity<Void> samuraiChamplooUpdated = new RestTemplate().exchange("http://localhost:8081/animes/",
                HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdated, createJsonHeader()),
                Void.class);
        log.info("************PUT FOR EXCHANGE - UPDATED************");
        log.info("Updated anime {}", samuraiChamplooUpdated);

        ResponseEntity<Void> samuraiChamplooDelete = new RestTemplate().exchange("http://localhost:8081/animes/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                animeToBeUpdated.getId());
        log.info("************DELETE FOR EXCHANGE - DELETE************");
        log.info(samuraiChamplooDelete);

    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
