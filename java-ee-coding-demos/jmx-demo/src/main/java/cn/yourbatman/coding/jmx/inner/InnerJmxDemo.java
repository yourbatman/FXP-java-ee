package cn.yourbatman.coding.jmx.inner;

import org.junit.jupiter.api.Test;

import javax.management.ObjectName;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/18 20:52
 * @since 0.0.1
 */
public class InnerJmxDemo {

    @Test
    public void test1() {
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        ObjectName objectName = classLoadingMXBean.getObjectName();
        long totalLoadedClassCount = classLoadingMXBean.getTotalLoadedClassCount();
        int loadedClassCount = classLoadingMXBean.getLoadedClassCount();
        long unloadedClassCount = classLoadingMXBean.getUnloadedClassCount();


        System.out.println("objectName：" + objectName);
        System.out.println("JVM启动起共加载的Class类总数（一个类被加载多次）：" + totalLoadedClassCount);
        System.out.println("JVM当前状态加载Class类总数：" + loadedClassCount);
        System.out.println("JVM还未加载的Class类总数：" + unloadedClassCount);
    }

    @Test
    public void test2() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        ObjectName objectName = runtimeMXBean.getObjectName();
        String name = runtimeMXBean.getName();
        // JVM信息
        String specVendor = runtimeMXBean.getSpecVendor();
        String specName = runtimeMXBean.getSpecName();
        String specVersion = runtimeMXBean.getSpecVersion();

        String bootClassPath = runtimeMXBean.getBootClassPath();
        String classPath = runtimeMXBean.getClassPath();
        String libraryPath = runtimeMXBean.getLibraryPath();

        System.out.println("objectName：" + objectName);
        System.out.println("运行期名称name：" + name);
        System.out.println("当前JVM进程ID：" + name.split("@")[0]);
        System.out.println("虚拟机信息：" + specVendor + ":" + specName + ":" + specVersion);
        // System.out.println("bootClassPath：" + bootClassPath);
        // System.out.println("classPath：" + classPath);
        // System.out.println("libraryPath：" + libraryPath);
    }

    @Test
    public void test3() {
        // JVM内存情况
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        ObjectName objectName = memoryMXBean.getObjectName();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("objectName:" + objectName);
        System.out.println("已使用堆内存:" + heapMemoryUsage);
        System.out.println("已使用非堆内存:" + nonHeapMemoryUsage);

        // 操作系统的内存情况？
        long l = Runtime.getRuntime().totalMemory();
        long l1 = Runtime.getRuntime().freeMemory();
    }

    @Test
    public void test4() {
        OperatingSystemMXBean osbean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("操作系统体系结构：" + osbean.getArch());
        System.out.println("操作系统名字：" + osbean.getName());
        System.out.println("处理器数目：" + osbean.getAvailableProcessors());
        System.out.println("操作系统版本：" + osbean.getVersion());

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.println("总线程数：" + threadBean.getThreadCount());//
    }

}
