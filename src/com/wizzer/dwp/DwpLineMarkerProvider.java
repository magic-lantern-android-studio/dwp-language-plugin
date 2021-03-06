package com.wizzer.dwp;

import com.intellij.codeInsight.daemon.*;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.wizzer.dwp.psi.DwpProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DwpLineMarkerProvider extends RelatedItemLineMarkerProvider {
  @Override
  protected void collectNavigationMarkers(@NotNull PsiElement element,
                                          Collection<? super RelatedItemLineMarkerInfo> result) {
    if (element instanceof PsiLiteralExpression) {
      PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
      String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
      if (value != null && value.startsWith("dwp" + ":")) {
        Project project = element.getProject();
        final List<DwpProperty> properties = DwpUtil.findProperties(project, value.substring(4));
        if (properties.size() > 0) {
          NavigationGutterIconBuilder<PsiElement> builder =
              NavigationGutterIconBuilder.create(DwpIcons.FILE).
                  setTargets(properties).
                                             setTooltipText("Navigate to a dwp property");
          result.add(builder.createLineMarkerInfo(element));
        }
      }
    }
  }
}
