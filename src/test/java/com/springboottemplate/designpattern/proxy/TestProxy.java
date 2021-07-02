package com.springboottemplate.designpattern.proxy;

public class TestProxy {
    /**
     * 这是动态代理
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 静态代理
         */
        Real real = new Real();
        Network network = new Proxy(real);
        network.browse();

        /**
         * 动态代理
         *   return Proxy.newProxyInstance(
         *                 target.getClass().getClassLoader(), // 目标类的类加载
         *                 target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
         *                 new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
         *         );
         */

        Network network1 = (Network) java.lang.reflect.Proxy.newProxyInstance(
                real.getClass().getClassLoader(),
                real.getClass().getInterfaces(),
                new NetWorkInvocationHandler(real));
        network1.browse();
    }


}
