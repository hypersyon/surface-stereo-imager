/*
 * Copyright (C) 2013-present Hypersyon.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hypersyon.labs.surface.analysis.data;

import java.text.Collator;
import java.util.Locale;

/**
 * Element of analysis.
 *
 * @author Carlos Uribe [carlos.uribe@hypersyon.com]
 * @version 1.0
 */
public class Surface implements Comparable<Surface> {

  private Locale locale;
  private String sourceFile;
  private String line;

  public Surface(Locale locale, String sourceFile, String line) {
    this.locale = locale;
    this.sourceFile = sourceFile;
    this.line = line;
  }
  
  public Surface(String sourceFile, String line) {
    this.locale = Locale.ENGLISH;
    this.sourceFile = sourceFile;
    this.line = line;
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public String getSourceFile() {
    return sourceFile;
  }

  public void setSourceFile(String sourceFile) {
    this.sourceFile = sourceFile;
  }

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  @Override
  public int compareTo(Surface surface) {
    Collator collator = Collator.getInstance(locale);
    return collator.compare(line, surface.line);
  }
}
