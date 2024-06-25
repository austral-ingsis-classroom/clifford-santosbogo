// In LsCommand.java
package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.components.Component;
import edu.austral.ingsis.clifford.components.Directory;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ls implements Command {
  private final Directory current;
  private final String order;

  public Ls(Directory current, String order) {
    this.current = current;
    this.order = order;
  }

  public Ls(Directory current) {
    this.current = current;
    this.order = null;
  }

  @Override
  public String execute() {
    List<Component> components = current.getChildren();
    if (order != null) {
      Comparator<Component> comparator =
          order.equals("asc")
              ? Comparator.comparing(Component::getName)
              : Comparator.comparing(Component::getName).reversed();
      components = components.stream().sorted(comparator).toList();
    }
    return components.stream().map(Component::getName).collect(Collectors.joining(" "));
  }
}
