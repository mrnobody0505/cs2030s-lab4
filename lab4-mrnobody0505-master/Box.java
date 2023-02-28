/**
 * A generic box storing an item.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Do Gia Hien (L14B)
 */

public class Box<T> {
  
  private final T x;
  private static final Box<?> EMPTY_BOX = new Box<>(null);

  private Box(T x) {
    this.x = x;
  }
  
  public static <T> Box<T> of(T x) {
    if (x == null) {
      return null;
    }
    return new Box<>(x);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || this.x == null) {
      return false;
    }
    if (obj instanceof Box<?>) {
      Box<?> b = (Box<?>) obj;
      if (this.x == b.x) {
        return true;
      }
      return this.x.equals(b.x);
    }
    return false;
  }

  @Override
  public String toString() {
    if (this.x == null) {
      return "[]";
    }
    return "[" + this.x.toString() + "]";
  }

  public static <T> Box<T> empty() {
    @SuppressWarnings("unchecked")
    Box<T> temp = (Box<T>) EMPTY_BOX;
    return temp;
  }

  public static <T> Box<T> ofNullable(T x) {
    if (x == null) {
      return Box.empty();
    }
    return new Box<>(x);
  }

  public boolean isPresent() {
    if (this.x == null) {
      return false;
    }
    return true;
  }

  public Box<T> filter(BooleanCondition<? super T> booleanCondition) {
    if (!this.isPresent() || !booleanCondition.test(this.x)) {
      return this.empty();
    }
    return this;
  }

  public <U> Box<U> map(Transformer<? super  T, ? extends U> t) {
    if (!this.isPresent()) {
      return this.empty();
    }
    U u = t.transform(this.x);
    if (u == null) {
      return this.empty();
    }
    return new Box<>(u);
  }
}
