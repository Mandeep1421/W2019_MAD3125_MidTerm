package com.midtermmad3125.Models;

public class WheatherInformation
{
    private String cityId;
    private String main;
    private String description;
    private String icon;

    public void Weather (String id, String main, String description, String icon)
    {
        this.cityId = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
    public String getId() {
        return cityId;
    }

    public void setId(String id) {
        this.cityId = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

