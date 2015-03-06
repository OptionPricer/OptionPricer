package optionpricer;
import java.util.*;
/**
 *
 * @author catherine_Liu
 */
public class finiteDifference {
    option Option;    
    int numOfTimeInterval;
    int numOfPriceInterval;
    double sMax;
        
    finiteDifference(){
       
    }
    finiteDifference(option givenOption,int N, int M, double sMax){
        Option = givenOption;
        this.numOfTimeInterval = N;
        this.numOfPriceInterval = M;
        this.sMax = sMax;
    }
    double calculate(){
        int i,j;
        int N = this.numOfTimeInterval;
        int M = this.numOfPriceInterval;
        double deltaT = this.Option.getTerm() / N;
        double deltaS = this.sMax / M;
        
        double[][] f = new double[N+1][];
        for(i=0;i<=N;i++){
            f[i] = new double[M+1];
            for(j=0;j<=M;j++){
                f[i][j] = 0.0;
            }
        }
        //initialize stock price array
        double[] stockPrice = new double[M+1];
        for(j=0;j<=M;j++){
            stockPrice[j] = j * this.sMax / M;
        }
        //initial stock price at zero and sMax
        if((this.Option.type == "AP")||(this.Option.type == "EP")){
            for(i=0;i<=N;i++){
                f[i][0] = this.Option.getStrikePrice();
                f[i][M] = 0.0;
            }
        }
        if((this.Option.type == "AC")||(this.Option.type == "EC")){
            for(i=0;i<=N;i++){
            f[i][0] = 0.0;
            f[i][M] = this.Option.getStrikePrice();
            }
        }
        //initialize option value at maturity
        if((this.Option.type == "AP")||(this.Option.type == "EP")){
            for(j=0;j<=M;j++){
                f[N][j]=Math.max(this.Option.getStrikePrice()-stockPrice[j],0.0);
            }
        }
        if((this.Option.type == "AC")||(this.Option.type == "EC")){
            for(j=0;j<=M;j++){
                f[N][j]=Math.max(stockPrice[j]-this.Option.getStrikePrice(),0.0);
            }
        }
        //Calculate interior values
        //These are arrays to be sent to the tridiagonal algorithm
        double[] a = new double[M-1];
        double[] b = new double[M-1];
        double[] c = new double[M-1];
        double[] r = new double[M-1];
        double[] u = new double[M-1];
        for(j=0;j<M-1;j++){           //note the offsets
            a[j] = aj(j+1,deltaT);
            b[j] = bj(j+1,deltaT);
            c[j] = cj(j+1,deltaT);
        }
        //The big loop over columns, backward from N-1 to zero
        for(i=1;i<=N;i++){
            for(j=0;j<M-1;j++){
                r[j] = f[N-i+1][j+1];               
            }
            r[0] = r[0]-a[0]*f[N-i][0];
            r[M-2] = r[M-2] - c[M-2]*f[N-i][M];
            //Solve the tridiagonal system of equations.
            //The solutions ar placed in u.
            tridiag(a,b,c,r,u,M-1);
            if(this.Option.type == "AP"){
                for(j=1;j<M;j++){
                    if(u[j-1] < this.Option.getStrikePrice() - j * deltaS)
                        f[N-i][j] = this.Option.getStrikePrice() - j * deltaS;
                    else
                        f[N-i][j] = u[j-1];
                } 
            }
            if(this.Option.type == "AC"){
               for(j=1;j<M;j++){
                if(u[j-1] < j * deltaS - this.Option.getStrikePrice())
                    f[N-i][j] = j * deltaS - this.Option.getStrikePrice();
                else
                    f[N-i][j] = u[j-1];
                } 
            }
            if(this.Option.type == "EP"){
                for(j=1;j<M;j++){
                    f[N-i][j] = u[j-1];
                }
            }
            if(this.Option.type == "EC"){
                for(j=1;j<M;j++){
                    f[N-i][j] = u[j-1];
                }
            }
        }
        
        double optionValue;
        j = 0;
        while(stockPrice[j] < this.Option.getsNaught())
            j++;
        if(stockPrice[j] == this.Option.getsNaught())
            optionValue = f[0][j];
        else
            //linear interpolation; we can do better
            optionValue = f[0][j-1] + (f[0][j] - f[0][j-1]) * (this.Option.getsNaught()-stockPrice[j-1])/(stockPrice[j]-stockPrice[j-1]);
        return optionValue;
    }
    //Solve a tridiagonal system of linear equations
    void tridiag(double[] a, double[] b, double[] c, double[] r, double[] u, int length) {
	int j;
	double bet;
	double[] gam = new double[length];
	u[0] = r[0] /( bet=b[0]);
	for (j = 1; j < length; j++) {
		gam[j] = c[j-1] / bet;
		bet = b[j] - a[j] * gam[j];
		u[j] = (r[j] - a[j] * u[j-1]) / bet;
	}
	for (j = (length-2); j >= 0; j--)
		u[j] -= gam[j+1] * u[j+1];
    }
    
    double aj(int j, double deltaT){
        double riskFreeRate = this.Option.getRiskFreeRate();
        double volatility = this.Option.getVolatility();
        return (0.5 * riskFreeRate * j * deltaT - 0.5 * volatility * volatility * j * j * deltaT);
    }
    double bj(int j, double deltaT){
        double riskFreeRate = this.Option.getRiskFreeRate();
        double volatility = this.Option.getVolatility();
        return (1.0 + volatility*volatility*j*j*deltaT + riskFreeRate*deltaT);
    }
    double cj(int j, double deltaT){
        double riskFreeRate = this.Option.getRiskFreeRate();
        double volatility = this.Option.getVolatility();
        return (-0.5*riskFreeRate*j*deltaT - 0.5*volatility*volatility*j*j*deltaT);
    }
}
