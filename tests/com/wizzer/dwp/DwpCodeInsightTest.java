package com.wizzer.dwp;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.codeStyle.CodeStyleSettingsManager;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.containers.ContainerUtil;
import com.wizzer.dwp.psi.DwpProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DwpCodeInsightTest extends LightCodeInsightFixtureTestCase {
  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected String getTestDataPath() {
    return "code_samples/dwp_language_plugin/testData";
  }

  public void testCompletion() {
    myFixture.configureByFiles("CompleteTestData.java", "DefaultTestData.dwp");
    myFixture.complete(CompletionType.BASIC, 1);
    List<String> strings = myFixture.getLookupElementStrings();
    assertTrue(strings.containsAll(Arrays.asList("key with spaces", "language", "message", "tab", "website")));
    assertEquals(5, strings.size());
  }

  public void testAnnotator() {
    myFixture.configureByFiles("AnnotatorTestData.java", "DefaultTestData.dwp");
    myFixture.checkHighlighting(false, false, true, true);
  }

  public void testFormatter() {
    myFixture.configureByFiles("FormatterTestData.dwp");
    CodeStyleSettingsManager.getSettings(getProject()).SPACE_AROUND_ASSIGNMENT_OPERATORS = true;
    CodeStyleSettingsManager.getSettings(getProject()).KEEP_BLANK_LINES_IN_CODE = 2;
    new WriteCommandAction.Simple(getProject()) {
      @Override
      protected void run() throws Throwable {
        CodeStyleManager.getInstance(getProject()).reformatText(myFixture.getFile(),
                ContainerUtil.newArrayList(myFixture.getFile().getTextRange()));
      }
    }.execute();
    myFixture.checkResultByFile("DefaultTestData.dwp");
  }

  public void testRename() {
    myFixture.configureByFiles("RenameTestData.java", "RenameTestData.dwp");
    myFixture.renameElementAtCaret("websiteUrl");
    myFixture.checkResultByFile("RenameTestData.dwp", "RenameTestDataAfter.dwp", false);
  }

  public void testFolding() {
    myFixture.configureByFiles("DefaultTestData.dwp");
    myFixture.testFolding(getTestDataPath() + "/FoldingTestData.java");
  }

  public void testFindUsages() {
    Collection<UsageInfo> usageInfos = myFixture.testFindUsages("FindUsagesTestData.dwp", "FindUsagesTestData.java");
    assertEquals(1, usageInfos.size());
  }

  public void testCommenter() {
    myFixture.configureByText(DwpFileType.INSTANCE, "<caret>website = http://en.wikipedia.org/");
    CommentByLineCommentAction commentAction = new CommentByLineCommentAction();
    commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
    myFixture.checkResult("#website = http://en.wikipedia.org/");
    commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
    myFixture.checkResult("website = http://en.wikipedia.org/");
  }

  public void testReference() {
    myFixture.configureByFiles("ReferenceTestData.java", "DefaultTestData.dwp");
    PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset()).getParent();
    assertEquals("http://en.wikipedia.org/", ((DwpProperty) element.getReferences()[0].resolve()).getValue());
  }
}
