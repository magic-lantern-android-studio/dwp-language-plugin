package com.wizzer.dwp.psi;

import com.intellij.psi.tree.IElementType;
import com.wizzer.dwp.DwpLanguage;
import org.jetbrains.annotations.*;

public class DwpTokenType extends IElementType {
  public DwpTokenType(@NotNull @NonNls String debugName) {
    super(debugName, DwpLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "DwpTokenType." + super.toString();
  }
}