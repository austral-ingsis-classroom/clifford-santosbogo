package edu.austral.ingsis.clifford.components;

public interface Component {
  String getName();

  Component getParent();

  boolean isComposite();
}
