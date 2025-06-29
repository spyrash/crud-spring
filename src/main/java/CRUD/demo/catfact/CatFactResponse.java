package CRUD.demo.catfact;

import lombok.Data;

@Data
public class CatFactResponse {
    private String fact;
    private Integer length;

    public CatFactResponse(String fact, Integer length) {
        this.fact = fact;
        this.length = length;
    }

}
