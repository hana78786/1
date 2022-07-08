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
		return "���� [�� ��=" + music + ", ����=" + singer + "]";
	}
	
	@Override
//	public int compareTo(Object o) {
//		Music other = (Music)o;
//		return this.music.compareTo(other.getMusic());
//	}//�̰� ����Ϸ��� ���� ����� �������̽��� <���׸�>�� ������
	
	
	public int compareTo(Music o) {
		return this.music.compareTo(o.getMusic());
	}

	
	
	
}
