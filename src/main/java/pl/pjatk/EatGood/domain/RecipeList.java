package pl.pjatk.EatGood.domain;

public class RecipeList {
    private Recipe[] results;

    public RecipeList() {
    }

    public RecipeList(Recipe[] results) {
        this.results = results;
    }

    public Recipe[] getResults() {
        return results;
    }

    public void setResults(Recipe[] results) {
        this.results = results;
    }
}
