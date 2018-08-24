package com.soully.doudemo.Api.Hot.UsBox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {

@SerializedName("box")
@Expose
private Integer box;
@SerializedName("new")
@Expose
private Boolean _new;
@SerializedName("rank")
@Expose
private Integer rank;
@SerializedName("subject")
@Expose
private Subject_ subject;

public Integer getBox() {
return box;
}

public void setBox(Integer box) {
this.box = box;
}

public Boolean getNew() {
return _new;
}

public void setNew(Boolean _new) {
this._new = _new;
}

public Integer getRank() {
return rank;
}

public void setRank(Integer rank) {
this.rank = rank;
}

public Subject_ getSubject() {
return subject;
}

public void setSubject(Subject_ subject) {
this.subject = subject;
}

}