package com.gyomu.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

class InnerField extends JTextField {
  private JPanel parent;
  public String defaultText;
  private boolean blocked;

  public InnerField (String defaultText) {
    this.parent = null;
    this.defaultText = defaultText;
    this.blocked = false;
    setdefault();

    addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if (blocked) {
          setText("");
          setForeground(Color.BLACK);
          blocked = false;
        }
      }

      @Override
      public void focusLost(FocusEvent e) {
        setdefault();
      }
    });
  }

  private void setdefault () {
    if (getText().isBlank() && !blocked) {
      setForeground(Color.GRAY);
      setText(defaultText);
      blocked = true;
    }
  }

  public void setParent (JPanel parent) {
    this.parent = parent;
  }

  @Override
  public String getText() {
    String ret = super.getText();
    if (ret.equals(this.defaultText))
      ret = "";
    return ret.strip();
  }

  public int getInt () {
    int ret = 0;
    try {
      ret = Integer.parseInt(this.getText());
    } catch (NumberFormatException e) {}
    return ret;
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension dim = super.getPreferredSize();
    if (this.parent != null)
      dim.setSize(this.parent.getWidth() * 0.7, dim.getHeight());
    return dim;
  }
}