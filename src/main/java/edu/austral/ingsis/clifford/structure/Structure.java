package edu.austral.ingsis.clifford.structure;

import edu.austral.ingsis.clifford.commands.Command;

public interface Structure {
  Command build(String command);
}
