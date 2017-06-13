FILE_NAME=$(out)

INCLUDE = -I/usr/include/  
  
LIBDIR  = -L/usr/X11R6/lib -L/usr/local/lib  

COMPILERFLAGS = -Wall  
  
CC = g++ 
  
CFLAGS = $(COMPILERFLAGS) $(INCLUDE)  
  
LIBRARIES = -lX11 -lXi -lXmu -lglut -lGL -lGLU -lm   

TARGET=$(basename $(FILE_NAME))


all: $(TARGET).o
	$(CC) $(CFLAGS) $(LIBDIR) $(FILE_NAME) -o $(TARGET).o $(LIBRARIES)  
  
clean:
	rm -f *.o  

