package com.wizzer.dwp;

import com.intellij.lang.Language;

public class DwpLanguage extends Language {
  public static final DwpLanguage INSTANCE = new DwpLanguage();

  private DwpLanguage() {
    super("DigitalWorkprint");
  }
}