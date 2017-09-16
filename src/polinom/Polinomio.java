package polinom;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Polinomio
{
	private int grado;
	private double[] coeficientes;

	// coeficiente [0] maxima potencia
	// coeficiente[grado] termino independiente

	public Polinomio(String path) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		this.grado = sc.nextInt();
		this.coeficientes = new double[grado + 1];
		for (int i = 0; i < coeficientes.length; i++) {
			this.coeficientes[i] = sc.nextDouble();
			
		}
		sc.close();
	}

	public Polinomio(double[] coeficientes)
	{
		grado = coeficientes.length;
		this.coeficientes = new double[grado];

		for (int i = 0; i < grado; i++)
			this.coeficientes[i] = coeficientes[i];
	}

	// ***************METODOS******************//

	public double evaluarMSucesivas(double x)
	{
		double resultado = 0;
		double parcial = 1;
		int potencia;
		for (int i = 0; i < coeficientes.length; i++) {
			potencia = this.coeficientes.length - i - 1;
			for (int j = 0; j < potencia; j++) {
				parcial *= x;
			}
			resultado += this.coeficientes[i] * parcial;
			parcial = 1;
		}
		return resultado;
	}

	public double evaluarRecursiva(double x)
	{
		double resultado = 0;
		double parcial;
		for (int i = 0; i < coeficientes.length; i++) {
			parcial = potenciaA(x, this.coeficientes.length - i - 1);
			resultado += this.coeficientes[i] * parcial;
		}
		return resultado;
	}

	public double potenciaA(double x, int n)
	{
		if (n != 0) {
			return x * potenciaA(x, n - 1);
		}
		return 1;
	}

	public double evaluarRecursivaPar(double x)
	{
		double resultado = 0;
		double parcial;
		for (int i = 0; i < coeficientes.length; i++) {
			parcial = potenciaB(x, this.coeficientes.length - i - 1);
			resultado += this.coeficientes[i] * parcial;
		}
		return resultado;
	}

	public double potenciaB(double x, int n)
	{
		if (n != 0) {
			if (n % 2 == 0) {
				return potenciaB(x * x, n / 2);
			} else {
				return x * potenciaB(x, n - 1);
			}
		}
		return 1;
	}

	public double evaluarProgDinamica(double x)
	{
		double[] vec = new double[coeficientes.length];
		double resultado = 0;
		vec[grado] = 1;
		for (int i = grado - 1; i >= 0; i--) {
			vec[i] = vec[i + 1] * x;
		}
		for (int j = 0; j < vec.length; j++) {
			resultado += coeficientes[j] * vec[j];
		}
		return resultado;
	}

	public double evaluarMejorada(double x)
	{
		double var = 1;
		double resultado = 0;
		for (int j = 0; j < coeficientes.length; j++) {
			resultado += coeficientes[coeficientes.length - j - 1] * var;
			var *= x;
		}
		return resultado;
	}

	public double evaluarPow(double x)
	{
		double resultado = 0;
		for (int i = 0; i < coeficientes.length; i++) {
			resultado += this.coeficientes[i] * Math.pow(x, grado - i);
		}
		return resultado;
	}

	public double evaluarHorner(double x)
	{
		double[] b = new double[grado + 1];
		b[grado] = this.coeficientes[0];
		for (int i = grado - 1; i >= 0; i--) {
			b[i] = this.coeficientes[this.coeficientes.length - i - 1] + b[i + 1] * x;
		}
		return b[0];
	}

	public void mostrar()
	{
		for (int i = 0; i < coeficientes.length; i++) {
			if (coeficientes.length - i - 1 != 0) {
				System.out.print(coeficientes[i] + "x^" + (coeficientes.length - i - 1));
				System.out.print(" + ");
			} else {
				System.out.println(coeficientes[i]);
			}
		}

	}

	public int getGrado()
	{
		return grado;
	}

	public void setGrado(int grado)
	{
		this.grado = grado;
	}

	public double[] getCoeficientes()
	{
		return coeficientes;
	}

	public void setCoeficientes(double[] coeficientes)
	{
		this.coeficientes = coeficientes;
	}
}
