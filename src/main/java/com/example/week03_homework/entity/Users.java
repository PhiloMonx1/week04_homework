package com.example.week03_homework.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Users {
	@Id// 유저네임으로 FK주고 DB저장 되는 이름도 username로 바꿈
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private UserRoleEnum role;

	@OneToMany(cascade = CascadeType.REFRESH)
	@JsonManagedReference
	private List<Blog> blogList;

	@OneToMany(mappedBy = "users")
	@JsonManagedReference
	private List<Comment> commentList;

	public Users(String username, String password, UserRoleEnum role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public void addBlog(Blog blog){
		this.blogList.add(blog);
	}
	public void removeBlog(Blog blog){
		this.blogList.remove(blog);
	}

	public void addComment(Comment comment){
		this.commentList.add(comment);
	}

	public void removeComment(Comment comment){
		this.commentList.remove(comment);
	}

}
