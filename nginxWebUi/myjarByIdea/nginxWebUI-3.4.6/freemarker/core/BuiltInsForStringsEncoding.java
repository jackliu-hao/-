package freemarker.core;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import freemarker.template._TemplateAPI;
import freemarker.template.utility.StringUtil;
import java.io.UnsupportedEncodingException;
import java.util.List;

class BuiltInsForStringsEncoding {
   private BuiltInsForStringsEncoding() {
   }

   abstract static class AbstractUrlBIResult implements TemplateScalarModel, TemplateMethodModel {
      protected final BuiltIn parent;
      protected final String targetAsString;
      private final Environment env;
      private String cachedResult;

      protected AbstractUrlBIResult(BuiltIn parent, String target, Environment env) {
         this.parent = parent;
         this.targetAsString = target;
         this.env = env;
      }

      protected abstract String encodeWithCharset(String var1) throws UnsupportedEncodingException;

      public Object exec(List args) throws TemplateModelException {
         this.parent.checkMethodArgCount(args.size(), 1);

         try {
            return new SimpleScalar(this.encodeWithCharset((String)args.get(0)));
         } catch (UnsupportedEncodingException var3) {
            throw new _TemplateModelException(var3, "Failed to execute URL encoding.");
         }
      }

      public String getAsString() throws TemplateModelException {
         if (this.cachedResult == null) {
            String cs = this.env.getEffectiveURLEscapingCharset();
            if (cs == null) {
               throw new _TemplateModelException(new Object[]{"To do URL encoding, the framework that encloses FreeMarker must specify the \"", "output_encoding", "\" setting or the \"", "url_escaping_charset", "\" setting, so ask the programmers to set them. Or, as a last chance, you can set the url_encoding_charset setting in the template, e.g. <#setting ", "url_escaping_charset", "='ISO-8859-1'>, or give the charset explicitly to the built-in, e.g. foo?url('ISO-8859-1')."});
            }

            try {
               this.cachedResult = this.encodeWithCharset(cs);
            } catch (UnsupportedEncodingException var3) {
               throw new _TemplateModelException(var3, "Failed to execute URL encoding.");
            }
         }

         return this.cachedResult;
      }
   }

   static class xmlBI extends BuiltInForLegacyEscaping {
      TemplateModel calculateResult(String s, Environment env) {
         return new SimpleScalar(StringUtil.XMLEnc(s));
      }
   }

   static class xhtmlBI extends BuiltInForLegacyEscaping {
      TemplateModel calculateResult(String s, Environment env) {
         return new SimpleScalar(StringUtil.XHTMLEnc(s));
      }
   }

   static class urlPathBI extends BuiltInForString {
      TemplateModel calculateResult(String s, Environment env) {
         return new UrlPathBIResult(this, s, env);
      }

      static class UrlPathBIResult extends AbstractUrlBIResult {
         protected UrlPathBIResult(BuiltIn parent, String target, Environment env) {
            super(parent, target, env);
         }

         protected String encodeWithCharset(String cs) throws UnsupportedEncodingException {
            return StringUtil.URLPathEnc(this.targetAsString, cs);
         }
      }
   }

   static class urlBI extends BuiltInForString {
      TemplateModel calculateResult(String s, Environment env) {
         return new UrlBIResult(this, s, env);
      }

      static class UrlBIResult extends AbstractUrlBIResult {
         protected UrlBIResult(BuiltIn parent, String target, Environment env) {
            super(parent, target, env);
         }

         protected String encodeWithCharset(String cs) throws UnsupportedEncodingException {
            return StringUtil.URLEnc(this.targetAsString, cs);
         }
      }
   }

   static class rtfBI extends BuiltInForLegacyEscaping {
      TemplateModel calculateResult(String s, Environment env) {
         return new SimpleScalar(StringUtil.RTFEnc(s));
      }
   }

   static class json_stringBI extends BuiltInForString {
      TemplateModel calculateResult(String s, Environment env) {
         return new SimpleScalar(StringUtil.jsonStringEnc(s));
      }
   }

   static class js_stringBI extends BuiltInForString {
      TemplateModel calculateResult(String s, Environment env) {
         return new SimpleScalar(StringUtil.javaScriptStringEnc(s));
      }
   }

   static class j_stringBI extends BuiltInForString {
      TemplateModel calculateResult(String s, Environment env) {
         return new SimpleScalar(StringUtil.javaStringEnc(s));
      }
   }

   static class htmlBI extends BuiltInForLegacyEscaping implements ICIChainMember {
      private final BIBeforeICI2d3d20 prevICIObj = new BIBeforeICI2d3d20();

      TemplateModel calculateResult(String s, Environment env) {
         return new SimpleScalar(StringUtil.XHTMLEnc(s));
      }

      public int getMinimumICIVersion() {
         return _TemplateAPI.VERSION_INT_2_3_20;
      }

      public Object getPreviousICIChainMember() {
         return this.prevICIObj;
      }

      static class BIBeforeICI2d3d20 extends BuiltInForLegacyEscaping {
         TemplateModel calculateResult(String s, Environment env) {
            return new SimpleScalar(StringUtil.HTMLEnc(s));
         }
      }
   }
}
