package com.wizzer.dwp;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.wizzer.dwp.psi.DwpTypes;
import org.jetbrains.annotations.*;

public class DwpFormattingModelBuilder implements FormattingModelBuilder {
  @NotNull
  @Override
  public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
    return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(),
                                                                   new DwpBlock(element.getNode(),
                                                                                   Wrap.createWrap(WrapType.NONE,
                                                                                                   false),
                                                                                   Alignment.createAlignment(),
                                                                                   createSpaceBuilder(settings)),
                                                                   settings);
  }

  private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
    return new SpacingBuilder(settings, DwpLanguage.INSTANCE).
                                                                    around(DwpTypes.SEPARATOR)
                                                                .spaceIf(settings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
                                                                .
                                                                    before(DwpTypes.PROPERTY)
                                                                .none();
  }

  @Nullable
  @Override
  public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
    return null;
  }
}