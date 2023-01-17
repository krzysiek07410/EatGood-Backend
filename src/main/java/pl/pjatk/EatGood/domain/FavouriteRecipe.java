package pl.pjatk.EatGood.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@ApiModel(value = "FavouriteRecipe", description = "A favourite recipe")
@Entity
public class FavouriteRecipe extends GenericRecipe {
    @ApiModelProperty(value = "Set of users that added this recipe to their favorites")
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
