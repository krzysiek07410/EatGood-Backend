package pl.pjatk.EatGood.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FavouriteRecipe extends GenericRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFavRecipe;
    @ManyToMany(mappedBy = "favouriteRecipeList")
    private List<User> userList;

    public FavouriteRecipe(Integer id, String title, String image, String imageType, Integer idFavRecipe, List<User> userList) {
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
}
