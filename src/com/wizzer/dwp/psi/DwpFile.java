package com.wizzer.dwp.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.wizzer.dwp.*;
import com.wizzer.dwp.DwpFileType;
import com.wizzer.dwp.DwpLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DwpFile extends PsiFileBase {
  public DwpFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, DwpLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return DwpFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "DigitalWorkprint File";
  }

  @Override
  public Icon getIcon(int flags) {
    return super.getIcon(flags);
  }
}