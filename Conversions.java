package frc.robot;

public class Conversions {
    public static final int inchesToEncoders(double[] data) {
        double doubleEncoders = (data[0]/(data[1] * Math.PI)) * data[2] * data[3];
        // data 0: inches, data 1: wheel size, data 2: encoders per rev, data 3: gear ratio
        int encoders = (int)doubleEncoders;
        return encoders;
    }
}
