package pl.pjatk.EatGood.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.EatGood.domain.GenericRecipe;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.domain.RecipeList;

import java.util.LinkedHashMap;
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

//    public RecipeService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public RecipeService(RestTemplate restTemplate,
                         @Value("${spoonacular.url}") String apiUrl,
                         @Value("${spoonacular.key.name}") String apiKeyName,
                         @Value("${spoonacular.key.value}") String apiKeyValue,
                         @Value("${spoonacular.host.value}") String hostName,
                         @Value("${spoonacular.host.value}") String hostValue) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKeyName = apiKeyName;
        this.apiKeyValue = apiKeyValue;
        this.hostName = hostName;
        this.hostValue = hostValue;
    }

//    public ResponseEntity<GenericRecipeList> getRecipesByQuery(String query) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(apiKeyName, apiKeyValue);
//        headers.set(hostName, hostValue);
//        HttpEntity<GenericRecipe> requestEntity = new HttpEntity<GenericRecipe>(headers);
//        return restTemplate.exchange(apiUrl + "/recipes/complexSearch?query=" + query, HttpMethod.GET, requestEntity, GenericRecipeList.class);
//    }

    public GenericRecipeList getRecipesByQuery(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<GenericRecipe> requestEntity = new HttpEntity<GenericRecipe>(headers);
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(apiUrl + "/recipes/complexSearch?query="
                + query, HttpMethod.GET, requestEntity, GenericRecipeList.class);
        return response.getBody();
    }

//    public ResponseEntity<Recipe[]> getRecipesInformation(String ids) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(apiKeyName, apiKeyValue);
//        headers.set(hostName, hostValue);
//        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
//        return restTemplate.exchange(apiUrl + "/recipes/informationBulk?ids=" + ids, HttpMethod.GET, requestEntity, Recipe[].class);
//    }

    public RecipeList getRecipesInformation(String ids) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        ResponseEntity<Recipe[]> response = restTemplate.exchange(apiUrl + "/recipes/informationBulk?ids=" + ids,
                HttpMethod.GET, requestEntity, Recipe[].class);
        return new RecipeList(response.getBody());
    }

//    public ResponseEntity<GenericRecipeList> getRecipesByCalories(long min, long max) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(apiKeyName, apiKeyValue);
//        headers.set(hostName, hostValue);
//        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
//        if (min == 0) {
//            return restTemplate.exchange(apiUrl + "/recipes/complexSearch?maxCalories=" + max, HttpMethod.GET, requestEntity, GenericRecipeList.class);
//        } else if (max == 0) {
//            return restTemplate.exchange(apiUrl + "/recipes/complexSearch?minCalories=" + min, HttpMethod.GET, requestEntity, GenericRecipeList.class);
//        } else {
//            return restTemplate.exchange(apiUrl + "/recipes/complexSearch?minCalories=" + min + "&maxCalories=" + max, HttpMethod.GET, requestEntity, GenericRecipeList.class);
//        }
//    }

    public GenericRecipeList getRecipesByCalories(long min, long max) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String url = new String();
        if (min == 0) {
            url = apiUrl + "/recipes/complexSearch?maxCalories=" + max;
        } else if (max == 0) {
            url = apiUrl + "/recipes/complexSearch?minCalories=" + min;
        } else {
            url = apiUrl + "/recipes/complexSearch?minCalories=" + min + "&maxCalories="  + max;
        }
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                GenericRecipeList.class);
        return response.getBody();
    }

//    public ResponseEntity<GenericRecipeList> getRecipesByCuisine(String cuisine) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(apiKeyName, apiKeyValue);
//        headers.set(hostName, hostValue);
//        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
//        return restTemplate.exchange(apiUrl + "/recipes/complexSearch?cuisine=" + cuisine, HttpMethod.GET, requestEntity, GenericRecipeList.class);
//    }

    public GenericRecipeList getRecipesByCuisine(String cuisine) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(apiUrl + "/recipes/complexSearch?cuisine="
                + cuisine, HttpMethod.GET, requestEntity, GenericRecipeList.class);
        return response.getBody();
    }

