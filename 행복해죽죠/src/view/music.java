package view;

import javazoom.jl.player.MP3Player;

public class music {

	public static void slotmc() {
		MP3Player mp3 = new MP3Player();
		mp3.play(".\\music\\슬롯머신.mp3");
	}
	public static void tri() {
		MP3Player mp3 = new MP3Player();
		mp3.play(".\\music\\야바위.mp3");
	}
	public static void race() {
		MP3Player mp3 = new MP3Player();
		mp3.play(".\\music\\경마.mp3");
	}
	
}


