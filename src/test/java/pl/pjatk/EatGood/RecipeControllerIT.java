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
@AutoConfigureMockMvc
public class RecipeControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnRecipeListByQuery() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/getRecipes?query=pizza");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":108172,\"title\":\"Pizza\",\"image\":\"https://spoonacular.com/recipeImages/108172-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1090114,\"title\":\"pizza\",\"image\":\"https://spoonacular.com/recipeImages/1090114-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":210327,\"title\":\"Pizza\",\"image\":\"https://spoonacular.com/recipeImages/210327-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":285752,\"title\":\"Pizza Mac\",\"image\":\"https://spoonacular.com/recipeImages/285752-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":172154,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/172154-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":508123,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/508123-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1696869,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/1696869-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1067382,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/1067382-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":248459,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/248459-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":527345,\"title\":\"Pizza Dip\",\"image\":\"https://spoonacular.com/recipeImages/527345-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnRecipesInformation() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/getRecipesInformation?ids=108172");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":108172,\"title\":\"Pizza\",\"summary\":\"Pizza might be just the <b>Mediterranean</b> recipe you are searching for. This recipe serves 6 and costs $1.57 per serving. One portion of this dish contains approximately <b>18g of protein</b>, <b>26g of fat</b>, and a total of <b>390 calories</b>. It works well as a main course. Not a lot of people made this recipe, and 1 would say it hit the spot. It is brought to you by My Recipes. Head to the store and pick up cornmeal, mozzarella, olive oil, and a few other things to make it today. From preparation to the plate, this recipe takes approximately <b>10 minutes</b>. Overall, this recipe earns a <b>solid spoonacular score of 58%</b>. Similar recipes include <a href=\\\"https://spoonacular.com/recipes/frozen-peanut-butter-cup-dessert-pizza-treatzza-pizza-video-898671\\\">Frozen Peanut Butter Cup Dessert Pizza (Treatzza Pizza) + VIDEO</a>, <a href=\\\"https://spoonacular.com/recipes/grilled-chicken-asparagus-and-mushroom-pizza-with-blackbird-bakery-pizza-crust-1249471\\\">Grilled Chicken, Asparagus, and Mushroom Pizza with Blackbird Bakery Pizza Crust</a>, and <a href=\\\"https://spoonacular.com/recipes/grilled-chicken-asparagus-and-mushroom-pizza-with-blackbird-bakery-pizza-crust-539911\\\">Grilled Chicken, Asparagus, and Mushroom Pizza with Blackbird Bakery Pizza Crust</a>.\",\"instructions\":\"Place a pizza stone, unglazed ceramic tiles, or a heavy cookie sheet on the oven rack. Preheat oven to 400 F. If starting with pizza dough, pat or pull each piece into a 12-inch circle. Top each with some sauce, then scatter the chicken, basil, and mozzarella over each. Drizzle with olive oil. Sprinkle pizza stone with the cornmeal. Using the back of a cookie sheet, transfer the pizza to the oven. (You may have to bake the pizzas one at a time, depending on your oven size.) Bake 20 minutes or until the cheese is melted and the crust is browned.\",\"image\":\"https://spoonacular.com/recipeImages/108172-556x370.jpg\",\"readyInMinutes\":10,\"servings\":6,\"cuisines\":[\"Mediterranean\",\"Italian\",\"European\"],\"diets\":[]}]"));
    }

    @Test
    void shouldReturnRecipeListByCalories() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/getRecipesByCalories?minCalories=100&maxCalories=200");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":37577,\"title\":\"Asparagus Beans Amd Squid\",\"image\":\"https://spoonacular.com/recipeImages/37577-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":8936,\"title\":\"Cream Cheese And Arugula Toast Bites\",\"image\":\"https://spoonacular.com/recipeImages/8936-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1093751,\"title\":\"Sam's Easy Choc-Chip Cookies\",\"image\":\"https://spoonacular.com/recipeImages/1093751-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnRecipeListByCuisine() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/getRecipesByCuisine?cuisine=italian");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":592686,\"title\":\"Italian Noodle Soup\",\"image\":\"https://spoonacular.com/recipeImages/592686-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":548450,\"title\":\"Sweet Potato Kale Pizza with Rosemary & Red Onion\",\"image\":\"https://spoonacular.com/recipeImages/548450-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":443063,\"title\":\"Italian Rice\",\"image\":\"https://spoonacular.com/recipeImages/443063-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":695172,\"title\":\"Inside-Out Lasagna\",\"image\":\"https://spoonacular.com/recipeImages/695172-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":246727,\"title\":\"Pasta e Fagioli\",\"image\":\"https://spoonacular.com/recipeImages/246727-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":775632,\"title\":\"Homemade Pizza Sauce\",\"image\":\"https://spoonacular.com/recipeImages/775632-312x231.png\",\"imageType\":\"png\"},{\"id\":591184,\"title\":\"Pumpkin Smoothie\",\"image\":\"https://spoonacular.com/recipeImages/591184-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":539288,\"title\":\"Mocha Chip Cheesecake “Milkshake” {high protein}\",\"image\":\"https://spoonacular.com/recipeImages/539288-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":611822,\"title\":\"Pumpkin Pie Oatmeal\",\"image\":\"https://spoonacular.com/recipeImages/611822-312x231.png\",\"imageType\":\"png\"},{\"id\":613283,\"title\":\"creamy parmesan garlic gnocchi\",\"image\":\"https://spoonacular.com/recipeImages/613283-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnRecipeListByDiet() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/getRecipesByDiet?diet=vegetarian");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"results\":[{\"id\":592479,\"title\":\"Kale and Quinoa Salad with Black Beans\",\"image\":\"https://spoonacular.com/recipeImages/592479-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":495111,\"title\":\"Citrus Sesame Kale\",\"image\":\"https://spoonacular.com/recipeImages/495111-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":582897,\"title\":\"Mexican Salad with Lime Dressing\",\"image\":\"https://spoonacular.com/recipeImages/582897-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":1009573,\"title\":\"Quinoa Kale Tomato Corn Salad\",\"image\":\"https://spoonacular.com/recipeImages/1009573-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":801710,\"title\":\"Matcha Green Tea and Pineapple Smoothie\",\"image\":\"https://spoonacular.com/recipeImages/801710-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":621163,\"title\":\"Pesto Pasta with Lemon, Spinach, Edamame & Toasted Almonds\",\"image\":\"https://spoonacular.com/recipeImages/621163-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":547899,\"title\":\"Sweet Potato and Black Bean Mexican Salad\",\"image\":\"https://spoonacular.com/recipeImages/547899-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":613079,\"title\":\"Smashed White Bean and Avocado Sandwich\",\"image\":\"https://spoonacular.com/recipeImages/613079-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":995889,\"title\":\"Low Calorie Peanut Butter Banana Spinach Smoothie\",\"image\":\"https://spoonacular.com/recipeImages/995889-312x231.jpg\",\"imageType\":\"jpg\"},{\"id\":483531,\"title\":\"Black Bean and Barley Salad\",\"image\":\"https://spoonacular.com/recipeImages/483531-312x231.jpg\",\"imageType\":\"jpg\"}]}"));
    }

    @Test
    void shouldReturnRandomRecipeList() throws Exception {
        int  recipeCount = 2;
        MockHttpServletRequestBuilder getRequestBuilder = get("/api/recipe/getRandomRecipes?recipeCount=" + recipeCount);
        mockMvc.perform(getRequestBuilder)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipes", hasSize(recipeCount)));
    }
}
