package com.jt.blog;
/**
 * 博客实体类
 * @author Administrator
 *
 */
public class Blog {
	private int id;
	private String title;
	private String content;
	private String createdTime;
	
	public Blog() {
		super();
	}

	public Blog(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public Blog(int id, String title, String content, String createdTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdTime = createdTime;
	}
	
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", createdTime=" + createdTime + "]";
	}
}
