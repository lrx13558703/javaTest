import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
                String userStr = Main.userInfos();
        //        List<User> models = Main.getUserModel(userStr);
        //        List<Usertest> newmodels = Main.getUserTestMOdel(models);
        //
        //        Integer a=new Integer(1);
        //        Integer b=Integer.valueOf(1);
        //

//        long aaa = Runtime.getRuntime().freeMemory();
//        System.out.println(aaa);
//
//        String a = "李瑞鑫";
//
//        int s = 2;
    }

    /**
     * 对象转json字符串
     *
     * @return json字符串
     */
    public static String userInfos() {
        List<User> userlist = new ArrayList<User>();

        User user_1 = new User(1, "张大", 15);
        User user_2 = new User(2, "张三", 16);
        User user_3 = new User(3, "张四", 17);

        userlist.add(user_1);
        userlist.add(user_2);
        userlist.add(user_3);
        userlist.add(user_3);
        userlist.add(user_3);
        userlist.add(user_3);

        boolean flag= userlist.remove(null);

        //// 开始转化
        Gson gson = new Gson();
        String str = gson.toJson(userlist);
        return str;
    }

    /**
     * Json字符串转对象
     *
     * @param userInfoStr Json字符串
     * @return 返回对象
     */
    public static List<User> getUserModel(String userInfoStr) {
        List<User> result = new ArrayList<User>();

        //// 开始转化
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        result = gson.fromJson(userInfoStr, new TypeToken<List<User>>() {
        }.getType());

        return result;
    }

    /**
     * 对象转对象
     *
     * @param userinfos 原对象
     * @return 新对象
     */
    public static List<Usertest> getUserTestMOdel(List<User> userinfos) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<Usertest>> typeToken = new TypeToken<List<Usertest>>() {
        };
        List<Usertest> result = modelMapper.map(userinfos, typeToken.getType());

        return result;
    }

    public static List<Usertest> getExchangeInfo(List<Usertest> userInfo) {
        List<Usertest> testinfos = new ArrayList<Usertest>();
        System.arraycopy(userInfo, 1, testinfos, 0, 2);
        System.out.println(new Gson().toJson(testinfos));
        return testinfos;
    }

}

class User {
    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class Usertest {
    private int id;

    private String name;

    private int age;

    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}


