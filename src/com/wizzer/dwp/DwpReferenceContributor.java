package com.wizzer.dwp;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class DwpReferenceContributor extends PsiReferenceContributor {
  @Override
  public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
    registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                                        new PsiReferenceProvider() {
                                          @NotNull
                                          @Override
                                          public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                                                       @NotNull ProcessingContext
                                                                                           context) {
                                            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
                                            String value = literalExpression.getValue() instanceof String ?
                                                (String) literalExpression.getValue() : null;
                                            if (value != null && value.startsWith("dwp" + ":")) {
                                              return new PsiReference[]{
                                                  new DwpReference(element, new TextRange(5, value.length() + 1))};
                                            }
                                            return PsiReference.EMPTY_ARRAY;
                                          }
                                        });
  }
}
