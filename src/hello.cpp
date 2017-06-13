#include "libsx.h"
//#include "bits/stdc++.h"
#include "stdlib.h"
#include "stdio.h"
#include "string.h"


Widget w[4];
int i=0;
void quit(Widget w,void *data){
	printf("hello\n");
	exit(0);
}

void draw_stuff(Widget w,int width,int height,void *data){
//	getchar();
	ClearDrawArea();
//	DrawPixel(0,0);
//	printf("%d: \n%d %d\n",i++,width,height);
	SetColor(RED);
	DrawBox(30,50,110,70);
	DrawLine(0,0,width,height);//just draw a diagonal line
}
int main(int argc,char **argv){
	int i=0;
	printf("first:\n");
	for(i=0;i<4;i++){
		printf(":%d\n",GetWidgetState(w[i]));
	}
	printf("-------\n");
	printf("start::\n");
	argc=OpenDisplay(argc,argv);
	printf("%d\n",argc);
	if(argc==0) exit(5);

	w[0]=MakeButton("Quit",quit,NULL);
	printf("second:\n");
	for(i=0;i<4;i++){
		printf(":%lld\n",GetWidgetState(w[i]));	
	}
	w[1]=MakeStringEntry("wpkenan",128,NULL,NULL);
	printf("third:\n");
	for(i=0;i<4;i++){
		printf(":%d\n",GetWidgetState(w[i]));
	}
	w[2]=MakeTextWidget("textwidget",0,1,100,200);
	printf("fourth:\n");
	for(i=0;i<4;i++){
		printf(":%d\n",GetWidgetState(w[i]));
	}
	w[3]=MakeDrawArea(300,400,draw_stuff,NULL);
	printf("fifth:\n");
	for(i=0;i<4;i++){
		printf(":%d\n",GetWidgetState(w[i]));
		
	}
//	w[3]=MakeDrawArea(300,400,draw_stuff,NULL);
	SetWidgetPos(w[1],PLACE_UNDER,w[0],NO_CARE,NULL);
	SetWidgetPos(w[2],PLACE_UNDER,w[1],NO_CARE,NULL);
	SetWidgetPos(w[3],PLACE_UNDER,w[2],NO_CARE,NULL);
//	SetWidgetPos(w[3],PLACE_UNDER,w[2],NO_CARE,NULL);
//	Widget quit_button,draw_area;
//	quit_button=MakeButton("Quit",quit,NULL);
//	draw_area=MakeDrawArea(500,500,draw_stuff,NULL);


//	MakeLabel("Hello World");
//	MainLoop();
	
//	getchar();
//	int i=0;
//	
//	

//	char new_txt[10];
//	printf("new_txt:\n");
//	gets(new_txt);
//	getchar();
	puts(GetStringEntry(w[1]));

//	SetStringEntry(w[1],new_txt);
	puts(GetStringEntry(w[1]));
	printf("active:\n");
	SetWidgetState(w[0],1);	
	for(i=0;i<=3;i++){
		printf(":%lld\n",GetWidgetState(w[i]));
		if(GetWidgetState(w[i])>0){
			printf("\n %lld \n\n",i);
			break;
		}
	}	
	printf("end:\n");
	SetDrawArea(w[2]);
//	SetBgColor(w[3],BLACK);
//	DrawBox(30,50,110,70);
//	ClearDrawArea();
//	
//	
//	SetDrawArea(w[1]);
//	MakeDrawArea(600,600,draw_stuff,NULL);
//	DrawLine(0,0,100,300);
//	DrawPixel(1,2);
	getchar();
//	SetCurrentWindow(w[2]);
//	CloseWindow();
	GetStandardColors();
	ShowDisplay();
//	MainLoop();
	getchar();
	getchar();
	CloseWindow();
	MainLoop();

}
