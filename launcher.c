#include <stdlib.h>

#ifdef defined(_WIN32)
#define OS_WINDOWS _WIN32
#else
#define OS_WINDOWS 0
#endif

int main()
{
	if (OS_WINDOWS)
	{
		system("recompile.bat");
		system("startclient.bat");
	}
	else
	{
		system("sh recompile.sh");
		system("sh startclient.sh");
	}
}