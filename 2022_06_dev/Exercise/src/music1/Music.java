package music1;

import java.util.Comparator;

public class Music implements Comparable<Music> {
	
	String songTilte;
	String singer;
	public String getSongTilte() {
		return songTilte;
	}
	public void setSongTilte(String songTilte) {
		this.songTilte = songTilte;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Music [songTilte=" + songTilte + ", singer=" + singer + "]";
	}

	@Override
	public int compareTo(Music o) {
		// TODO Auto-generated method stub
		return this.songTilte.compareTo(o.getSongTilte());
	}
	
}
