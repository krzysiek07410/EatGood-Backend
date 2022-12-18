package pl.pjatk.EatGood.domain;

public class CuisinesList {
    private Cuisines[] results;

    public CuisinesList() {
    }

    public CuisinesList(Cuisines[] results) {
        this.results = results;
    }

    public Cuisines[] getResults() {
        return results;
    }

    public void setResults(Cuisines[] results) {
        this.results = results;
    }
}

