#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(void)
{
	FILE *fp;
	char document[128], Str[21], row[201], save;
	int i = 0, fl = -1, li = -1, line = 0, flag = 0;

	printf("input the file's name and the string: ");

	scanf("%s%s", document, Str);             //�����ļ����ʹ����ҵ��ַ���
	if((fp = fopen(document, "r")) == NULL) 
	{
		printf("\nfile open error!");
		exit(0);
	}

	printf("------------------------File content:----------------------\n");
	
	/*���ļ��ж����ַ�������ÿһ�н��в���*/
	do
	{
		save = fgetc(fp);				
		row[i] = save;

		if (save == EOF) //������������ļ���������˵���Ѿ����������һ���ַ� 
		{
			row[i] = '\0';   //����ַ���������־
			line++;          //��������1
			strlwr(row);     //������row�е��ַ���ȫ��ת����Сд��ĸ
			strlwr(Str);     //������Str�е��ַ���ȫ��ת����Сд��ĸ
			if (flag != 1)    //���ַ���row�л�δ�ҵ��ַ���Str
			{
				if (strstr(row, Str) != NULL)  //���ַ���row���ҵ��ַ���Str
				{
					fl = line;           //���ַ���Str��һ�γ��ֵ���������f1
					flag = 1;            //��flag��ֵ��Ϊ1��˵���Ѿ��ҵ����ַ���Str
				}
			}
			
			if (strstr(row, Str) != NULL) //���ַ���row���ҵ��ַ���Str
			{
				li = line; //����������li
			}
			break; //�����ļ��Ķ�ȡ����
		}
		
		/* ����������ǻ��з���˵���Ѿ�������һ���ַ� */
		else if (save == '\n')
		{
			putchar(save); 
			row[i] = '\0';
			i = 0;         //i��ʼ����Ϊ����һ���ַ���׼��
			line++;
			strlwr(row);    //��ΪСд
			strlwr(Str);
			if (flag != 1)
			{
				if (strstr(row, Str) != NULL)
				{
					fl = line;
					flag = 1;
				}
			}
			if (strstr(row, Str) != NULL)
			{
				li = line;
			}
		}
		/* �����Ĳ��ǻ��з�Ҳ�����ļ������� */
		else 
		{
			putchar(save); //������ַ�
			i++; //Ϊ����һ���ַ���׼��
		}
		
	} while (1);
	printf("\n------------------------File summary:----------------------\n");

	printf("%d lines, first line: %d, last line: %d\n", line, fl, li);
	fclose(fp);

	return 0;
}



		