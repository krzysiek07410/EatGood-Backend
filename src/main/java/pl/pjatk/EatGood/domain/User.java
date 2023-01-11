package pl.pjatk.EatGood.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    @ManyToMany
    @JoinTable(
            name = "u_f",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "favourite_recipe_id"))
    Set<FavouriteRecipe> favouriteRecipeList;

    public User(Integer id, String username, Set<FavouriteRecipe> favouriteRecipeList) {
        this.id = id;
        this.username = username;
        this.favouriteRecipeList = favouriteRecipeList;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<FavouriteRecipe> getFavouriteRecipeList() {
        return favouriteRecipeList;
    }

    public void setFavouriteRecipeList(Set<FavouriteRecipe> favouriteRecipeList) {
        this.favouriteRecipeList = favouriteRecipeList;
    }
}
