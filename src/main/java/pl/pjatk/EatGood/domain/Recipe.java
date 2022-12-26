package pl.pjatk.EatGood.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //czy na pewno potrzebne?
    private Integer id;
    private String title;
//    @Column(columnDefinition = "TEXT")
    private String summary;
//    @Column(columnDefinition = "TEXT")
    private String instructions;
    private String image;
    private int readyInMinutes;
    private int servings;
    private List<Cuisines> cuisines;
//    @ElementCollection(targetClass = Cuisines.class)
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "recipe_cuisines", joinColumns = @JoinColumn(name = "recipe_id"))
//    @Column(name="cuisines")
//    private Collection<Cuisines> cuisines;

    public Recipe() {
    }

    public Recipe(Integer id, String title, String summary, String instructions, String image, int readyInMinutes,
                  int servings, String[] cuisines) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.instructions = instructions;
        this.image = image;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.cuisines = stringsToEnums(cuisines);
    }

    private List<Cuisines> stringsToEnums(String[] cuisinesStrings) {
        return Arrays.stream(cuisinesStrings)
                .map(String::toUpperCase)
                .map(Cuisines::valueOf)
                .collect(Collectors.toList());
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

    public List<Cuisines> getCuisines() {
        return cuisines;
    }

    public void setCuisines(String[] cuisines) {
        this.cuisines = stringsToEnums(cuisines);
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
