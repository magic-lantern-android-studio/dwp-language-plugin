package com.wizzer.dwp;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.wizzer.dwp.psi.DwpTypes;
import org.jetbrains.annotations.NotNull;

public class DwpCompletionContributor extends CompletionContributor {
  public DwpCompletionContributor() {
    extend(CompletionType.BASIC,
           PlatformPatterns.psiElement(DwpTypes.VALUE).withLanguage(DwpLanguage.INSTANCE),
           new CompletionProvider<CompletionParameters>() {
             public void addCompletions(@NotNull CompletionParameters parameters,
                                        ProcessingContext context,
                                        @NotNull CompletionResultSet resultSet) {
               resultSet.addElement(LookupElementBuilder.create("Hello"));
             }
           }
    );
  }
}
