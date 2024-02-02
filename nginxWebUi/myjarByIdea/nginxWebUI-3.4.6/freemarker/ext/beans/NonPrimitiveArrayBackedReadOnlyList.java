package freemarker.ext.beans;

import java.util.AbstractList;

class NonPrimitiveArrayBackedReadOnlyList extends AbstractList {
   private final Object[] array;

   NonPrimitiveArrayBackedReadOnlyList(Object[] array) {
      this.array = array;
   }

   public Object get(int index) {
      return this.array[index];
   }

   public int size() {
      return this.array.length;
   }
}
