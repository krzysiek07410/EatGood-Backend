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
import pl.pjatk.EatGood.domain.GenericRecipe;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.domain.RecipeList;
import pl.pjatk.EatGood.service.RecipeService;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?query=chicken"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByQuery(query);

        assertEquals(expectedRecipes, actualRecipes);
    }

//    @Test
//    public void getRecipesInformationTest() {
//        String ids = "123,456";
//        RecipeList expectedRecipes = new RecipeList();
//        ResponseEntity<RecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
//        when(restTemplate.exchange(eq(API_URL + "/recipes/information?ids=" + ids),
//                eq(HttpMethod.GET), any(HttpEntity.class), eq(RecipeList.class))).thenReturn(response);
//
//        RecipeList actualRecipes = recipeService.getRecipesInformation(ids);
//
//        assertEquals(expectedRecipes, actualRecipes);
//    }

    @Test
    public void getRecipesByCaloriesTest() {
        long minCalories = 100;
        long maxCalories = 1000;
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?minCalories=" + minCalories + "&maxCalories="  + maxCalories),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByCalories(minCalories, maxCalories);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByCuisineTest() {
        String cuisine = "chinese";
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?cuisine=" + cuisine),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByCuisine(cuisine);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRecipesByDietTest() {
        String diet = "vegetarian";
        GenericRecipeList expectedRecipes = new GenericRecipeList();
        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?diet=" + diet),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);

        GenericRecipeList actualRecipes = recipeService.getRecipesByDiet(diet);

        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    public void getRandomRecipeTest() {
        RecipeList expectedRecipes = new RecipeList();
        ResponseEntity<RecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
        when(restTemplate.exchange(eq(API_URL + "/recipes/random?number=1" ),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(RecipeList.class))).thenReturn(response);

        RecipeList actualRecipes = recipeService.getRandomRecipe();

        assertEquals(expectedRecipes, actualRecipes);
    }

//    @Test
//    public void getHeadersTest() {
//        GenericRecipeList expectedRecipes = new GenericRecipeList();
//        ResponseEntity<GenericRecipeList> response = new ResponseEntity<>(expectedRecipes, HttpStatus.OK);
//        when(restTemplate.exchange(eq(API_URL + "/recipes/complexSearch?query=xyz"),
//                eq(HttpMethod.GET), any(HttpEntity.class), eq(GenericRecipeList.class))).thenReturn(response);
//
//        LinkedHashMap<String, Integer> actualHeaders = recipeService.getHeaders();
//
//        assertEquals(response.getHeaders(), actualHeaders);
//    }
}