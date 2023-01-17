package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GenericRecipeList", description = "A wrapper class of Generic Recipes")
public class GenericRecipeList {
    @ApiModelProperty(value = "Array of GenericRecipes", required = true)
    private GenericRecipe[] results;

    public GenericRecipeList() {
    }

    public GenericRecipeList(GenericRecipe[] results) {
        this.results = results;
    }

    public GenericRecipe[] getResults() {
        return results;
    }

    public void setResults(GenericRecipe[] results) {
        this.results = results;
    }
}

