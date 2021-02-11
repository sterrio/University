/* Stephen Terrio B00755443 */
#ifndef CALCULATOR_H
#define CALCULATOR_H
// Need to include this lib to use bool instead of _BOOL datatypes
#include <stdbool.h>

// Structure to hold calculator elements -
typedef struct _Calculator {
  double (**operations) (int,int); // Function pointers to math ops
  int **data; // operation data from input file
  int operationCount; // total operations in Calculator
  int dataLength; // total number of data points from the input.
} Calculator;

// Forward declaring functions -
Calculator* create_calculator(double(**)(int,int),int); // Creating Calculator Structure
bool load_calculator_data(Calculator*, char*); // Read and store info in Calc
void run_calculator(Calculator*); // perform all the ops in order and print them to stdout
bool destroy_calculator(Calculator*); // Destroy the Calculator
double add_calculator(int,int); // Add
double sub_calculator(int,int); // Subtract
double mul_calculator(int,int); // Divide
double div_calculator(int,int); // Multiply
double mod_calculator(int,int); // Modulus

#endif
