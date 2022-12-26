package pl.pjatk.EatGood.domain;

public class RecipeList {
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
