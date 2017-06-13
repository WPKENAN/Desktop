/* This is the main body of the program.  It is just a simple skeleton
 * and should be fleshed out as desired.  Mainly what you'll do to flesh 
 * it out is to edit the data structure defined in main.h so that it contains 
 * the information your program needs.  Then modify init_display() to create
 * the interface you want, and then just write the associated callback 
 * routines that are driven by the user's interaction with display.
 *
 * Easy, huh? (sorta)
 *
 *               --  This code is under the GNU copyleft  --
 *
 *   Dominic Giampaolo
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <memory.h>

#include "libsx.h"             /* gets us in the door with libsx          */
#include "main.h"              /* where program specific stuff is defined */
#include "callbacks.h"         /* prototypes for callback functions       */


/* define's */
#define X_SIZE 300     /* default window size, change as desired */
#define Y_SIZE 300


char *string_table[] =
{
  "Metallica", "Black Sabbath", "Diamond Head", "Budgie", "Dio",
  "Ozzy Osbourne", "Flotsam and Jetsam", "George Micheal", "Slayer",
  "Candlemass", "Van Halen", "W.A.S.P.", "Anthrax", "Soundgarden",
  "Iron Maiden", "The Cult", "Danzig", "Queensryche", "Motorhead",
  "AC/DC", "Led Zepplin", "Misfits", "Jimi Hendrix", "Nudeswirl",
  "Nirvana", "Vivaldi", "Holst", "Ravel", "B-52's", "Ice Cube", "Yes",
  "The Police", "The Cure", "Minor Threat", "Cro-Mags", "Agnostic Front",
  "Ministry", "Ice-T", "N.W.A", "Run-DMC", "Deep Purple", "Agent Orange",
  NULL
};




int main(int argc, char **argv)
{
  MyProgram mydata;

  memset(&mydata, '\0', sizeof(MyProgram));  /* clear this out! */

  argc = init_display(argc, argv, &mydata);  /* setup the display */
  if (argc == 0)
    exit(0);


  MainLoop();                                /* go right into the main loop */
  return 0;
}



/*
 * This function sets up the display for us.
 */

