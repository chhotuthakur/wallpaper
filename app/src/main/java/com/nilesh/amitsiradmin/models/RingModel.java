package com.nilesh.amitsiradmin.models;

public class RingModel {
    String id,filename,fileurl,desc;

    public RingModel() {
    }

    public RingModel(String id, String filename, String fileurl, String desc) {
        this.id = id;
        this.filename = filename;
        this.fileurl = fileurl;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
