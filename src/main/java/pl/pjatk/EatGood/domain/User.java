package pl.pjatk.EatGood.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private Integer id;
    private String username;
    @Transient
    private String password;
    @ManyToMany
    @JoinTable(
            name = "u_f",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "favourite_recipe_id"))
    Set<FavouriteRecipe> favouriteRecipeSet;

    public User(Integer id, String username, Set<FavouriteRecipe> favouriteRecipeSet) {
        this.id = id;
        this.username = username;
        this.favouriteRecipeSet = favouriteRecipeSet;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
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

    public Set<FavouriteRecipe> getFavouriteRecipeSet() {
        return favouriteRecipeSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavouriteRecipeSet(Set<FavouriteRecipe> favouriteRecipeList) {
        this.favouriteRecipeSet = favouriteRecipeList;
    }
}
