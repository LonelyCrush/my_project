package com.xzit.wanger.collection.stack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static java.lang.Math.max;

@SpringBootTest
public class StackTest {

    @Test
    public void testStack() {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("apple");
        stringStack.push("banana");
        stringStack.push("cherry");
        System.out.println(stringStack);
        System.out.println(stringStack.pop());
        System.out.println(stringStack.peek());
        stringStack.pop();
        System.out.println(stringStack);
        // 当需要使用栈时，Java 已不推荐使用Stack，而是推荐使用更高效的stack（双端队列）
    }

    @Test
    public void testArrayDequeStack() {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("apple");
        stack.push("banana");
        stack.push("cherry");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack.peek());
    }

    @Test
    public void testArrayDequeQueue() {
        ArrayDeque<String> queue = new ArrayDeque<>();
        // offer队尾添加
        queue.offer("apple");
        queue.offer("banana");
        queue.offer("cherry");
        System.out.println(queue);
        System.out.println(queue.peek());
        // poll队首弹出
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    @Test
    public void testLeeCode1() {
        String s1 = "()[]{}";
        String s2 = "(])[{}(";
        String s3 = "([)]";
        String s4 = ")[)]";
        String s5 = "([{}])";
        String s6 = "";
        String s7 = " ";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));
        System.out.println(isValid(s7));
    }

    private boolean isValid(String s) {
        if ("".equals(s.trim()) || s.length() == 0) {
            return true;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (map.get(c) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testString() {
        System.out.println("  ".length());
        String s1 = "  Hello World  ";
        System.out.println(s1.trim().length());
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     */
    @Test
    public void testLeeCode2() {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }

    private List<String> generateParenthesis(int n) {
        return n <= 0 ? null : generateParenthesis("", 0, 0, n, new ArrayList<>());
    }

    private List<String> generateParenthesis(String pointer, int left, int right, int n, List<String> result) {
        if (left > n || right > left ) {
            return result;
        }
        if (pointer.length() == 2 * n) {
            result.add(pointer);
            return result;
        }
        result = generateParenthesis(pointer + "(", left + 1, right, n, result);
        result = generateParenthesis(pointer + ")", left, right + 1, n, result);
        return result;
    }

    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出包含有效括号的子串的最长长度。
     * 示例 1:
     *      输入: "(()"
     *      输出: 2
     *      解释: 最长有效括号子串为 "()"
     * 示例 2:
     *      输入: ")()())"
     *      输出: 4
     *      解释: 最长有效括号子串为 "()()"
     *
     * 状态:
     *      dp[i] 表示以下标 i 为字符结尾的最长有效字符串的长度
     * 状态转移方程:
     *      if s[i] == ‘(’
     *          以 ( 结尾的子字符串不考虑，因为不可能构成合法括号
     *      if s[i] == ‘)’
     *          s[i - 1] == ‘(’，也就是字符串形如 “……()”，我们可以推出：dp[i] = dp[i − 2] + 2。因为结束部分的 “()” 是一个有效子字符串，并且增加了 2.
     *          s[i - 1] == ‘)’，也就是字符串形如 “……))”，我们需要判断:因为如果倒数第二个 )是一个有效子字符串的一部分（记为subs），
     *              我们此时需要判断 subs 前面一个符号是不是 ( ，如果恰好是(，我们可以推出：dp[i] = dp[i − 1] + 2
     *              除此以外，我们也会把子字符串 subs 前面的有效字符串的长度加上，也就是 dp[i - dp[i − 1] − 2].
     */
    @Test
    public void testLeeCode3() {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()(()))"));
    }

    private int longestValidParentheses(String str) {
        char[] s = str.toCharArray();
        int size = str.length();
        int[] dp = new int[size];
        int maxLength = 0;

        for (int i = 1; i < size; i++) {
            if (s[i] == ')') {
                // ...()
                if (s[i - 1] == '(') {
                    // ...()
                    if (i - 1 > 0) {
                        dp[i] = dp[i - 2] + 2;
                    // ()
                    } else {
                        dp[i] = 2;
                    }
                // ...))
                } else if (dp[i - 1] > 0) {
                    // ((...))
                    if ((i - dp[i - 1]) > 0 && s[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        // ...((...))
                        if ((i - dp[i - 1] - 1) > 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            maxLength = max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
