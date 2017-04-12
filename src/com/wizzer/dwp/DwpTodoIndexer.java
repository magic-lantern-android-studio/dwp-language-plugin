package com.wizzer.dwp;

import com.intellij.lexer.Lexer;
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer;
import com.intellij.psi.impl.cache.impl.todo.LexerBasedTodoIndexer;

public class DwpTodoIndexer extends LexerBasedTodoIndexer {
  @Override
  public Lexer createLexer(OccurrenceConsumer consumer) {
    return DwpIdIndexer.createIndexingLexer(consumer);
  }
}
