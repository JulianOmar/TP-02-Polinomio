package polinom;

import java.io.FileNotFoundException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		String path = "grado";
		String grado = "300";
		double x = 1;
		final int CANT_PRUB = 1; // cantidad de repeticiones por metodo de resolucion

		Polinomio p1 = new Polinomio(path+ grado +".in");
		//Polinomio p1 = new Polinomio("fatiga.in");
		long tIniResol;
		long tFinResol;
		long diff;
		long tot = 0;

		BinomioDeNewton bin = new BinomioDeNewton(3, 2, 4);

		Polinomio ppt = new Polinomio(bin.obtenercoeficientes());
		System.out.println(bin.obtenerUnCoeficiente(2));
		ppt.mostrar();

		// p1.mostrar();

		for (int i = 0; i < 1000; i++)
		{
			tIniResol = System.nanoTime();
			p1.evaluarMSucesivas(x);
			tFinResol = System.nanoTime();
			diff = tFinResol - tIniResol;
			tot += diff;
		}
		tot /= 1000;
		System.out.println("Tiempo Prom de MSucesivas() = " + tot / 1000 + " microsegs");
		for (int i = 0; i < 1000; i++)
		{
			tIniResol = System.nanoTime();
			p1.evaluarRecursiva(x);
			tFinResol = System.nanoTime();
			diff = tFinResol - tIniResol;
			tot += diff;
		}
		tot /= 1000;
		System.out.println("Tiempo Prom de Recursiva() = " + tot / 1000 + " microsegs");
		for (int i = 0; i < 1000; i++)
		{
			tIniResol = System.nanoTime();
			p1.evaluarRecursivaPar(x);
			tFinResol = System.nanoTime();
			diff = tFinResol - tIniResol;
			tot += diff;
		}
		tot /= 1000;
		System.out.println("Tiempo Prom de RecursivaPar() = " + tot / 1000 + " microsegs");
		for (int i = 0; i < 1000; i++)
		{
			tIniResol = System.nanoTime();
			;
			p1.evaluarProgDinamica(x);
			tFinResol = System.nanoTime();
			diff = tFinResol - tIniResol;
			tot += diff;
		}
		tot /= 1000;
		System.out.println("Tiempo Prom de ProgDinamica() = " + tot / 1000 + " microsegs");
		for (int i = 0; i < 1000; i++)
		{
			tIniResol = System.nanoTime();
			p1.evaluarMejorada(x);
			tFinResol = System.nanoTime();
			diff = tFinResol - tIniResol;
			tot += diff;
		}
		tot /= 1000;
		System.out.println("Tiempo Prom de Mejorada() = " + tot / 1000 + " microsegs");
		for (int i = 0; i < 1000; i++)
		{
			tIniResol = System.nanoTime();
			p1.evaluarPow(x);
			tFinResol = System.nanoTime();
			diff = tFinResol - tIniResol;
			tot += diff;
		}
		tot /= 1000;
		System.out.println("Tiempo Prom de Pow() = " + tot / 1000 + " microsegs");
		for (int i = 0; i < 1000; i++)
		{
			tIniResol = System.nanoTime();
			p1.evaluarHorner(x);
			tFinResol = System.nanoTime();
			diff = tFinResol - tIniResol;
			tot += diff;
		}
		tot /= 1000;
		System.out.println("Tiempo Prom de Horner() = " + tot / 1000 + " microsegs");

	}

}
