package com.kh.music.model.vo;

import java.util.Comparator;


public class DescSinger implements Comparator<Music>{
	
@Override
public int compare(Music o1, Music o2) {
	// TODO Auto-generated method stub
	Music mOne = (Music)o1;
	Music mTow = (Music)o2;
	
	return mOne.getSinger().compareTo(mTow.getSinger()) * -1;
	//-1�� ���ָ� ���������� �Ǿ� �������� ������ ��
}
}
