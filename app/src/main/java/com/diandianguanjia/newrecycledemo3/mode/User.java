package com.diandianguanjia.newrecycledemo3.mode;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by an on 2017/8/17.
 */

public class User {
    public User(String hotel_id, String hotel_name) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    /**
     * hotel_id : 45
     * hotel_name : 九江风之旅人家庭房
     * available_start_date : 0
     * available_end_date : 0
     * click_count : 0
     * market_price : 178.00
     * hotel_price : 168.00
     * is_promote : 0
     * promote_price : 0.00
     * promote_start_date : 0
     * promote_end_date : 0
     * keywords :
     * hotel_brief :
     * hotel_desc :
     * hotel_img : /DDHK/Upload/img/hotel/2017-06-24/594dbcd1b30d7.jpg
     * hotel_gallery : ["http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-24/594dbcdd5fc81.jpg","http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-24/594dbce7dd28e.jpg","http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-24/594dbcf2f0159.jpg"]
     * add_time : 1498266159
     * sort_order : 100
     * f_id : 0
     * province : 江西省
     * city : 九江市
     * district : 庐山区
     * address : 长虹大道156号裕泰园
     * lng : 0.000000
     * lat : 0.000000
     * if_vacant : 1
     * distance : 666.6KM
     * attr : [{"attr_id":"6","attr_name":"1","attr_icon":"http://weixin.dd1760.com","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"1","is_show":"1"},{"attr_id":"17","attr_name":"单间出租","attr_icon":"http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-30/2.png","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"2","is_show":"1"},{"attr_id":"19","attr_name":"1室","attr_icon":"http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-30/3.png","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"3","is_show":"1"},{"attr_id":"23","attr_name":"确认快","attr_icon":"http://weixin.dd1760.com","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"4","is_show":"1"},{"attr_id":"26","attr_name":"无线网络","attr_icon":"http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-30/5.png","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"5","is_show":"1"},{"attr_id":"27","attr_name":"空调","attr_icon":"http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-30/6.png","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"5","is_show":"1"},{"attr_id":"28","attr_name":"吹风机","attr_icon":"http://weixin.dd1760.com/DDHK/Upload/img/hotel/2017-06-30/7.png","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"5","is_show":"1"},{"attr_id":"29","attr_name":"电视","attr_icon":"http://weixin.dd1760.com","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"5","is_show":"1"},{"attr_id":"30","attr_name":"停车位","attr_icon":"http://weixin.dd1760.com","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"5","is_show":"1"},{"attr_id":"31","attr_name":"冰箱","attr_icon":"http://weixin.dd1760.com","attr_type":"1","attr_values":"","sort_order":"0","attr_parent_id":"5","is_show":"1"}]
     */

    private String hotel_id;
    private String hotel_name;
    private String available_start_date;
    private String available_end_date;
    private String click_count;
    private String market_price;
    private String hotel_price;
    private String is_promote;
    private String promote_price;
    private String promote_start_date;
    private String promote_end_date;
    private String keywords;
    private String hotel_brief;
    private String hotel_desc;
    private String hotel_img;
    private String add_time;
    private String sort_order;
    private String f_id;
    private String province;
    private String city;
    private String district;
    private String address;
    private String lng;
    private String lat;
    private String if_vacant;
    private String distance;
    private List<String> hotel_gallery;
    private List<AttrBean> attr;

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getAvailable_start_date() {
        return available_start_date;
    }

    public void setAvailable_start_date(String available_start_date) {
        this.available_start_date = available_start_date;
    }

    public String getAvailable_end_date() {
        return available_end_date;
    }

    public void setAvailable_end_date(String available_end_date) {
        this.available_end_date = available_end_date;
    }

    public String getClick_count() {
        return click_count;
    }

    public void setClick_count(String click_count) {
        this.click_count = click_count;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getHotel_price() {
        return hotel_price;
    }

    public void setHotel_price(String hotel_price) {
        this.hotel_price = hotel_price;
    }

    public String getIs_promote() {
        return is_promote;
    }

    public void setIs_promote(String is_promote) {
        this.is_promote = is_promote;
    }

    public String getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(String promote_price) {
        this.promote_price = promote_price;
    }

    public String getPromote_start_date() {
        return promote_start_date;
    }

    public void setPromote_start_date(String promote_start_date) {
        this.promote_start_date = promote_start_date;
    }

    public String getPromote_end_date() {
        return promote_end_date;
    }

    public void setPromote_end_date(String promote_end_date) {
        this.promote_end_date = promote_end_date;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getHotel_brief() {
        return hotel_brief;
    }

    public void setHotel_brief(String hotel_brief) {
        this.hotel_brief = hotel_brief;
    }

    public String getHotel_desc() {
        return hotel_desc;
    }

    public void setHotel_desc(String hotel_desc) {
        this.hotel_desc = hotel_desc;
    }

    public String getHotel_img() {
        return hotel_img;
    }

    public void setHotel_img(String hotel_img) {
        this.hotel_img = hotel_img;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getSort_order() {
        return sort_order;
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getIf_vacant() {
        return if_vacant;
    }

    public void setIf_vacant(String if_vacant) {
        this.if_vacant = if_vacant;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public List<String> getHotel_gallery() {
        return hotel_gallery;
    }

    public void setHotel_gallery(List<String> hotel_gallery) {
        this.hotel_gallery = hotel_gallery;
    }

    public List<AttrBean> getAttr() {
        return attr;
    }

    public void setAttr(List<AttrBean> attr) {
        this.attr = attr;
    }

    public static class AttrBean {
        /**
         * attr_id : 6
         * attr_name : 1
         * attr_icon : http://weixin.dd1760.com
         * attr_type : 1
         * attr_values :
         * sort_order : 0
         * attr_parent_id : 1
         * is_show : 1
         */

        private String attr_id;
        private String attr_name;
        private String attr_icon;
        private String attr_type;
        private String attr_values;
        private String sort_order;
        private String attr_parent_id;
        private String is_show;

        public String getAttr_id() {
            return attr_id;
        }

        public void setAttr_id(String attr_id) {
            this.attr_id = attr_id;
        }

        public String getAttr_name() {
            return attr_name;
        }

        public void setAttr_name(String attr_name) {
            this.attr_name = attr_name;
        }

        public String getAttr_icon() {
            return attr_icon;
        }

        public void setAttr_icon(String attr_icon) {
            this.attr_icon = attr_icon;
        }

        public String getAttr_type() {
            return attr_type;
        }

        public void setAttr_type(String attr_type) {
            this.attr_type = attr_type;
        }

        public String getAttr_values() {
            return attr_values;
        }

        public void setAttr_values(String attr_values) {
            this.attr_values = attr_values;
        }

        public String getSort_order() {
            return sort_order;
        }

        public void setSort_order(String sort_order) {
            this.sort_order = sort_order;
        }

        public String getAttr_parent_id() {
            return attr_parent_id;
        }

        public void setAttr_parent_id(String attr_parent_id) {
            this.attr_parent_id = attr_parent_id;
        }

        public String getIs_show() {
            return is_show;
        }

        public void setIs_show(String is_show) {
            this.is_show = is_show;
        }
    }
}
