package com.soully.doudemo.Api.Hot.UsBox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

@SerializedName("max")
@Expose
private Integer max;
@SerializedName("average")
@Expose
private Double average;
@SerializedName("stars")
@Expose
private String stars;
@SerializedName("min")
@Expose
private Integer min;

public Integer getMax() {
return max;
}

public void setMax(Integer max) {
this.max = max;
}

public Double getAverage() {
return average;
}

public void setAverage(Double average) {
this.average = average;
}

public String getStars() {
return stars;
}

public void setStars(String stars) {
this.stars = stars;
}

public Integer getMin() {
return min;
}

public void setMin(Integer min) {
this.min = min;
}

}
