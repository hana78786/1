package com.kh.borad;

import java.util.List;

public class Board implements OpenCloseable{
private String title;
private String contents;
private List<Comment> comments;
private Ranking rank;

public Board() {
	rank = new Ranking();
}

public void setTitle(String title) {
	this.title = title;
}

public String getTitle() {
	return title;
}

public void setContents(String contents) {
	this.contents=contents;
}
public void addComment(Comment comment) {
	comments.add(comment);
}
public String getContents() {
	return contents;
}
public List<Comment> getComments(){
	return comments;
}

@Override
public void open() {
	// TODO Auto-generated method stub
	
}

@Override
public void close() {
	// TODO Auto-generated method stub
	
}

public String getTitleWithRanking(Ranking ranking) {
	return "";
}

}