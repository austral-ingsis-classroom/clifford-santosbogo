package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.components.Component;
import edu.austral.ingsis.clifford.components.Directory;
import edu.austral.ingsis.clifford.components.File;

public class Touch implements Command {
  private final String name;
  private final Directory current;

  public Touch(String name, Directory current) {
    this.name = name;
    this.current = current;
  }

  @Override
  public String execute() {
    if (name.contains("/") || name.contains(" ")) {
      return "touch: invalid file name";
    }
    for (Component child : current.getChildren()) {
      if (child.getName().equals(name)) {
        current.remove(child.getName());
        break;
      }
    }
    current.add(new File(name, current));
    return "'" + name + "' file created";
  }
}
