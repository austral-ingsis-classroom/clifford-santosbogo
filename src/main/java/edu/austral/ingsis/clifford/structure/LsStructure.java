package edu.austral.ingsis.clifford.structure;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Ls;

public class LsStructure implements Structure {
  private final FileSystem fileSystem;

  public LsStructure(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String command) {
    String[] parts = command.split(" ");
    if (parts.length == 2) {
      return new Ls(fileSystem.getCurrent(), parts[1].split("=")[1]);
    } else {
      return new Ls(fileSystem.getCurrent());
    }
  }
}
