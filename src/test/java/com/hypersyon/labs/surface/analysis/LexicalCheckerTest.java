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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;

/**
 * Unit test for LexicalChecker.
 *
 * @author Carlos Uribe [carlos.uribe@hypersyon.com]
 * @version 1.0
 */
public class LexicalCheckerTest extends TestCase {
  
  public LexicalCheckerTest(String testName) {
    super(testName);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }
  
  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test of findDuplicates method, of class LexicalChecker.
   */
  public void testFindDuplicates() {
    System.out.println("findDuplicates");
    
    List<String> elements = new ArrayList<>();
    elements.add("foo");
    elements.add("bar");
    elements.add("abc");
    elements.add("foo");
    elements.add("cde");
    elements.add("cde");
    elements.add("efg");
    elements.add("cde");
    
    Set<String> expResult = new LinkedHashSet<>();
    expResult.add("foo");
    
    LexicalChecker instance = new LexicalChecker();
    Set<String> result = instance.findDuplicates(elements);
    
    assertNotSame(expResult, result);
    
    expResult.add("cde");
    assertEquals(expResult, result);
  }
}
