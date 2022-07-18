package com.kh.music.model.vo;

public class Music implements Comparable<Music>{

	
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
		return "곡은 [곡 명=" + music + ", 가수=" + singer + "]";
	}
	
	@Override
//	public int compareTo(Object o) {
//		Music other = (Music)o;
//		return this.music.compareTo(other.getMusic());
//	}//이걸 사용하려면 위에 연결된 인터페이스에 <제네릭>을 지우면됨
	
	
	public int compareTo(Music o) {
		return this.music.compareTo(o.getMusic());
	}

	
	
	
}
