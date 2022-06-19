#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(void)
{
	FILE *fp;
	char document[128], Str[21], row[201], save;
	int i = 0, fl = -1, li = -1, line = 0, flag = 0;

	printf("input the file's name and the string: ");

	scanf("%s%s", document, Str);             //输入文件名和待查找的字符串
	if((fp = fopen(document, "r")) == NULL) 
	{
		printf("\nfile open error!");
		exit(0);
	}

	printf("------------------------File content:----------------------\n");
	
	/*从文件中读出字符，并对每一行进行查找*/
	do
	{
		save = fgetc(fp);				
		row[i] = save;

		if (save == EOF) //如果读出的是文件结束符，说明已经读出了最后一行字符 
		{
			row[i] = '\0';   //添加字符串结束标志
			line++;          //行数增加1
			strlwr(row);     //将数组row中的字符串全部转换成小写字母
			strlwr(Str);     //将数组Str中的字符串全部转换成小写字母
			if (flag != 1)    //在字符串row中还未找到字符串Str
			{
				if (strstr(row, Str) != NULL)  //在字符串row中找到字符串Str
				{
					fl = line;           //将字符串Str第一次出现的行数赋给f1
					flag = 1;            //将flag的值置为1，说明已经找到过字符串Str
				}
			}
			
			if (strstr(row, Str) != NULL) //在字符串row中找到字符串Str
			{
				li = line; //将行数赋给li
			}
			break; //结束文件的读取操作
		}
		
		/* 如果读出的是换行符，说明已经读出了一行字符 */
		else if (save == '\n')
		{
			putchar(save); 
			row[i] = '\0';
			i = 0;         //i初始化，为读下一行字符做准备
			line++;
			strlwr(row);    //换为小写
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
		/* 读出的不是换行符也不是文件结束符 */
		else 
		{
			putchar(save); //输出该字符
			i++; //为读下一个字符做准备
		}
		
	} while (1);
	printf("\n------------------------File summary:----------------------\n");

	printf("%d lines, first line: %d, last line: %d\n", line, fl, li);
	fclose(fp);

	return 0;
}



		