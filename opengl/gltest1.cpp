#include <GL/glut.h>  
  
void init();  
  
void display();  
  
int main(int argc, char* argv[])  
  
{  
  
    glutInit(&argc, argv);  
  
    glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);  
  
    glutInitWindowPosition(0, 0);  
  
    glutInitWindowSize(500, 500);  
  
    glutCreateWindow("OpenGL 3D View");  
  
    init();  
    glutDisplayFunc(display);  
  
    glutMainLoop();  
  
    return 0;  
  
}  
  
void init()  
  
{  
  
    glClearColor(1.0, 1.0, 1.0, 1.0);  
  
    glMatrixMode(GL_PROJECTION);  
  
    glMatrixMode(GL_MODELVIEW);  
  
}  
  
void display()  
  
{  
  
    glClear(GL_COLOR_BUFFER_BIT);  
      
    glBegin(GL_POLYGON);  
    glShadeModel(GL_SMOOTH);  
  
    glColor3f(1.0,0.0,0.0);  
    glVertex2f(-0.5,0.8);  
  
    glColor3f(1.0,1.0,0.0);  
    glVertex2f(0.5,0.8);  
  
    glColor3f(0.0,1.0,0.0);  
    glVertex2f(1,0.0);  
  
    glColor3f(0.0,1.0,1.0);  
    glVertex2f(0.5,-0.8);  
  
    glColor3f(0.0,0.0,1.0);  
    glVertex2f(-0.5,-0.8);  
  
    glColor3f(1.0,0.0,1.0);  
    glVertex2f(-1.0,0.0);  
  
    glEnd();  
  
    glFlush();  
}  
