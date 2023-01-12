package pl.pjatk.EatGood.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class FavouriteRecipe extends GenericRecipe {
    @ManyToMany(mappedBy = "favouriteRecipeSet")
    @JsonBackReference
    private Set<User> userSet;

    public FavouriteRecipe(Integer id, String title, String image, String imageType, Set<User> userSet) {
        super(id, title, image, imageType);
        this.userSet = userSet;
    }

    public FavouriteRecipe() {
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userList) {
        this.userSet = userList;
    }

}
