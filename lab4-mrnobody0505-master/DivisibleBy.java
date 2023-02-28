/**
 * A boolean condition with an integer parameter y that can be 
 * apply to another integer x.  Returns true if x is divisible 
 * by y, false otherwise.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Do Gia Hien (L14B)
 */

public class DivisibleBy implements BooleanCondition<Integer> {

  private Integer i;

  public DivisibleBy(Integer i) {
    this.i = i;
  }

  @Override
  public boolean test(Integer x) {
    return x.intValue() % i.intValue() == 0;
  }
}

