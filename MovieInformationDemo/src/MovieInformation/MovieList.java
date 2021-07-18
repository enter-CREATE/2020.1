package MovieInformation;


//这个类用来处理Movie数组的---增删改查
public class MovieList {
    //定义一个Movie的数组，用来保存movie对象的，未初始化，需要在下面方法中初始化
    private Movie[] movies;
    private int total = 0;//这是当前数组中有效的个数


    //这是类的一个构造函数，
    //参数是为了给当前定义的数组进行初始化的
    public MovieList(int totalMovie) {
        //给当前数组进行初始化
        movies = new Movie[totalMovie];
    }


    //方法：向数组中添加movie对象
    //新对象：movie
    //return   成功返回true，失败返回false
    public boolean addMovie(Movie movie) {
        //判断有效位数大于长度，无法添加
        if (total >= movies.length) {
            return false;
        }
        //否则，可以添加
        movies[total++] = movie;
        //成功返回true
        return true;
    }


    //方法：替换原来数组指定下标的元素（修改数组中的某个元素）
    //要替换的数组下标位置：index
    //要替换的新movie对象：mo
    //替换成功返回true，失败返回false
    public boolean replaceMovie(int index, Movie mo) {

        //替换的下标不在有效范围内，报错
        if (index < 0 || index >= total) {
            return false;
        }
        //否则。可以替换
        movies[index] = mo;
        return true;
    }


    //方法：删除数组中指定下标的元素
    //指定下标：index
    //删除成功返回true，失败返回false
    public boolean deleteMovie(int index) {
        //报错判断
        if (index < 0 || index >= total) {
            return false;
        }
        //利用for循环进行删除
        for (int i = index; i < total - 1; i++) {
            movies[i] = movies[i + 1];
        }
        //最后一位为null
        movies[total - 1] = null;
        //有效位减一
        total--;
        return true;
    }


    //方法：显示当前有效个数的数组的全部元素
    public Movie[] getAllMovies() {
        //定义一个新数组，将原数组逐个赋值给新数组，然后输出
        Movie[] movies1 = new Movie[total];
        for (int i = 0; i < movies1.length; i++) {

            movies1[i] = movies[i];
        }
        return movies1;
    }


    //方法：通过指定下标查询电影对象
    //指定下标：index
    public Movie getMovie(int index) {
        //报错判断
        if (index < 0 || index > total) {
            return null;
        }
        return movies[index];
    }


    //方法：获取当前有效元素个数
    public int getTotal() {

        return total;
    }
}
