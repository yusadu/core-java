package edu.nf.ch07;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author roy
 */
public class TestCollection {

    /**
     * ArrayList是基于数组的结构实现的
     */
    public void testArraylist(){
        ArrayList<String> list=new ArrayList<>();
        //添加元素,允许重复元素
        list.add("roy");
        list.add("karry");
        list.add("jackson");
        list.add("feng");
        //根据下标取出指定元素
        System.out.println(list.get(0));
        System.out.println(list.get(3));
        System.out.println("*****************");

        //遍历集合
        for (String s:list){
            System.out.println(s);
        }
        System.out.println("*****************");
        //替换指定下标
        list.set(2,"ling");
        System.out.println(list.get(2));
        System.out.println("*****************");
        //删除元素
        list.remove(1);
        System.out.println("集合大小："+list.size());
        System.out.println("*****************");
        //判断某个元素是否存在
        boolean b1=list.contains("roy");
        System.out.println("是否包含元素、；"+b1);
        System.out.println("*****************");
        //获取元素的下标值
        int index=list.indexOf("feng");
        System.out.println("元素下标为："+index);

    }

    /**
     * LinkedList集合是基于链表的数据结构实现的
     */
    public void testLinkedList(){
        LinkedList<String> list=new LinkedList<>();
        //添加元素,允许重复元素
        list.add("roy");
        list.add("karry");
        list.add("jackson");
        list.add("feng");
        //根据下标取出元素
        list.get(2);
        list.get(3);

        //LinkedList独有的api方法，可以在集合的头和尾操作元素
        //从头部添加元素
        list.addFirst("ling");
        //从尾部添加元素
        list.addLast("li");
        //移除头和尾的元素
        list.removeFirst();
        list.removeLast();
    }

    /**
     * HashSet是基于散列的数据结构
     * HashSet是无下标，无序，不可重复的一种集合
     */
    public void testHashSet(){
        HashSet<String> set=new HashSet();
        set.add("1");
        set.add("2");
        set.add("3");
        //遍历循环
//        for (String s:set){
//            System.out.println(s);
//        }
        set.forEach(s -> System.out.println(s));
        System.out.println("###################");
        //判断集合是否为空
        System.out.println(set.isEmpty());
        //判断集合是否包含元素
        System.out.println(set.contains("1"));
    }

    public void testHashSet2(){
        HashSet<Users> set=new HashSet<>();
        Users u1=new Users("roy",12);
        Users u2=new Users("roy",12);
        set.add(u1);
        set.add(u2);
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        TestCollection test=new TestCollection();
//        test.testArraylist();
        test.testHashSet2();
    }
}
