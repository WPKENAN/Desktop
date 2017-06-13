#include <stdio.h>
#include "libsx.h"


void quit(Widget w, void *data)
{
  exit(0);
}



main(int argc, char **argv)
{
  MakeButton("Click to Quit", quit, NULL);
  MainLoop();
}
