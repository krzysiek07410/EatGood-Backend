package pl.pjatk.EatGood.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Ingredient", description = "Details of an ingredient")
public class Ingredient {
    @ApiModelProperty(value = "Name of the ingredient.", required = true)
    private String name;
    @ApiModelProperty(value = "Amount of the ingredient.", required = true)
    private float amount;
    @ApiModelProperty(value = "Unit of the ingredient.", required = true)
    private String unit;

    public Ingredient() {
    }

    public Ingredient(String name, float amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
