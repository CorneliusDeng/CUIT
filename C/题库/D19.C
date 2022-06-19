#include<stdio.h>

#define Yes 1
#define No  0

char *getStrFromBuf(char *Buf, char *Str, char *divStr);
int charInStr(char *Str, char t);

int main(void)
{
        char inBuf[100] = ">how old are/ you?", *point, oneWord[20];
        char divChar[] = " ;?!,.>/\\";

        point = inBuf;
        while (*point)
        {
                /*********Found************/
                point = getStrFromBuf(point, oneWord, divChar);
                if (*oneWord)
                {
                        puts(oneWord);
                }
        }

	return 0;
}

int charInStr(char *Str, char t)//判断字符t是否出现在串Str中
{
        for (; *Str; Str++)
        {
                /*********Found************/
                if (*Str == t)
                {
                        /*********Found************/
                        return Yes;
                }
        }
        /*********Found************/
        return No;
}


char *getStrFromBuf(char *Buf, char *Str, char *divStr)//从Buf的开始处寻找第一个单词，将找到的单词作为一个字符串复制到Str处
{
        for (; *Buf; Buf++)
        {
                if (charInStr(divStr, *Buf) == No)//如果Buf中的元素没有出现在divStr中，跳出循环
                {
                        break;
                }

        }

        for (; *Buf; Buf++)
        {
                if (charInStr(divStr, *Buf) == Yes)//如果Buf中的元素没有出现在divStr中，将找到的单词作为一个字符串复制到Str处
                {
                        break;
                }
                /*********Found************/
                *Str = *Buf;
                Str++;
        }
        /*********Found************/
        *Str = '\0';

        /*********Found************/
        return Buf;
}
