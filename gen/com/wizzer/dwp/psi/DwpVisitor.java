// This is a generated file. Not intended for manual editing.
package com.wizzer.dwp.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class DwpVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull DwpProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull DwpNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
