package ch.qos.logback.core.boolex;

import ch.qos.logback.core.spi.ContextAwareBase;

public abstract class EventEvaluatorBase<E> extends ContextAwareBase implements EventEvaluator<E> {
   String name;
   boolean started;

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      if (this.name != null) {
         throw new IllegalStateException("name has been already set");
      } else {
         this.name = name;
      }
   }

   public boolean isStarted() {
      return this.started;
   }

   public void start() {
      this.started = true;
   }

   public void stop() {
      this.started = false;
   }
}
