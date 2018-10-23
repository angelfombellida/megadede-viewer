package angel.megadede;

import android.net.Uri;

public class Program {
    private final static String BASE_URL = "https://www.megadede.com/serie/";
    private String title;
    private String name;
    private Uri link;

    public Program(String title) {
        this.title = title;
        this.name = title;
        this.name = name.trim().replaceAll("\\s", "-");
        this.link = Uri.parse(BASE_URL + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = Uri.parse(link);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
