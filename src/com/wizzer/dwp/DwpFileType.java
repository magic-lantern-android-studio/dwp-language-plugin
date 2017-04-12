package com.wizzer.dwp;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class DwpFileType extends LanguageFileType {
  public static final DwpFileType INSTANCE = new DwpFileType();

  private DwpFileType() {
    super(DwpLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "DigitalWorkprint file";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "DigitalWorkprint language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "dwp";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return DwpIcons.FILE;
  }
}