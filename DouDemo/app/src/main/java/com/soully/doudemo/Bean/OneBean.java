package com.soully.doudemo.Bean;

/**
 * Created by Soully on 2017/3/30.
 */

public class OneBean {
    private String[] list_name ={"热门电影","即将上映","北美票房榜"};
    private String more = "更多";
    private String[] hot = new String[20];
    private String[] recently = new String[20];
    private String[] us = new String[20];
    private String[] hotImage = new String[20];
    private String[] recentlyImage = new String[20];
    private String[] usImage = new String[20];

    public String getUsImage(int id) {
        return usImage[id];
    }

    public void setUsImage(String[] usImage) {
        this.usImage = usImage;
    }

    public String getUs(int id) {
        return us[id];
    }

    public void setUs(String[] us) {
        this.us = us;
    }

    public String getRecentlyImage(int id) {
        return recentlyImage[id];
    }

    public void setRecentlyImage(String[] recentlyImage) {
        this.recentlyImage = recentlyImage;
    }

    public String getRecently(int id) {
        return recently[id];
    }

    public void setRecently(String[] recently) {
        this.recently = recently;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getList_name(int id) {

        return list_name[id];
    }

    public void setList_name(String[] list_name) {
        this.list_name = list_name;
    }

    public String getHotImage(int id) {

        return hotImage[id];
    }

    public void setHotImage(String[] hotImage) {
        this.hotImage = hotImage;
    }

    public String getHot(int id) {

        return hot[id];
    }

    public void setHot(String[] hot) {
        this.hot = hot;
    }
}