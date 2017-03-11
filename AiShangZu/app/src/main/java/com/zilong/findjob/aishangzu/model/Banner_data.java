package com.zilong.findjob.aishangzu.model;

import java.util.List;

/**
 * Created by 子龙 on 2017/2/22.
 */

public class Banner_data {

    /**
     * code : 200
     * msg : 成功
     * currentTime : 1487729574731
     * obj : [{"createdAt":1487729574749,"updatedAt":1487729574749,"operatorId":null,"operatorUid":null,"id":144,"title":"2017，好想和你一起住","img":"http://img.ishangzu.com/woju/2017/2/28/15/21df6ef0-a1f9-4776-8dbc-dcd851dbf515.jpg","areaCode":"330100","pageType":"H5","url":"http://www.ishangzu.com/huodong?iform=sitebaner","recommendInfoTypeCode":"00310003","recommendInfoId":0,"recommendPositionCode":"003","sort":0,"startTime":1486483200000,"endTime":1484150400000,"valid":1,"isShow":1,"createdUid":null,"updatedUid":null,"readCount":null,"shareCount":null,"readPeopleCount":null,"sharePeopleCount":null},{"createdAt":1487729574749,"updatedAt":1487729574749,"operatorId":null,"operatorUid":null,"id":100,"title":"0元租房  快带TA来入住吧！","img":"http://img.ishangzu.com/woju/2017/2/28/18/450e21d8-514a-4e57-8d5e-c0ddadce2bd6.jpg","areaCode":"310100,320100,320500,330100","pageType":"H5","url":"http://m.ishangzu.com/hz/app/article/379","recommendInfoTypeCode":"00310003","recommendInfoId":0,"recommendPositionCode":"003","sort":0,"startTime":1487260800000,"endTime":1478188800000,"valid":1,"isShow":1,"createdUid":null,"updatedUid":null,"readCount":null,"shareCount":null,"readPeopleCount":null,"sharePeopleCount":null},{"createdAt":1487729574749,"updatedAt":1487729574749,"operatorId":null,"operatorUid":null,"id":142,"title":"业主入住2","img":"http://img.ishangzu.com/woju/2017/2/28/17/04394655-85db-45aa-bce5-65d39704b01c.jpg","areaCode":"310100,320100,320500,330100","pageType":"H5","url":"http://m.ishangzu.com/hz/app/article/377","recommendInfoTypeCode":"00310003","recommendInfoId":0,"recommendPositionCode":"003","sort":0,"startTime":1486310400000,"endTime":1484150400000,"valid":1,"isShow":1,"createdUid":null,"updatedUid":null,"readCount":null,"shareCount":null,"readPeopleCount":null,"sharePeopleCount":null},{"createdAt":1487729574749,"updatedAt":1487729574749,"operatorId":null,"operatorUid":null,"id":126,"title":"老带新活动","img":"http://img.ishangzu.com/woju/2017/2/28/10/8fbb4f8a-a1de-46c7-9f1d-5decf327aa52.jpg","areaCode":"330100","pageType":"H5","url":"https://jinshuju.net/f/NYxVpF","recommendInfoTypeCode":"00310003","recommendInfoId":0,"recommendPositionCode":"003","sort":0,"startTime":1486569600000,"endTime":1482336000000,"valid":1,"isShow":1,"createdUid":null,"updatedUid":null,"readCount":null,"shareCount":null,"readPeopleCount":null,"sharePeopleCount":null}]
     */

    private String code;
    private String msg;
    private long currentTime;
    private List<ObjBean> obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {

        public ObjBean() {

        }

        /**
         * createdAt : 1487729574749
         * updatedAt : 1487729574749
         * operatorId : null
         * operatorUid : null
         * id : 144
         * title : 2017，好想和你一起住
         * img : http://img.ishangzu.com/woju/2017/2/28/15/21df6ef0-a1f9-4776-8dbc-dcd851dbf515.jpg
         * areaCode : 330100
         * pageType : H5
         * url : http://www.ishangzu.com/huodong?iform=sitebaner
         * recommendInfoTypeCode : 00310003
         * recommendInfoId : 0
         * recommendPositionCode : 003
         * sort : 0
         * startTime : 1486483200000
         * endTime : 1484150400000
         * valid : 1
         * isShow : 1
         * createdUid : null
         * updatedUid : null
         * readCount : null
         * shareCount : null
         * readPeopleCount : null
         * sharePeopleCount : null
         */

        private long createdAt;
        private long updatedAt;
        private Object operatorId;
        private Object operatorUid;
        private int id;
        private String title;
        private String img;
        private String areaCode;
        private String pageType;
        private String url;
        private String recommendInfoTypeCode;
        private int recommendInfoId;
        private String recommendPositionCode;
        private int sort;
        private long startTime;
        private long endTime;
        private int valid;
        private int isShow;
        private Object createdUid;
        private Object updatedUid;
        private Object readCount;
        private Object shareCount;
        private Object readPeopleCount;
        private Object sharePeopleCount;

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }

        public long getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(long updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getOperatorId() {
            return operatorId;
        }

        public void setOperatorId(Object operatorId) {
            this.operatorId = operatorId;
        }

        public Object getOperatorUid() {
            return operatorUid;
        }

        public void setOperatorUid(Object operatorUid) {
            this.operatorUid = operatorUid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getPageType() {
            return pageType;
        }

        public void setPageType(String pageType) {
            this.pageType = pageType;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRecommendInfoTypeCode() {
            return recommendInfoTypeCode;
        }

        public void setRecommendInfoTypeCode(String recommendInfoTypeCode) {
            this.recommendInfoTypeCode = recommendInfoTypeCode;
        }

        public int getRecommendInfoId() {
            return recommendInfoId;
        }

        public void setRecommendInfoId(int recommendInfoId) {
            this.recommendInfoId = recommendInfoId;
        }

        public String getRecommendPositionCode() {
            return recommendPositionCode;
        }

        public void setRecommendPositionCode(String recommendPositionCode) {
            this.recommendPositionCode = recommendPositionCode;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public int getValid() {
            return valid;
        }

        public void setValid(int valid) {
            this.valid = valid;
        }

        public int getIsShow() {
            return isShow;
        }

        public void setIsShow(int isShow) {
            this.isShow = isShow;
        }

        public Object getCreatedUid() {
            return createdUid;
        }

        public void setCreatedUid(Object createdUid) {
            this.createdUid = createdUid;
        }

        public Object getUpdatedUid() {
            return updatedUid;
        }

        public void setUpdatedUid(Object updatedUid) {
            this.updatedUid = updatedUid;
        }

        public Object getReadCount() {
            return readCount;
        }

        public void setReadCount(Object readCount) {
            this.readCount = readCount;
        }

        public Object getShareCount() {
            return shareCount;
        }

        public void setShareCount(Object shareCount) {
            this.shareCount = shareCount;
        }

        public Object getReadPeopleCount() {
            return readPeopleCount;
        }

        public void setReadPeopleCount(Object readPeopleCount) {
            this.readPeopleCount = readPeopleCount;
        }

        public Object getSharePeopleCount() {
            return sharePeopleCount;
        }

        public void setSharePeopleCount(Object sharePeopleCount) {
            this.sharePeopleCount = sharePeopleCount;
        }
    }
}
