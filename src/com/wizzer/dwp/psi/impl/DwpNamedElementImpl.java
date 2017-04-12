package com.wizzer.dwp.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.wizzer.dwp.psi.DwpNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class DwpNamedElementImpl extends ASTWrapperPsiElement implements DwpNamedElement {
  public DwpNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }
}