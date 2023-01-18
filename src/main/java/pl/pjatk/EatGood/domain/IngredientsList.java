package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IngredientsList", description = "A wrapper class of Ingredients")
public class IngredientsList {
    @ApiModelProperty(value = "Array of Ingredients", required = true)
    private Ingredient[] extendedIngredients;

    public IngredientsList() {
    }

    public IngredientsList(Ingredient[] extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public Ingredient[] getIngredients() {
        return extendedIngredients;
    }

    public void setIngredients(Ingredient[] extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }
}
