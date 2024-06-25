package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.structure.*;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.components.Directory;
import java.util.HashMap;
import java.util.Map;

public class MyFileSystem implements FileSystem {
  private final Directory root;
  private Directory current;
  private final Map<String, Structure> commands;

  public MyFileSystem() {
    this.root = new Directory("/", null);
    this.current = root;
    this.commands = makeCommands();
  }

  private Map<String, Structure> makeCommands() {
    Map<String, Structure> map = new HashMap<>();
    map.put("cd", new CdStructure(this));
    map.put("ls", new LsStructure(this));
    map.put("pwd", new PwdStructure(this));
    map.put("mkdir", new MkdirStructure(this));
    map.put("rm", new RmStructure(this));
    map.put("touch", new TouchStructure(this));
    return map;
  }

  @Override
  public void setCurrent(Directory current) {
    this.current = current;
  }

  @Override
  public Directory getCurrent() {
    return current;
  }

  @Override
  public Directory getRoot() {
    return root;
  }

  @Override
  public String executeCommand(String command) {
    String commandName = command.split(" ")[0];
    Command commandToExecute = commands.get(commandName).build(command);
    return commandToExecute.execute();
  }
}
