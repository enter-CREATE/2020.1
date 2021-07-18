package MovieInformation;

//实体类，用于封装电影的一些信息
public class Movie {
    private String name;//电影名
    private String date;//上映日期
    private String director;//导演
    private String type;//电影类型
    private int boxOffice;//票房
    private int score;//评分

    public Movie() {
    }

    public Movie(String name, String date, String director, String type, int boxOffice, int score) {
        this.name = name;
        this.date = date;
        this.director = director;
        this.type = type;
        this.boxOffice = boxOffice;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(int boxOffice) {
        this.boxOffice = boxOffice;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", director='" + director + '\'' +
                ", type='" + type + '\'' +
                ", boxOffice=" + boxOffice +
                ", score=" + score +
                '}';
    }
}
