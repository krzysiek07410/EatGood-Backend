package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "Recipe", description = "Details of a recipe")
public class Recipe {
    @ApiModelProperty(value = "Unique identifier of the recipe.", required = true)
    private Integer id;
    @ApiModelProperty(value = "Title of the recipe.", required = true)
    private String title;
    @ApiModelProperty(value = "Summary of instructions", required = true)
    private String summary;
    @ApiModelProperty(value = "Instructions of the recipe.", required = true)
    private String instructions;
    @ApiModelProperty(value = "Image of the recipe.", required = true)
    private String image;
    @ApiModelProperty(value = "Time to make recipe in minutes.", required = true)
    private int readyInMinutes;
    @ApiModelProperty(value = "Servings of the recipe.", required = true)
    private int servings;
    @ApiModelProperty(value = "List of cuisines of the recipe.", required = true)
    private List<String> cuisines;
    @ApiModelProperty(value = "List of diets of the recipe.", required = true)
    private List<String> diets;

    public Recipe() {
    }

    public Recipe(Integer id, String title, String summary, String instructions, String image, int readyInMinutes,
                  int servings, List<String> cuisines, List<String> diets) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.instructions = instructions;
        this.image = image;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.cuisines = cuisines;
        this.diets = diets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    public List<String> getDiets() {
        return diets;
    }

    public void setDiets(List<String> diets) {
        this.diets = diets;
    }

    //    @Override
//    public String toString() {
//        return "Recipe{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", summary='" + summary + '\'' +
//                ", instructions='" + instructions + '\'' +
//                ", image='" + image + '\'' +
//                ", readyInMinutes=" + readyInMinutes +
//                ", servings=" + servings +
//                '}';
//    }
}
