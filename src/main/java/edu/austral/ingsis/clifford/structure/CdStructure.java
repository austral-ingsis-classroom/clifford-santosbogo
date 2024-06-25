package edu.austral.ingsis.clifford.structure;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Cd;
import edu.austral.ingsis.clifford.commands.Command;

public class CdStructure implements Structure {
  private final FileSystem fileSystem;

  public CdStructure(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String command) {
    String path = command.split(" ")[1];
    return new Cd(fileSystem, path);
  }
}
