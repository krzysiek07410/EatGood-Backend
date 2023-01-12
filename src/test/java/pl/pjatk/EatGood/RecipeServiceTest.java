package pl.pjatk.EatGood;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.service.RecipeService;

import java.io.FileInputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
//@TestPropertySource()
//@TestPropertySource(properties = {
//        "spoonacular.url=https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
//        "spoonacular.host.name=X-RapidAPI-Host",
//        "spoonacular.host.value=spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
//        "spoonacular.key.name=X-RapidAPI-Key",
//        "spoonacular.key.value=8f550b7fa2msha9a927ff991988cp11574ajsn2b82d10d2ca7"
//})
public class RecipeServiceTest {
    RecipeServiceTest() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/test.properties"));
        apiUrl = properties.getProperty("spoonacular.url");
        apiKeyName = properties.getProperty("spoonacular.key.name");
        apiKeyValue = properties.getProperty("spoonacular.key.value");
        hostName = properties.getProperty("spoonacular.host.name");
        hostValue = properties.getProperty("spoonacular.host.value");
    }

    //    @Value("${spoonacular.url}")
    private String apiUrl;// = ReflectionTestUtils.getField(recipeServiceSpy, "apiUrl").toString();
//    private String apiUrl = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";

    //    @Value("${spoonacular.key.name}")
    private String apiKeyName;
//    private String apiKeyName = "X-RapidAPI-Key";

    //    @Value("${spoonacular.key.value}")
    private String apiKeyValue;
//    private String apiKeyValue = "8f550b7fa2msha9a927ff991988cp11574ajsn2b82d10d2ca7";

    //    @Value("${spoonacular.host.name}")
    private String hostName;
//    private String hostName = "X-RapidAPI-Host";

    //    @Value("${spoonacular.host.value}")
    private String hostValue;
    //    private String hostValue = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";

    @Mock
    private RestTemplate restTemplate;

//    @InjectMocks
    @Autowired
    private RecipeService recipeService = new RecipeService(restTemplate, apiUrl, apiKeyName, apiKeyValue, hostName, hostValue);

//    @Spy
//    private final RecipeService recipeServiceSpy = new RecipeService(restTemplate);
//
//    @Before(value = "")
//    public void setUp() {
//        ReflectionTestUtils.setField(recipeService, "apiUrl", "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com");
//        ReflectionTestUtils.setField(recipeService, "apiKeyName", "X-RapidAPI-Key");
//        ReflectionTestUtils.setField(recipeService, "apiKeyValue", "8f550b7fa2msha9a927ff991988cp11574ajsn2b82d10d2ca7");
//        ReflectionTestUtils.setField(recipeService, "hostName", "X-RapidAPI-Host");
//        ReflectionTestUtils.setField(recipeService, "hostValue", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com");
//    }

    @Test
    void getRecipesByQueryTest() {
        System.out.println("apiUrl: " + apiUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String query = "chicken";
        String expectedUrl = apiUrl + "/recipes/complexSearch?query=chicken";

        ResponseEntity<GenericRecipeList> expectedResponse = new ResponseEntity<>(new GenericRecipeList(), HttpStatus.OK);
        when(restTemplate.exchange(expectedUrl, HttpMethod.GET, requestEntity, GenericRecipeList.class)).thenReturn(expectedResponse);

        ResponseEntity<GenericRecipeList> response = recipeService.getRecipesByQuery(query);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getRecipesInformationTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        String ids = "123,456,789";
        String expectedUrl = apiUrl + "/recipes/informationBulk?ids=123,456,789";

        ResponseEntity<Recipe[]> expectedResponse = new ResponseEntity<>(new Recipe[3], HttpStatus.OK);
        when(restTemplate.exchange(expectedUrl, HttpMethod.GET, requestEntity, Recipe[].class)).thenReturn(expectedResponse);

        ResponseEntity<Recipe[]> response = recipeService.getRecipesInformation(ids);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getRecipesByCaloriesTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(apiKeyName, apiKeyValue);
        headers.set(hostName, hostValue);
        HttpEntity<Recipe> requestEntity = new HttpEntity<Recipe>(headers);
        long min = 200;
        long max = 300;
        String expectedUrl = apiUrl + "/recipes/complexSearch?minCalories=200&maxCalories=300";

        ResponseEntity<GenericRecipeList> expectedResponse = new ResponseEntity<>(new GenericRecipeList(), HttpStatus.OK);
        when(restTemplate.exchange(expectedUrl, HttpMethod.GET, requestEntity, GenericRecipeList.class)).thenReturn(expectedResponse);

        ResponseEntity<GenericRecipeList> response = recipeService.getRecipesByCalories(min, max);
        assertEquals(expectedResponse, response);
    }

//    @Test
//    void getRecipesByCuisineTest() {
//        String cuisine = "italian";
//        String expectedUrl = apiUrl + "/recipes/complexSearch?cuisine=italian";
//        ResponseEntity<GenericRecipeList> expectedResponse = new Response
//    }
}