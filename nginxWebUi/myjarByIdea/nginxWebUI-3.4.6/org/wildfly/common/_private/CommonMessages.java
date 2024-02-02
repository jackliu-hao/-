package org.wildfly.common._private;

import java.io.IOException;
import java.security.Permission;
import java.security.PrivilegedActionException;
import org.jboss.logging.Messages;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageBundle;
import org.wildfly.common.codec.DecodeException;

@MessageBundle(
   projectCode = "COM",
   length = 5
)
public interface CommonMessages {
   CommonMessages msg = (CommonMessages)Messages.getBundle(CommonMessages.class);

   @Message(
      id = 0,
      value = "Parameter '%s' may not be null"
   )
   IllegalArgumentException nullParam(String var1);

   @Message(
      id = 1,
      value = "Parameter '%s' must not be less than %d"
   )
   IllegalArgumentException paramLessThan(String var1, long var2);

   IllegalArgumentException paramLessThan(String var1, double var2);

   @Message(
      id = 2,
      value = "Parameter '%s' must not be greater than than %d"
   )
   IllegalArgumentException paramGreaterThan(String var1, long var2);

   IllegalArgumentException paramGreaterThan(String var1, double var2);

   @Message(
      id = 3,
      value = "Given offset of %d is greater than array length of %d"
   )
   ArrayIndexOutOfBoundsException arrayOffsetGreaterThanLength(int var1, int var2);

   @Message(
      id = 4,
      value = "Given offset of %d plus length of %d is greater than array length of %d"
   )
   ArrayIndexOutOfBoundsException arrayOffsetLengthGreaterThanLength(int var1, int var2, int var3);

   @Message(
      id = 5,
      value = "Array index %d of parameter '%s' may not be null"
   )
   IllegalArgumentException nullArrayParam(int var1, String var2);

   @Message(
      id = 6,
      value = "Parameter '%s' may not be null"
   )
   NullPointerException nullParamNPE(String var1);

   @Message(
      id = 7,
      value = "Invalid permission action '%s'"
   )
   IllegalArgumentException invalidPermissionAction(String var1);

   @Message(
      id = 8,
      value = "Parameter '%s' must not be empty"
   )
   IllegalArgumentException emptyParam(String var1);

   @Message(
      id = 9,
      value = "Invalid expression syntax at position %d"
   )
   String invalidExpressionSyntax(int var1);

   @Message(
      id = 10,
      value = "No environment property found named \"%s\""
   )
   IllegalArgumentException unresolvedEnvironmentProperty(String var1);

   @Message(
      id = 11,
      value = "No system property found named \"%s\""
   )
   IllegalArgumentException unresolvedSystemProperty(String var1);

   @Message(
      id = 12,
      value = "Invalid address length of %d; must be 4 or 16"
   )
   IllegalArgumentException invalidAddressBytes(int var1);

   @Message(
      id = 13,
      value = "Invalid address string \"%s\""
   )
   IllegalArgumentException invalidAddress(String var1);

   @Message(
      id = 100,
      value = "Method \"%s\" of class \"%s\" is not implemented"
   )
   UnsupportedOperationException unsupported(String var1, String var2);

   @Message(
      id = 200,
      value = "Privileged action failed"
   )
   PrivilegedActionException privilegedActionFailed(@Cause Exception var1);

   @Message(
      id = 300,
      value = "Permission collection is read-only"
   )
   SecurityException readOnlyPermissionCollection();

   @Message(
      id = 301,
      value = "Invalid permission type (expected %s, actual value was %s)"
   )
   IllegalArgumentException invalidPermissionType(Class<? extends Permission> var1, Class<? extends Permission> var2);

   @Message(
      id = 400,
      value = "Invalid serialized remote exception cause object with odd number of strings in fields key/value list"
   )
   IllegalStateException invalidOddFields();

   @Message(
      id = 401,
      value = "Field name or field value cannot be null"
   )
   IllegalArgumentException cannotContainNullFieldNameOrValue();

   @Message(
      id = 402,
      value = "Remote exception stream is corrupted and cannot be read"
   )
   IOException corruptedStream();

   @Message("Remote exception %s: %s")
   String remoteException(String var1, String var2);

   @Message("Remote exception %s")
   String remoteException(String var1);

   @Message(
      id = 500,
      value = "Unexpected padding"
   )
   DecodeException unexpectedPadding();

   @Message(
      id = 501,
      value = "Expected padding"
   )
   DecodeException expectedPadding();

   @Message(
      id = 502,
      value = "Incomplete decode"
   )
   DecodeException incompleteDecode();

   @Message(
      id = 503,
      value = "Expected %d padding characters"
   )
   DecodeException expectedPaddingCharacters(int var1);

   @Message(
      id = 504,
      value = "Invalid base 32 character"
   )
   DecodeException invalidBase32Character();

   @Message(
      id = 505,
      value = "Expected an even number of hex characters"
   )
   DecodeException expectedEvenNumberOfHexCharacters();

   @Message(
      id = 506,
      value = "Invalid hex character"
   )
   DecodeException invalidHexCharacter();

   @Message(
      id = 507,
      value = "Expected two padding characters"
   )
   DecodeException expectedTwoPaddingCharacters();

   @Message(
      id = 508,
      value = "Invalid base 64 character"
   )
   DecodeException invalidBase64Character();

   @Message(
      id = 509,
      value = "Byte string builder is too large to grow"
   )
   IllegalStateException tooLarge();

   @Message(
      id = 1000,
      value = "Internal error: Assertion failure: Unexpectedly null value"
   )
   String unexpectedNullValue();

   @Message(
      id = 1001,
      value = "Internal error: Assertion failure: Current thread expected to hold lock for %s"
   )
   String expectedLockHold(Object var1);

   @Message(
      id = 1002,
      value = "Internal error: Assertion failure: Current thread expected to not hold lock for %s"
   )
   String expectedLockNotHold(Object var1);

   @Message(
      id = 1003,
      value = "Internal error: Assertion failure: Expected boolean value to be %s"
   )
   String expectedBoolean(boolean var1);

   @Message(
      id = 2000,
      value = "Internal error: Unreachable code has been reached"
   )
   IllegalStateException unreachableCode();

   @Message(
      id = 2001,
      value = "Internal error: Impossible switch condition encountered: %s"
   )
   IllegalStateException impossibleSwitchCase(Object var1);
}