int init_display(int argc, char **argv, MyProgram *me)
{
  Widget w[25];

  argc = OpenDisplay(argc, argv);
  if (argc == FALSE)
    return argc;


  w[0]  = MakeMenu("File");
  w[1]  = MakeMenuItem(w[0], "Load...",  load, me);
  w[2]  = MakeMenuItem(w[0], "Save...",  save, me);
  w[3]  = MakeMenuItem(w[0], "Quit",     quit, me);
 
  w[4]  = MakeMenu("Edit");
  w[5]  = MakeMenuItem(w[4], "Check me", check_me, me);
  w[6]  = MakeMenuItem(w[4], "Copy",  NULL, NULL);
  w[7]  = MakeMenuItem(w[4], "Paste", NULL, NULL);
  
  w[8]  = MakeButton("Color Stuff", do_stuff,   me); 
  w[9]  = MakeButton("More Stuff",  more_stuff, me);
  w[10] = MakeButton("Quit!",       quit,       me);

  w[11] = MakeDrawArea(X_SIZE, Y_SIZE, redisplay, me);
  w[12] = MakeScrollList(string_table, 125, 275, list_callback, NULL);
  
  w[13] = MakeHorizScrollbar(X_SIZE, scroll_func, me);
  w[14] = MakeHorizScrollbar(X_SIZE, scroll_func, me);
  w[15] = MakeVertScrollbar(Y_SIZE, scroll_func, me);

  w[16] = MakeToggle("Slow",    TRUE,  NULL,  toggle1, me);
  w[17] = MakeToggle("Fast",    FALSE, w[16], toggle2, me);
  w[18] = MakeToggle("Faster",  FALSE, w[16], toggle3, me);
  w[19] = MakeToggle("Fastest", FALSE, w[16], toggle4, me);

  w[20] = MakeToggle("Toggle me", FALSE, NULL, other_toggle, me);

  w[21] = MakeStringEntry("button.c", 435, string_func, me);
  w[22] = MakeTextWidget("button.c", TRUE, TRUE, 435, 200);
  w[23] = MakeLabel("   A Sample Libsx Demo Program (cool huh?)");


  SetWidgetPos(w[4],  PLACE_RIGHT, w[0], NO_CARE, NULL);

  SetWidgetPos(w[8],  PLACE_UNDER, w[0], NO_CARE,     NULL);
  SetWidgetPos(w[9],  PLACE_UNDER, w[0], PLACE_RIGHT, w[8]);
  SetWidgetPos(w[10], PLACE_UNDER, w[0], PLACE_RIGHT, w[9]);

  SetWidgetPos(w[11], PLACE_UNDER, w[8], NO_CARE, NULL); 

  SetWidgetPos(w[13], PLACE_UNDER, w[11], NO_CARE, NULL);
  SetWidgetPos(w[14], PLACE_UNDER, w[13], NO_CARE, NULL);
  SetWidgetPos(w[15], PLACE_RIGHT, w[11], PLACE_UNDER, w[8]);

  SetWidgetPos(w[12], PLACE_RIGHT, w[15], PLACE_UNDER, w[8]);

  SetWidgetPos(w[16], PLACE_RIGHT, w[13], PLACE_UNDER, w[15]);
  SetWidgetPos(w[17], PLACE_RIGHT, w[16], PLACE_UNDER, w[15]);
  SetWidgetPos(w[18], PLACE_RIGHT, w[13], PLACE_UNDER, w[16]);
  SetWidgetPos(w[19], PLACE_RIGHT, w[18], PLACE_UNDER, w[16]);

  SetWidgetPos(w[20], PLACE_RIGHT, w[10], PLACE_UNDER, w[0]);
  SetWidgetPos(w[21], PLACE_UNDER, w[18], NO_CARE, NULL);
  SetWidgetPos(w[22], PLACE_UNDER, w[21], NO_CARE, NULL);
  SetWidgetPos(w[23], PLACE_RIGHT, w[4],  NO_CARE, NULL);


  /*
   * initialize the state of the toggle variables.
   */
  me->toggle1 = TRUE;
  me->toggle2 = me->toggle3 = me->toggle4 = me->other_toggle = FALSE;

  me->list         = w[12];   /* save these widget values for later */
  me->str_entry    = w[21];
  me->text_widget  = w[22];
  me->draw_widget  = w[11];
  me->quit         = w[10];
  me->color_widget = w[8];

  me->draw_font = GetFont("10x20");
  if (me->draw_font == NULL)
    me->draw_font = GetFont("fixed");

  SetWidgetFont(me->draw_widget, me->draw_font);

  SetButtonDownCB(w[11], button_down);
  SetButtonUpCB(w[11],   button_up);
  SetKeypressCB(w[11],   keypress);

  SetScrollbar(w[13],   3.0,  14.0, 14.0);
  SetScrollbar(w[14], 250.0, 255.0,  1.0);
  SetScrollbar(w[15],  30.0, 100.0, 25.0);

  /*
   * Now actually put the display on the screen.
   */
  ShowDisplay();


  /*
   * Get some colors for drawing with.
   */
  GetStandardColors();

  me->col1 = GetNamedColor("peachpuff2");
  if (me->col1 == -1)
    fprintf(stderr, "Error getting color peachpuff\n");

  me->col2 = GetRGBColor(255, 0, 255);
  if (me->col2 == -1)
    fprintf(stderr, "Error getting RGB color 0 255 255\n");

  return argc;
}


void do_colorstuff(void);


/* Here is where all redrawing will take place for your program. 
 * When the window needs to be redrawn, this function will be called.
 * When your program starts up for the first time, this function will 
 * be called and you should draw anything you need to draw in here.
 */
void do_redisplay(MyProgram *me, int width, int height) 
{
  int i;
  char *str = "My Cool Program";

  if (me->in_color_mode)
   {
     do_colorstuff();
     return;
   }

  SetBgColor(me->draw_widget, WHITE);
  ClearDrawArea();       /* start with a clean slate */

  SetColor(BLACK);
  SetBgColor(me->draw_widget, GREEN);
  DrawText(str, (width-TextWidth(me->draw_font, str))/2, height/2); 

  SetBgColor(me->draw_widget, WHITE);
  SetColor(me->col1);
  for(i=0; i < width; i+=5)
     DrawLine(0,i, i,height);

  SetColor(me->col2);
  for(i=0; i < width; i+=5)
     DrawLine(width,i, width-i,height);
}



void do_colorstuff(void)
{
  int i;

  for(i=0; i < 256; i++)
    {
      SetColor(i);
      DrawLine(i,0, i,255);
    }
}

