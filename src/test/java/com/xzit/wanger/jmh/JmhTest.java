package com.xzit.wanger.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

/**
 * @author leizefeng
 */
@BenchmarkMode(Mode.Throughput) // 吞吐量
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 结果所使用的时间单位
@State(Scope.Thread) // // 每个测试线程分配一个实例
@Fork(2) // Fork进行的数目
@Warmup(iterations = 1) // 预热循环次数
@Measurement(iterations = 2) // 计量循环次数
public class JmhTest {

    JmhService jmhService;

    @Setup(Level.Trial) // 初始化方法，在全部 Benchmark 运行之前进行
    public void init() {
        jmhService = new JmhService();
    }

    @Benchmark
    public void testScannerArrayList() {
        jmhService.scannerArrayList();
    }

    @Benchmark
    public void testScannerLinkedList() {
        jmhService.scannerLinkedList();
    }

    @TearDown(Level.Trial) // 结束方法，在全部 Benchmark 运行之后进行
    public void destroy() {
        jmhService.clear();
    }

    /**
     * 两者的性能（数字越大越好）
     *
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JmhTest.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
