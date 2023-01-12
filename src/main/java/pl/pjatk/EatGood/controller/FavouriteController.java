package pl.pjatk.EatGood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.service.FavouriteService;

@RestController
@RequestMapping("/favrec")
public class FavouriteController {

    private final FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test");
    }


    @PostMapping("/save")
    public ResponseEntity<FavouriteRecipe> saveFavouriteRecipe(@RequestBody FavouriteRecipe favouriteRecipeToSave) {
        return ResponseEntity.ok(favouriteService.saveFavouriteRecipe(favouriteRecipeToSave));
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteFavouriteRecipe(@RequestBody Integer id) {
        favouriteService.deleteFavourtieRecipe(id);
        return ResponseEntity.ok().build();
    }
}
