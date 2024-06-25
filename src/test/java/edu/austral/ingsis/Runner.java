package edu.austral.ingsis;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.ArrayList;
import java.util.List;

public class Runner implements FileSystemRunner {
  private final FileSystem fileSystem;

  public Runner(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> results = new ArrayList<>();
    for (String command : commands) {
      String result = fileSystem.executeCommand(command);
      results.add(result);
    }
    return results;
  }
}
