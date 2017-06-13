# cmake_minimum_required(VERSION <specify CMake version here>)
project(First)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp)
add_executable(First ${SOURCE_FILES})