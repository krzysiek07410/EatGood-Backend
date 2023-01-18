package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Ingredient", description = "Details of an ingredient")
public class Ingredient {
    @ApiModelProperty(value = "Name of the ingredient.", required = true)
    private String name;
    @ApiModelProperty(value = "Amount of the ingredient.", required = true)
    private int amount;
    @ApiModelProperty(value = "Unit of the ingredient.", required = true)
    private String unit;
}
