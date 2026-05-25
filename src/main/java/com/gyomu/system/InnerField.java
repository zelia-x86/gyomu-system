package com.gyomu.system;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

class InnerField extends JTextField {
  private JPanel parent;

  public InnerField () {
    this.parent = null;
  }

  public void setParent (JPanel parent) {
    this.parent = parent;
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension dim = super.getPreferredSize();
    if (this.parent != null)
      dim.setSize(this.parent.getWidth() * 0.7, dim.getHeight());
    return dim;
  }
}