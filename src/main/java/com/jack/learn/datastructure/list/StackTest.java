package com.jack.learn.datastructure.list;

import java.util.Stack;

/**
 * <p>
 *     栈测试
 * </p>
 *
 * @author liweijian.
 * @date 2019/11/10.
 */
public class StackTest {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer element) {
        mainStack.push(element);
        if (minStack.isEmpty() || element < minStack.peek()) {
            minStack.push(element);
        }
    }

    public Integer pop() {
        // 主栈推出元素时，如果最小栈的栈顶数据与主栈的栈顶数据一样，最小栈也要推出当前小最的数据，从而保持最小数据同步
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin() throws Exception {
        if (minStack.isEmpty()) {
            throw new Exception("minStack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        StackTest stack = new StackTest();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }


}
