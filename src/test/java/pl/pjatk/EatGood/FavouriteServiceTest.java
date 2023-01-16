package pl.pjatk.EatGood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.domain.GenericRecipe;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.repository.favourite.RecipeRepository;
import pl.pjatk.EatGood.repository.favourite.UserRepository;
import pl.pjatk.EatGood.service.FavouriteService;
import pl.pjatk.EatGood.service.RecipeService;

import java.security.Principal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class FavouriteServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FavouriteService favouriteService;

    @InjectMocks
    private RecipeService recipeService;

    //saveFavouriteRecipe DONE
    //deleteFavouriteRecipe DONE
    //findFavouriteRecipeById DONE
    //saveUser DONE
    //getUserIdFromUsername TODO
    //deleteUser DONE
    //findUserById DONE
    //findUserByIdOrSaveUser DONE
    //addRecipeToUser TODO
    //removeRecipeFromUser DONE
    //getUserFavouriteRecipes TODO

    @Test
    public void shouldSaveFavouriteRecipe() {
        FavouriteRecipe favouriteRecipe = new FavouriteRecipe();
        when(recipeRepository.save(any(FavouriteRecipe.class))).thenReturn(favouriteRecipe);

        FavouriteRecipe savedFavouriteRecipe = favouriteService.saveFavouriteRecipe(favouriteRecipe);

        assertThat(savedFavouriteRecipe).isNotNull();
    }

    @Test
    public void shouldDeleteFavouriteRecipe() {
        favouriteService.deleteFavouriteRecipe(1);
        Mockito.verify(recipeRepository).deleteById(any());
    }

    @Test
    public void shouldFindFavouriteRecipeById() {
        FavouriteRecipe favouriteRecipe = new FavouriteRecipe(749013,
                "Pasta",
                "https://spoonacular.com/recipeImages/749013-312x231.jpeg",
                "jpeg",
                Set.of(new User(1, "user", Set.of()), new User(2, "user2", Set.of())));

        when(recipeRepository.findById(749013)).thenReturn(java.util.Optional.of(favouriteRecipe));

        assertThat(favouriteService.findFavouriteRecipeById(749013)).isEqualTo(favouriteRecipe);
    }

    @Test
    public void shouldSaveUser() {
        String username = "user";
        User user = new User(1, username, Set.of());
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = favouriteService.saveUser(username);

        assertThat(savedUser).isNotNull();
    }

//    @Test
//    public void shouldGetUserIdFromUsername() {
//        String username = "user";
//        User user = new User(1, username, Set.of());
//        when(userRepository.findIdByUsername(username)).thenReturn(user.getId());
//
//        assertThat(favouriteService.getUserIdFromUsername(username)).isEqualTo(user.getId());
//    }

    @Test
    public void shouldDeleteUser() {
        favouriteService.deleteUser(1);
        Mockito.verify(userRepository).deleteById(any());
    }

    @Test
    public void shouldFindUserById() {
        User user = new User(1, "user", Set.of());

        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        assertThat(favouriteService.findUserById(1)).isEqualTo(user);
    }

    @Test
    public void shouldFindUserByUsernameOrSaveUser() {
        String username = "user";
        User user = new User(1, username, Set.of());

        when(userRepository.findUserByUsername(username)).thenReturn(java.util.Optional.of(user));

        assertThat(favouriteService.findUserByUsernameOrSaveUser(username)).isEqualTo(user);
    }

//    @Test
//    public void shouldAddRecipeToUser() {
//        User user = new User(1, "user", Set.of());
//        FavouriteRecipe favouriteRecipe = new FavouriteRecipe(749013,
//                "Pasta",
//                "https://spoonacular.com/recipeImages/749013-312x231.jpeg",
//                "jpeg",
//                Set.of(user));
//
//        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
//
//        favouriteService.addRecipeToUser(749013, "user");
//
//        assertThat(user.getFavouriteRecipeSet()).contains(favouriteRecipe);
//    }

//    @Test
//    public void shouldAddRecipeToUser() {
//        User user = new User(1, "user", Set.of());
//        FavouriteRecipe favouriteRecipe = new FavouriteRecipe(749013,
//                "Pasta",
//                "https://spoonacular.com/recipeImages/749013-312x231.jpeg",
//                "jpeg",
//                Set.of(new User(1, "user", Set.of()), new User(2, "user2", Set.of())));
//        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
//        when(recipeRepository.findById(749013)).thenReturn(java.util.Optional.of(favouriteRecipe));
//
//        favouriteService.addRecipeToUser(1, "user");
//
//        assertThat(user.getFavouriteRecipeSet()).contains(favouriteRecipe);
//    }

//    @Test
//    public void shouldAddRecipeToUser() {
//        FavouriteRecipe favouriteRecipe = new FavouriteRecipe(749013,
//                "Pasta",
//                "https://spoonacular.com/recipeImages/749013-312x231.jpeg",
//                "jpeg",
//                Set.of(new User(1, "user", Set.of()), new User(2, "user2", Set.of())));
//        Principal principal = () -> "u1";
//
//        favouriteService.addRecipeToUser(749013, principal);
//
//        assertThat(favouriteService.findFavouriteRecipeById(749013)).isEqualTo(favouriteRecipe);
//    }

    @Test
    public void shouldRemoveRecipeFromUser() {
        favouriteService.deleteFavouriteRecipe(1);
        Mockito.verify(recipeRepository).deleteById(any());
    }

//    @Test
//    public void shouldGetUserFavouriteRecipes() {
//        User user = new User(1, "user", Set.of());
//        FavouriteRecipe favouriteRecipe = new FavouriteRecipe(749013,
//                "Pasta",
//                "https://spoonacular.com/recipeImages/749013-312x231.jpeg",
//                "jpeg",
//                Set.of(user));
//        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
//
//        favouriteService.getUserFavouriteRecipes("user");
//
//        assertThat(user.getFavouriteRecipeSet()).contains(favouriteRecipe);
//    }

//    @Test
//    public void shouldGetUserFavouriteRecipes() {
//        User user = new User(1, "user", Set.of(new FavouriteRecipe(749013,
//                "Pasta",
//                "https://spoonacular.com/recipeImages/749013-312x231.jpeg",
//                "jpeg",
//                Set.of(new User(1, "user", Set.of()), new User(2, "user2", Set.of())))));
//        userRepository.save(user);
//        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
//        Principal principal = () -> "u1";
//
//        when(userRepository.findByUsername("u1")).thenReturn(user);
//
//        assertThat(favouriteService.getUserFavouriteRecipes(principal)).isEqualTo(user.getFavouriteRecipeSet());
//    }

//    @Test
//    public void  shouldGetUserFavouriteRecipes() {
//        User user = new User(1, "user", Set.of(new FavouriteRecipe(749013,
//                "Pasta",
//                "https://spoonacular.com/recipeImages/749013-312x231.jpeg",
//                "jpeg",
//                Set.of(new User(1, "user", Set.of()), new User(2, "user2", Set.of())))));
//        userRepository.save(user);
//        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
//
//        assertThat(favouriteService.getUserFavouriteRecipes("user")).isEqualTo(user.getFavouriteRecipeSet());
//    }
}