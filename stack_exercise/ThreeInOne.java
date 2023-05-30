package stack_exercise;
public class ThreeInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;
    private int[] topOfStacks;
  
    public ThreeInOne(int stackSize) {
      // TODO
      values = new int[stackSize];
      stackCapacity = stackSize;

      // sizes 
      sizes = new int[numberOfStacks + 1];
      for(int i = 1; i < sizes.length; i++){
        sizes[i] = (i * stackCapacity) / numberOfStacks;
      }

      // top of stacks.
      topOfStacks = new int[numberOfStacks + 1];
      for(int i = 1; i < topOfStacks.length; i++){
        topOfStacks[i] = sizes[i - 1];
      }
    }
  
    // isFull
    public boolean isFull(int stackNum) {
      // TODO
      return topOfStacks[stackNum] == sizes[stackNum];
    }
  
    // isEmpty
    public boolean isEmpty(int stackNum) {
        // TODO
        return topOfStacks[stackNum] == sizes[stackNum - 1];
    }
  
    // indexOfTop - this is helper method for push, pop and peek methods
  
    private int indexOfTop(int stackNum) {
      // TODO
      return topOfStacks[stackNum];
    }
  
    // push
    public void push(int stackNum, int value) {
      // TODO
      if(isFull(stackNum)) {
        System.out.println("stack is full. No Push Operation.");
        return;
      }
      int index = indexOfTop(stackNum);
      System.out.println(index + "....");
      values[index] = value;
      topOfStacks[stackNum] += 1;
      System.out.println(topOfStacks[stackNum] + " ... top");
    }
  
    // pop
    public int pop(int stackNum) {
      // TODO
      if(isEmpty(stackNum)){
        System.out.println("stack is empty.");
        return -1;
      }
      int index = indexOfTop(stackNum) - 1;
      int result = values[index];
      if(topOfStacks[stackNum] - 1 != sizes[stackNum - 1]){
        topOfStacks[stackNum] -= 1; 
      }
      return result;
    }
  
    // peek
  
    public int peek(int stackNum) {
      // TODO
      if(isEmpty(stackNum)) {
        System.out.println("stack is empty");
        return -1;
      }
      int index = indexOfTop(stackNum);
      return values[index - 1];
    }

    public void print(){
        for(int i = 0; i < stackCapacity; i++){
            System.out.print(values[i] + ", ");
        }
        System.out.println();
    }
  
    public void printArray(){
        for(int i = 0; i < topOfStacks.length; i++){
            System.out.print(topOfStacks[i] + ", ");
        }System.out.println();
    }
  }
  
