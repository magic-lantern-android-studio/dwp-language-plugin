package com.wizzer.dwp;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class DwpFileTypeFactory extends FileTypeFactory {
  @Override
  public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
    fileTypeConsumer.consume(DwpFileType.INSTANCE, "dwp");
  }
}