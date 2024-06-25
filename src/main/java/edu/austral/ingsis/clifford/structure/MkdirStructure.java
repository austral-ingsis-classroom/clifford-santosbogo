package edu.austral.ingsis.clifford.structure;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Mkdir;

public class MkdirStructure implements Structure {
  private final FileSystem fileSystem;

  public MkdirStructure(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String command) {
    return new Mkdir(fileSystem.getCurrent(), command.split(" ")[1]);
  }
}
