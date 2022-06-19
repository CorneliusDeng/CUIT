#include<stdio.h>
#include<stdlib.h>

int main(void)
{
        /*********Found************/
        char *pch;//如果是数组，则已经分配了内存空间了，无需再用malloc再开辟空间

        /*********Found************/
        if ((pch = (char *)malloc(100)) == NULL)
        {
                printf("malloc memory fail!\n");
                return 1;
        }
        printf("%p\n", pch);

        /*********Found************/
        free(pch);//开辟空间之后不应该是关闭文件，而是释放内存

	return 0;
}
