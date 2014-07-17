#include <stdio.h>

void reverse(char*);

int main(){
    char my_str1[] = "Hello World.";
    char* my_str2 = NULL;
    char my_str3[] = "";

    reverse(my_str1);
    printf("%s\n", my_str1);

    reverse(my_str2);

    reverse(my_str3);
    printf("%s\n", my_str3);

    return 0;
}

void reverse(char* str){
    char* end = str;
    char tmp;

    if(str){    //checks if NULL or not
        //printf("str: %s", str);
        while(*end){
            ++end;
        }
        --end;

        while(str < end){
            //swap data at memory address
            //and move pointers
            tmp = *str;
            *str++ = *end;
            *end-- = tmp;
        }
    }
    else{
        printf("str is null\n");
    }
}

