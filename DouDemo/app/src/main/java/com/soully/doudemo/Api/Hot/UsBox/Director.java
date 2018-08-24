package com.soully.doudemo.Api.Hot.UsBox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Director {

@SerializedName("alt")
@Expose
private String alt;
@SerializedName("avatars")
@Expose
private Avatars_ avatars;
@SerializedName("name")
@Expose
private String name;
@SerializedName("id")
@Expose
private String id;

public String getAlt() {
return alt;
}

public void setAlt(String alt) {
this.alt = alt;
}

public Avatars_ getAvatars() {
return avatars;
}

public void setAvatars(Avatars_ avatars) {
this.avatars = avatars;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

}