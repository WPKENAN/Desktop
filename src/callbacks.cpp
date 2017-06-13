/* This file contains routines that are called when a button is pressed 
 * in your window or when things happen in a drawing area.
 *
 * If you add a function to this file, you should also add a function 
 * prototype for it to the callbacks.h file (unless it is an internal 
 * function, then you should just add it down below where it says 
 * "internal prototypes").
 *
 *              --  This code is under the GNU copyleft  --
 *
 *   Dominic Giampaolo
 */

#include <stdio.h>
#include <stdlib.h>

#include "libsx.h"
#include "main.h"
#include "callbacks.h"


static int width, height;



/*  -- CALLBACK ROUTINES  --
 *
 * These functions are called when various things happen in your windows.
 * They should handle what happened and give feedback to the user
 */


void quit(Widget w, void *data)
{
  MyProgram *me = (MyProgram *)data;
  int index;
  char *str;

  str = GetStringEntry(me->str_entry);
  printf("Final value for string entry is: %s\n", str);

  index = GetCurrentListItem(me->list);
  printf("Current list index is: %d\n", index);

  exit(0);
}



void load(Widget w1, void *data)
{
  char *fname;

  fname = GetString("Enter name of file to load:", "Foobar.c");
  if (fname)
   {
     printf("You entered: %s\n", fname);
     free(fname);
   }
  else
    printf("You clicked cancel.\n");
}


void save(Widget w, void *data)
{
  int ans;

  ans = GetYesNo("\nAre you a weenie?\n\n");

  if (ans == TRUE)
     printf("You're a weenie.\n");
  else
    printf("You are not a weenie.\n");
}


void scroll_func(Widget w, float val, void *arg)
{
  printf("new value is: %f\n", val);
}


void string_func(Widget w, char *txt, void *arg)
{
  MyProgram *me = (MyProgram *)arg;
  FILE *fp;

  printf("Got text: %s\n", txt);
  
  if ((fp = fopen(txt, "r")) != NULL)  /* test if it exists first */
   {
     fclose(fp);

     SetTextWidgetText(me->text_widget, txt, TRUE);
   }
  else
   {
     SetTextWidgetText(me->text_widget, txt, FALSE);
   }
  
}



void list_callback(Widget w, char *str, int index, void *arg)
{
  printf("In list callback, got item: %s  index==%d\n", str, index);
}


void do_stuff(Widget w, void *data)
{
  int i;
  static int counter=2, asked=0;
  MyProgram *me=(MyProgram*)data;
  char *str="This takes over the colormap of the display.\n\n Are you Sure?";

  if (asked == FALSE && GetYesNo(str) == FALSE)
    return;
  asked=1;

  GetAllColors();
  SetColorMap(counter);
  counter = (counter + 1) % 4;

  SetFgColor(me->quit,     248);   /* 255 should always be an ok color */
  SetBorderColor(me->quit, 248);

  SetFgColor(me->color_widget,     248);
  SetBorderColor(me->color_widget, 248);

  me->in_color_mode = 1;
  for(i=0; i < 256; i++)
    {
      SetColor(i);
      DrawLine(i,0, i,255);
    }
}


void check_me(Widget w, void *data)
{
  static int toggle=0;

  toggle ^= 1;
  SetMenuItemChecked(w, toggle);
}


void write_ppm(char *name, char *data, int width, int height)
{
  FILE *fp;
  int i,j;

  fp = fopen(name, "wb");
  if (fp == NULL)
    return;

  fprintf(fp, "P5\n%d %d\n255\n", width, height);
  fwrite(data, width*height, 1, fp);

  fclose(fp);
}
  

void more_stuff(Widget w, void *data)
{
  MyProgram *me=(MyProgram*)data;
  char *img;
  int width=100,height=100;
  
  printf("More stuff...\n");

  img = (char *)malloc(width*height);
  if (img == NULL)
    return;

  GetImage(img, 25, 25, width, height);

  write_ppm("foo.ppm", img, width,height);

  ScrollDrawArea(0, FontHeight(me->draw_font), 0,0, 300,300);
}


void toggle1(Widget w, void *data)
{
  MyProgram *me = (MyProgram *)data;

  me->toggle1 ^= 1;

  printf("toggle 1 changing state: %d\n", me->toggle1);
}

void toggle2(Widget w, void *data)
{
  MyProgram *me = (MyProgram *)data;
  
  me->toggle2 ^= 1;
  
  printf("toggle 2 changing state: %d\n", me->toggle2);
}


void toggle3(Widget w, void *data)
{
  MyProgram *me = (MyProgram *)data;

  me->toggle3 ^= 1;
  
  printf("toggle 3 changing state: %d\n", me->toggle3);
}


