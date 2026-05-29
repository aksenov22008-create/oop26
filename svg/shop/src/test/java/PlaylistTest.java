import music.Playlist;
import music.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistTest {
    @Test
    public void testEmptyPlaylist(){
        Playlist playlist = new Playlist();
        assertTrue(playlist.isEmpty());
    }
    @Test
    public void testSingleElement(){
        Playlist playlist = new Playlist();
        playlist.add(new Song("Jan Kowalski","Test",183));
        assertEquals(1,playlist.size());
    }
    @Test
    public void testSameElements(){
        Playlist playlist = new Playlist();
        Song song = new Song("Jan Kowalski","Test",183);
        playlist.add(song);
        assertTrue(playlist.contains(song));
    }
}
