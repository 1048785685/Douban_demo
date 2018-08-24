package com.soully.doudemo.Api.Hot.UsBox;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UxBox {

@SerializedName("date")
@Expose
private String date;
@SerializedName("subjects")
@Expose
private List<Subject> subjects = null;
@SerializedName("title")
@Expose
private String title;

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public List<Subject> getSubjects() {
return subjects;
}

public void setSubjects(List<Subject> subjects) {
this.subjects = subjects;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

}
