package com.zilong.findjob.aishangzu.model;

import java.util.List;

/**
 * Created by 子龙 on 2017/2/27.
 */

public class Shequ_Read {

    /**
     * code : 200
     * msg : 成功
     * currentTime : 1488097307467
     * obj : [{"createdAt":1481798763000,"updatedAt":1484676891000,"operatorId":null,"operatorUid":null,"id":360,"title":"揭秘 | 2016年爱上租20000名青年租房生活研究报告","viceTitle":"你有趣吗？来看看~","content":null,"tag":null,"mainImg":"http://img.ishangzu.com/woju/2016/12/31/10/5e20d198-53ea-4e1a-9f10-d928629939ca.jpg","deleted":0,"viewCount":3465,"authorId":null,"authorName":"15088643961","type":1,"thumbupCount":0,"commentCount":3,"isSync":0,"channel":5,"twocodePic":null,"platform":"1","platformName":null,"classify":1,"areaCode":null,"time":null,"url":null,"homeRecommended":null,"totalCount":110,"isTop":1,"readPeopleCount":null,"sharePeopleCount":null,"commentPeopleCount":null,"shareCount":null,"createdTime":"2016-12-15 18:46:03","channelName":"未知频道","channelNameCode":"unknown","classifyName":"有趣青年","updatedTime":"2017-01-18 02:14:51"},{"createdAt":1487901655000,"updatedAt":1487912020000,"operatorId":null,"operatorUid":null,"id":395,"title":"有趣青年|今天有个租客闯进了爱上租\u2026\u2026","viceTitle":"","content":null,"tag":null,"mainImg":"http://img.ishangzu.com/woju/2017/2/28/9/52c8e9bd-e2a6-4d33-b0fe-e6133da6b9b6.jpg","deleted":0,"viewCount":723,"authorId":null,"authorName":"15088643961","type":1,"thumbupCount":0,"commentCount":0,"isSync":0,"channel":5,"twocodePic":null,"platform":"1,2","platformName":null,"classify":1,"areaCode":null,"time":null,"url":null,"homeRecommended":null,"totalCount":110,"isTop":0,"readPeopleCount":null,"sharePeopleCount":null,"commentPeopleCount":null,"shareCount":null,"createdTime":"2017-02-24 10:00:55","channelName":"未知频道","channelNameCode":"unknown","classifyName":"有趣青年","updatedTime":"2017-02-24 12:53:40"},{"createdAt":1487064226000,"updatedAt":1487144792000,"operatorId":null,"operatorUid":null,"id":394,"title":"认真去做的，才叫爱","viceTitle":"","content":null,"tag":null,"mainImg":"http://img.ishangzu.com/woju/2017/2/28/17/7da5691b-99f4-451c-99a9-585a91281eda.jpg","deleted":0,"viewCount":385,"authorId":null,"authorName":"15268117032","type":1,"thumbupCount":0,"commentCount":0,"isSync":0,"channel":5,"twocodePic":null,"platform":"1,2","platformName":null,"classify":6,"areaCode":null,"time":null,"url":null,"homeRecommended":null,"totalCount":110,"isTop":0,"readPeopleCount":null,"sharePeopleCount":null,"commentPeopleCount":null,"shareCount":null,"createdTime":"2017-02-14 17:23:46","channelName":"未知频道","channelNameCode":"unknown","classifyName":"官方活动","updatedTime":"2017-02-15 15:46:32"},{"createdAt":1487052050000,"updatedAt":1487052345000,"operatorId":null,"operatorUid":null,"id":392,"title":"杭州人才净流入量全国第一，爱上租为你们的梦想安个家。","viceTitle":"","content":null,"tag":null,"mainImg":"http://img.ishangzu.com/woju/2017/2/28/14/1b3cb280-c589-4d86-a354-2cdc7a5043b4.jpg","deleted":0,"viewCount":49,"authorId":null,"authorName":"15088643961","type":1,"thumbupCount":0,"commentCount":0,"isSync":0,"channel":5,"twocodePic":null,"platform":"1","platformName":null,"classify":4,"areaCode":null,"time":null,"url":null,"homeRecommended":null,"totalCount":110,"isTop":0,"readPeopleCount":null,"sharePeopleCount":null,"commentPeopleCount":null,"shareCount":null,"createdTime":"2017-02-14 14:00:50","channelName":"未知频道","channelNameCode":"unknown","classifyName":"媒体报道","updatedTime":"2017-02-14 14:05:45"},{"createdAt":1487051633000,"updatedAt":1487051748000,"operatorId":null,"operatorUid":null,"id":390,"title":"深度服务行业信息化，马云为爱上租授牌","viceTitle":"","content":null,"tag":null,"mainImg":"http://img.ishangzu.com/woju/2017/2/28/13/41eca59b-6b1d-4367-9d14-24d05bbf08c5.jpg","deleted":0,"viewCount":51,"authorId":null,"authorName":"15088643961","type":1,"thumbupCount":0,"commentCount":0,"isSync":0,"channel":5,"twocodePic":null,"platform":"1","platformName":null,"classify":4,"areaCode":null,"time":null,"url":null,"homeRecommended":null,"totalCount":110,"isTop":0,"readPeopleCount":null,"sharePeopleCount":null,"commentPeopleCount":null,"shareCount":null,"createdTime":"2017-02-14 13:53:53","channelName":"未知频道","channelNameCode":"unknown","classifyName":"媒体报道","updatedTime":"2017-02-14 13:55:48"},{"createdAt":1486719947000,"updatedAt":1486719947000,"operatorId":null,"operatorUid":null,"id":387,"title":"欢迎回家过元宵","viceTitle":"","content":null,"tag":null,"mainImg":"http://img.ishangzu.com/woju/2017/2/28/17/ce31da36-f0ec-44f6-8b42-871366b3e61d.jpg","deleted":0,"viewCount":179,"authorId":null,"authorName":"15268117032","type":1,"thumbupCount":0,"commentCount":0,"isSync":0,"channel":5,"twocodePic":null,"platform":"1","platformName":null,"classify":1,"areaCode":null,"time":null,"url":null,"homeRecommended":null,"totalCount":110,"isTop":0,"readPeopleCount":null,"sharePeopleCount":null,"commentPeopleCount":null,"shareCount":null,"createdTime":"2017-02-10 17:45:47","channelName":"未知频道","channelNameCode":"unknown","classifyName":"有趣青年","updatedTime":"2017-02-10 17:45:47"}]
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
         * createdAt : 1481798763000
         * updatedAt : 1484676891000
         * operatorId : null
         * operatorUid : null
         * id : 360
         * title : 揭秘 | 2016年爱上租20000名青年租房生活研究报告
         * viceTitle : 你有趣吗？来看看~
         * content : null
         * tag : null
         * mainImg : http://img.ishangzu.com/woju/2016/12/31/10/5e20d198-53ea-4e1a-9f10-d928629939ca.jpg
         * deleted : 0
         * viewCount : 3465
         * authorId : null
         * authorName : 15088643961
         * type : 1
         * thumbupCount : 0
         * commentCount : 3
         * isSync : 0
         * channel : 5
         * twocodePic : null
         * platform : 1
         * platformName : null
         * classify : 1
         * areaCode : null
         * time : null
         * url : null
         * homeRecommended : null
         * totalCount : 110
         * isTop : 1
         * readPeopleCount : null
         * sharePeopleCount : null
         * commentPeopleCount : null
         * shareCount : null
         * createdTime : 2016-12-15 18:46:03
         * channelName : 未知频道
         * channelNameCode : unknown
         * classifyName : 有趣青年
         * updatedTime : 2017-01-18 02:14:51
         */

