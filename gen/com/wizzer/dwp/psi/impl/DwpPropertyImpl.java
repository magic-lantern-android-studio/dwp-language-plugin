// This is a generated file. Not intended for manual editing.
package com.wizzer.dwp.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.wizzer.dwp.psi.DwpTypes.*;
import com.wizzer.dwp.psi.*;
import com.intellij.navigation.ItemPresentation;

public class DwpPropertyImpl extends DwpNamedElementImpl implements DwpProperty {

  public DwpPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull DwpVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DwpVisitor) accept((DwpVisitor)visitor);
    else super.accept(visitor);
  }

  public String getKey() {
    return DwpPsiImplUtil.getKey(this);
  }

  public String getValue() {
    return DwpPsiImplUtil.getValue(this);
  }

  public String getName() {
    return DwpPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return DwpPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return DwpPsiImplUtil.getNameIdentifier(this);
  }

  public ItemPresentation getPresentation() {
    return DwpPsiImplUtil.getPresentation(this);
  }

}
