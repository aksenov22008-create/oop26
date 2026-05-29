import database.DatabaseConnection;
import music.Song;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SongTest {
    @Test
    public void testRead() throws SQLException {
        DatabaseConnection.connect("songs.db");

        Optional<Song> song =Song.Persistence.read(5);
        Song expected = new Song("The Beatles","Hey Jude",431);
        assertTrue(song.isPresent());
        assertEquals(expected,song.get());

    }
    @Test
    public void testReadFail() throws SQLException {
        DatabaseConnection.connect("songs.db");
        Optional<Song> song = Song.Persistence.read(68);
        assertTrue(song.isEmpty());
    }

}
