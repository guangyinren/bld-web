package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@TableName("article")
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 文章id
	 */
	@TableId
	private String articleId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 作者
	 */
	private String userId;
	/**
	 * 封面图
	 */
	private String img;
	/**
	 * 关键字
	 */
	private String keywords;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 是否允许评论(0:不允许,1:允许)
	 */
	private Integer isAllowcomment;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 阅读数量
	 */
	private Integer readNum;
	/**
	 * 置顶等级
	 */
	private Integer top;
	/**
	 * 投稿数
	 */
	private Integer articleNum;
	/**
	 * 浏览数
	 */
	private Integer browseNum;
	/**
	 * 排序
	 */
	private Integer sortno;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 设置
	 */
	private String config;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 修改人
	 */
	private String modifier;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 最后修改日期
	 */
	private Date modifyTime;
	/**
	 * 
	 */
	private String prop1;
	/**
	 * 
	 */
	private String prop2;
	/**
	 * 
	 */
	private String prop3;
	/**
	 * 
	 */
	private String prop4;
	/**
	 * 
	 */
	private String prop5;
	/**
	 * 
	 */
	private String prop6;

	/**
	 * 设置：文章id
	 */
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	/**
	 * 获取：文章id
	 */
	public String getArticleId() {
		return articleId;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：文章标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：文章标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：作者
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：作者
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：封面图
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：封面图
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：关键字
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * 获取：关键字
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * 设置：简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：简介
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：是否允许评论(0:不允许,1:允许)
	 */
	public void setIsAllowcomment(Integer isAllowcomment) {
		this.isAllowcomment = isAllowcomment;
	}
	/**
	 * 获取：是否允许评论(0:不允许,1:允许)
	 */
	public Integer getIsAllowcomment() {
		return isAllowcomment;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：阅读数量
	 */
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
	/**
	 * 获取：阅读数量
	 */
	public Integer getReadNum() {
		return readNum;
	}
	/**
	 * 设置：置顶等级
	 */
	public void setTop(Integer top) {
		this.top = top;
	}
	/**
	 * 获取：置顶等级
	 */
	public Integer getTop() {
		return top;
	}
	/**
	 * 设置：投稿数
	 */
	public void setArticleNum(Integer articleNum) {
		this.articleNum = articleNum;
	}
	/**
	 * 获取：投稿数
	 */
	public Integer getArticleNum() {
		return articleNum;
	}
	/**
	 * 设置：浏览数
	 */
	public void setBrowseNum(Integer browseNum) {
		this.browseNum = browseNum;
	}
	/**
	 * 获取：浏览数
	 */
	public Integer getBrowseNum() {
		return browseNum;
	}
	/**
	 * 设置：排序
	 */
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSortno() {
		return sortno;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * 设置：设置
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	/**
	 * 获取：设置
	 */
	public String getConfig() {
		return config;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifier() {
		return modifier;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最后修改日期
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：最后修改日期
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：
	 */
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	/**
	 * 获取：
	 */
	public String getProp1() {
		return prop1;
	}
	/**
	 * 设置：
	 */
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
	/**
	 * 获取：
	 */
	public String getProp2() {
		return prop2;
	}
	/**
	 * 设置：
	 */
	public void setProp3(String prop3) {
		this.prop3 = prop3;
	}
	/**
	 * 获取：
	 */
	public String getProp3() {
		return prop3;
	}
	/**
	 * 设置：
	 */
	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}
	/**
	 * 获取：
	 */
	public String getProp4() {
		return prop4;
	}
	/**
	 * 设置：
	 */
	public void setProp5(String prop5) {
		this.prop5 = prop5;
	}
	/**
	 * 获取：
	 */
	public String getProp5() {
		return prop5;
	}
	/**
	 * 设置：
	 */
	public void setProp6(String prop6) {
		this.prop6 = prop6;
	}
	/**
	 * 获取：
	 */
	public String getProp6() {
		return prop6;
	}
}
