import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Obtener los datos del conjunto de datos
        double[][] data = DataSet.getData();

        // Calcular la regresión polinómica
        double[][] coefficients = DiscreteMath.calculatePolynomialRegression(data);

        // Calcular el error de la regresión polinómica
        double error = DiscreteMath.calculateError(data, coefficients);

        // Imprimir los resultados
        printResults(coefficients, error);

        // Encontrar la mejor posición
        double[] xValues = Arrays.stream(data).mapToDouble(d -> d[0]).toArray();
        double[] yValues = Arrays.stream(data).mapToDouble(d -> d[1]).toArray();
        int bestPositionIndex = findBestPosition(yValues);
        System.out.println("La mejor posición en la gráfica es para X = " + xValues[bestPositionIndex] + ", Y = " + yValues[bestPositionIndex]);
    }

    // Método para imprimir los resultados
    public static void printResults(double[][] coefficients, double error) {
        System.out.println("Coeficientes de la regresión polinómica:");
        System.out.println("b0 = " + coefficients[0][0]);
        System.out.println("b1 = " + coefficients[1][0]);
        System.out.println("b2 = " + coefficients[2][0]);
        System.out.println("Error de la regresión polinómica (epsilon) = " + error);
    }

    // Método para encontrar la mejor posición
    public static int findBestPosition(double[] yValues) {
        double maxValue = yValues[0];
        int maxIndex = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] > maxValue) {
                maxValue = yValues[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
