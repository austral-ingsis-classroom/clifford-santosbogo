package edu.austral.ingsis.clifford.structure;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Rm;

public class RmStructure implements Structure {
  private final FileSystem fileSystem;

  public RmStructure(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String[] command = commandLine.split(" ");
    if (command.length == 2) {
      return new Rm(fileSystem.getCurrent(), command[1], false);
    } else if (command.length == 3 && command[1].equals("--recursive")) {
      return new Rm(fileSystem.getCurrent(), command[2], true);
    }
    return new Rm(fileSystem.getCurrent(), "", false);
  }
}
