/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class ReflectionUtils {
  private ReflectionUtils() {}

  public static String getStringValueOfField(Field f) throws IllegalAccessException {
    switch (f.getType().getName()) {
    case "java.lang.String":
      return (String) f.get(null);
    case "short":
      short shValue = (short) f.get(null);
      return Integer.toString(shValue);
    case "int":
      int iValue = (int) f.get(null);
      return Integer.toString(iValue);
    case "long":
      long lValue = (long) f.get(null);
      return Long.toString(lValue);
    case "float":
      float fValue = (float) f.get(null);
      return Float.toString(fValue);
    case "double":
      double dValue = (double) f.get(null);
      return Double.toString(dValue);
    case "boolean":
      boolean bValue = (boolean) f.get(null);
      return Boolean.toString(bValue);
    default:
      return null;
    }
  }

  public static <T> void setFinalField(
          Class<T> type, final T obj, final String fieldName, Object value)
          throws ReflectiveOperationException {
    Field f = type.getDeclaredField(fieldName);
    f.setAccessible(true);
    Field modifiersField = ReflectionUtils.getModifiersField();
    modifiersField.setAccessible(true);
    modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
    f.set(obj, value);
  }

  public static Field getModifiersField() throws ReflectiveOperationException {
    Method getDeclaredFields0 = Class.class.getDeclaredMethod("getDeclaredFields0", boolean.class);
    getDeclaredFields0.setAccessible(true);
    Field[] fields = (Field[]) getDeclaredFields0.invoke(Field.class, false);
    for (Field each : fields) {
      if ("modifiers".equals(each.getName())) {
        return each;
      }
    }
    throw new UnsupportedOperationException();
  }
}
