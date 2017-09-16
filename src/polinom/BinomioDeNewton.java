package polinom;

public class BinomioDeNewton
{
//(2x+4)^3=8.0x^3 + 48.0x^2 + 96.0x^1 + 64.0
	
	int n;
	double a, b;

	public BinomioDeNewton(int n, double a, double b) // (aX+b)^n
	{
		this.n = n;
		this.a = a;
		this.b = b;
	}

	
	public double[] obtenercoeficientes()
	{
		double [] vec =new double[n+1];
		for(int i=0;i<this.n+1 ; i++) 
			vec[i]= this.obtenerUnCoeficiente(n-i);		
		return vec;
		
	}
	
	
	public double obtenerUnCoeficiente(int k)
	{
		if (k > this.n || k < 0)
			throw new ArithmeticException("no se puede obtener el k-ésimo coeficiente: valor de k no válido");

		
		return (combinatoria(n,k) * Math.pow(this.b, n-(k))* Math.pow(this.a, k)); ///CAMBIAR A - B
	}

	private int combinatoria(int n1, int n2)
	{
		return (factorial(n1) / (factorial(n2) * factorial(n1 - n2)));
	}

	private int factorial(int n)
	{
		int res = 1;
		for (int i = n; i > 0; i--) {
			if (n == 0 || n == 1) {
				res = 1;
				break;
			}
			res = i * res;
		}
		return res;
	}

	public double evaluarBinomio(double x)
	{
		double[] coeficientes = new double[this.n + 1];

		for (int i = 1; i <= coeficientes.length; i++) {
			System.out.println("Coef " + i + ": " + obtenerUnCoeficiente(i));
			coeficientes[i - 1] = obtenerUnCoeficiente(i);
		}

		return new Polinomio(coeficientes).evaluarMejorada(x);
	}

}
