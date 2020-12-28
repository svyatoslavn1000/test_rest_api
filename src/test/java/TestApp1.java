import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class TestApp1 {

    public final String PLAYA_MAIN = "https://playavr.com/";
    public final String PLAYA_ALL_VIDEOS = "https://playavr.com/video/api/videos";
    Gson gson = new Gson();
    Response response = null;
    List<String> videoUrl = new ArrayList<>();
    List<Integer> idVideo = new ArrayList<>();
    List<String> thumbs = new ArrayList<>();

    @Test
    public void getAllVideo(){
//        Response response = RestAssured.given().get(PLAYA_ALL_VIDEOS)
////        System.out.println(response.asString());
//        String allVideo = response.asString();
//
//        Videos videos =gson.fromJson(allVideo, Videos.class);
//
//        for(int i = 0; i < videos.getScenes().get(0).getList().size(); i++){
//            System.out.println(videos.getScenes().get(0).getList().get(i).getId());
//        }

        Response singleVideo = RestAssured.given().get("http://playavr.com/video/api/video/172");
        Video video = gson.fromJson(singleVideo.asString(), Video.class);
        System.out.println(video.getId() + " " + video.getTitle() + " " + video.getCategories() + " " + video.getVideoThumbNail());

    }

    @Test
    public void parsingEndpointSources(){
                response = RestAssured.given().get(PLAYA_ALL_VIDEOS);
        String allVideo = response.asString();
        Videos videos =gson.fromJson(allVideo, Videos.class);

        for(int i = 0; i < videos.getScenes().get(0).getList().size(); i++){
            idVideo.add(videos.getScenes().get(0).getList().get(i).getId());
            thumbs.add(videos.getScenes().get(0).getList().get(i).getThumbnailUrl());
        }
        checkThumbsUrl(thumbs);
        checkVideoLinks(idVideo);
        checkThumbsUrl(videoUrl);
    }

    private void checkThumbsUrl(List<String> links){
        for (String link : links) {
            response = RestAssured.given().head(link);
            if (response.getStatusCode() == 200) {
                System.out.println(link + "---" + "Ok" + " " + response.getHeader("Content-Length"));

            } else {
                System.out.println(link + " " + "Something Out of Order");
            }
        }
    }

    private void checkVideoLinks(List<Integer> id){
        for (Integer integer : id) {
            response = RestAssured.given().get("http://playavr.com/video/api/video/" + integer);
            Video video = gson.fromJson(response.asString(), Video.class);
            for (int j = 0; j < video.getEncodings().get(0).getVideoSourses().size(); j++) {
                videoUrl.add(video.getEncodings().get(0).getVideoSourses().get(j).getUrl());
            }
        }
    }
}
