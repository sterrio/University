cmake_minimum_required(VERSION 3.11)
project(miner C)

set(CMAKE_C_STANDARD 99)
set(THREADS_PREFER_PTHREAD_FLAG ON)

add_executable(miner main.c transactions.c transactions.h siggen.c nonce.h nonce.c siggen.h mempool.c mempool.h)
find_package(Threads REQUIRED)
target_link_libraries(miner PRIVATE Threads::Threads)