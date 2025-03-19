package com.spotify.oauth2.tests;

 import com.spotify.oauth2.applicationApi.PlaylistApi;
 import com.spotify.oauth2.pojo.playList.ErrorRoot;
 import com.spotify.oauth2.pojo.playList.Example;
 import io.restassured.response.Response;
 import org.testng.annotations.Test;

 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.Matchers.*;


public class PlayListTests {


    @Test
    public void createPlayList() {
   Example exampleRequest = exampleBuilder("New Playlist", "New playlist description", true);

      Example exampleResponse = PlaylistApi.postPlaylist(exampleRequest).as(Example.class);
        assertPlayList(exampleResponse, exampleRequest);

    }
    @Test
    public void getPlayList() {
        Example exampleRequest= new Example().
                setName("New Playlist").
                setDescription("New playlist description").
                setPublic(true);
        Response response = PlaylistApi.getPlaylist(exampleRequest);
        System.out.println(response.asString());
      Example exampleResponse=  response.as(Example.class);
        assertThat(exampleResponse.getName(), equalTo(exampleRequest.getName()));
        assertThat(exampleResponse.getDescription(), equalTo(exampleRequest.getDescription()));
        assertThat(exampleResponse.getPublic(), equalTo(exampleRequest.getPublic()));

    }
    @Test
    public void putPlayList() {
        Example exampleRequest= new Example().
                setName("New Playlist").
                setDescription("New playlist description").
                setPublic(false);
        Response response = PlaylistApi.putPlaylits(exampleRequest);
        assertThat(response.statusCode(), equalTo(200));
    }

    //Negative test case need to be optimized
    @Test
    public void notAbleToCreatePlayList() {
        Example exampleRequest = new Example().
                setDescription("New playlist description").
                setName("New Playlist").
                setPublic(true);
        ErrorRoot errorRootResponse = PlaylistApi.postPlaylistError(exampleRequest).as(ErrorRoot.class);
        assertThat(errorRootResponse.getError().getStatus(), equalTo(402));
        assertThat(errorRootResponse.getError().getMessage(), equalTo("Invalid access token"));

    }
    public Example exampleBuilder(String name, String description, boolean isPublic) {
        return new Example().
                setName(name).
                setDescription(description).
                setPublic(isPublic);
    }

    public void assertPlayList(Example exampleResponse, Example exampleRequest) {
        assertThat(exampleResponse.getName(), equalTo(exampleRequest.getName()));
        assertThat(exampleResponse.getDescription(), equalTo(exampleRequest.getDescription()));
        assertThat(exampleResponse.getPublic(), equalTo(exampleRequest.getPublic()));
    }
}
