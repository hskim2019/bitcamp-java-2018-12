package algorithm.data_structure.arry;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import algorithm.data_structure.array.ArrayList;

public class ArrayListTest {
  
  @Test
  // @test => alt + / => org.junit 
  public void testAdd() {
    ArrayList list = new ArrayList();
    list.add(100); // list.add(Integer.valueOf(100)) : 오토박싱
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(6, list.size());  //(기대하는 값 6, 실제 값 size)
  }
  
  @Test //test 수행할 때 이 메서드를 호출하라는 뜻
  public void testList() {
    ArrayList list = new ArrayList();
    list.add(100); // list.add(Integer.valueOf(100)) : 오토박싱
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertArrayEquals(new Object[] {100,200,300,400,500,600}, list.toArray());
  }
  
  @Test //test 수행할 때 이 메서드를 호출하라는 뜻
  public void testInsert() {
    ArrayList list = new ArrayList();
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    list.insert(2, 55); //2번째에 55를 넣어라 
    assertArrayEquals(new Object[] {100,200,55,300,400,500,600}, list.toArray());
  }
  
  @Test //test 수행할 때 이 메서드를 호출하라는 뜻
  public void testGet() {
    ArrayList list = new ArrayList();
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(100, list.get(0)); //예상되는 값 100, 실제값 get()메서드에서 0번째 인덱스 값
    assertEquals(300, list.get(2));
    assertEquals(600, list.get(5));
    assertNull(list.get(-1));
    assertNull(list.get(6));
  }
  
  @Test //test 수행할 때 이 메서드를 호출하라는 뜻
  public void testSet() {
    ArrayList list = new ArrayList();
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(300, list.set(2, 55)); // 2번 인덱스에 55 넣음. return된 old값이 300인지 확인
    assertEquals(55, list.get(2));     // 55로 바뀌었는지 확인
  }
  
  @Test //test 수행할 때 이 메서드를 호출하라는 뜻
  public void testRemove() {
    ArrayList list = new ArrayList();
    list.add(100); 
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(300, list.remove(2)); 
    assertEquals(5, list.size());
    assertArrayEquals(new Object[] {100,200,400,500,600}, list.toArray());
    
    assertEquals(500, list.remove(3));
    assertEquals(4, list.size());
    assertArrayEquals(new Object[] {100,200,400,600}, list.toArray());
    
    }
}
