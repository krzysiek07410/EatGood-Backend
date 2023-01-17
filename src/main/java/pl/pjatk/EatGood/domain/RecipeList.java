package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RecipeList", description = "A wrapper class of Recipes")
public class RecipeList {
    @ApiModelProperty(value = "Array of recipes", required = true)
    private Recipe[] recipes;

    public RecipeList() {
    }

    public RecipeList(Recipe[] results) {
        this.recipes = results;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe[] recipes) {
        this.recipes = recipes;
    }
}
