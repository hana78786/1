package music;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	List<Music> mList = new ArrayList<Music>();

	public void addSongList(Music music) {
		// TODO Auto-generated method stub
		mList.add(music);		
	}

	public void addSongListFirst(Music music) {
		// TODO Auto-generated method stub
		mList.add(0,music);
		
	}

	public List<Music> allList() {
		return mList;
		
	}

	public int serchTitle(String songTilte) {
		// TODO Auto-generated method stub
		for(int i =0; i<mList.size();i++) {
		Music music = mList.get(i);
			if(music.getSongTitle().equals(songTilte)) {
				return i;
			}
		}
		
		return -1;
	}

	public Music SongListIndex(int index) {
		// TODO Auto-generated method stub
		Music music = mList.get(index);
		return music;
	}

	public void songRemove(int index) {
		// TODO Auto-generated method stub
		 mList.remove(index);
		
		
	}

	public void ChangeInfo(Music musicCh, int index) {
		// TODO Auto-generated method stub
		mList.set(index, musicCh);
		
	}
	
	
	
}
