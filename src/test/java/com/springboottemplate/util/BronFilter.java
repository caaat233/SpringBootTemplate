package com.springboottemplate.util;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/9/16 11:06
 */

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

/**
 * https://snailclimb.gitee.io/javaguide/#/docs/cs-basics/data-structure/bloom-filter
 */
public class BronFilter {

    /**
     * 但是它有一个重大的缺陷就是只能单机使用（另外，容量扩展也不容易），而现在互联网一般都是分布式的场景。为了解决这个问题，我们就需要用到 Redis 中的布隆过滤器了。
     */
    @Test
    public void testBloomFilter() {
        // 创建布隆过滤器对象
        // 我们创建了一个最多存放 最多 1500 个整数的布隆过滤器，并且我们可以容忍误判的概率为百分之（0.01）
        //在我们的示例中，当mightContain() 方法返回 true 时，我们可以 99％确定该元素在过滤器中，当过滤器返回 false 时，我们可以 100％确定该元素不存在于过滤器中。
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);

        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }
}
