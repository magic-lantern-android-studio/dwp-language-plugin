// This is a generated file. Not intended for manual editing.
package com.wizzer.dwp.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.wizzer.dwp.psi.impl.*;

public interface DwpTypes {

  IElementType PROPERTY = new DwpElementType("PROPERTY");

  IElementType COMMENT = new DwpTokenType("COMMENT");
  IElementType KEY = new DwpTokenType("KEY");
  IElementType SEPARATOR = new DwpTokenType("SEPARATOR");
  IElementType VALUE = new DwpTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new DwpPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
