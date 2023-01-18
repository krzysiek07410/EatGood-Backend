package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IngredientsList", description = "A wrapper class of Ingredients")
public class IngredientsList {
    @ApiModelProperty(value = "Array of Ingredients", required = true)
    private Ingredient[] ingredients;

    public IngredientsList() {
    }

    public IngredientsList(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }
}
