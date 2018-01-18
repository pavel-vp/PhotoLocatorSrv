package com.mobileme.inhouse.serv.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 31.08.2015.
 */
public class HSFullArticleInfo implements Serializable {
    private HSArticleInfo articleInfo;
    private List<HSComment> commentList;

    public HSArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(HSArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

    public List<HSComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<HSComment> commentList) {
        this.commentList = commentList;
    }
}
