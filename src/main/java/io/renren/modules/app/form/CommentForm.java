package io.renren.modules.app.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 评论表单
 * @author LHC
 * 2018年7月1日
 */
public class CommentForm {
	/**
	 * 回复评论id
	 */
    private String replyId;

    /**
     * 来源类型 0:动态 1:论坛
     */
    private String sourceType;
    
    /**
     * 来源id
     */
    @NotBlank(message="动态id不能为空")
    private String sourceId;

    /**
     * 评论内容
     */
    @NotBlank(message="评论内容不能为空")
    private String content;
    
    /**
     * 用户id
     */
    @NotBlank(message="发表评论用户id不能为空")
    private String userId;
    
    /**
     * 图片资源
     */
    private String resources;

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}
	
}
