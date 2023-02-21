package model.growable;

public enum PlantType {
    CARROT(1, "Carrot", "Carrots", "C"),
    SALAD(2, "Salad", "Salads", "S"),
    TOMATO(3, "Tomato", "Tomatoes", "T"),
    MUSHROOM(4, "Mushroom", "Mushrooms", "M");

    private final int growthInterval;
    private final String singularName;
    private final String pluralName;
    private final String nickName;

    PlantType(final int growthInterval, final String singularName, final String pluralName, final String nickName) {
        this.growthInterval = growthInterval;
        this.singularName = singularName;
        this.pluralName = pluralName;
        this.nickName = nickName;
    }

    public int getGrowthInterval() {
        return this.growthInterval;
    }

    public String getSingularName() {
        return this.singularName;
    }

    public String getPluralName() {
        return this.pluralName;
    }

    public String getNickName() {
        return this.nickName;
    }
}

