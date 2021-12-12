package com.springboot.blog.springbootblogrestapi.payload;

import java.util.Objects;

import lombok.Data;

@Data
public class PostDTO {
	private Long id;
	private String description;
	private String content;
	private String title;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
	public PostDTO(Long id, String description, String content, String title) {
		super();
		this.id = id;
		this.description = description;
		this.content = content;
		this.title = title;
	}
	public PostDTO() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, description, id, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		return Objects.equals(content, other.content) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "PostDTO [id=" + id + ", description=" + description + ", content=" + content + ", title=" + title + "]";
	}
	
	
}
