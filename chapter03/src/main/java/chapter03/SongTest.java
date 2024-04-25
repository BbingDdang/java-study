package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song01 = new Song("좋은날", "Real", "아이유",  "이민수", 2010, 3);
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setYear(2010);
//		song.setTrack(3);
//		song.setComposer("이민수");
		song01.show();
		Song song02 = new Song("Ditto", "NewJeans");
		song02.show();

	}

}
