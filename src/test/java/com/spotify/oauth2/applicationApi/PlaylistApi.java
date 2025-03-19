package com.spotify.oauth2.applicationApi;

import com.spotify.oauth2.pojo.playList.Example;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.RestResource.*;
import static com.spotify.oauth2.api.TokenManager.getToken;


/**
 * This class is used to create a post, get and put for Playlist Api
 */

public class PlaylistApi {

   // public static String accessToken = "BQBH6jsCOWYd1mEmsDbDUx5OZzSY3D60VKB3kzwmS1HOYJ6yoPGpfjGIccHlV2EFWnHu7fq23Y0369MerUSBlMoHsYhBdxSidwmXSbHU6FkZ-gC3B1xfFzR58X-d4SawWON9R0tCoycdGmQHAgAqVQbeJ6L1OMR2c2HH7YuRWjdABXgK96x8Pu-d9bK_J7c1Mo0VKSa2gA4z6jnilK7MLHcYj7pUc_AkJ4McGDMXEtIcTISwiYHLf7gCZsmwoht4E1CSDBQVDrugMfmeG1FUWPO3LVRES__OFqUBoX6L5dYvEOL2";

    public static final String  postEndpoint = "/users/3153miac3bs3new2ubuwfjc6lozq/playlists";
    public static final String getEndpoint = "/playlists/4jajuuF1v9hkVrQCTN5qm1";
    public static final String putEndpoint = "/playlists/4jajuuF1v9hkVrQCTN5qm1";
    public static final String invalidAccessToken ="12324";
    //Post method for  Playlist  Api
    public static Response postPlaylist(Example exampleRequest) {
        return  post(postEndpoint, getToken(), exampleRequest);
    }
//Get method for  Playlist  Api
    public static Response getPlaylist( Example exampleRequest) {
        return  get(getEndpoint, getToken(), exampleRequest);
    }
//Put method for  Playlist  Api
public static Response putPlaylits(Example exampleRequest) {
        return  put(putEndpoint,  getToken(), exampleRequest);
}
    //Negative test case for Playlist Api
    public static Response postPlaylistError(Example exampleRequest) {
        return  postError( postEndpoint, invalidAccessToken,  exampleRequest);
    }
}
