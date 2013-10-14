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
package com.hypersyon.labs.surface.analysis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Word checks and lexical rules.
 *
 * @author Carlos Uribe [carlos.uribe@hypersyon.com]
 * @version 1.0
 */
public class LexicalChecker {
  
  public <T> Set<T> findDuplicates(Collection<T> elements) {
    Set<T> duplicates = new HashSet<>();
    Set<T> uniques = new HashSet<>();
    
    for (T element : elements) {
      if (!uniques.add(element)) {
        duplicates.add(element);
      }
    }
    
    return duplicates;
  }
}
