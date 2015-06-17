package com.test;

import java.util.Stack;

public class MinStack {
    
	/*
	 * We keep a second stack to keep track of minimum at each insertion.
	 * */
	
	private Stack<Integer> internal = new Stack<Integer>();
    private Stack <Integer> mins = new Stack<Integer>();    
 
    public void push2(int x) {
        if (internal.empty()){
            mins.push(x);
        }else if(x>=mins.peek()){
            mins.push(mins.peek());
        }else{
            mins.push(x);
        }
        internal.push(x);
        
    }
 
    public void pop2() {
        internal.pop();
        mins.pop();
    }
 
    public int top2() {
        return internal.peek();
    }
 
    public int getMin2() {
        return mins.peek();
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