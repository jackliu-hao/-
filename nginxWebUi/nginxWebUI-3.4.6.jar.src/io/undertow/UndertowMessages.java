/*    */ package io.undertow;
/*    */ 
/*    */ import io.undertow.predicate.PredicateBuilder;
/*    */ import io.undertow.protocols.http2.HpackException;
/*    */ import io.undertow.security.api.AuthenticationMechanism;
/*    */ import io.undertow.server.RequestTooBigException;
/*    */ import io.undertow.server.handlers.builder.HandlerBuilder;
/*    */ import io.undertow.server.handlers.form.MultiPartParserDefinition;
/*    */ import io.undertow.util.BadRequestException;
/*    */ import io.undertow.util.HttpString;
/*    */ import io.undertow.util.ParameterLimitException;
/*    */ import io.undertow.util.UrlDecodeException;
/*    */ import java.io.IOException;
/*    */ import java.nio.channels.ClosedChannelException;
/*    */ import java.nio.file.Path;
/*    */ import javax.net.ssl.SSLException;
/*    */ import javax.net.ssl.SSLHandshakeException;
/*    */ import javax.net.ssl.SSLPeerUnverifiedException;
/*    */ import org.jboss.logging.Messages;
/*    */ import org.jboss.logging.annotations.Cause;
/*    */ import org.jboss.logging.annotations.Message;
/*    */ import org.jboss.logging.annotations.MessageBundle;
/*    */ import org.xnio.channels.ReadTimeoutException;
/*    */ import org.xnio.channels.WriteTimeoutException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageBundle(projectCode = "UT")
/*    */ public interface UndertowMessages
/*    */ {
/* 52 */   public static final UndertowMessages MESSAGES = (UndertowMessages)Messages.getBundle(UndertowMessages.class);
/*    */   
/*    */   @Message(id = 1, value = "Maximum concurrent requests must be larger than zero.")
/*    */   IllegalArgumentException maximumConcurrentRequestsMustBeLargerThanZero();
/*    */   
/*    */   @Message(id = 2, value = "The response has already been started")
/*    */   IllegalStateException responseAlreadyStarted();
/*    */   
/*    */   @Message(id = 4, value = "getResponseChannel() has already been called")
/*    */   IllegalStateException responseChannelAlreadyProvided();
/*    */   
/*    */   @Message(id = 5, value = "getRequestChannel() has already been called")
/*    */   IllegalStateException requestChannelAlreadyProvided();
/*    */   
/*    */   @Message(id = 8, value = "Handler cannot be null")
/*    */   IllegalArgumentException handlerCannotBeNull();
/*    */   
/*    */   @Message(id = 9, value = "Path must be specified")
/*    */   IllegalArgumentException pathMustBeSpecified();
/*    */   
/*    */   @Message(id = 10, value = "Session is invalid %s")
/*    */   IllegalStateException sessionIsInvalid(String paramString);
/*    */   
/*    */   @Message(id = 11, value = "Session manager must not be null")
/*    */   IllegalStateException sessionManagerMustNotBeNull();
/*    */   
/*    */   @Message(id = 12, value = "Session manager was not attached to the request. Make sure that the SessionAttachmentHandler is installed in the handler chain")
/*    */   IllegalStateException sessionManagerNotFound();
/*    */   
/*    */   @Message(id = 13, value = "Argument %s cannot be null")
/*    */   IllegalArgumentException argumentCannotBeNull(String paramString);
/*    */   
/*    */   @Message(id = 17, value = "Form value is a file, use getFileItem() instead")
/*    */   IllegalStateException formValueIsAFile();
/*    */   
/*    */   @Message(id = 18, value = "Form value is a String, use getValue() instead")
/*    */   IllegalStateException formValueIsAString();
/*    */   
/*    */   @Message(id = 20, value = "Connection terminated as request was larger than %s")
/*    */   RequestTooBigException requestEntityWasTooLarge(long paramLong);
/*    */   
/*    */   @Message(id = 21, value = "Session already invalidated")
/*    */   IllegalStateException sessionAlreadyInvalidated();
/*    */   
/*    */   @Message(id = 22, value = "The specified hash algorithm '%s' can not be found.")
/*    */   IllegalArgumentException hashAlgorithmNotFound(String paramString);
/*    */   
/*    */   @Message(id = 23, value = "An invalid Base64 token has been received.")
/*    */   IllegalArgumentException invalidBase64Token(@Cause IOException paramIOException);
/*    */   
/*    */   @Message(id = 24, value = "An invalidly formatted nonce has been received.")
/*    */   IllegalArgumentException invalidNonceReceived();
/*    */   
/*    */   @Message(id = 25, value = "Unexpected token '%s' within header.")
/*    */   IllegalArgumentException unexpectedTokenInHeader(String paramString);
/*    */   
/*    */   @Message(id = 26, value = "Invalid header received.")
/*    */   IllegalArgumentException invalidHeader();
/*    */   
/*    */   @Message(id = 27, value = "Could not find session cookie config in the request")
/*    */   IllegalStateException couldNotFindSessionCookieConfig();
/*    */   
/*    */   @Message(id = 29, value = "Channel was closed mid chunk, if you have attempted to write chunked data you cannot shutdown the channel until after it has all been written.")
/*    */   IOException chunkedChannelClosedMidChunk();
/*    */   
/*    */   @Message(id = 30, value = "User %s successfully authenticated.")
/*    */   String userAuthenticated(String paramString);
/*    */   
/*    */   @Message(id = 31, value = "User %s has logged out.")
/*    */   String userLoggedOut(String paramString);
/*    */   
/*    */   @Message(id = 34, value = "Stream is closed")
/*    */   IOException streamIsClosed();
/*    */   
/*    */   @Message(id = 35, value = "Cannot get stream as startBlocking has not been invoked")
/*    */   IllegalStateException startBlockingHasNotBeenCalled();
/*    */   
/*    */   @Message(id = 36, value = "Connection terminated parsing multipart data")
/*    */   IOException connectionTerminatedReadingMultiPartData();
/*    */   
/*    */   @Message(id = 37, value = "Failed to parse path in HTTP request")
/*    */   RuntimeException failedToParsePath();
/*    */   
/*    */   @Message(id = 38, value = "Authentication failed, requested user name '%s'")
/*    */   String authenticationFailed(String paramString);
/*    */   
/*    */   @Message(id = 39, value = "Too many query parameters, cannot have more than %s query parameters")
/*    */   BadRequestException tooManyQueryParameters(int paramInt);
/*    */   
/*    */   @Message(id = 40, value = "Too many headers, cannot have more than %s header")
/*    */   String tooManyHeaders(int paramInt);
/*    */   
/*    */   @Message(id = 41, value = "Channel is closed")
/*    */   ClosedChannelException channelIsClosed();
/*    */   
/*    */   @Message(id = 42, value = "Could not decode trailers in HTTP request")
/*    */   IOException couldNotDecodeTrailers();
/*    */   
/*    */   @Message(id = 43, value = "Data is already being sent. You must wait for the completion callback to be be invoked before calling send() again")
/*    */   IllegalStateException dataAlreadyQueued();
/*    */   
/*    */   @Message(id = 44, value = "More than one predicate with name %s. Builder class %s and %s")
/*    */   IllegalStateException moreThanOnePredicateWithName(String paramString, Class<? extends PredicateBuilder> paramClass1, Class<? extends PredicateBuilder> paramClass2);
/*    */   
/*    */   @Message(id = 45, value = "Error parsing predicated handler string %s:%n%s")
/*    */   IllegalArgumentException errorParsingPredicateString(String paramString1, String paramString2);
/*    */   
/*    */   @Message(id = 46, value = "The number of cookies sent exceeded the maximum of %s")
/*    */   IllegalStateException tooManyCookies(int paramInt);
/*    */   
/*    */   @Message(id = 47, value = "The number of parameters exceeded the maximum of %s")
/*    */   ParameterLimitException tooManyParameters(int paramInt);
/*    */   
/*    */   @Message(id = 48, value = "No request is currently active")
/*    */   IllegalStateException noRequestActive();
/*    */   
/*    */   @Message(id = 50, value = "AuthenticationMechanism Outcome is null")
/*    */   IllegalStateException authMechanismOutcomeNull();
/*    */   
/*    */   @Message(id = 51, value = "Not a valid IP pattern %s")
/*    */   IllegalArgumentException notAValidIpPattern(String paramString);
/*    */   
/*    */   @Message(id = 52, value = "Session data requested when non session based authentication in use")
/*    */   IllegalStateException noSessionData();
/*    */   
/*    */   @Message(id = 53, value = "Listener %s already registered")
/*    */   IllegalArgumentException listenerAlreadyRegistered(String paramString);
/*    */   
/*    */   @Message(id = 54, value = "The maximum size %s for an individual file in a multipart request was exceeded")
/*    */   MultiPartParserDefinition.FileTooLargeException maxFileSizeExceeded(long paramLong);
/*    */   
/*    */   @Message(id = 55, value = "Could not set attribute %s to %s as it is read only")
/*    */   String couldNotSetAttribute(String paramString1, String paramString2);
/*    */   
/*    */   @Message(id = 56, value = "Could not parse URI template %s, exception at char %s")
/*    */   RuntimeException couldNotParseUriTemplate(String paramString, int paramInt);
/*    */   
/*    */   @Message(id = 57, value = "Mismatched braces in attribute string %s")
/*    */   RuntimeException mismatchedBraces(String paramString);
/*    */   
/*    */   @Message(id = 58, value = "More than one handler with name %s. Builder class %s and %s")
/*    */   IllegalStateException moreThanOneHandlerWithName(String paramString, Class<? extends HandlerBuilder> paramClass1, Class<? extends HandlerBuilder> paramClass2);
/*    */   
/*    */   @Message(id = 61, value = "Out of band responses only allowed for 100-continue requests")
/*    */   IllegalArgumentException outOfBandResponseOnlyAllowedFor100Continue();
/*    */   
/*    */   @Message(id = 65, value = "SSL must be specified to connect to a https URL")
/*    */   IOException sslWasNull();
/*    */   
/*    */   @Message(id = 66, value = "Incorrect magic number %s for AJP packet header")
/*    */   IOException wrongMagicNumber(int paramInt);
/*    */   
/*    */   @Message(id = 67, value = "No client cert was provided")
/*    */   SSLPeerUnverifiedException peerUnverified();
/*    */   
/*    */   @Message(id = 68, value = "Servlet path match failed")
/*    */   IllegalArgumentException servletPathMatchFailed();
/*    */   
/*    */   @Message(id = 69, value = "Could not parse set cookie header %s")
/*    */   IllegalArgumentException couldNotParseCookie(String paramString);
/*    */   
/*    */   @Message(id = 70, value = "method can only be called by IO thread")
/*    */   IllegalStateException canOnlyBeCalledByIoThread();
/*    */   
/*    */   @Message(id = 71, value = "Cannot add path template %s, matcher already contains an equivalent pattern %s")
/*    */   IllegalStateException matcherAlreadyContainsTemplate(String paramString1, String paramString2);
/*    */   
/*    */   @Message(id = 72, value = "Failed to decode url %s to charset %s")
/*    */   UrlDecodeException failedToDecodeURL(String paramString1, String paramString2, @Cause Exception paramException);
/*    */   
/*    */   @Message(id = 73, value = "Resource change listeners are not supported")
/*    */   IllegalArgumentException resourceChangeListenerNotSupported();
/*    */   
/*    */   @Message(id = 75, value = "Object was freed")
/*    */   IllegalStateException objectWasFreed();
/*    */   
/*    */   @Message(id = 76, value = "Handler not shutdown")
/*    */   IllegalStateException handlerNotShutdown();
/*    */   
/*    */   @Message(id = 77, value = "The underlying transport does not support HTTP upgrade")
/*    */   IllegalStateException upgradeNotSupported();
/*    */   
/*    */   @Message(id = 78, value = "Renegotiation not supported")
/*    */   IOException renegotiationNotSupported();
/*    */   
/*    */   @Message(id = 80, value = "Not a valid regular expression pattern %s")
/*    */   IllegalArgumentException notAValidRegularExpressionPattern(String paramString);
/*    */   
/*    */   @Message(id = 81, value = "Bad request")
/*    */   BadRequestException badRequest();
/*    */   
/*    */   @Message(id = 82, value = "Host %s already registered")
/*    */   RuntimeException hostAlreadyRegistered(Object paramObject);
/*    */   
/*    */   @Message(id = 83, value = "Host %s has not been registered")
/*    */   RuntimeException hostHasNotBeenRegistered(Object paramObject);
/*    */   
/*    */   @Message(id = 84, value = "Attempted to write additional data after the last chunk")
/*    */   IOException extraDataWrittenAfterChunkEnd();
/*    */   
/*    */   @Message(id = 85, value = "Could not generate unique session id")
/*    */   RuntimeException couldNotGenerateUniqueSessionId();
/*    */   
/*    */   @Message(id = 88, value = "SPDY control frames cannot have body content")
/*    */   IOException controlFrameCannotHaveBodyContent();
/*    */   
/*    */   @Message(id = 91, value = "Buffer has already been freed")
/*    */   IllegalStateException bufferAlreadyFreed();
/*    */   
/*    */   @Message(id = 94, value = "Blocking await method called from IO thread. Blocking IO must be dispatched to a worker thread or deadlocks will result.")
/*    */   IOException awaitCalledFromIoThread();
/*    */   
/*    */   @Message(id = 95, value = "Recursive call to flushSenders()")
/*    */   RuntimeException recursiveCallToFlushingSenders();
/*    */   
/*    */   @Message(id = 96, value = "More data was written to the channel than specified in the content-length")
/*    */   IllegalStateException fixedLengthOverflow();
/*    */   
/*    */   @Message(id = 97, value = "AJP request already in progress")
/*    */   IllegalStateException ajpRequestAlreadyInProgress();
/*    */   
/*    */   @Message(id = 98, value = "HTTP ping data must be 8 bytes in length")
/*    */   String httpPingDataMustBeLength8();
/*    */   
/*    */   @Message(id = 99, value = "Received a ping of size other than 8")
/*    */   String invalidPingSize();
/*    */   
/*    */   @Message(id = 100, value = "stream id must be zero for frame type %s")
/*    */   String streamIdMustBeZeroForFrameType(int paramInt);
/*    */   
/*    */   @Message(id = 101, value = "stream id must not be zero for frame type %s")
/*    */   String streamIdMustNotBeZeroForFrameType(int paramInt);
/*    */   
/*    */   @Message(id = 103, value = "Http2 stream was reset")
/*    */   IOException http2StreamWasReset();
/*    */   
/*    */   @Message(id = 104, value = "Incorrect HTTP2 preface")
/*    */   IOException incorrectHttp2Preface();
/*    */   
/*    */   @Message(id = 105, value = "HTTP2 frame to large")
/*    */   IOException http2FrameTooLarge();
/*    */   
/*    */   @Message(id = 106, value = "HTTP2 continuation frame received without a corresponding headers or push promise frame")
/*    */   IOException http2ContinuationFrameNotExpected();
/*    */   
/*    */   @Message(id = 107, value = "Huffman encoded value in HPACK headers did not end with EOS padding")
/*    */   HpackException huffmanEncodedHpackValueDidNotEndWithEOS();
/*    */   
/*    */   @Message(id = 108, value = "HPACK variable length integer encoded over too many octects, max is %s")
/*    */   HpackException integerEncodedOverTooManyOctets(int paramInt);
/*    */   
/*    */   @Message(id = 109, value = "Zero is not a valid header table index")
/*    */   HpackException zeroNotValidHeaderTableIndex();
/*    */   
/*    */   @Message(id = 110, value = "Cannot send 100-Continue, getResponseChannel() has already been called")
/*    */   IOException cannotSendContinueResponse();
/*    */   
/*    */   @Message(id = 111, value = "Parser did not make progress")
/*    */   IOException parserDidNotMakeProgress();
/*    */   
/*    */   @Message(id = 112, value = "Only client side can call createStream, if you wish to send a PUSH_PROMISE frame use createPushPromiseStream instead")
/*    */   IOException headersStreamCanOnlyBeCreatedByClient();
/*    */   
/*    */   @Message(id = 113, value = "Only the server side can send a push promise stream")
/*    */   IOException pushPromiseCanOnlyBeCreatedByServer();
/*    */   
/*    */   @Message(id = 114, value = "Invalid IP access control rule %s. Format is: [ip-match] allow|deny")
/*    */   IllegalArgumentException invalidAclRule(String paramString);
/*    */   
/*    */   @Message(id = 115, value = "Server received PUSH_PROMISE frame from client")
/*    */   IOException serverReceivedPushPromise();
/*    */   
/*    */   @Message(id = 116, value = "CONNECT not supported by this connector")
/*    */   IllegalStateException connectNotSupported();
/*    */   
/*    */   @Message(id = 117, value = "Request was not a CONNECT request")
/*    */   IllegalStateException notAConnectRequest();
/*    */   
/*    */   @Message(id = 118, value = "Cannot reset buffer, response has already been commited")
/*    */   IllegalStateException cannotResetBuffer();
/*    */   
/*    */   @Message(id = 119, value = "HTTP2 via prior knowledge failed")
/*    */   IOException http2PriRequestFailed();
/*    */   
/*    */   @Message(id = 120, value = "Out of band responses are not allowed for this connector")
/*    */   IllegalStateException outOfBandResponseNotSupported();
/*    */   
/*    */   @Message(id = 121, value = "Session was rejected as the maximum number of sessions (%s) has been hit")
/*    */   IllegalStateException tooManySessions(int paramInt);
/*    */   
/*    */   @Message(id = 122, value = "CONNECT attempt failed as target proxy returned %s")
/*    */   IOException proxyConnectionFailed(int paramInt);
/*    */   
/*    */   @Message(id = 123, value = "MCMP message %s rejected due to suspicious characters")
/*    */   RuntimeException mcmpMessageRejectedDueToSuspiciousCharacters(String paramString);
/*    */   
/*    */   @Message(id = 124, value = "renegotiation timed out")
/*    */   IllegalStateException rengotiationTimedOut();
/*    */   
/*    */   @Message(id = 125, value = "Request body already read")
/*    */   IllegalStateException requestBodyAlreadyRead();
/*    */   
/*    */   @Message(id = 126, value = "Attempted to do blocking IO from the IO thread. This is prohibited as it may result in deadlocks")
/*    */   IllegalStateException blockingIoFromIOThread();
/*    */   
/*    */   @Message(id = 127, value = "Response has already been sent")
/*    */   IllegalStateException responseComplete();
/*    */   
/*    */   @Message(id = 128, value = "Remote peer closed connection before all data could be read")
/*    */   IOException couldNotReadContentLengthData();
/*    */   
/*    */   @Message(id = 129, value = "Failed to send after being safe to send")
/*    */   IllegalStateException failedToSendAfterBeingSafe();
/*    */   
/*    */   @Message(id = 130, value = "HTTP reason phrase was too large for the buffer. Either provide a smaller message or a bigger buffer. Phrase: %s")
/*    */   IllegalStateException reasonPhraseToLargeForBuffer(String paramString);
/*    */   
/*    */   @Message(id = 131, value = "Buffer pool is closed")
/*    */   IllegalStateException poolIsClosed();
/*    */   
/*    */   @Message(id = 132, value = "HPACK decode failed")
/*    */   HpackException hpackFailed();
/*    */   
/*    */   @Message(id = 133, value = "Request did not contain an Upgrade header, upgrade is not permitted")
/*    */   IllegalStateException notAnUpgradeRequest();
/*    */   
/*    */   @Message(id = 134, value = "Authentication mechanism %s requires property %s to be set")
/*    */   IllegalStateException authenticationPropertyNotSet(String paramString1, String paramString2);
/*    */   
/*    */   @Message(id = 135, value = "renegotiation failed")
/*    */   IllegalStateException rengotiationFailed();
/*    */   
/*    */   @Message(id = 136, value = "User agent charset string must have an even number of items, in the form pattern,charset,pattern,charset,... Instead got: %s")
/*    */   IllegalArgumentException userAgentCharsetMustHaveEvenNumberOfItems(String paramString);
/*    */   
/*    */   @Message(id = 137, value = "Could not find the datasource called %s")
/*    */   IllegalArgumentException datasourceNotFound(String paramString);
/*    */   
/*    */   @Message(id = 138, value = "Server not started")
/*    */   IllegalStateException serverNotStarted();
/*    */   
/*    */   @Message(id = 139, value = "Exchange already complete")
/*    */   IllegalStateException exchangeAlreadyComplete();
/*    */   
/*    */   @Message(id = 140, value = "Initial SSL/TLS data is not a handshake record")
/*    */   SSLHandshakeException notHandshakeRecord();
/*    */   
/*    */   @Message(id = 141, value = "Initial SSL/TLS handshake record is invalid")
/*    */   SSLHandshakeException invalidHandshakeRecord();
/*    */   
/*    */   @Message(id = 142, value = "Initial SSL/TLS handshake spans multiple records")
/*    */   SSLHandshakeException multiRecordSSLHandshake();
/*    */   
/*    */   @Message(id = 143, value = "Expected \"client hello\" record")
/*    */   SSLHandshakeException expectedClientHello();
/*    */   
/*    */   @Message(id = 144, value = "Expected server hello")
/*    */   SSLHandshakeException expectedServerHello();
/*    */   
/*    */   @Message(id = 145, value = "Too many redirects")
/*    */   IOException tooManyRedirects(@Cause IOException paramIOException);
/*    */   
/*    */   @Message(id = 146, value = "HttpServerExchange cannot have both async IO resumed and dispatch() called in the same cycle")
/*    */   IllegalStateException resumedAndDispatched();
/*    */   
/*    */   @Message(id = 147, value = "No host header in a HTTP/1.1 request")
/*    */   IOException noHostInHttp11Request();
/*    */   
/*    */   @Message(id = 148, value = "Invalid HPack encoding. First byte: %s")
/*    */   HpackException invalidHpackEncoding(byte paramByte);
/*    */   
/*    */   @Message(id = 149, value = "HttpString is not allowed to contain newlines. value: %s")
/*    */   IllegalArgumentException newlineNotSupportedInHttpString(String paramString);
/*    */   
/*    */   @Message(id = 150, value = "Pseudo header %s received after receiving normal headers. Pseudo headers must be the first headers in a HTTP/2 header block.")
/*    */   String pseudoHeaderInWrongOrder(HttpString paramHttpString);
/*    */   
/*    */   @Message(id = 151, value = "Expected to receive a continuation frame")
/*    */   String expectedContinuationFrame();
/*    */   
/*    */   @Message(id = 152, value = "Incorrect frame size")
/*    */   String incorrectFrameSize();
/*    */   
/*    */   @Message(id = 153, value = "Stream id not registered")
/*    */   IllegalStateException streamNotRegistered();
/*    */   
/*    */   @Message(id = 154, value = "Mechanism %s returned a null result from sendChallenge()")
/*    */   NullPointerException sendChallengeReturnedNull(AuthenticationMechanism paramAuthenticationMechanism);
/*    */   
/*    */   @Message(id = 155, value = "Framed channel body was set when it was not ready for flush")
/*    */   IllegalStateException bodyIsSetAndNotReadyForFlush();
/*    */   
/*    */   @Message(id = 156, value = "Invalid GZIP header")
/*    */   IOException invalidGzipHeader();
/*    */   
/*    */   @Message(id = 157, value = "Invalid GZIP footer")
/*    */   IOException invalidGZIPFooter();
/*    */   
/*    */   @Message(id = 158, value = "Response of length %s is too large to buffer")
/*    */   IllegalStateException responseTooLargeToBuffer(Long paramLong);
/*    */   
/*    */   @Message(id = 161, value = "HTTP/2 header block is too large")
/*    */   String headerBlockTooLarge();
/*    */   
/*    */   @Message(id = 162, value = "An invalid SameSite attribute [%s] is specified. It must be one of %s")
/*    */   IllegalArgumentException invalidSameSiteMode(String paramString1, String paramString2);
/*    */   
/*    */   @Message(id = 163, value = "Invalid token %s")
/*    */   IllegalArgumentException invalidToken(byte paramByte);
/*    */   
/*    */   @Message(id = 164, value = "Request contained invalid headers")
/*    */   IllegalArgumentException invalidHeaders();
/*    */   
/*    */   @Message(id = 165, value = "Invalid character %s in request-target")
/*    */   String invalidCharacterInRequestTarget(char paramChar);
/*    */   
/*    */   @Message(id = 166, value = "Pooled object is closed")
/*    */   IllegalStateException objectIsClosed();
/*    */   
/*    */   @Message(id = 167, value = "More than one host header in request")
/*    */   IOException moreThanOneHostHeader();
/*    */   
/*    */   @Message(id = 168, value = "An invalid character [ASCII code: %s] was present in the cookie value")
/*    */   IllegalArgumentException invalidCookieValue(String paramString);
/*    */   
/*    */   @Message(id = 169, value = "An invalid domain [%s] was specified for this cookie")
/*    */   IllegalArgumentException invalidCookieDomain(String paramString);
/*    */   
/*    */   @Message(id = 170, value = "An invalid path [%s] was specified for this cookie")
/*    */   IllegalArgumentException invalidCookiePath(String paramString);
/*    */   
/*    */   @Message(id = 173, value = "An invalid control character [%s] was present in the cookie value or attribute")
/*    */   IllegalArgumentException invalidControlCharacter(String paramString);
/*    */   
/*    */   @Message(id = 174, value = "An invalid escape character in cookie value")
/*    */   IllegalArgumentException invalidEscapeCharacter();
/*    */   
/*    */   @Message(id = 175, value = "Invalid Hpack index %s")
/*    */   HpackException invalidHpackIndex(int paramInt);
/*    */   
/*    */   @Message(id = 178, value = "Buffer pool is too small, min size is %s")
/*    */   IllegalArgumentException bufferPoolTooSmall(int paramInt);
/*    */   
/*    */   @Message(id = 179, value = "Invalid PROXY protocol header")
/*    */   IOException invalidProxyHeader();
/*    */   
/*    */   @Message(id = 180, value = "PROXY protocol header exceeded max size of 107 bytes")
/*    */   IOException headerSizeToLarge();
/*    */   
/*    */   @Message(id = 181, value = "HTTP/2 trailers too large for single buffer")
/*    */   RuntimeException http2TrailerToLargeForSingleBuffer();
/*    */   
/*    */   @Message(id = 182, value = "Ping not supported")
/*    */   IOException pingNotSupported();
/*    */   
/*    */   @Message(id = 183, value = "Ping timed out")
/*    */   IOException pingTimeout();
/*    */   
/*    */   @Message(id = 184, value = "Stream limit exceeded")
/*    */   IOException streamLimitExceeded();
/*    */   
/*    */   @Message(id = 185, value = "Invalid IP address %s")
/*    */   IOException invalidIpAddress(String paramString);
/*    */   
/*    */   @Message(id = 186, value = "Invalid TLS extension")
/*    */   SSLException invalidTlsExt();
/*    */   
/*    */   @Message(id = 187, value = "Not enough data")
/*    */   SSLException notEnoughData();
/*    */   
/*    */   @Message(id = 188, value = "Empty host name in SNI extension")
/*    */   SSLException emptyHostNameSni();
/*    */   
/*    */   @Message(id = 189, value = "Duplicated host name of type %s")
/*    */   SSLException duplicatedSniServerName(int paramInt);
/*    */   
/*    */   @Message(id = 190, value = "No context for SSL connection")
/*    */   SSLException noContextForSslConnection();
/*    */   
/*    */   @Message(id = 191, value = "Default context cannot be null")
/*    */   IllegalStateException defaultContextCannotBeNull();
/*    */   
/*    */   @Message(id = 192, value = "Form value is a in-memory file, use getFileItem() instead")
/*    */   IllegalStateException formValueIsInMemoryFile();
/*    */   
/*    */   @Message(id = 193, value = "Character decoding failed. Parameter [%s] with value [%s] has been ignored. Note: further occurrences of Parameter errors will be logged at DEBUG level.")
/*    */   String failedToDecodeParameterValue(String paramString1, String paramString2, @Cause Exception paramException);
/*    */   
/*    */   @Message(id = 194, value = "Character decoding failed. Parameter with name [%s] has been ignored. Note: further occurrences of Parameter errors will be logged at DEBUG level.")
/*    */   String failedToDecodeParameterName(String paramString, @Cause Exception paramException);
/*    */   
/*    */   @Message(id = 195, value = "Chunk size too large")
/*    */   IOException chunkSizeTooLarge();
/*    */   
/*    */   @Message(id = 196, value = "Session with id %s already exists")
/*    */   IllegalStateException sessionWithIdAlreadyExists(String paramString);
/*    */   
/*    */   @Message(id = 197, value = "Blocking read timed out after %s nanoseconds.")
/*    */   ReadTimeoutException blockingReadTimedOut(long paramLong);
/*    */   
/*    */   @Message(id = 198, value = "Blocking write timed out after %s nanoseconds.")
/*    */   WriteTimeoutException blockingWriteTimedOut(long paramLong);
/*    */   
/*    */   @Message(id = 199, value = "Read timed out after %s milliseconds.")
/*    */   ReadTimeoutException readTimedOut(long paramLong);
/*    */   
/*    */   @Message(id = 200, value = "Failed to replace hash output stream ")
/*    */   SSLException failedToReplaceHashOutputStream(@Cause Exception paramException);
/*    */   
/*    */   @Message(id = 201, value = "Failed to replace hash output stream ")
/*    */   RuntimeException failedToReplaceHashOutputStreamOnWrite(@Cause Exception paramException);
/*    */   
/*    */   @Message(id = 202, value = "Failed to initialize path manager for '%s' path.")
/*    */   RuntimeException failedToInitializePathManager(String paramString, @Cause IOException paramIOException);
/*    */   
/*    */   @Message(id = 203, value = "Invalid ACL entry")
/*    */   IllegalArgumentException invalidACLAddress(@Cause Exception paramException);
/*    */   
/*    */   @Message(id = 204, value = "Out of flow control window: no WINDOW_UPDATE received from peer within %s miliseconds")
/*    */   IOException noWindowUpdate(long paramLong);
/*    */   
/*    */   @Message(id = 205, value = "Path is not a directory '%s'")
/*    */   IOException pathNotADirectory(Path paramPath);
/*    */   
/*    */   @Message(id = 206, value = "Path '%s' is not a directory")
/*    */   IOException pathElementIsRegularFile(Path paramPath);
/*    */ }


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\i\\undertow\UndertowMessages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */