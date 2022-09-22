package exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {

    private static ApplicationContext instance = new ApplicationContext();

    public static ApplicationContext getInstance(){
        return instance;
    }
    private Properties props;
    private Map objectMap;

    private ApplicationContext(){
        props = new Properties();
        objectMap = new HashMap<String, Object>();
        try {
            props.load(new FileInputStream("src/main/resources/Beans.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Object getBean(String id) throws Exception{

        Object o1 = objectMap.get(id);
        if(o1 == null) {
            String className = props.getProperty(id);
            Class clazz = Class.forName(className);
            Method[] methods = clazz.getMethods();
            /*for (Method method : methods) {
                System.out.println("method = " + method.getName());
            }*/

            Object o = clazz.newInstance();
            objectMap.put(id, o);
            o1 = objectMap.get(id);
        }
        return o1;
    }
}
