<%@page contentType="text/html;charset=gb2312"%>
<HTML>
<HEAD><TITLE>request</TITLE></HEAD>
<BODY>
<FORM action=" action.jsp" method=post name=formTest>
����ְҵ�ǣ�<br><br>
<!--��ѡȡְҵ���͵ļ���-->
<input type="hidden" name="formName" value="formTest">
<INPUT type="checkbox" name=job value="ѧ��">ѧ��
<INPUT type="checkbox" name=job value="��ʦ">��ʦ
<INPUT type="checkbox" name=job value="����Ա">����Ա
<INPUT type="checkbox" name=job value="ҽ��">ҽ��
<INPUT type="checkbox" name=job value="����Ա">����Ա<br><br>
<INPUT type="submit" value="�ͳ�" name=submit>
<INPUT type="reset" value="���" name=reset>
</FORM></BODY></HTML>
