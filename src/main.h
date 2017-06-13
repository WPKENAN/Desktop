/* This file contains the various things related to the main body of the 
 * program.  It is pretty sparse, and really shouldn't be too cluttered
 * up.
 *
 */

/* This structure contains information relevant to your program.
 * You should fill it in with information that you need.
 *
 */
typedef struct MyProgram
{
  int down;                         /* for when the mouse button goes down */
  int startx, starty, oldx, oldy;   /* used for drawing out boxes */
  
  int col1, col2;
  int toggle1, toggle2, toggle3, toggle4, other_toggle;
  int in_color_mode;
  Widget quit;
  Widget str_entry;
  Widget list;
  Widget other_window;
  Widget text_widget;
  Widget color_widget;
  Widget draw_widget;
  XFont  draw_font;
}MyProgram;


/* protos */
int  init_display(int argc, char **argv, MyProgram *me);
void do_redisplay(MyProgram *me, int x, int y);


#ifndef TRUE
#define TRUE  1
#define FALSE 0
#endif
