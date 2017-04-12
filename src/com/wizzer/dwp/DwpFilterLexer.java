package com.wizzer.dwp;

import com.intellij.lexer.Lexer;
import com.intellij.psi.impl.cache.impl.*;
import com.intellij.psi.search.UsageSearchContext;

public class DwpFilterLexer extends BaseFilterLexer {
  public DwpFilterLexer(final Lexer originalLexer, final OccurrenceConsumer table) {
    super(originalLexer, table);
  }

  @Override
  public void advance() {
    scanWordsInToken(UsageSearchContext.IN_COMMENTS, false, false);
    advanceTodoItemCountsInToken();
    myDelegate.advance();
  }
}
