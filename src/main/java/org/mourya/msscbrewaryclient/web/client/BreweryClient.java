package org.mourya.msscbrewaryclient.web.client;

import org.mourya.msscbrewaryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer";
    public String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 +"/"+ uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID id, BeerDto beerDto){
        restTemplate.put(apiHost + BEER_PATH_V1 + "/" + id.toString(), beerDto);
    }

    public void deleteBeer(UUID id){
        restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + id.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

}
