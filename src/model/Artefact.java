package model;

public class Artefact {
private int id;
private String name;
private String type;
private String material;
private String dynasty;
private String region;
private String description;

public Artefact(
        int id,
        String name,
        String type,
        String material,
        String dynasty,
        String region,
        String description) {

    this.id = id;
    this.name = name;
    this.type = type;
    this.material = material;
    this.dynasty = dynasty;
    this.region = region;
    this.description = description;
}

public int getId() {
    return id;
}

public String getName() {
    return name;
}

public String getType() {
    return type;
}

public String getMaterial() {
    return material;
}

public String getDynasty() {
    return dynasty;
}

public String getRegion() {
    return region;
}

public String getDescription() {
    return description;
}

}
