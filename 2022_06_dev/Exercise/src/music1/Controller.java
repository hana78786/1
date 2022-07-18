package music1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
	List mList;
	
	public Controller() {
		mList = new ArrayList();
	}

	public void addSongList(Music music) {
		mList.add(music);
		
	}

	public void addSongListFist(Music music) {
		mList.add(0,music);
		
	}

	public List List() {
		
		return mList;
	}



	public List serchTitle(String songTitle) {
		
		List serchList = new ArrayList();
		for(int i =0; i<mList.size();i++) {
			Music music = (Music) mList.get(i);
			if(songTitle.equals(music.getSongTilte())) {
				serchList.add(music);				
			}
		}
		return serchList;
	}

	public void removeMusic(Music removeMusic) {
		for(int i=0; i<mList.size(); i++) {
			if(removeMusic.equals(mList.get(i))) {
				mList.remove(i);
			}
		}
		
	}

	public int modifyMusic(Music modifyMusic) {
		for(int i=0; i<mList.size(); i++) {
			if(modifyMusic.equals(mList.get(i))) {
				return i;
			}
		}
		return -1;
		
	}

	public void setList(Music modifyMusic, int index) {
		mList.set(index, modifyMusic);
		
	}

	public void sort() {
	Collections.sort(mList);
	}

	public void disort() {
		Collections.sort(mList, new Desort());
	
		
	}

}
