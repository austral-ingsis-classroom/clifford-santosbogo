package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.components.Component;

public class Pwd implements Command {
  private final Component current;

  public Pwd(Component current) {
    this.current = current;
  }

  @Override
  public String execute() {
    return getPath(current);
  }

  private String getPath(Component component) {
    if (component.getParent() == null) {
      return "";
    }
    return getPath(component.getParent()) + "/" + component.getName();
  }
}
