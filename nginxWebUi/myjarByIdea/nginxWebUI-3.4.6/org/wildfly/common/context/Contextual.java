package org.wildfly.common.context;

import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import org.wildfly.common.Assert;
import org.wildfly.common._private.CommonMessages;
import org.wildfly.common.annotation.NotNull;
import org.wildfly.common.function.ExceptionBiConsumer;
import org.wildfly.common.function.ExceptionBiFunction;
import org.wildfly.common.function.ExceptionBiPredicate;
import org.wildfly.common.function.ExceptionConsumer;
import org.wildfly.common.function.ExceptionFunction;
import org.wildfly.common.function.ExceptionIntFunction;
import org.wildfly.common.function.ExceptionLongFunction;
import org.wildfly.common.function.ExceptionPredicate;

public interface Contextual<C extends Contextual<C>> {
   @NotNull
   ContextManager<C> getInstanceContextManager();

   default void run(Runnable runnable) {
      Assert.checkNotNullParam("runnable", runnable);
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      try {
         runnable.run();
      } finally {
         contextManager.restoreCurrent(old);
      }

   }

   default <R> R runAction(PrivilegedAction<R> action) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var4;
      try {
         var4 = action.run();
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var4;
   }

   default <R> R runExceptionAction(PrivilegedExceptionAction<R> action) throws PrivilegedActionException {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var4;
      try {
         var4 = action.run();
      } catch (Exception var8) {
         throw CommonMessages.msg.privilegedActionFailed(var8);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var4;
   }

   default <V> V runCallable(Callable<V> callable) throws Exception {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var4;
      try {
         var4 = callable.call();
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var4;
   }

   default <T, U> void runBiConsumer(BiConsumer<T, U> consumer, T param1, U param2) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      try {
         consumer.accept(param1, param2);
      } finally {
         contextManager.restoreCurrent(old);
      }

   }

   default <T, U, E extends Exception> void runExBiConsumer(ExceptionBiConsumer<T, U, E> consumer, T param1, U param2) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      try {
         consumer.accept(param1, param2);
      } finally {
         contextManager.restoreCurrent(old);
      }

   }

   default <T> void runConsumer(Consumer<T> consumer, T param) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      try {
         consumer.accept(param);
      } finally {
         contextManager.restoreCurrent(old);
      }

   }

   default <T, E extends Exception> void runExConsumer(ExceptionConsumer<T, E> consumer, T param) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      try {
         consumer.accept(param);
      } finally {
         contextManager.restoreCurrent(old);
      }

   }

   default <T, U, R> R runBiFunction(BiFunction<T, U, R> function, T param1, U param2) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var6;
      try {
         var6 = function.apply(param1, param2);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var6;
   }

   default <T, U, R, E extends Exception> R runExBiFunction(ExceptionBiFunction<T, U, R, E> function, T param1, U param2) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var6;
      try {
         var6 = function.apply(param1, param2);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var6;
   }

   default <T, R> R runFunction(Function<T, R> function, T param) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var5;
      try {
         var5 = function.apply(param);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var5;
   }

   default <T, R, E extends Exception> R runExFunction(ExceptionFunction<T, R, E> function, T param) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var5;
      try {
         var5 = function.apply(param);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var5;
   }

   default <T, U> boolean runBiPredicate(BiPredicate<T, U> predicate, T param1, U param2) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      boolean var6;
      try {
         var6 = predicate.test(param1, param2);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var6;
   }

   default <T, U, E extends Exception> boolean runExBiPredicate(ExceptionBiPredicate<T, U, E> predicate, T param1, U param2) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      boolean var6;
      try {
         var6 = predicate.test(param1, param2);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var6;
   }

   default <T> boolean runPredicate(Predicate<T> predicate, T param) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      boolean var5;
      try {
         var5 = predicate.test(param);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var5;
   }

   default <T, E extends Exception> boolean runExPredicate(ExceptionPredicate<T, E> predicate, T param) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      boolean var5;
      try {
         var5 = predicate.test(param);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var5;
   }

   default <T> T runIntFunction(IntFunction<T> function, int value) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var5;
      try {
         var5 = function.apply(value);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var5;
   }

   default <T, E extends Exception> T runExIntFunction(ExceptionIntFunction<T, E> function, int value) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var5;
      try {
         var5 = function.apply(value);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var5;
   }

   default <T> T runLongFunction(LongFunction<T> function, long value) {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var6;
      try {
         var6 = function.apply(value);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var6;
   }

   default <T, E extends Exception> T runExLongFunction(ExceptionLongFunction<T, E> function, long value) throws E {
      ContextManager<C> contextManager = this.getInstanceContextManager();
      C old = contextManager.getAndSetCurrent(this);

      Object var6;
      try {
         var6 = function.apply(value);
      } finally {
         contextManager.restoreCurrent(old);
      }

      return var6;
   }
}
