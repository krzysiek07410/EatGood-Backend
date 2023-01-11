package pl.pjatk.EatGood.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class FavouriteRecipe extends GenericRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFavRecipe;
    @ManyToMany(mappedBy = "favouriteRecipeList")
    private Set<User> userList;

    public FavouriteRecipe(Integer id, String title, String image, String imageType, Integer idFavRecipe,
                           Set<User> userList) {
        super(id, title, image, imageType);
        this.idFavRecipe = idFavRecipe;
        this.userList = userList;
    }

    public FavouriteRecipe() {
    }

    public Integer getIdFavRecipe() {
        return idFavRecipe;
    }

    public void setIdFavRecipe(Integer idFavRecipe) {
        this.idFavRecipe = idFavRecipe;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

}
