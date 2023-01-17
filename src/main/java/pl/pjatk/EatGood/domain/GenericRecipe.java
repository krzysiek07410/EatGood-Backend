package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@ApiModel(value = "GenericRecipe", description = "A generic model of recipe")
@MappedSuperclass
public class GenericRecipe {
    @ApiModelProperty(value = "Unique identifier of the recipe", required = true)
    @Id
    private Integer id;
    @ApiModelProperty(value = "Title of the recipe", required = true)
    private String title;
    @ApiModelProperty(value = "Image of the recipe", required = true)
    private String image;
    @ApiModelProperty(value = "Image type of the recipe", required = true)
    @Transient
    private String imageType;

    public GenericRecipe(Integer id, String title, String image, String imageType) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
    }

    public GenericRecipe() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public String toString() {
        return "GenericRecipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", imageType='" + imageType + '\'' +
                '}';
    }
}
