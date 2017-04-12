package com.wizzer.dwp.psi;

import com.intellij.psi.tree.IElementType;
import com.wizzer.dwp.DwpLanguage;
import org.jetbrains.annotations.*;

public class DwpElementType extends IElementType {
  public DwpElementType(@NotNull @NonNls String debugName) {
    super(debugName, DwpLanguage.INSTANCE);
  }
}