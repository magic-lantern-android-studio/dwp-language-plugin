package com.wizzer.dwp.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.wizzer.dwp.DwpFileType;

public class DwpElementFactory {
  public static DwpProperty createProperty(Project project, String name, String value) {
    final DwpFile file = createFile(project, name + " = " + value);
    return (DwpProperty) file.getFirstChild();
  }

  public static DwpProperty createProperty(Project project, String name) {
    final DwpFile file = createFile(project, name);
    return (DwpProperty) file.getFirstChild();
  }

  public static PsiElement createCRLF(Project project) {
    final DwpFile file = createFile(project, "\n");
    return file.getFirstChild();
  }

  public static DwpFile createFile(Project project, String text) {
    String name = "dummy.dwp";
    return (DwpFile) PsiFileFactory.getInstance(project).
        createFileFromText(name, DwpFileType.INSTANCE, text);
  }
}