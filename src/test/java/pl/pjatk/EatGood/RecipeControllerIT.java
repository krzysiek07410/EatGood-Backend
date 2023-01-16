package pl.pjatk.EatGood;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
public class RecipeControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnGenericRecipeListByQuery() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/generic?query=pizza");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":108172,\"title\":\"Pizza\",\"image\":\"https://spoonacular.com/recipeImages/108172-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1090114,\"title\":\"pizza\",\"image\":\"https://spoonacular.com/recipeImages/1090114-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":210327,\"title\":\"Pizza\",\"image\":\"https://spoonacular.com/recipeImages/210327-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":285752,\"title\":\"Pizza Mac\",\"image\":\"https://spoonacular.com/recipeImages/285752-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":172154,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/172154-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":508123,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/508123-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1696869,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/1696869-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1067382,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/1067382-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":248459,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/248459-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":527345,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/527345-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnRecipesInformation() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/information?ids=108172,10173");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"recipes\":[{\"id\":108172,\"title\":\"Pizza\",\"summary\":\"Pizza might be just the <b>Mediterranean</b> recipe you are searching for. This recipe serves 6 and costs $1.57 per serving. One portion of this dish contains approximately <b>18g of protein</b>, <b>26g of fat</b>, and a total of <b>390 calories</b>. It works well as a main course. Not a lot of people made this recipe, and 1 would say it hit the spot. It is brought to you by My Recipes. Head to the store and pick up cornmeal, mozzarella, olive oil, and a few other things to make it today. From preparation to the plate, this recipe takes approximately <b>10 minutes</b>. Overall, this recipe earns a <b>solid spoonacular score of 58%</b>. Similar recipes include <a href=\\\"https://spoonacular.com/recipes/frozen-peanut-butter-cup-dessert-pizza-treatzza-pizza-video-898671\\\">Frozen Peanut Butter Cup Dessert Pizza (Treatzza Pizza) + VIDEO</a>, <a href=\\\"https://spoonacular.com/recipes/grilled-chicken-asparagus-and-mushroom-pizza-with-blackbird-bakery-pizza-crust-1249471\\\">Grilled Chicken, Asparagus, and Mushroom Pizza with Blackbird Bakery Pizza Crust</a>, and <a href=\\\"https://spoonacular.com/recipes/grilled-chicken-asparagus-and-mushroom-pizza-with-blackbird-bakery-pizza-crust-539911\\\">Grilled Chicken, Asparagus, and Mushroom Pizza with Blackbird Bakery Pizza Crust</a>.\",\"instructions\":\"Place a pizza stone, unglazed ceramic tiles, or a heavy cookie sheet on the oven rack. Preheat oven to 400 F. If starting with pizza dough, pat or pull each piece into a 12-inch circle. Top each with some sauce, then scatter the chicken, basil, and mozzarella over each. Drizzle with olive oil. Sprinkle pizza stone with the cornmeal. Using the back of a cookie sheet, transfer the pizza to the oven. (You may have to bake the pizzas one at a time, depending on your oven size.) Bake 20 minutes or until the cheese is melted and the crust is browned.\",\"image\":\"https://spoonacular.com/recipeImages/108172-556x370.jpg\",\"readyInMinutes\":10,\"servings\":6,\"cuisines\":[\"Mediterranean\",\"Italian\",\"European\"],\"diets\":[]},{\"id\":10173,\"title\":\"Sesame Red Curry Chicken with Bok Choy and Sweet Coconut Rice\",\"summary\":\"The recipe Sesame Red Curry Chicken with Bok Choy and Sweet Coconut Rice can be made <b>in about 3 hours and 15 minutes</b>. This recipe makes 4 servings with <b>753 calories</b>, <b>33g of protein</b>, and <b>23g of fat</b> each. For <b>$4.01 per serving</b>, this recipe <b>covers 32%</b> of your daily requirements of vitamins and minerals. It works well as a main course. A mixture of ginger, freshly cilantro leaves, salt and ground pepper, and a handful of other ingredients are all it takes to make this recipe so yummy. It is a <b>pretty expensive</b> recipe for fans of Indian food. A couple people made this recipe, and 35 would say it hit the spot. It is a good option if you're following a <b>gluten free, dairy free, and fodmap friendly</b> diet. It is brought to you by Foodnetwork. Overall, this recipe earns a <b>super spoonacular score of 81%</b>. Users who liked this recipe also liked <a href=\\\"https://spoonacular.com/recipes/sesame-red-curry-chicken-with-bok-choy-and-sweet-coconut-rice-292043\\\">Sesame Red Curry Chicken with Bok Choy and Sweet Coconut Rice</a>, <a href=\\\"https://spoonacular.com/recipes/red-curry-tofu-with-coconut-chile-carrots-and-bok-choy-604256\\\">Red Curry Tofu with Coconut Chile Carrots and Bok Choy</a>, and <a href=\\\"https://spoonacular.com/recipes/turkey-in-red-curry-with-sweet-potato-and-baby-bok-choy-552136\\\">Turkey in Red Curry with Sweet Potato and Baby Bok Choy</a>.\",\"instructions\":\"Watch how to make this recipe.                    Arrange bok choy and red pepper in bottom of slow cooker. Season 4 chicken breast halves all over with salt and black pepper and place on top of bok choy.                          In a small bowl, whisk together broth, sake, sesame oil, ginger, and curry paste. Pour mixture over chicken. Cover and cook on LOW for 6 to 8 hours or HIGH for 3 to 4 hours.                          In a small skillet toast flaked coconut on low heat until lightly toasted, about 5 to 8 minutes. To a medium saucepan, add rice and coconut milk and set pan over medium-high heat, bring to a simmer for 5 minutes. Remove from heat and let stand 5 minutes. Stir in toasted coconut. Set aside 1 1/2 cups for another recipe.                          Spoon rice onto a serving platter. Top with chicken, bok choy, bell peppers and sauce from slow cooker. Garnish with cilantro.\",\"image\":\"https://spoonacular.com/recipeImages/10173-556x370.jpeg\",\"readyInMinutes\":195,\"servings\":4,\"cuisines\":[\"Indian\",\"Asian\"],\"diets\":[\"gluten free\",\"dairy free\",\"fodmap friendly\"]}]}"));
    }

    @Test
    void shouldReturnGenericRecipeListByCalories() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/calories?minCalories=100&maxCalories=200");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":37577,\"title\":\"Asparagus Beans Amd Squid\",\"image\":\"https://spoonacular.com/recipeImages/37577-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":8936,\"title\":\"Cream Cheese And Arugula Toast Bites\",\"image\":\"https://spoonacular.com/recipeImages/8936-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1093751,\"title\":\"Sam's Easy Choc-Chip Cookies\",\"image\":\"https://spoonacular.com/recipeImages/1093751-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnGenericRecipeListByCuisine() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/cuisine?cuisine=italian");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":592686,\"title\":\"Italian Noodle Soup\",\"image\":\"https://spoonacular.com/recipeImages/592686-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":548450,\"title\":\"Sweet Potato Kale Pizza with Rosemary & Red Onion\",\"image\":\"https://spoonacular.com/recipeImages/548450-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":443063,\"title\":\"Italian Rice\",\"image\":\"https://spoonacular.com/recipeImages/443063-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":695172,\"title\":\"Inside-Out Lasagna\",\"image\":\"https://spoonacular.com/recipeImages/695172-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":246727,\"title\":\"Pasta e Fagioli\",\"image\":\"https://spoonacular.com/recipeImages/246727-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":775632,\"title\":\"Homemade Pizza Sauce\",\"image\":\"https://spoonacular.com/recipeImages/775632-312x231.png\",\"imageType\":\"png\"},{\"id\":591184,\"title\":\"Pumpkin Smoothie\",\"image\":\"https://spoonacular.com/recipeImages/591184-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":539288,\"title\":\"Mocha Chip Cheesecake “Milkshake” {high protein}\",\"image\":\"https://spoonacular.com/recipeImages/539288-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":611822,\"title\":\"Pumpkin Pie Oatmeal\",\"image\":\"https://spoonacular.com/recipeImages/611822-312x231.png\",\"imageType\":\"png\"},{\"id\":613283,\"title\":\"creamy parmesan garlic gnocchi\",\"image\":\"https://spoonacular.com/recipeImages/613283-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnGenericRecipeListByDiet() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/diet?diet=vegetarian");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":592479,\"title\":\"Kale and Quinoa Salad with Black Beans\",\"image\":\"https://spoonacular.com/recipeImages/592479-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":495111,\"title\":\"Citrus Sesame Kale\",\"image\":\"https://spoonacular.com/recipeImages/495111-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":582897,\"title\":\"Mexican Salad with Lime Dressing\",\"image\":\"https://spoonacular.com/recipeImages/582897-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1009573,\"title\":\"Quinoa Kale Tomato Corn Salad\",\"image\":\"https://spoonacular.com/recipeImages/1009573-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":801710,\"title\":\"Matcha Green Tea and Pineapple Smoothie\",\"image\":\"https://spoonacular.com/recipeImages/801710-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":621163,\"title\":\"Pesto Pasta with Lemon, Spinach, Edamame & Toasted Almonds\",\"image\":\"https://spoonacular.com/recipeImages/621163-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":547899,\"title\":\"Sweet Potato and Black Bean Mexican Salad\",\"image\":\"https://spoonacular.com/recipeImages/547899-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":613079,\"title\":\"Smashed White Bean and Avocado Sandwich\",\"image\":\"https://spoonacular.com/recipeImages/613079-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":995889,\"title\":\"Low Calorie Peanut Butter Banana Spinach Smoothie\",\"image\":\"https://spoonacular.com/recipeImages/995889-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":483531,\"title\":\"Black Bean and Barley Salad\",\"image\":\"https://spoonacular.com/recipeImages/483531-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnGenericRecipeListByQueryAndDiet() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/queryanddiet?query=chicken&diet=vegetarian");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":248083,\"title\":\"Chicken Marsala\",\"image\":\"https://spoonacular.com/recipeImages/248083-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":71599,\"title\":\"Chicken Pot Pie\",\"image\":\"https://spoonacular.com/recipeImages/71599-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1018659,\"title\":\"Chicken Waldorf Salad\",\"image\":\"https://spoonacular.com/recipeImages/1018659-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":496505,\"title\":\"Chicken Pilaf with Cilantro\",\"image\":\"https://spoonacular.com/recipeImages/496505-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":312626,\"title\":\"Chicken and Egg Soup with Pastina\",\"image\":\"https://spoonacular.com/recipeImages/312626-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":1436971,\"title\":\"Chicken and Dumpling Soup with Spring Vegetables\",\"image\":\"https://spoonacular.com/recipeImages/1436971-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":252928,\"title\":\"Chicken Legs & Thighs Braised in a Savory Rhubarb Onion Sauce\",\"image\":\"https://spoonacular.com/recipeImages/252928-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":344451,\"title\":\"Mexi-Chicken Rice\",\"image\":\"https://spoonacular.com/recipeImages/344451-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":478961,\"title\":\"Faux Chicken Rice Noodle Soup\",\"image\":\"https://spoonacular.com/recipeImages/478961-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1116692,\"title\":\"Keto Chicken Marinade for Grilled Chicken\",\"image\":\"https://spoonacular.com/recipeImages/1116692-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnGenericRecipeListByQueryAndCalories() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/queryandcalories?query=chicken&calories=500");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":296687,\"title\":\"Chicken\",\"image\":\"https://spoonacular.com/recipeImages/296687-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":379523,\"title\":\"Chicken\",\"image\":\"https://spoonacular.com/recipeImages/379523-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":1224783,\"title\":\"Chicken 65\",\"image\":\"https://spoonacular.com/recipeImages/1224783-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":637876,\"title\":\"Chicken 65\",\"image\":\"https://spoonacular.com/recipeImages/637876-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":74194,\"title\":\"Chicken Olé\",\"image\":\"https://spoonacular.com/recipeImages/74194-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":737537,\"title\":\"Chicken Pho\",\"image\":\"https://spoonacular.com/recipeImages/737537-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":737543,\"title\":\"Chicken Pie\",\"image\":\"https://spoonacular.com/recipeImages/737543-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":279390,\"title\":\"Chicken Mac\",\"image\":\"https://spoonacular.com/recipeImages/279390-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":83890,\"title\":\"Chicken Blt\",\"image\":\"https://spoonacular.com/recipeImages/83890-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":496844,\"title\":\"Chicken Pho\",\"image\":\"https://spoonacular.com/recipeImages/496844-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnGenericRecipeListByDietAndCalories() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/dietandcalories?diet=vegetarian&calories=500");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":8936,\"title\":\"Cream Cheese And Arugula Toast Bites\",\"image\":\"https://spoonacular.com/recipeImages/8936-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1093751,\"title\":\"Sam's Easy Choc-Chip Cookies\",\"image\":\"https://spoonacular.com/recipeImages/1093751-312x231.jpg\",\"imageType\":\"jpg\"}]}"));

    }

    @Test
    void shouldReturnGenericRecipeListByQueryAndDietAndCalories() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/queryanddietandcalories?query=chicken&diet=vegetarian&calories=500");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":296687,\"title\":\"Chicken\",\"image\":\"https://spoonacular.com/recipeImages/296687-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":379523,\"title\":\"Chicken\",\"image\":\"https://spoonacular.com/recipeImages/379523-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":1224783,\"title\":\"Chicken 65\",\"image\":\"https://spoonacular.com/recipeImages/1224783-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":637876,\"title\":\"Chicken 65\",\"image\":\"https://spoonacular.com/recipeImages/637876-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":74194,\"title\":\"Chicken Olé\",\"image\":\"https://spoonacular.com/recipeImages/74194-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":737537,\"title\":\"Chicken Pho\",\"image\":\"https://spoonacular.com/recipeImages/737537-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":737543,\"title\":\"Chicken Pie\",\"image\":\"https://spoonacular.com/recipeImages/737543-312x231.jpeg\",\"imageType\":\"jpeg\"},{\"id\":279390,\"title\":\"Chicken Mac\",\"image\":\"https://spoonacular.com/recipeImages/279390-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":83890,\"title\":\"Chicken Blt\",\"image\":\"https://spoonacular.com/recipeImages/83890-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":496844,\"title\":\"Chicken Pho\",\"image\":\"https://spoonacular.com/recipeImages/496844-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    public void shouldGetRandomRecipe() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/random");
        mockMvc.perform(getRequestBuilder)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[0].id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[0].title").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[0].summary").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[0].instructions").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[0].image").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[0].readyInMinutes").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[0].servings").isNotEmpty());
        }

    @Test
    public void shouldGetHeaders() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/headers");
        mockMvc.perform(getRequestBuilder)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x-ratelimit-requests-limit").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x-ratelimit-requests-remaining").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x-ratelimit-results-limit").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x-ratelimit-results-remaining").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x-ratelimit-tinyrequests-limit").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x-ratelimit-tinyrequests-remaining").isNotEmpty());
        }
}