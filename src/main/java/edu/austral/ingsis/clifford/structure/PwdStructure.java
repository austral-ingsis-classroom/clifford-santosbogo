package edu.austral.ingsis.clifford.structure;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;

public class PwdStructure implements Structure {
  private final FileSystem fileSystem;

  public PwdStructure(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String command) {
    return new edu.austral.ingsis.clifford.commands.Pwd(fileSystem.getCurrent());
  }
}
