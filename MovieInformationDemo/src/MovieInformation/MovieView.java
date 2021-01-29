package MovieInformation;

//与用户进行交互的视图类

public class MovieView {
    private MovieList movieList=new MovieList(10);
    public MovieView(){
        //给数组添加一个例，方便操作
        Movie movie=new Movie("红海行动","2018-2-16","林超贤","动作",365078,8) ;
        movieList.addMovie(movie);
    }

    //主方法，执行所有操作
    public void enterMainMenu(){
        boolean flag=true;
        while (flag){

            System.out.println("--------------------电影信息管理系统--------------------");
            System.out.println("                      1.添加电影                       ");
            System.out.println("                      2.修改电影                       ");
            System.out.println("                      3.删除电影                       ");
            System.out.println("                      4.电影列表                       ");
            System.out.println("                      5.退    出\n                     ");
            System.out.print("                     请选择（1-5）：");
            //获取输入
            char c=MovieUtils.readMenuSelection();
            switch (c){
                case '1':
                    addNewMovie();
                    break;
                case '2':
                    modifyMovie();
                    break;
                case '3':
                    deleteMovie();
                    break;
                case '4':
                    listAllMovie();
                    break;
                case '5':
                    System.out.print("是否确定退出（Y/N）？");
                    //用户输入
                    char exit=MovieUtils.readConfirmSelection();
                    if('Y'==exit){
                        flag=false;
                    }

            }
        }
    }
    //添加
    public void addNewMovie(){

        System.out.println("------------添加电影------------");

        System.out.print("电影名：");
        String name=MovieUtils.readString(20);

        System.out.print("上映日期：");
        String date=MovieUtils.readString(15);

        System.out.print("导演：");
        String director=MovieUtils.readString(10);

        System.out.print("电影类型：");
        String type=MovieUtils.readString(10);

        System.out.print("票房：");
        int boxOffice=MovieUtils.readInt1();

        System.out.print("评分");
        int score=MovieUtils.readInt();

        Movie movie=new Movie(name,date,director,type,boxOffice,score);

        boolean b = movieList.addMovie(movie);

        if (b){
            System.out.println("------------------电影添加完成---------------");
        }else {
            System.out.println("------------电影添加失败，电影列表已经满------");
        }

    }
    //修改
    public  void modifyMovie(){
        //
        System.out.println("-----------------修改电影--------------");

        //死循环，那么必定是需要打破循环的条件的，必须要有break语句
        Movie movie;//作用域提升
        int number;//作用域提升
        for (;;){
            System.out.print("请输入待修改的电影编号(-1退出):");
            //获取键盘输入
            number = MovieUtils.readInt();
            //判断
            if (number==-1){
                //需要退出整个修改方法。。。
                return;//结束整个方法
            }

            //第二个还需要判断，当前用户输入的编号在你的数组中是否存在？
            //只需要拿着用户输入的数去查询一下当前的数组，看是否能取出一个对象
            movie =movieList.getMovie(number-1);//一定要注意

            if (null==movie){
                //根据用户输入的内容没有找到对应的对象
                System.out.println("没有找到指定的电影");
            }else {
                //相当于找到了customer！=null,那么就可以对这个找出来的对象进行修改
                //不在这个里面操作，在外面操作，此处只需要打破循环即可。
                break;
            }
        }



        //下面就是真正的修改操作
        System.out.print("电影名("+movie.getName()+")");
        //调用工具类，获取键盘输入
        String name = MovieUtils.readString(20, movie.getName());

        System.out.print("上映日期("+movie.getDate()+")");
        String data = MovieUtils.readString(15,movie.getDate());

        System.out.print("导演("+movie.getDirector()+")");
        String director = MovieUtils.readString(10,movie.getDirector());

        System.out.print("类型("+movie.getType()+")");
        String type = MovieUtils.readString(10, movie.getType());

        System.out.print("票房("+movie.getBoxOffice()+")");
        int boxOffice = MovieUtils.readInt1(movie.getBoxOffice());

        System.out.print("评分("+movie.getScore()+")");
        int score = MovieUtils.readInt( movie.getScore());


        //将修改之后的数据，进行封装
        Movie mov = new Movie(name,data,director,type,boxOffice,score);

        //调用修改的方法  replace
        boolean b2 =movieList.replaceMovie(number - 1, mov);

        if (b2){
            System.out.println("---------------修改成功----------");
        }else {
            System.out.println("---------------修改失败-----------");
        }

    }
    //删除
    public void deleteMovie() {

        System.out.println("----------------删除电影--------------");

        Movie delcus;
        int num;
        for (; ; ) {

            System.out.print("请输入待删除的电影的编号(-1退出):");

            //获取键盘输入
            num = MovieUtils.readInt();
            if (num == -1) {
                return;
            }

            //第二个判断要删除的电影，是否存在
            delcus = movieList.getMovie(num - 1);

            if (null == delcus) {
                System.out.println("没有找到指定的电影,无法删除");
            } else {
                break;//只需要打破循环
            }

        }

        //删除的方法
        System.out.print("确定要删除电影" + delcus.getName() + "吗(Y/N)？");
        //获取键盘输入
        char isDeleted = MovieUtils.readConfirmSelection();
        if ('Y' == isDeleted) {

            //删除，调用删除的方法来进行删除
            boolean del = movieList.deleteMovie(num - 1);

            if (del) {
                //删除成功
                System.out.println("------------------删除成功---------------");
            } else {

                System.out.println("------------------删除失败---------------");
            }

        } else {
            //结束删除的方法
            return;
        }
    }

    //列表展示（查）
    public void listAllMovie(){

        System.out.println("------------电影查询------------");
        //查看当前数组中有多少有效数据
        int total = movieList.getTotal();
        if(total==0){
            System.out.println("抱歉，当前没有电影数据");
        }else{
            //说明存在内容
            System.out.println("\t电影名\t\t上映日期\t\t\t导演\t\t类型\t\t票房\t\t评分");
            //获取当前全部数据
            Movie[] allMovies = movieList.getAllMovies();
            for(int i=0;i<allMovies.length;i++){
                //需要取出每一个对象
                Movie c = allMovies[i];
                System.out.println(i+1+"\t"+c.getName()+"\t\t"+c.getDate()+"\t\t"+c.getDirector()+"\t\t"+c.getType()+"\t\t"+c.getBoxOffice()+"\t\t"+c.getScore());
                //System.out.println(i+1+"\t\t"+c.listInfo());
            }
        }
        System.out.println("------------列表展示完成------------");
    }

    public static void main(String[] args){
        //创建当前类的一个对象
        MovieView movieView=new MovieView();
        movieView.enterMainMenu();
    }

}
