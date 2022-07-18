package com.kh.music.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.music.model.vo.DescSinger;
import com.kh.music.model.vo.Music;

public class Controller {

	
	List mList;

	public Controller() {
		mList = new ArrayList();
	}

	public void addSong(Music music) {
		mList.add(music);

	}

	public void addfirstSong(Music music) {
		// TODO Auto-generated method stub
		mList.add(0, music);

	}

	public List musicList() {
		// TODO Auto-generated method stub
		return mList;
	}

	public int serchIndex(String songName) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mList.size(); i++) {
			Music music = (Music) mList.get(i);
			if (music.getMusic().equals(songName)) {
				int index = i;
				return index;
			}
		}
		return -1;
	}

	public Music serchSong(int index) {
		// TODO Auto-generated method stub
		Music music = (Music) mList.get(index);
		return music;
	}
	
	
	/////검색한 곡을 여러개 출력함...
	public List selectMusicByname(String title){
		List findList= new ArrayList();
		for(int i =0; i<mList.size();i++) {
			if(title.equals(((Music) mList.get(i)).getMusic())) {
				findList.add((Music) mList.get(i));
			}
		}
		return findList;
	}
	

	public void remove(int index, List selectList) {
		// TODO Auto-generated method stub
		for(int i= 0;i<mList.size();i++) {
				if(selectList.get(index).equals(mList.get(i))) {
					mList.remove(i);
				}
			
		}
		
		
	}

	public void setMusic(int index, Music changeSong) {
		// TODO Auto-generated method stub
		
				mList.set(index, changeSong);
	
	}



	public void sortByTitle() {
		// TODO Auto-generated method stub
		Collections.sort(mList);
		//Collections.sort(mList); a를 기준없이 기본값으로 정렬한다.
		
	}

	public int serchIndexChage(int index, List selectList) {
		// TODO Auto-generated method stub
		for(int i =0; i<mList.size();i++) {
			if(selectList.get(index).equals(mList.get(i))) {
				return i;
			}
		}
		return -1;
	}

	public void sortBySinger() {
		Collections.sort(mList, new DescSinger());
		//Collections.sort(a, b); a를 b를 기준으로 정렬한다
	}
	
	
}

