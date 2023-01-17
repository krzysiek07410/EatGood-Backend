package pl.pjatk.EatGood;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.repository.favourite.RecipeRepository;
import pl.pjatk.EatGood.repository.favourite.UserRepository;
import pl.pjatk.EatGood.service.FavouriteService;

import java.util.Optional;

import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
public class FavouriteControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FavouriteService favouriteService;

    @MockBean
    private RecipeRepository recipeRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void shouldReturnTestString() throws Exception {
        mockMvc.perform(post("/api/favourite/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Test"));
    }

//    @Test
//    public void shouldSaveFavouriteRecipe() throws Exception {
//        FavouriteRecipe favouriteRecipe = new FavouriteRecipe();
//        favouriteRecipe.setId(1);
//        favouriteRecipe.setTitle("Test recipe");
//        favouriteRecipe.setImage("test.jpg");
//
//        when(recipeRepository.save(favouriteRecipe)).thenReturn(favouriteRecipe);
//
//        mockMvc.perform(post("/api/favourite/recipe/save")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(String.valueOf(favouriteRecipe)).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Test recipe"))
//                .andExpect(jsonPath("$.image").value("test.jpg"));
//
//        verify(recipeRepository, times(1)).save(favouriteRecipe);
//    }

//    @Test
//    public void saveFavouriteRecipeEndpointTest() throws Exception {
//        FavouriteRecipe favouriteRecipe = new FavouriteRecipe();
//        favouriteRecipe.setId(1);
//        favouriteRecipe.setTitle("Test recipe");
//        favouriteRecipe.setImage("test.jpg");
//
//        when(userRepository.(favouriteRecipe)).thenReturn(favouriteRecipe);
//
//        mockMvc.perform(post("/api/favourite/recipe/save")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(favouriteRecipe)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.title", is("Test recipe")))
//                .andExpect(jsonPath("$.image", is("test.jpg")));
//
//        verify(favouriteRepository, times(1)).save(favouriteRecipe);
//    }

    @Test
    public void shouldDeleteFavouriteRecipe() throws Exception {
        doNothing().when(recipeRepository).deleteById(1);
//        MockHttpServletRequestBuilder getRequestBuilder = get("/api/favourite/recipe/delete");
        mockMvc.perform(get("/api/favourite/recipe/delete")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(favouriteService, times(1)).deleteFavouriteRecipe(1);
    }

//    @Test
//    public void shouldFindFavouriteRecipeById() throws Exception {
//        FavouriteRecipe favouriteRecipe = new FavouriteRecipe();
//        favouriteRecipe.setId(1);
//
//        when(recipeRepository.findById(1)).thenReturn(Optional.of(favouriteRecipe));
//
//        mockMvc.perform(get("/api/favourite/recipe/find")
//                        .param("id", "1"))
//                .andExpect(status().isOk());
////                .andExpect();
//
//        verify(recipeRepository, times(1)).findById(1);
//    }

//    @Test
//    public void shouldSaveUser() {
//
//    }

    @Test
    public void shouldDeleteUser() throws Exception {
        doNothing().when(userRepository).deleteById(1);
//        MockHttpServletRequestBuilder getRequestBuilder = get("/api/favourite/user/delete");
        mockMvc.perform(get("/api/favourite/user/delete")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(favouriteService, times(1)).deleteUser(1);
    }

    @Test
    public void shouldFindUserById() throws Exception {
        User user = new User(1, "user");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/favourite/user/find")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk());

//        verify(userRepository, times(1)).findById(1);

        //TODO: check if user is returned
    }

//    @Test
//    public void shouldFindUserByUsernameOrSaveUser() throws Exception {
//        User user = new User(1, "user");
//
//        when(userRepository.findUserByUsername("user")).thenReturn(Optional.of(user));
//
//        mockMvc.perform(get("/api/favourite/user/find")
//                        .param("username", "user"))
//                .andDo(print())
//                .andExpect(status().isOk());
//
////        verify(favouriteService, times(1)).findUserByUsernameOrSaveUser("user");
//    }

//    @Test
//    public  void shouldAddRecipeToUser() {
//
//    }

//    @Test
//    public void shouldDeleteRecipeFromUser() {
//
//    }

//    @Test
//    public void shouldGetUserFavouriteRecipes() {
//
//    }
}
