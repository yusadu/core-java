package edu.nf.ch07;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * [k,v]数据结构，其内部的实现是基于数组+链表（jdk1.8之前）
 * 数组+链表+红黑树（jdk1.8之后）
 *
 * HashMap是允许空的键和空的值,Hashtable是不允许的
 * HashMap是线程不安全的（性能高）,Hashtable是线程的安全的（性能低）
 *
 */
public class TestMap {

    public void testHashTable(){
        Hashtable<String,Object> hashtable=new Hashtable<>();
        hashtable.put("key1","hello");
        hashtable.put("key2","world");
        hashtable.put(null,null);
    }

    public void testHashMap(){
        HashMap<String,Object> map=new HashMap<>();
        //以”键值对“的方式存储数据
        map.put("k1","张三");
        map.put("k2",23);
        map.put("k3","男");
        //取值必须根据key获取value
        String str=(String)map.get("k1");
        System.out.println(str);
        System.out.println("-----------------------");
        //判断map集合中是否包含某个key或value
        System.out.println(map.containsKey("key1"));
        System.out.println(map.containsValue(23));
        //获取map集合中所有的key,返回一个set集合
        Set<String> keys=map.keySet();
        keys.forEach(key-> System.out.println(key));
        System.out.println("________________________");
        //遍历map集合，先获取所有的key，再根据key取出value
        for (String key:map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }
        System.out.println("------------------------");
        //遍历map集合，获取Entry的Set集合（一个Entry表示一个键值对的元素）
        //可以通过Entry的getKey或getValue方法获取键值
        for (Map.Entry<String,Object> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }

    public static void main(String[] args) {
        TestMap testMap=new TestMap();
        testMap.testHashMap();
        testMap.testHashTable();
    }
}
