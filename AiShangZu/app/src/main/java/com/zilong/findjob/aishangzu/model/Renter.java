package com.zilong.findjob.aishangzu.model;

/**
 * Created by 子龙 on 2017/2/24.
 */

public class Renter {

    /**
     * code : 200
     * msg : 成功
     * currentTime : 1487908921686
     * obj : {"content":"一个人的生活谈不上幸福，但会快乐，至少平静，也有愉悦。","title":"租客 kimmy","img":"http://img.ishangzu.com/woju/2017/2/28/9/7cdb25c8-8a4d-4440-8b77-55d20337d69a.jpg","projectType":"1"}
     */

    private String code;
    private String msg;
    private long currentTime;
    private ObjBean obj;

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

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * content : 一个人的生活谈不上幸福，但会快乐，至少平静，也有愉悦。
         * title : 租客 kimmy
         * img : http://img.ishangzu.com/woju/2017/2/28/9/7cdb25c8-8a4d-4440-8b77-55d20337d69a.jpg
         * projectType : 1
         */

        private String content;
        private String title;
        private String img;
        private String projectType;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getProjectType() {
            return projectType;
        }

        public void setProjectType(String projectType) {
            this.projectType = projectType;
        }
    }
}
