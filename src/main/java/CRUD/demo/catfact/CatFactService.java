package CRUD.demo.catfact;

import CRUD.demo.product.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatFactService implements Query<Integer, CatFactDto> {

    private final RestTemplate restTemplate;

    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDto> execute(Integer input) {
        // getForObject is a get request
        CatFactResponse catFactResponse = restTemplate.getForObject("https://catfact.ninja/fact?max_length=" + input, CatFactResponse.class);
        CatFactDto catFactDto = null;
        if (catFactResponse != null) {
            catFactDto = new CatFactDto(catFactResponse.getFact());
        }
        return  ResponseEntity.ok(catFactDto);
    }
}
