package pl.pjatk.EatGood.domain;

public class GenericRecipeList {
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

