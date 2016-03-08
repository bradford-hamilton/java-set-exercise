package main;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SetTest {

  @Test
  public void setWithSingleItemIsNotEmpty() {
    Set set = new Set();
    set.Add(42);
    Assert.assertEquals(false, set.IsEmpty());
  }

  @Test
  public void setWithTwoItemsIsNotEmpty() {
    Set set = new Set();
    set.Add(42);
    set.Add(13);
    Assert.assertEquals(false, set.IsEmpty());
  }

  @Test
  public void setKeepsTrackOfNumberOfItems() {
    Set set = new Set();
    set.Add(42);
    set.Add(13);
    set.Add(7);
    Assert.assertEquals(3, set.Size());
  }

  @Test
  public void duplicateItemsDoNotIncreseSize() {
    Set set = new Set();
    set.Add(42);
    set.Add(42);
    set.Add(42);
    Assert.assertEquals(1, set.Size());
  }

  @Test
  public void canSearchForItemsInSet() {
    Set set = new Set();
    set.Add(42);
    Assert.assertEquals(true, set.Contains(42));
    Assert.assertEquals(false, set.Contains(7));
  }

  @Test
  public void removingItemCannotBeFound() {
    Set set = new Set();
    set.Add(42);
    set.Add(13);
    set.Add(7);
    Assert.assertEquals(true, set.Contains(13));
    set.Remove(13);
    Assert.assertEquals(false, set.Contains(13));
  }

  @Test
  public void removingItemDecreasesSize() {
    Set set = new Set();
    set.Add(42);
    set.Add(13);
    set.Add(7);
    Assert.assertEquals(3, set.Size());
    set.Remove(7);
    Assert.assertEquals(2, set.Size());
  }

  @Test
  public void canEnumarateArrayFromSet() {
    Set set = new Set();
    set.Add(42);
    set.Add(13);
    set.Add(7);
    int[] values = set.Enumerate();
    Assert.assertEquals(values.length, set.Size());
    Assert.assertEquals(true, arrayContains(values, 42));
    Assert.assertEquals(true, arrayContains(values, 13));
    Assert.assertEquals(true, arrayContains(values, 7));
  }

  public static boolean arrayContains(int[] arr, int value) {
  	for(int i: arr){
  		if(i == value)
  			return true;
  	}
  	return false;
  }

}