//    public ResponseEntity<GenericRecipeList> getRecipesByDiet(String diet) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(apiKeyName, apiKeyValue);
//        headers.set(hostName, hostValue);
//        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
//        return restTemplate.exchange(apiUrl + "/recipes/complexSearch?diet=" + diet, HttpMethod.GET, requestEntity, GenericRecipeList.class);
//    }

    public GenericRecipeList getRecipesByDiet(String diet) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(apiUrl + "/recipes/complexSearch?diet="
                + diet, HttpMethod.GET, requestEntity, GenericRecipeList.class);
        return response.getBody();
    }

    public GenericRecipeList getRecipesByQueryAndDiet(String query, String diet) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<GenericRecipe> requestEntity = new HttpEntity<GenericRecipe>(headers);
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(apiUrl + "/recipes/complexSearch?query="
                + query + "&diet=" + diet, HttpMethod.GET, requestEntity, GenericRecipeList.class);
        return response.getBody();
    }

    public GenericRecipeList getRecipesByQueryAndCalories(String query, long min, long max) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String url = new String();
        if (min == 0) {
            url = apiUrl + "/recipes/complexSearch?query=" + query + "&maxCalories=" + max;
        } else if (max == 0) {
            url = apiUrl + "/recipes/complexSearch?query=" + query + "&inCalories=" + min;
        } else {
            url = apiUrl + "/recipes/complexSearch?query=" + query + "&inCalories=" + min + "&maxCalories="  + max;
        }
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                GenericRecipeList.class);
        return response.getBody();
    }

    public GenericRecipeList getRecipesByDietAndCalories(String diet, long min, long max) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String url = new String();
        if (min == 0) {
            url = apiUrl + "/recipes/complexSearch?diet=" + diet + "&maxCalories=" + max;
        } else if (max == 0) {
            url = apiUrl + "/recipes/complexSearch?diet=" + diet + "&inCalories=" + min;
        } else {
            url = apiUrl + "/recipes/complexSearch?diet=" + diet + "&inCalories=" + min + "&maxCalories="  + max;
        }
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                GenericRecipeList.class);
        return response.getBody();
    }

    public GenericRecipeList getRecipesByQueryAndDietAndCalories(String query, String diet, long min, long max) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String url = new String();
        if (min == 0) {
            url = apiUrl + "/recipes/complexSearch?query=" + query + "&diet=" + diet + "&maxCalories=" + max;
        } else if (max == 0) {
            url = apiUrl + "/recipes/complexSearch?query=" + query + "&diet=" + diet + "&inCalories=" + min;
        } else {
            url = apiUrl + "/recipes/complexSearch?query=" + query + "&diet=" + diet + "&inCalories=" + min +
                    "&maxCalories="  + max;
        }
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                GenericRecipeList.class);
        return response.getBody();
    }
//    public ResponseEntity<RecipeList> getRandomRecipes(int recipeCount) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(apiKeyName, apiKeyValue);
//        headers.set(hostName, hostValue);
//        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
//        return restTemplate.exchange(apiUrl + "/recipes/random?number=" + recipeCount, HttpMethod.GET, requestEntity, RecipeList.class);
//    }

    public RecipeList getRandomRecipe() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        ResponseEntity<RecipeList> response = restTemplate.exchange(apiUrl + "/recipes/random?number=1",
                HttpMethod.GET, requestEntity, RecipeList.class);
        return response.getBody();
    }

    public LinkedHashMap<String, Integer> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<GenericRecipe> requestEntity = new HttpEntity<GenericRecipe>(headers);
        ResponseEntity<GenericRecipeList> response = restTemplate.exchange(apiUrl +
                "/recipes/complexSearch?query=xyz", HttpMethod.GET, requestEntity, GenericRecipeList.class);
        LinkedHashMap<String, Integer> mapLimits = new LinkedHashMap<>();

        List<String> tempList = response.getHeaders().get("x-ratelimit-requests-limit");
        mapLimits.put("x-ratelimit-requests-limit", Integer.parseInt(tempList.get(0)));
        tempList = response.getHeaders().get("x-ratelimit-requests-remaining");
        mapLimits.put("x-ratelimit-requests-remaining", Integer.parseInt(tempList.get(0)));
        tempList = response.getHeaders().get("x-ratelimit-results-limit");
        mapLimits.put("x-ratelimit-results-limit", Integer.parseInt(tempList.get(0)));
        tempList = response.getHeaders().get("x-ratelimit-results-remaining");
        mapLimits.put("x-ratelimit-results-remaining", Integer.parseInt(tempList.get(0)));
        tempList = response.getHeaders().get("x-ratelimit-tinyrequests-limit");
        mapLimits.put("x-ratelimit-tinyrequests-limit", Integer.parseInt(tempList.get(0)));
        tempList = response.getHeaders().get("x-ratelimit-tinyrequests-remaining");
        mapLimits.put("x-ratelimit-tinyrequests-remaining", Integer.parseInt(tempList.get(0)));

        return mapLimits;
    }
}
