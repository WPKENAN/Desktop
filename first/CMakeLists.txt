# cmake_minimum_required(VERSION <specify CMake version here>)

cmake_minimum_required(VERSION 3.3)
project(first)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.c)

set(TARGET_LIB
        "/usr/lib/i386-linux-gnu/libGL.so"
        "/usr/lib/i386-linux-gnu/libGLU.so"
        "/usr/lib/i386-linux-gnu/libglut.so"
        )

add_executable(first ${SOURCE_FILES})
target_link_libraries(${PROJECT_NAME} GL GLU glut)