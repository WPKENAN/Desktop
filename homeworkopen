#include <stdlib.h>
#include <stdio.h>
#include <GL/glut.h>
#include "math.h"
#include "bits/stdc++.h"
using namespace std;
int currentMode = 0;
const int ModeNums = 7;
float theta=0.0;
float PI=3.1415926;
float R=6.0,n=3;
void init()
{
	glClearColor(1.0,1.0,1.0,1.0);
}
void myKey( unsigned char key, int x, int y) //响应ASCII对应键，鼠标的当前x和y位置也被返回。
{
	switch(key)
	{
		case ' ': currentMode = (currentMode+1)%ModeNums;
			      glutPostRedisplay();
				  break;
		case 27:  exit(-1);
	}
}

void mydisplay(){
	glClear(GL_COLOR_BUFFER_BIT);
	glBegin(GL_TRIANGLES);	
	int i=0;
	for(int i=0;i<n;i++){
		glVertex2f(R*cos(theta+i*2*PI/n),R*sin(theta+i*2*PI/n));
	}
	glEnd();
	glFlush();
}

void myidle(){

	theta+=0.001;
	if(theta>=2*PI) theta-=2*PI;
	mydisplay();	
}


void RenderScene()
{
	cout << currentMode << endl;
	glClear(GL_COLOR_BUFFER_BIT);
	switch(currentMode)
	{
		case 0: 
				glutIdleFunc(NULL);
				glPointSize(5);
				glBegin(GL_POINTS);
				theta=0.0;
				glColor3f(1.0,0.0,0.0);
				break;
		case 1: 
				glutIdleFunc(NULL);
				glBegin(GL_LINE_STRIP);
				theta=0.0;
			    glColor3f(0.0,1.0,0.0);
			    break;
		case 2: 
				glutIdleFunc(NULL);
				glBegin(GL_LINE_LOOP);
				theta=0.0;
			    glColor3f(0.0,0.0,1.0);
				break;
		case 3: 
				glutIdleFunc(NULL);
				glBegin(GL_TRIANGLES);
				theta=0.0;
			    glColor3f(1.0,1.0,0.0);
				break;
		case 4:
				glutIdleFunc(NULL);
				glScalef(0.5,0.5,0.5);
				glBegin(GL_TRIANGLES);
				break;


		case 5:
				glutIdleFunc(NULL);
				glTranslatef(-10,0,0);
				glBegin(GL_TRIANGLES);
				break;
		case 6:
				glutIdleFunc(myidle);
				return;
				
	}
	int i=0;
	for(int i=0;i<n;i++){
		glVertex2f(R*cos(theta+i*2*PI/n),R*sin(theta+i*2*PI/n));
	}
	
	glEnd();
	glFlush();
//	printf("%lf,%lf\n",R*(cos(theta)+i*2*PI/n),R*sin(theta+i*2*PI/n));
}
void ChangeSize(GLsizei w,GLsizei h)
{
	float ratio;
	if(h==0)
		h = 1;
	glViewport(0,0,w,h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	ratio = (float)w/(float)h;
	if(w<=h)
		gluOrtho2D(-10.0,10.0,-10.0/ratio,10.0/ratio);
	else
		gluOrtho2D(-10.0*ratio,10.0*ratio,-10.0,10.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}




int main(int argc,char *argv[])
{
	printf("%lf\n",sin(1/2.0*PI));
	glutInit(&argc,argv);
	glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB);
	glutInitWindowPosition(50,50);
	glutInitWindowSize(360,360);
	glutCreateWindow("KeyboardFunc");

	init();
	glutDisplayFunc(RenderScene);
	glutReshapeFunc(ChangeSize);
	glutKeyboardFunc(myKey);  //为当前窗口设置键盘回调函数。	
	printf("Press space to continue,press escape to exit!\n");
	glutMainLoop();
}
