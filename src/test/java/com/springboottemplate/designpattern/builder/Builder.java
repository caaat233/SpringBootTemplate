package com.springboottemplate.designpattern.builder;

/*
 * 模板模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性。
 * 策略模式与模板模式很相似，都是对接口的不同实现，不同的是
 *  即模板模式一般只针对一套算法，注重对同一个算法的不同细节进行抽象提供不同的实现。
 *   而策略模式注重多套算法多套实现，在算法中间不应该有交集，因此算法和算法只间一般不会有冗余代码！因为不同算法只间的实现一般不同很相近。

作者：AcientFish
链接：https://www.jianshu.com/p/ef6c822e1c35
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public abstract class Builder {
	/**
	 * 第一步：装CPU
	 */
	public abstract void buildCPU();

	/**
	 * 第二步：装主板
	 */
	public abstract void buildMainBoard();

	/**
	 * 第三步：装硬盘
	 */
	public abstract void buildHD();

	/**
	 * 获得组装好的电脑
	 *
	 * @return
	 */
	public abstract Computer getComputer();

}
