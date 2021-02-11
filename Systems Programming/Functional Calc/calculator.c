/* Stephen Terrio B00755443 */

// Packages
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "calculator.h"

// MARK: - Operations
double add_calculator(int x, int y) {
    double result = (double)x + (double)y;
    return (double)result;
}

double sub_calculator(int x, int y) {
    double result = (double)x - (double)y;
    return (double)result;
}

double mul_calculator(int x, int y) {
    double result = (double)x * (double)y;
    return (double)result;
}

double div_calculator(int x, int y) {
    double result = (double)x / (double)y;
    return (double)result;
}

double mod_calculator(int x, int y) {
    double result = x % y;
    return (double)result;
}

// MARK: - Calculator
Calculator* create_calculator(double(**ops)(int x, int y), int length) {
  // Allocating memory to store the calculator information
  Calculator* calc = (Calculator*) malloc(sizeof(Calculator));
  if (calc != NULL){
      calc->operations = ops; // Array of pointers to the operation functions
      calc->operationCount = length;
  }
  return calc;
}


bool load_calculator_data(Calculator* calc, char* fileName) {
    // Zero out data length
    calc->dataLength = 0;

    // Open file
    FILE *input = fopen(fileName, "r");
    char line[256];

    int* buffer[1000];
    // Read data points from file
    while (fgets(line, sizeof(line), input)) {
        // https://www.cplusplus.com/reference/cstdlib/strtol/
        char *temp;
        int o, x, y;
        o = strtol(line, &temp, 10);
        x = strtol(temp, &temp, 10);
        y = strtol(temp, &temp, 10);

        int* point = malloc(3 * sizeof(int));
        point[0] = o;
        point[1] = x;
        point[2] = y;
        buffer[calc->dataLength] = point;

        // Increase the data length
        calc->dataLength++;
    }

    // Allocate data points array
    calc->data = malloc(calc->dataLength * sizeof(int*));
    // Store data points in calculator
    for (int i = 0; i < calc->dataLength; i++) {
        calc->data[i] = buffer[i];
    }
    fclose(input);
    if (calc->dataLength > 0) {
     return true;
 }
 return false;
}

void run_calculator(Calculator* calc) {
    for (int i = 0; i < calc->dataLength; i++) {
        int x, y;
        double (*op)(int, int);
        int* point = calc->data[i];
        op = calc->operations[point[0]];
        x = point[1];
        y = point[2];

        double result = op(x, y);
        printf("%.5f\n", result);
    }
}

bool destroy_calculator(Calculator* calc) {
    // Verify objects have been deleted
    if (calc != NULL) {
        if (calc->data != NULL) {
            if (calc->data[0] != NULL) {
                // Destroy calculator
                for (int i = 0; i < calc->dataLength; i++) {
                    free(calc->data[i]);
                }
            }
            free(calc->data);
        }
        free(calc);
        return true;
    }
    return false;
}
