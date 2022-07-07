package com.kh.music.model.vo;

public class Music {
	
	private String music;
	private String singer;
	
	
	
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "°îÀº [°î ¸í=" + music + ", °¡¼ö=" + singer + "]";
	}

	public int compareTo() {
		// TODO Auto-generated method stub
		return this.getMusic().compareTo(getMusic());

	}
	
	
}
