package cacahe1;

import java.net.URL;  
import java.util.List;  
import net.sf.ehcache.Cache;  
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;  
  
public class Test2 {  
  
    public static void main(String[] args) throws Exception {  
  
        URL url = Test2.class.getClassLoader().getResource("ehcache.xml");  
        if (url == null) {  
            System.out.println("null");  
            return;  
        }else{  
            System.out.println(url);  
        }  
        CacheManager manager = new CacheManager(url);  
        Cache cache = manager.getCache("mobileCache");  
        int i = 1;  
        while (true) {  
            cache.put(new Element(String.valueOf(i), String.valueOf(i)));
            List<String> list = cache.getKeys();  
            for (Object str : list) {  
                System.out.print("## " + str + "\t");  
            }  
            i++;
            System.out.println("");  
            Thread.sleep(4000);  
        }  
    }  
      
}  