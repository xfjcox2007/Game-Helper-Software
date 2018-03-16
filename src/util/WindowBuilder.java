package util;

public interface WindowBuilder<T> {
  WindowBuilder<T> addPerson(String name, int level, int blue, int yellow, int pink, int green);

  T build();
}
