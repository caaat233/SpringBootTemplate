package com.springboottemplate.jihe;

import java.util.*;

import org.junit.Test;

public class SetTest {
    /*
     * （1）根据需要选择正确的集合类型。比如，如果指定了大小，我们会选用Array而非ArrayList。如果我们想根据插入顺序遍历一个Map，
     * 我们需要使用TreeMap。如果我们不想重复，我们应该使用Set。
     * （2）一些集合类允许指定初始容量，所以如果我们能够估计到存储元素的数量，我们可以使用它，就避免了重新哈希或大小调整。
     * （3）基于接口编程，而非基于实现编程，它允许我们后来轻易地改变实现。 （4）总是使用类型安全的泛型，避免在运行时出现ClassCastException。
     * （5）使用JDK提供的不可变类作为Map的key，可以避免自己实现hashCode()和equals()。
     * （6）尽可能使用Collections工具类，或者获取只读、同步或空的集合，而非编写自己的实现。它将会提供代码重用性，它有着更好的稳定性和可维护性。
     * ———————————————— 版权声明：本文为CSDN博主「李人」的原创文章，遵循 CC 4.0 BY-SA
     * 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_26465035/article/details/103164167
     *
     *
     */

    /**
     * LinkedHashSet根据元素插入顺序排序?但是元素依然是不能重复的
     * 但是TreeSet是根据元素的值大小排序， TreeSet就是 SortSet的实现
     */
    @Test
    public void LinkedHashSet() {
        //LinkedHashSet根据元素插入顺序排序
        LinkedHashSet dset = new LinkedHashSet<>();
        dset.add(5);
        dset.add(8);
        dset.add(4);
        dset.add(2);
        dset.add(2);
        dset.add(null);
        System.out.println(dset.toString() + "     " + dset.size());
//但是TreeSet是根据元素的值大小排序
        TreeSet treeSet = new TreeSet();
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(4);
        treeSet.add(2);
        treeSet.add(2);
        System.out.println(treeSet.toString());
    }


    /**
     * 根据元素的值排序
     * 这两个接口提供排序操作，实现他们的子类都具有接口中定义的功能。Set和Map本身不具备排序功能，提供了SortedMap和SortedSet接口之后可以在提供排序方案的同时，增加更多的获取集合特定位置元素的方法。类似：结合的第一个元素，最后一个元素，位于特定元素之间的元素等。
     * <p>
     * sortedSet意为按照对象的比较函数对元素排序，而不是只元素的插入次序，插入顺序则用LinkedHashSet来保存，以Comparator comparator()自然方式排序
     * <p>
     * 其中TreeSet就是SortSet的实现
     */
    @Test
    public void SortSet() {
        //	SortedSet<Object> objects = new SortedSet<>();

    }

    /**
     * TreeSet 是二差树实现的,Treeset中的数据是自动排好序的，不允许放入null值。
     * TreeSet是根据元素的值大小排序
     */
    @Test
    public void TreeSet() {
        TreeSet treeSet = new TreeSet();
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("b");
        treeSet.add("d");
        treeSet.add(null);//放空报错
        System.out.println(treeSet.toString());
        treeSet.remove("c");
        System.out.println(treeSet.toString());

    }

    @Test
    public void test1() {
        Set<String> set = new HashSet<String>();
        set = test2();
        System.out.println(set.size());
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        // 这个可以得到一个集合的镜像，它的返回结果不可直接被改变，否则会
        Collections.unmodifiableCollection(set);
        set.add("b");
        set.add(null);
        set.add(null);

        System.out.println(set.remove("a"));
        System.out.println(set.size());
        System.out.println(set.contains(""));//false
        System.out.println(set.contains(null));//true

    }


    public Set<String> test2() {
        Set<String> set = new HashSet<String>();
        set.add("1111");
        if ("C".equals(null)) {
            System.out.println("aa");
        } else {
            System.out.println("bb");
        }
        String name = null;
        if (name == null) {
            System.out.println("1111");
        }

        return set;
    }


    @Test
    public void test3() {

        Set<String> set = returnSet();
        System.out.println(set.size());
        System.out.println(set);
        System.out.println(set = set);

    }

    public Set<String> returnSet() {
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
        return set;
    }


}
