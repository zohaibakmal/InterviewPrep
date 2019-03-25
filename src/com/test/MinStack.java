package com.test;

import java.util.Stack;

public class MinStack {
    
	/*
	 * We maintain two stacks. One keeps alls elements in LIFO form.
	 * The other one keep track of MIN at each level. We can keep track of min at each level by doing the following:
	 * - At insertion time, we check if the current min is greater than value to be inserted. If it is, add new value to min stack.
	 *  Otherwise, don't add the new value to the stack.
	 *
	 * - At the time of deletion, we check if the current Value to be deleted matches the value in min stack. If it is, we also pop min stack.
	 * */




    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push2(int x) {
        if(stack.size()==0 || getMin()>=x){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop2() {
        if(top()==getMin()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top2() {
        return stack.peek();
    }

    public int getMin2() {
        return minStack.peek();
    }


	
	
	/*
	 * Algorithm:
	 * - Push
	 *   - If we are pushing a value which is greater or equal to the current minimum, we push it right in.
	 *   - If we are pushing in a value which is less than the current minimum, we push in the value 2*value-currentMin.
	 *     - Next we set the new minimum to be the value
	 * - Pop
	 *   - If the value being popped is greater than currentMinimum, it is the right value.
	 *   - If the value being popped is less than currentMinimum, our real value for pop is currentMinimum.
	 *     - Next we set the new minimum to be 2*currentMinimum-poppedValue    -->poppedValue is the wrong value.
	 *     
	 * - Top
	 *   - Same as pop.
	 * 
	 * */
	Stack <Long> mainStack = new Stack<Long>();
    int currentMin = Integer.MAX_VALUE;
    
    public void push(int x) {
        if (x>=currentMin){
            mainStack.push((long)x);
        }else{
        	mainStack.push((long) 2*x-currentMin);
        	currentMin = x;
        }
    }

    public void pop() {
        long pop = mainStack.pop();
    	if (pop<currentMin){
    		currentMin = (int) (2* (long)currentMin- pop);
    	}
    }

    public int top() {
        long top = mainStack.peek();
        if (top<currentMin){
        	return currentMin;
        }else{
        	return (int)top;
        }
    }

    public int getMin() {
        return currentMin;
    }
}