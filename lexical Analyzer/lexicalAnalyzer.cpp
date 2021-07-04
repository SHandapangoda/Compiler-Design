# include <iostream>
#include <fstream>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int keyWord(char buffer[]){
    int keyWords [32][10] = {"auto","break","case","char","const","continue","default","do","double","else","enum","extern","float","for","goto","if","int"
    "long","register","return","short","signed","sizeof","static","struct","switch","typedef","union","unsigned","void","volatile","while"
    };

    int i, flag = 0 ;

    for(i = 0 ; i < 32 ; ++i){
        if(strcmp(keyWords[i], buffer) == 0) {
            flag = 1;
            break;
        }
    }

    return flag;

}

int main(){
    char ch, buffer[15], operator[] = "+-*/%=";

    ifstream find("lexical.txt");

    int i,j=0;

    if(!find.is_open()){
        cout << "error file cannot be opened \n";
        exit(0);

    }

    while(!find.eof()){
        ch = find.get();

        for( i =0; i < 6; ++i){
            if(ch == operator[i]){
                cout << ch << "operator\n";
            }

            if(isalnum(ch)){
                buffer[j++] = ch;
            }

            else if ((ch == ' ' || ch == '\n') && (j != 0)){
                buffer[j] = '\0';
                j = 0;
            }

            if(iskeyWord(buffer) == 1){
                cout << buffer << "is keyword\n";
            }
            else{
                cout << buffer << "is indentifier\n";
            }
        }
    }
    fin.close();
    return 0;
}
