package pl.pjatk.EatGood.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.EatGood.domain.GenericRecipe;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.domain.RecipeList;

import java.util.List;

@Service
public class RecipeService {
    @Value("${spoonacular.url}")
    private String apiUrl;

    @Value("${spoonacular.key.name}")
    private String apiKeyName;

    @Value("${spoonacular.key.value}")
    private String apiKeyValue;

    @Value("${spoonacular.host.name}")
    private String hostName;

    @Value("${spoonacular.host.value}")
    private String hostValue;

    private final RestTemplate restTemplate;

    public RecipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<GenericRecipeList> getRecipesByQuery(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<GenericRecipe> requestEntity = new HttpEntity<GenericRecipe>(headers);
        return restTemplate.exchange(apiUrl + "/recipes/complexSearch?query=" + query, HttpMethod.GET, requestEntity, GenericRecipeList.class);
    }

    public ResponseEntity<Recipe[]> getRecipesInformation(String ids) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        return restTemplate.exchange(apiUrl + "/recipes/informationBulk?ids=" + ids, HttpMethod.GET, requestEntity, Recipe[].class);
    }

    public ResponseEntity<GenericRecipeList> getRecipesByCalories(long min, long max) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        if (min == 0) {
            return restTemplate.exchange(apiUrl + "/recipes/complexSearch?maxCalories=" + max, HttpMethod.GET, requestEntity, GenericRecipeList.class);
        } else if (max == 0) {
            return restTemplate.exchange(apiUrl + "/recipes/complexSearch?minCalories=" + min, HttpMethod.GET, requestEntity, GenericRecipeList.class);
        } else {
            return restTemplate.exchange(apiUrl + "/recipes/complexSearch?minCalories=" + min + "&maxCalories=" + max, HttpMethod.GET, requestEntity, GenericRecipeList.class);
        }
    }

    public ResponseEntity<GenericRecipeList> getRecipesByCuisine(String cuisine) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        return restTemplate.exchange(apiUrl + "/recipes/complexSearch?cuisine=" + cuisine, HttpMethod.GET, requestEntity, GenericRecipeList.class);
    }

    public ResponseEntity<GenericRecipeList> getRecipesByDiet(String diet) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        return restTemplate.exchange(apiUrl + "/recipes/complexSearch?diet=" + diet, HttpMethod.GET, requestEntity, GenericRecipeList.class);
    }

    public ResponseEntity<RecipeList> getRandomRecipes(int recipeCount) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        return restTemplate.exchange(apiUrl + "/recipes/random?number=" + recipeCount, HttpMethod.GET, requestEntity, RecipeList.class);
    }
}
