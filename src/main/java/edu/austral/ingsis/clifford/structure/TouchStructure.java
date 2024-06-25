package edu.austral.ingsis.clifford.structure;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Touch;

public class TouchStructure implements Structure {
  private final FileSystem fileSystem;

  public TouchStructure(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String command) {
    String name = command.split(" ")[1];
    return new Touch(name, fileSystem.getCurrent());
  }
}
