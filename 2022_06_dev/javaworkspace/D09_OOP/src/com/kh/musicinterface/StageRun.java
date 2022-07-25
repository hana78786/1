package com.kh.musicinterface;

public class StageRun {
	public static void main(String args[]) {
		Musician musician = new Musician();
		Piano piano = new Piano();
		musician.playInstrument(piano);
		Chello chello = new Chello();
		musician.playInstrument(chello);
		Drum drum = new Drum();
		musician.playInstrument(drum);
	}
}
