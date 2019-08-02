import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybaitsTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
//        Category c = new Category();             //插入数据
//        c.setName("新增加的Category");
//        session.insert("addCategory",c);
//        listAll(session);                   //显示所有数据的名字
//        session.commit();
//        session.close()

//        Category d=new Category();               //删除
//        d.setId(2);
//        session.delete("deleteCategory",d);
//        listAll(session);
//        session.commit();
//        session.close();

//        Category c= session.selectOne("getCategory",1);    //根据ID查找数据
//        System.out.println(c.getName());
//        session.commit();
//        session.close();

//        Category c= session.selectOne("getCategory",3);      //修改ID=3的数据的名字
//        c.setName("修改了的Category名稱");
//        session.update("updateCategory",c);
//        listAll(session);
//        session.commit();
//        session.close();

//        List<Category> cs = session.selectList("listCategoryByName","cat");      //模糊查询名字中含有cat的
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
//        session.commit();
//        session.close();

//        Map<String,Object> params = new HashMap<>();      //多个参数查询
//        params.put("id", 1);
//        params.put("name", "cat");
//        List<Category> cs = session.selectList("listCategoryByIdAndName",params);
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }

        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t" + p);
            }
        }

        session.commit();
        session.close();

    }
}


//
//    private static void listAll(SqlSession session) {
//        List<Category> cs = session.selectList("listCategory");
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }

//        List<Product> pt=session.selectList("listProduct");
//        List<Category> cs=session.selectList("listCategory");
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
//
//        for (Product p:pt){
//            System.out.println(p.getId()+p.getName()+p.getPrice());
////        }
//    }
//}
