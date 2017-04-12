package com.wizzer.dwp;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class DwpLexerAdapter extends FlexAdapter {
  public DwpLexerAdapter() {
    super(new DwpLexer((Reader) null));
  }
}
