/**
 * Takes an item and return the item in a box.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */
public class BoxIt<T> implements Transformer<T, Box<T>> {

  @Override
  public Box<T> transform(T t) {
    return Box.of(t);
  }  

}