void toggle4(Widget w, void *data)
{
  MyProgram *me = (MyProgram *)data;

  me->toggle4 ^= 1;
  
  printf("toggle 4 changing state: %d\n", me->toggle4);
}


void other_toggle(Widget w, void *data)
{
  MyProgram *me = (MyProgram *)data;
  
  me->other_toggle ^= 1;
  
  printf("Other toggle changing state: %d\n", me->other_toggle);
}


void menu_item1(Widget w, void *data)
{
  printf("menu item 1 chosen\n");
}


void menu_item2(Widget w, void *data)
{
  printf("menu item 2 chosen\n");
}


void menu_item3(Widget w, void *data)
{
  printf("menu item 3 chosen\n");
}


void menu_item4(Widget w, void *data)
{
  printf("menu item 4 chosen\n");
}



/*
 * The following functions are callbacks for the drawing area widgets.
 *
 */


void redisplay(Widget w, int new_width, int new_height, void *data)
{
  MyProgram *me = (MyProgram*)data;

  width  = new_width;                 /* save new window size */
  height = new_height;
  
  do_redisplay(me, width, height);
}



void button_down(Widget w, int which_button, int x, int y, void *data)
{
  MyProgram *me=(MyProgram*)data;
  
  printf("You pressed mouse button %d at (%d,%d)\n", which_button, x,y);

  me->down = which_button;
  me->oldx = me->startx = x;
  me->oldy = me->starty = y;

  SetMouseMotionCB(w, motion);
  SetDrawMode(SANE_XOR);
  SetColor(me->col1);
  SetBgColor(me->draw_widget, WHITE);
}


void button_up(Widget w, int which_button, int x, int y, void *data)
{
  MyProgram *me=(MyProgram*)data;
  
  printf("You released mouse button %d at (%d,%d)\n", which_button, x,y);

  me->down = 0;
  SetDrawMode(GXcopy);   /* sets things back to normal */
  SetMouseMotionCB(w, NULL);
}




/*
 * The following function is called when keypresses happen in the drawing
 * area widget.
 *
 *  It is useful to know that the string returned to your program is
 * not necessarily a single ASCII character. You will get the usual
 * ASCII characters, including control characters (such as ^C or ^H).
 * But, the workstation's function keys will also be returned in a
 * string such as "F11" or "F23".  You will also get other longer
 * strings such as "Control_L", "Alt_R", or "Shift_L".  It is
 * important to understand that even if you just press the shift key to
 * get a capital letter, you will first receive the string "Shift_L"
 * or "Shift_R", then you will receive a capital letter (say, "H").
 * You should probably ignore the "Shift_L" or "Shift_R" messages (but
 * who knows, you may find some use for them).
 *
 * The argument, up_or_down, tells you whether the given key was pressed
 * or released.  If the key was pressed down, up_or_down has a zero (0),
 * if the key was released, up_or_down contains a 1.
 *
 *
 * NOTE WELL:
 *   The string that is returned to you can _NOT_ (I'll repeat that,
 *   can _NOT_) be modified by your program.  Got it?  Do _NOT_ modify
 *   the string.  If you want to munge with it, make a copy using
 *   strdup() or strcpy() into your own buffer space.
 */

void keypress(Widget w, char *input, int up_or_down, void *data)
{
  char *str;

  if (input == NULL)
    return;

  if (up_or_down == 0)
    str = "Down";
  else
    str = "up";
  
  printf("Key: <<%s>> %s\n", input, str);
}




/* Called when a DrawingArea gets mouse motion events.  The arguments
 * X and Y are the current position of the mouse in the window.
 *
 * NOTE: This routine should be _fast_ because *every* single time
 *       the mouse moves in the drawing area, this function is called. 
 *       So even if you are just moving the mouse across the drawing area,
 *       this routine is called. As it stands, it doesn't do anything.
 */
void motion(Widget w, int x, int y, void *data)
{
  MyProgram *me=(MyProgram*)data;
  int owidth, oheight;
  
  owidth  = me->oldx - me->startx;
  oheight = me->oldy - me->starty;
  
  if (me->down == 1)                  /* draw box outlines */
   {
     DrawBox(me->startx, me->starty, owidth, oheight);
     DrawBox(me->startx, me->starty, (x - me->startx), (y - me->starty));
   }
  else if (me->down == 2)             /* draw some circles */
   {
     DrawArc(me->startx, me->starty, owidth, oheight, 0, 360);
     DrawArc(me->startx, me->starty, (x-me->startx),(y-me->starty), 360,360);
   }
  else if (me->down == 3)             /* draw some filled boxes */
   {
     DrawFilledBox(me->startx, me->starty, owidth, oheight);
     DrawFilledBox(me->startx, me->starty, (x - me->startx), (y - me->starty));
   }

  me->oldx = x;
  me->oldy = y;
}


