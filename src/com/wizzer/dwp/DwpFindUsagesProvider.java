package com.wizzer.dwp;

import com.intellij.lang.cacheBuilder.*;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.*;
import com.intellij.psi.tree.TokenSet;
import com.wizzer.dwp.psi.DwpProperty;
import com.wizzer.dwp.psi.DwpTypes;
import org.jetbrains.annotations.*;

public class DwpFindUsagesProvider implements FindUsagesProvider {
  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner(new DwpLexerAdapter(),
                                   TokenSet.create(DwpTypes.KEY),
                                   TokenSet.create(DwpTypes.COMMENT),
                                   TokenSet.EMPTY);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof PsiNamedElement;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof DwpProperty) {
      return "dwp property";
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof DwpProperty) {
      return ((DwpProperty) element).getKey();
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof DwpProperty) {
      return ((DwpProperty) element).getKey() + ":" + ((DwpProperty) element).getValue();
    } else {
      return "";
    }
  }
}