        private long createdAt;
        private long updatedAt;
        private Object operatorId;
        private Object operatorUid;
        private int id;
        private String title;
        private String viceTitle;
        private Object content;
        private Object tag;
        private String mainImg;
        private int deleted;
        private int viewCount;
        private Object authorId;
        private String authorName;
        private int type;
        private int thumbupCount;
        private int commentCount;
        private int isSync;
        private int channel;
        private Object twocodePic;
        private String platform;
        private Object platformName;
        private int classify;
        private Object areaCode;
        private Object time;
        private Object url;
        private Object homeRecommended;
        private int totalCount;
        private int isTop;
        private Object readPeopleCount;
        private Object sharePeopleCount;
        private Object commentPeopleCount;
        private Object shareCount;
        private String createdTime;
        private String channelName;
        private String channelNameCode;
        private String classifyName;
        private String updatedTime;

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

        public String getViceTitle() {
            return viceTitle;
        }

        public void setViceTitle(String viceTitle) {
            this.viceTitle = viceTitle;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Object getTag() {
            return tag;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public String getMainImg() {
            return mainImg;
        }

        public void setMainImg(String mainImg) {
            this.mainImg = mainImg;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public Object getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Object authorId) {
            this.authorId = authorId;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getThumbupCount() {
            return thumbupCount;
        }

        public void setThumbupCount(int thumbupCount) {
            this.thumbupCount = thumbupCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getIsSync() {
            return isSync;
        }

        public void setIsSync(int isSync) {
            this.isSync = isSync;
        }

        public int getChannel() {
            return channel;
        }

        public void setChannel(int channel) {
            this.channel = channel;
        }

        public Object getTwocodePic() {
            return twocodePic;
        }

        public void setTwocodePic(Object twocodePic) {
            this.twocodePic = twocodePic;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public Object getPlatformName() {
            return platformName;
        }

        public void setPlatformName(Object platformName) {
            this.platformName = platformName;
        }

        public int getClassify() {
            return classify;
        }

        public void setClassify(int classify) {
            this.classify = classify;
        }

        public Object getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(Object areaCode) {
            this.areaCode = areaCode;
        }

        public Object getTime() {
            return time;
        }

        public void setTime(Object time) {
            this.time = time;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }

        public Object getHomeRecommended() {
            return homeRecommended;
        }

        public void setHomeRecommended(Object homeRecommended) {
            this.homeRecommended = homeRecommended;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getIsTop() {
            return isTop;
        }

        public void setIsTop(int isTop) {
            this.isTop = isTop;
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

        public Object getCommentPeopleCount() {
            return commentPeopleCount;
        }

        public void setCommentPeopleCount(Object commentPeopleCount) {
            this.commentPeopleCount = commentPeopleCount;
        }

        public Object getShareCount() {
            return shareCount;
        }

        public void setShareCount(Object shareCount) {
            this.shareCount = shareCount;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getChannelNameCode() {
            return channelNameCode;
        }

        public void setChannelNameCode(String channelNameCode) {
            this.channelNameCode = channelNameCode;
        }

        public String getClassifyName() {
            return classifyName;
        }

        public void setClassifyName(String classifyName) {
            this.classifyName = classifyName;
        }

        public String getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
        }
    }
}
