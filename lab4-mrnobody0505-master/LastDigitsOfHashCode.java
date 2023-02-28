/**
 * A transformer with a parameter k that takes in an object x 
 * and outputs the last k digits of the hash value of x.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */
public class LastDigitsOfHashCode implements Transformer<Object, Integer> {

  private Integer k;

  public LastDigitsOfHashCode(Integer k) {
    this.k = k;
  }

  @Override
  public Integer transform(Object obj) {
    Integer hs = obj.hashCode();
    Integer divisor = (int) Math.pow(10, this.k.intValue());
    if (hs / divisor == 0) {
      return 0;
    }
    return Math.absExact(hs % divisor);
  }
}
