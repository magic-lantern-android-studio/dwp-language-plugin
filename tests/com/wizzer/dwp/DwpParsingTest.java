package com.wizzer.dwp;

import com.intellij.testFramework.ParsingTestCase;

public class DwpParsingTest extends ParsingTestCase {
  public DwpParsingTest() {
    super("", "dwp", new DwpParserDefinition());
  }

  public void testParsingTestData() {
    doTest(true);
  }

  @Override
  protected String getTestDataPath() {
    return "code_samples/dwp_language_plugin/testData";
  }

  @Override
  protected boolean skipSpaces() {
    return false;
  }

  @Override
  protected boolean includeRanges() {
    return true;
  }
}
