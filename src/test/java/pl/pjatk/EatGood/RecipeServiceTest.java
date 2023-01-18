package pl.pjatk.EatGood;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import pl.pjatk.EatGood.domain.GenericRecipe;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.domain.RecipeList;
import pl.pjatk.EatGood.service.RecipeService;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

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
    public void getRecipesByQueryTest() {
        String query = "chicken";
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?query=chicken&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByQuery(query);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesInformationTest() {
        String ids = "123,456";
        Recipe[] expectedRecipes = new Recipe[]{};
        ResponseEntity<Recipe[]> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/informationBulk?ids=" + ids + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(Recipe[].class))).thenReturn(response);

        RecipeList actualRecipes = recipeService.getRecipesInformation(ids);

        assertArrayEquals(expectedRecipes, actualRecipes.getRecipes());
    }

    @Test
    public void getRecipesByCaloriesTest() {
        long minCalories = 100;
        long maxCalories = 1000;
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?minCalories=" + minCalories + "&maxCalories="  + maxCalories + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByCalories(minCalories, maxCalories);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByCuisineTest() {
        String cuisine = "chinese";
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?cuisine=" + cuisine + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByCuisine(cuisine);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByDietTest() {
        String diet = "vegetarian";
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?diet=" + diet + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByDiet(diet);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByQueryAndDietTest() {
        String query = "chicken";
        String diet = "vegetarian";
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?query=" + query + "&diet=" + diet + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByQueryAndDiet(query, diet);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByQueryAndCaloriesTest() {
        String query = "chicken";
        long min = 100;
        long max = 1000;
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?query=" + query + "&minCalories=" + min + "&maxCalories="  + max + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByQueryAndCalories(query, min, max);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByDietAndCaloriesTest() {
        String diet = "vegetarian";
        long minCalories = 100;
        long maxCalories = 1000;
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?diet=" + diet + "&minCalories=" + minCalories + "&maxCalories="  + maxCalories + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByDietAndCalories(diet, minCalories, maxCalories);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByQueryDietAndCaloriesTest() {
        String query = "chicken";
        String diet = "vegetarian";
        long minCalories = 100;
        long maxCalories = 1000;
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?query=" + query + "&diet=" + diet + "&minCalories=" + minCalories + "&maxCalories="  + maxCalories + "&instructionsRequired=true"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByQueryAndDietAndCalories(query, diet, minCalories, maxCalories);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRandomRecipeTest() {
        RecipeList expectedRecipes = new RecipeList();
        ResponseEntity<RecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/random?number=1&instructionsRequired=true" ),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(RecipeList.class))).thenReturn(response);

        RecipeList actualRecipes = recipeService.getRandomRecipe();

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getHeadersTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-ratelimit-requests-limit", "10");
        headers.set("x-ratelimit-requests-remaining", "99");
        headers.set("x-ratelimit-results-limit", "100");
        headers.set("x-ratelimit-results-remaining", "997");
        headers.set("x-ratelimit-tinyrequests-limit", "420");
        headers.set("x-ratelimit-tinyrequests-remaining", "666");
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(headers, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?query=xyz"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        LinkedHashMap<String, Integer> mapLimits = recipeService.getHeaders();

        assertTrue(mapLimits.containsKey("x-ratelimit-requests-limit"));
        assertTrue(mapLimits.containsKey("x-ratelimit-requests-remaining"));
        assertTrue(mapLimits.containsKey("x-ratelimit-results-limit"));
        assertTrue(mapLimits.containsKey("x-ratelimit-results-remaining"));
        assertTrue(mapLimits.containsKey("x-ratelimit-tinyrequests-limit"));
        assertTrue(mapLimits.containsKey("x-ratelimit-tinyrequests-remaining"));
        assertNotNull(mapLimits.get("x-ratelimit-requests-limit"));
        assertNotNull(mapLimits.get("x-ratelimit-requests-remaining"));
        assertNotNull(mapLimits.get("x-ratelimit-results-limit"));
        assertNotNull(mapLimits.get("x-ratelimit-results-remaining"));
        assertNotNull(mapLimits.get("x-ratelimit-tinyrequests-limit"));
        assertNotNull(mapLimits.get("x-ratelimit-tinyrequests-remaining"));
    }
}