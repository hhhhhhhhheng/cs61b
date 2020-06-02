public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/**
	 * constructor
	 */
	public Body(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance (Body b) {
		double dx = b.xxPos - this.xxPos;
		double dy = b.yyPos - this.yyPos;
		double rSqr = Math.pow(dx,2) + Math.pow(dy,2);
		return Math.sqrt(rSqr);
	}

	public double calcForceExertedBy (Body b) {
		double G = 6.67 * Math.pow(10, -11);
		return G * this.mass * b.mass / Math.pow(this.calcDistance(b) , 2 );
	}

	public double calcForceExertedByX (Body b) {
		double dx = b.xxPos - this.xxPos;
		return this.calcForceExertedBy(b) * dx / this.calcDistance(b);
	}
	public double calcForceExertedByY (Body b) {
		double dy = b.yyPos - this.yyPos;
		return this.calcForceExertedBy(b) * dy / this.calcDistance(b);
	}

	public double calcNetForceExertedByX (Body[] Bodies) {
		double Dis = 0;
		for (int i = 0; i < Bodies.length; i ++) {
			if (Bodies[i].equals(this)) {
				continue;
			}
			Dis += this.calcForceExertedByX(Bodies[i]);
		}
		return Dis;
	}
	public double calcNetForceExertedByY (Body[] Bodies) {
		double Dis = 0;
		for (int i = 0; i < Bodies.length; i ++) {
			if (Bodies[i].equals(this)) {
				continue;
			}
			Dis += this.calcForceExertedByY(Bodies[i]);
		}
		return Dis;
	}
	public void update (double dt, double Fx, double Fy) {
		double ax = Fx / this.mass;
		double ay = Fy / this.mass;
		this.xxVel = this.xxVel + dt * ax;
		this.yyVel = this.yyVel + dt * ay;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}
}