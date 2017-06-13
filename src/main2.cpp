/*
 * This is a simple demo program that shows how to use multiple form
 * widgets.  All you really have to do is create the first form widget
 * before you create any of the child widgets.  Then when you are done
 * creating all the widgets that will go in a particular form, lay them
 * out with calls to SetWidgetPos() if necessary.  Then make your next
 * form, specifying where it should go relative to the previous form. Next 
 * you create all of this new form's children, lay them out, etc.  You can
 * create as many form widgets as you like in this manner.
 *
 * Just keep in mind that every time you create a form widget, all future
 * calls to the MakeXXX() functions will put that widget in the current
 * form widget (current is defined as the most recent form created).
 *
 *               --  This code is under the GNU copyleft  --
 *
 *   Dominic Giampaolo
 *   dbg@sgi.com
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <memory.h>

#include "libsx.h"             /* gets us in the door with libsx          */


/* define's */
#define X_SIZE 300     /* default window size, change as desired */
#define Y_SIZE 300



void main(int argc, char **argv)
{
  argc = init_display(argc, argv, NULL);    /* setup the display */
  if (argc == 0)
    exit(0);


  MainLoop();                                /* go right into the main loop */
}


void quit(Widget w, void *junk)
{
  exit(0);
}


#include "foo.h"

void redisplay(Widget w, int width, int height, void *arg)
{
  int i,j,k;
  int colors[5];

  SetBgColor(w, WHITE);
  ClearDrawArea();
  
  colors[0] = BLACK; 
  colors[1] = GREEN; 
  colors[2] = RED; 
  colors[3] = BLUE; 
  colors[4] = YELLOW; 

  for(i=0; i < width; i+=foo_width)
    for(j=0; j < height; j+=foo_height)
     {
       int fg, bg;

       /* pick some colors to draw with (that aren't the same) */
       fg = colors[rand()%5];
       while((bg = colors[rand()%5]) == fg)
	 ;

       SetFgColor(w, fg);
       SetBgColor(w, bg);
       DrawBitmap(foo_bits, i,j, foo_width, foo_height);
     }
}


/*
 * This function sets up the display for us.
 */

int init_display(int argc, char **argv, void *junk)
{
  Widget w[25], form1, form2;
  XFont xf;

  argc = OpenDisplay(argc, argv);
  if (argc == FALSE)
    return argc;


  form1 = MakeForm(TOP_LEVEL_FORM, NO_CARE, NULL, NO_CARE, NULL);
  w[0] = MakeButton("fufanu", NULL, NULL);
  w[1] = MakeButton("foo", NULL, NULL);
  w[2] = MakeButton("Long String", NULL, NULL);
  w[3] = MakeButton("Blah", NULL, NULL);
  w[4] = MakeButton("Bletchrl", NULL, NULL);
  w[5] = MakeButton("Quit", quit, NULL);
  
  SetWidgetPos(w[1], PLACE_UNDER, w[0], NO_CARE, NULL);
  SetWidgetPos(w[2], PLACE_UNDER, w[1], NO_CARE, NULL);
  SetWidgetPos(w[3], PLACE_UNDER, w[2], NO_CARE, NULL);
  SetWidgetPos(w[4], PLACE_UNDER, w[3], NO_CARE, NULL);
  SetWidgetPos(w[5], PLACE_UNDER, w[4], NO_CARE, NULL);
  

  SetForm(TOP_LEVEL_FORM);
  w[6] = MakeDrawArea(X_SIZE, Y_SIZE, redisplay, NULL);
  SetWidgetPos(w[6], PLACE_RIGHT, form1, NO_CARE, NULL);

  form2 = MakeForm(TOP_LEVEL_FORM, PLACE_RIGHT, form1, PLACE_UNDER, w[6]);
  w[7] = MakeButton("Button1", NULL, NULL);
  w[8] = MakeButton("Button2", NULL, NULL);
  w[9] = MakeButton("Button3", NULL, NULL);
  
  SetWidgetPos(w[8], PLACE_RIGHT, w[7], NO_CARE, NULL);
  SetWidgetPos(w[9], PLACE_RIGHT, w[8], NO_CARE, NULL);


  /*
   * Now actually put the display on the screen.
   */
  ShowDisplay();

  /*
   * Get some colors for drawing with.
   */
  GetStandardColors();

  SetBgColor(form1, BLUE);
  SetBgColor(form2, YELLOW);

  return argc;
}


