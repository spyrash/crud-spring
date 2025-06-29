package CRUD.demo.catfact;

import CRUD.demo.product.Query;
import com.ctc.wstx.shaded.msv_core.util.Uri;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CatFactService implements Query<Integer, CatFactDto> {

    private final RestTemplate restTemplate;
    private final String url = "https://catfact.ninja";
    private final String MAX_LENGTH = "max_length";

    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDto> execute(Integer input) {
        // sets up our URL with the query parameter
        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(MAX_LENGTH, input)
                .build()
                .toUri();

        //headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<CatFactResponse> response = restTemplate
                    .exchange(uri, HttpMethod.GET, entity, CatFactResponse.class);
            CatFactDto catFactDto = new CatFactDto(response.getBody().getFact());
            return ResponseEntity.ok(catFactDto);
        } catch (Exception e) {
            throw new RuntimeException("Cat Facts API is down.");
        }
    }
}
