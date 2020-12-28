import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Video {
    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private int id;

    @SerializedName("videoLength")
    private int videoLength;

    @SerializedName("is3d")
    private boolean is3d;

    @SerializedName("screenType")
    private String screenType;

    @SerializedName("stereoMode")
    private String stereoMode;

    @SerializedName("videoThumbNail")
    private Object videoThumbNail;

    @SerializedName("videoPreview")
    private Object videoPreview;

    @SerializedName("videoThumbNailUrl")
    @Expose
    private String videoThumbNailUrl;

    @SerializedName("categories")
    @Expose
    private List<Integer> categories = null;

    @SerializedName("projectionType")
    private String projectionType;

    public List<Encoding> getEncodings() {
        return encodings;
    }

    @SerializedName("encodings")
    @Expose
    private List<Encoding> encodings = null;

    public boolean isIs3d() {
        return is3d;
    }

    public String getProjectionType() {
        return projectionType;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVideoLength() {
        return videoLength;
    }

    public Boolean getIs3d() {
        return is3d;
    }

    public String getScreenType() {
        return screenType;
    }

    public String getStereoMode() {
        return stereoMode;
    }

    public Object getVideoThumbNail() {
        return videoThumbNail;
    }

    public Object getVideoPreview() {
        return videoPreview;
    }

    public String getVideoThumbNailUrl() {
        return videoThumbNailUrl;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public class Encoding {
        @SerializedName("name")
        private String name;

        @SerializedName("videoSourses")
        private List<VideoSourse> videoSourses = null;

        @SerializedName("audioSourses")
        private List<AudioSource> audioSourses = null;

        public String getName() {
            return name;
        }

        public List<VideoSourse> getVideoSourses() {
            return videoSourses;
        }

        public List<AudioSource> getAudioSourses() {
            return audioSourses;
        }
    }
    public class AudioSource{
        @SerializedName("url")
        private String url;

        public String getUrl() {
            return url;
        }
    }

    public class VideoSourse{

        @SerializedName("resolution")
        private String resolution;

        @SerializedName("url")
        private String url;

        public String getResolution() {
            return resolution;
        }

        public String getUrl() {
            return url;
        }
    }
}
