package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JacksonTest {
    /** Java对象转为JSON字符串 */
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.调用方法转换
        /*
            转换方法：
                1.writeValue(参数1，obj)：许多重载
                    参数1：
                        File：将obj对象转换为 JSON 字符串，并保存到指定的文件中
                        Writer：将obj对象转换为 JSON 字符串，并将 json 数据填充到字符输出流中
                        OutputStream：将obj对象转换为 JSON 字符串，并将 json 数据填充到字节输出流中

                2.writeValueAsString(obj) : 将对象转为 json 字符串
         */
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
        // {"name":"张三","age":23,"gender":"男"}

        //将数据写到D盘下的 a.txt文件
//        mapper.writeValue(new File("d://a.txt"),p);

        //将数据关联到Writer中
        mapper.writeValue(new FileWriter("d://b.txt"),p);
    }

    @Test
    public void test2() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());
        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    // {"name":"张三","age":23,"gender":"男","birthday":1588915376102}
    }

    @Test
    public void test3() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());
        // 创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);
        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
        /*  json 数组
            [
                {"name":"张三","age":23,"gender":"男","birthday":"2020-05-08"},
                {"name":"张三","age":23,"gender":"男","birthday":"2020-05-08"},
                {"name":"张三","age":23,"gender":"男","birthday":"2020-05-08"}
            ]
         */
    }

    @Test
    public void test4() throws Exception {
        //1.创建Map集合
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");
//        map.put("Name","李四");
//        map.put("Age",24);
//        map.put("Gender","男");

        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
        // 打印顺序很迷，但是格式没问题
    }

    /**
     * 演示 JSON 字符串转换为 Java对象
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";

        //2.创建Jackson核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    //  Person{name='张三', age=23, gender='男', birthday=null}

    }
}
