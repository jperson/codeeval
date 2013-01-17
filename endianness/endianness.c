#include <stdio.h>

int main(int argc, char* argv[]) 
{
    int value;
    char* vPtr = (char*)&value;

    vPtr[0] = vPtr[1] = vPtr[2] = 0; vPtr[3] = 1;
    printf("%s\n", (1 == value)?"BigEndian":"LittleEndian");

    return 0;
}
