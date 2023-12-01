package org.mourya.msscbrewaryclient.web.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mourya.msscbrewaryclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
public class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerByIdTest(){

        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        Assertions.assertNotNull(beerDto);

    }

    @Test
    void saveNewBeerTest(){

        BeerDto beerDto = BeerDto.builder().BeerName("New Beer").build();
        URI uri = breweryClient.saveNewBeer(beerDto);
        Assertions.assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeerTest(){

        BeerDto beerDto = BeerDto.builder().BeerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);

    }

    @Test
    void deleteBeerTest(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}
