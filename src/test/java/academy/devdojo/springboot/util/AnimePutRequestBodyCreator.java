package academy.devdojo.springboot.util;

import academy.devdojo.springboot.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody(){
        return AnimePutRequestBody
                .builder()
                .id(AnimeCreator.createValidUpdateToAnime().getId())
                .name(AnimeCreator.createValidUpdateToAnime().getName())
                .build();
    }
}
