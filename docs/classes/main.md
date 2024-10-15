# Main
The Main class serves as the entry point for the application. It reads a list of planets from a specified input file, launches a separate process to calculate the gravitational acceleration for each planet using the PlanetGravityCalculator class, and then waits for these processes to complete. After all calculations, it retrieves and displays the gravity results from output files. If any output file is missing, it prints an error message.
<br><br>
<hr>

## Methods
#### - main(String[] args) throws Exception:

&nbsp;&nbsp;&nbsp;&nbsp;
The main method that reads planet data, launches gravity calculation processes, waits for their completion, and displays the results.

<br><br>
<hr>

[<- Volver](../documentation.md)