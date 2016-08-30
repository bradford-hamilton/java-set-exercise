package main;

public class Set {

  private boolean isEmpty = true;
  private int size = 0;
  private int[] myIntArray = new int[100];
  private int currentIndex = 0;

  public boolean IsEmpty() {
    return isEmpty;
  }

  public boolean Add(int value) {
    boolean contains = Contains(value);
    if (!contains) {
      myIntArray[currentIndex] = value;
      currentIndex++;
      isEmpty = false;
      size++;
      return false;
    }
    return true;
  }

  public int Size() {
    return size;
  }

  public boolean Contains(int value) {
    for (int i = 0; i < currentIndex; i++) {
      if ( myIntArray[i] == value ) {
        return true;
      }
    }
    return false;
  }

  public boolean Remove(int value) {
    int foundIndex = -1;
    for (int i = 0; i < currentIndex; i++) {
      if ( myIntArray[i] == value ) {
        foundIndex = i;
        break;
      }
    }
    if ( foundIndex == -1 ) {
      return false;
    } else {
      for (int i = foundIndex; i < currentIndex; i++) {
        myIntArray[i] = myIntArray[i + 1];
      }
      size--;
      currentIndex--;
      return true;
    }
  }

  public void Clear() {

  }

  public int[] Enumerate() {
    int[] values = new int[currentIndex];
    for (int i = 0; i < currentIndex; i++) {
      values[i] = this.myIntArray[i];
    }
    return values;
  }

}
