package pl.pjatk.EatGood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.service.RecipeService;

import java.io.FileInputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {
    private final static String API_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
    private final static String API_KEY_NAME = "X-RapidAPI-Key";
    private final static String API_KEY_VALUE = "8f550b7fa2msha9a927ff991988cp11574ajsn2b82d10d2ca7";
    private final static String HOST_NAME = "X-RapidAPI-Host";
    private final static String HOST_VALUE = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";

    @Mock
    private RestTemplate restTemplate;
    private RecipeService recipeService;


    @BeforeEach
    void setup() {
        recipeService = new RecipeService(restTemplate, API_URL, API_KEY_NAME, API_KEY_VALUE, HOST_NAME, HOST_VALUE);
    }

    @Test
    void getRecipesByQueryTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(API_KEY_NAME, API_KEY_VALUE);
        headers.set(HOST_NAME, HOST_VALUE);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String query = "chicken";
        String expectedUrl = API_URL + "/recipes/complexSearch?query=chicken";

        ResponseEntity<GenericRecipeList> expectedResponse = new ResponseEntity<>(new GenericRecipeList(), HttpStatus.OK);
        when(restTemplate.exchange(expectedUrl, HttpMethod.GET, requestEntity, GenericRecipeList.class)).thenReturn(expectedResponse);

        ResponseEntity<GenericRecipeList> response = recipeService.getRecipesByQuery(query);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getRecipesInformationTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(API_KEY_NAME, API_KEY_VALUE);
        headers.set(HOST_NAME, HOST_VALUE);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String ids = "123,456,789";
        String expectedUrl = API_URL + "/recipes/informationBulk?ids=123,456,789";

        ResponseEntity<Recipe[]> expectedResponse = new ResponseEntity<>(new Recipe[3], HttpStatus.OK);
        when(restTemplate.exchange(expectedUrl, HttpMethod.GET, requestEntity, Recipe[].class)).thenReturn(expectedResponse);

        ResponseEntity<Recipe[]> response = recipeService.getRecipesInformation(ids);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getRecipesByCaloriesTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(API_KEY_NAME, API_KEY_VALUE);
        headers.set(HOST_NAME, HOST_VALUE);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        long min = 200;
        long max = 300;
        String expectedUrl = API_URL + "/recipes/complexSearch?minCalories=200&maxCalories=300";

        ResponseEntity<GenericRecipeList> expectedResponse = new ResponseEntity<>(new GenericRecipeList(), HttpStatus.OK);
        when(restTemplate.exchange(expectedUrl, HttpMethod.GET, requestEntity, GenericRecipeList.class)).thenReturn(expectedResponse);

        ResponseEntity<GenericRecipeList> response = recipeService.getRecipesByCalories(min, max);
        assertEquals(expectedResponse, response);
    }

//    @Test
//    void getRecipesByCuisineTest() {
//        String cuisine = "italian";
//        String expectedUrl = API_URL + "/recipes/complexSearch?cuisine=italian";
//        ResponseEntity<GenericRecipeList> expectedResponse = new Response
//    }
}