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

import com.hypersyon.labs.surface.analysis.data.Surface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Laboratory tool for QoD (Quality of Data) analysis on the surface.
 *
 * @author Carlos Uribe [carlos.uribe@hypersyon.com]
 * @version 1.0
 */
public class SurfaceStereoImager {
  
  public static void main(String[] args) {
    for (Surface surface : mergeAndSort(args)) {
      System.out.println(surface.getSourceFile() + ": " + surface.getLine());
    }
  }

  public static List<Surface> mergeAndSort(String... filepaths) {
    List<Surface> list = new ArrayList<>();

    for (String filepath : filepaths) {
      list.addAll(loadFile(filepath));
    }
    
    Collections.sort(list);
    return list;
  }

  public static List<Surface> loadFile(String filepath) {
    List<Surface> lines = new ArrayList<>();

    try {
      File file = new File(filepath);
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;

      while ((line = reader.readLine()) != null) {
        lines.add(new Surface(file.getName(), line));
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(SurfaceStereoImager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(SurfaceStereoImager.class.getName()).log(Level.SEVERE, null, ex);
    }

    return lines;
  }
}
