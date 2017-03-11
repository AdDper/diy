package com.zilong.findjob.aishangzu.model;

import java.util.List;

/**
 * Created by 子龙 on 2017/2/22.
 */

public class Apart {

    /**
     * code : 200
     * msg : 成功
     * currentTime : 1487764932314
     * obj : [{"createdAt":1487764932327,"updatedAt":1487764932327,"operatorId":null,"operatorUid":null,"id":20,"title":"合租公寓","img":"http://img.ishangzu.com/woju/2016/11/30/16/bad65825-4613-4d99-ab88-49f678c4a105.jpg","pageType":"NATIVE","url":null,"layoutInfoTypeCode":"0061006","layoutInfoId":0,"layoutPoseionCode":"009","sort":5,"valid":1,"isShow":1,"createdUid":null,"updatedUid":0,"areaCode":"310100,320100,330100"},{"createdAt":1487764932327,"updatedAt":1487764932327,"operatorId":null,"operatorUid":null,"id":19,"title":"整租公寓","img":"http://img.ishangzu.com/woju/2016/11/30/16/ad359495-a6a3-4789-8305-8fb566a666e3.jpg","pageType":"NATIVE","url":null,"layoutInfoTypeCode":"0061004","layoutInfoId":0,"layoutPoseionCode":"009","sort":4,"valid":1,"isShow":1,"createdUid":null,"updatedUid":0,"areaCode":"310100,320100,330100"},{"createdAt":1487764932328,"updatedAt":1487764932328,"operatorId":null,"operatorUid":null,"id":18,"title":"品牌公寓","img":"http://img.ishangzu.com/woju/2016/11/30/16/014ff75e-b467-4649-b1e9-77468203ea8d.jpg","pageType":"NATIVE","url":null,"layoutInfoTypeCode":"0061005","layoutInfoId":0,"layoutPoseionCode":"009","sort":3,"valid":1,"isShow":1,"createdUid":null,"updatedUid":0,"areaCode":"310100,320100,330100"},{"createdAt":1487764932328,"updatedAt":1487764932328,"operatorId":null,"operatorUid":null,"id":17,"title":"通勤找房","img":"http://img.ishangzu.com/woju/2016/11/30/16/e5ea358a-8cc3-46af-a3bd-83653158be1e.jpg","pageType":"NATIVE","url":null,"layoutInfoTypeCode":"0071002","layoutInfoId":0,"layoutPoseionCode":"009","sort":2,"valid":1,"isShow":1,"createdUid":null,"updatedUid":0,"areaCode":"310100,320100,330100"},{"createdAt":1487764932328,"updatedAt":1487764932328,"operatorId":null,"operatorUid":null,"id":16,"title":"公司找房","img":"http://img.ishangzu.com/woju/2016/11/30/16/272673a4-8f3b-483f-9a24-6bd2cf625d6a.jpg","pageType":"NATIVE","url":null,"layoutInfoTypeCode":"0071001","layoutInfoId":0,"layoutPoseionCode":"009","sort":1,"valid":1,"isShow":1,"createdUid":null,"updatedUid":0,"areaCode":"310100,320100,330100"}]
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
        /**
         * createdAt : 1487764932327
         * updatedAt : 1487764932327
         * operatorId : null
         * operatorUid : null
         * id : 20
         * title : 合租公寓
         * img : http://img.ishangzu.com/woju/2016/11/30/16/bad65825-4613-4d99-ab88-49f678c4a105.jpg
         * pageType : NATIVE
         * url : null
         * layoutInfoTypeCode : 0061006
         * layoutInfoId : 0
         * layoutPoseionCode : 009
         * sort : 5
         * valid : 1
         * isShow : 1
         * createdUid : null
         * updatedUid : 0
         * areaCode : 310100,320100,330100
         */

        private long createdAt;
        private long updatedAt;
        private Object operatorId;
        private Object operatorUid;
        private int id;
        private String title;
        private String img;
        private String pageType;
        private Object url;
        private String layoutInfoTypeCode;
        private int layoutInfoId;
        private String layoutPoseionCode;
        private int sort;
        private int valid;
        private int isShow;
        private Object createdUid;
        private int updatedUid;
        private String areaCode;

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

        public String getPageType() {
            return pageType;
        }

        public void setPageType(String pageType) {
            this.pageType = pageType;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }

        public String getLayoutInfoTypeCode() {
            return layoutInfoTypeCode;
        }

        public void setLayoutInfoTypeCode(String layoutInfoTypeCode) {
            this.layoutInfoTypeCode = layoutInfoTypeCode;
        }

        public int getLayoutInfoId() {
            return layoutInfoId;
        }

        public void setLayoutInfoId(int layoutInfoId) {
            this.layoutInfoId = layoutInfoId;
        }

        public String getLayoutPoseionCode() {
            return layoutPoseionCode;
        }

        public void setLayoutPoseionCode(String layoutPoseionCode) {
            this.layoutPoseionCode = layoutPoseionCode;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
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

        public int getUpdatedUid() {
            return updatedUid;
        }

        public void setUpdatedUid(int updatedUid) {
            this.updatedUid = updatedUid;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }
    }
}
