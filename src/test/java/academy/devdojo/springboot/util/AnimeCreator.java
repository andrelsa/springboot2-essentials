package academy.devdojo.springboot.util;

import academy.devdojo.springboot.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved() {
        return Anime
                .builder()
                .name("Hajime no Ipoo")
                .build();
    }

    public static Anime createValidaAnime() {
        return Anime
                .builder()
                .id(1L)
                .name("Hajime no Ipoo")
                .build();
    }

    public static Anime createValidUpdateToAnime() {
        return Anime
                .builder()
                .id(1L)
                .name("Hajime no Ipoo")
                .build();
    }
}
