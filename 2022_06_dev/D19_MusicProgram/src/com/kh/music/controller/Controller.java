package com.kh.music.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.music.model.vo.Music;

public class Controller {

	
	ArrayList<Music> mList;

	public Controller() {
		mList = new ArrayList<Music>();
	}

	public void addSong(Music music) {
		mList.add(music);

	}

	public void addfirstSong(Music music) {
		// TODO Auto-generated method stub
		mList.add(0, music);

	}

	public ArrayList<Music> musicList() {
		// TODO Auto-generated method stub
		return mList;
	}

	public int serchIndex(String songName) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mList.size(); i++) {
			Music music = mList.get(i);
			if (music.getMusic().equals(songName)) {
				int index = i;
				return index;
			}
		}
		return -1;
	}

	public Music serchSong(int index) {
		// TODO Auto-generated method stub
		Music music = mList.get(index);
		return music;
	}
	
	
	/////검색한 곡을 여러개 출력함...
	public ArrayList<Music>selectMusicByname(String title){
		ArrayList<Music> findList= new ArrayList<Music>();
		for(int i =0; i<mList.size();i++) {
			if(title.equals(mList.get(i).getMusic())) {
				findList.add(mList.get(i));
			}
		}
		return findList;
	}
	

	public void remove(int index) {
		// TODO Auto-generated method stub
		mList.remove(index);
		
	}

	public void setMusic(int index, Music changeSong) {
		// TODO Auto-generated method stub
		mList.set(index, changeSong);
		
	}

	public void sortAscending() {
		
		
//		Collections.sort(mList);
		
		
		
	}
}
