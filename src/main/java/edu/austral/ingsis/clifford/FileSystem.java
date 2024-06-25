package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.components.Directory;

public interface FileSystem {
  void setCurrent(Directory current);

  Directory getCurrent();

  Directory getRoot();

  String executeCommand(String command);
}
