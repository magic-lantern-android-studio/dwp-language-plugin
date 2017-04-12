package com.wizzer.dwp;

import com.intellij.ide.structureView.*;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import com.wizzer.dwp.psi.DwpFile;
import org.jetbrains.annotations.NotNull;

public class DwpStructureViewModel extends StructureViewModelBase implements
    StructureViewModel.ElementInfoProvider {
  public DwpStructureViewModel(PsiFile psiFile) {
    super(psiFile, new DwpStructureViewElement(psiFile));
  }

  @NotNull
  public Sorter[] getSorters() {
    return new Sorter[]{Sorter.ALPHA_SORTER};
  }


  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    return false;
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    return element instanceof DwpFile;
  }
}