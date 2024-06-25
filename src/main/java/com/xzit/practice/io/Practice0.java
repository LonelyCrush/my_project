package com.xzit.practice.io;

import java.io.*;

/**
 * <p>
 * 该类用于：InputStream使用
 * </p>
 *
 * @author leizf
 * @since 2024-04-23 21:30
 */
public class Practice0 {

    private static final String pathIn = "src/main/resources/io/is.txt";
    private static final String pathOut = "src/main/resources/io/os.txt";
    private static final String pathBIn = "src/main/resources/io/is.pdf";
    private static final String pathBOut = "src/main/resources/io/os.pdf";

    private Practice0() {}

    private static class Practice0Instance {
        private static final Practice0 PRACTICE_0 = new Practice0();
    }

    private static Practice0 getSingletonInstance() {
        return Practice0Instance.PRACTICE_0;
    }

    private void useFis() {
        try(InputStream fis = new FileInputStream(pathIn)) {
            System.out.println("available方法返回输入流中可以读取的字节数：" + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("skip方法忽略输入流中的n个字节，返回实际忽略的字节数：" + skip);
            System.out.println("从文件中读取的内容：");
            System.out.println("=============>>");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void useFos() {
        try (FileOutputStream output = new FileOutputStream(pathOut)) {
            byte[] array = "JavaGuide".getBytes();
            output.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void useFr() {
        try(Reader fr = new FileReader(pathIn)) {
            int content;
            long skip = fr.skip(3);
            System.out.println("skip方法忽略输入流中的n个字节，返回实际忽略的字节数：" + skip);
            System.out.println("从文件中读取的内容：");
            System.out.println("=============>>");
            while ((content = fr.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void useFw() {
        try (Writer fr = new FileWriter(pathOut)) {
            fr.write("你好，我是Guide。");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void compareFisAndBis() {
        try(InputStream fis = new FileInputStream(pathBIn);
            OutputStream fos = new FileOutputStream(pathBOut)) {
            long start = System.currentTimeMillis();
            int content;
            while ((content = fis.read()) != -1) {
                fos.write((char) content);
            }
            long end = System.currentTimeMillis();
            System.out.println("使用普通流总耗时：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream ois = new BufferedInputStream(new FileInputStream(pathBIn));
            OutputStream bos = new BufferedOutputStream(new FileOutputStream(pathBOut))) {
            long start = System.currentTimeMillis();
            int content;
            while ((content = ois.read()) != -1) {
                bos.write((char) content);
            }
            long end = System.currentTimeMillis();
            System.out.println("使用缓冲流总耗时：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream fis = new FileInputStream(pathBIn);
            OutputStream fos = new FileOutputStream(pathBOut)) {
            long start = System.currentTimeMillis();
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("使用普通流加byte[]总耗时：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream ois = new BufferedInputStream(new FileInputStream(pathBIn));
            OutputStream bos = new BufferedOutputStream(new FileOutputStream(pathBOut))) {
            long start = System.currentTimeMillis();
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = ois.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("使用缓冲流加byte[]总耗时：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Practice0 practice0 = getSingletonInstance();
//        practice0.useFis();
//        practice0.useFos();
//        practice0.useFr();
//        practice0.useFw();
        practice0.compareFisAndBis();
    }
}
