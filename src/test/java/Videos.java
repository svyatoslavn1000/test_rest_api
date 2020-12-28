import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Videos {
    @SerializedName("scenes")
    private List<Scene> scenes = null;

    public List<Scene> getScenes() {
        return scenes;
    }

    public class Scene{
        @SerializedName("name")
        private String name;

        @SerializedName("list")
        private List<Video> list = null;

        public String getName() {
            return name;
        }

        public List<Video> getList() {
            return list;
        }
    }

    public class Video {
        @SerializedName("id")
        private int id;

        @SerializedName("title")
        private String title;

        @SerializedName("videoLength")
        private int videoLength;

        @SerializedName("thumbnailUrl")
        private String thumbnailUrl;

        @SerializedName("videoUrl")
        private String videoUrl;

        @SerializedName("categories")
        private int[] categories;

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getVideoLength() {
            return videoLength;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public int[] getCategories() {
            return categories;
        }
    }
}
