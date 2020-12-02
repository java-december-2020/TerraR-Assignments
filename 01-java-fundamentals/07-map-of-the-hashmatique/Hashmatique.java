import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        Hashmatique hash = new Hashmatique();
        hash.getLyrics("What a Wonderful World");
    }

    public void getLyrics(String songName) {
        HashMap<String, String> trackList = new HashMap<>();

        trackList.put("What a Wonderful World",
                "I see trees of green, red roses too; I see them bloom for me and you; And I say to myself, what a wonderful world");
        trackList.put("At Last",
                "At last, my love has come along; My lonely days are over; And life is like a song, oh yeah yeah");
        trackList.put("Cupid",
                "Cupid draw back your bow; And let your arrow go; Straight to my lover's heart for me, for me");
        trackList.put("Stormy Weather",
                "Don't know why; There's no sun up in the sky; Stormy weather; Since my man and I ain't together; Keeps rainin' all the time");

        String lyrics = trackList.get(songName);

        System.out.println("\nSelected Track: " + songName);
        System.out.println("Lyrics: " + lyrics);

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.print("\n" + key + " : ");
            System.out.print(trackList.get(key));
        }
    }
}
