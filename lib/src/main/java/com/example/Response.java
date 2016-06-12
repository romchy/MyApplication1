package com.example;

import java.util.List;

/**
 * Created by Roman on 27.5.2016.
 */
public class Response {

    /**
     * id : 9
     * name : my_house
     * description : Netduino Plus connected to sensors around the house
     * latitude : 40.44
     * longitude : -79.9965
     * field1 : Light
     * field2 : Outside Temperature
     * created_at : 2010-12-14T01:20:06Z
     * updated_at : 2016-05-27T18:12:09Z
     * last_entry_id : 10201515
     */

    private ChannelBean channel;
    /**
     * created_at : 2016-05-27T17:47:23Z
     * entry_id : 10201416
     * field1 : 480
     * field2 : 73.29087048832271
     */

    private List<FeedsBean> feeds;

    public ChannelBean getChannel() {
        return channel;
    }

    public void setChannel(ChannelBean channel) {
        this.channel = channel;
    }

    public List<FeedsBean> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedsBean> feeds) {
        this.feeds = feeds;
    }

    public static class ChannelBean {
        private int id;
        private String name;
        private String description;
        private String latitude;
        private String longitude;
        private String field1;
        private String field2;
        private String created_at;
        private String updated_at;
        private int last_entry_id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getLast_entry_id() {
            return last_entry_id;
        }

        public void setLast_entry_id(int last_entry_id) {
            this.last_entry_id = last_entry_id;
        }
    }

    public static class FeedsBean {
        private String created_at;
        private int entry_id;
        private String field1;
        private String field2;

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getEntry_id() {
            return entry_id;
        }

        public void setEntry_id(int entry_id) {
            this.entry_id = entry_id;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }
    }
}
