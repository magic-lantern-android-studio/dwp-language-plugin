package com.wizzer.dwp;

import com.intellij.lexer.Lexer;
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer;
import com.intellij.psi.impl.cache.impl.id.LexerBasedIdIndexer;

public class DwpIdIndexer extends LexerBasedIdIndexer {

  public static Lexer createIndexingLexer(OccurrenceConsumer consumer) {
    return new DwpFilterLexer(new DwpLexerAdapter(), consumer);
  }

  @Override
  public Lexer createLexer(final OccurrenceConsumer consumer) {
    return createIndexingLexer(consumer);
  }
}
